package com.id.configuration.remote.commands;

import org.apache.felix.service.command.Descriptor;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import com.id.configuration.proto.Option;
import com.id.configuration.proto.ValueOption;
import com.id.configuration.remote.client.IRemoteConfigurationClientBuilder;

@Component(service = GetRemoteConfigurationOptionCommand.class, property = {
		"osgi.command.scope" + "=rconf", "osgi.command.function" + "=get" })
public class GetRemoteConfigurationOptionCommand {

	@Reference
	private IRemoteConfigurationClientBuilder fClient;

	@Descriptor("Get a configuration option from the remote config service")
	public String get(@Descriptor("level") int level, @Descriptor("path") String path) {
		ValueOption o = fClient.getConfigurationService()
				.getLeveledConfigOption(Option.newBuilder().setLevel(level).setPath(path).build());
		return o.toString();
	}
}
