package com.id.configuration.remote.commands;

import org.apache.felix.service.command.Descriptor;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import com.id.configuration.proto.Option;
import com.id.configuration.remote.client.IRemoteConfigurationClientBuilder;

@Component(service = UnSetRemoteConfigurationOptionCommand.class, property = {
		"osgi.command.scope=rconf", "osgi.command.function=unset" })
public class UnSetRemoteConfigurationOptionCommand {

	@Reference
	private IRemoteConfigurationClientBuilder fClient;

	@Descriptor("Set a configuration option from the remote config service")
	public void unset(@Descriptor("level") int level, @Descriptor("path") String path) {
		Option o = Option.newBuilder().setLevel(level).setPath(path).build();
		fClient.getConfigurationService().unsetLeveledConfigOption(o);
	}
}
