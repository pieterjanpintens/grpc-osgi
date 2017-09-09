package com.id.configuration.remote.commands;

import org.apache.felix.service.command.Descriptor;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import com.google.protobuf.ByteString;
import com.id.configuration.proto.Type;
import com.id.configuration.proto.ValueOption;
import com.id.configuration.remote.client.IRemoteConfigurationClientBuilder;

@Component(service = SetRemoteConfigurationOptionCommand.class, property = { "osgi.command.scope=rconf",
		"osgi.command.function=set" })
public class SetRemoteConfigurationOptionCommand {

	@Reference
	private IRemoteConfigurationClientBuilder fClient;

	@Descriptor("Set a configuration option from the remote config service")
	public void set(@Descriptor("level") int level, @Descriptor("path") String path,
			@Descriptor("value") String value) {
		ValueOption o = ValueOption.newBuilder().setLevel(level).setPath(path).setType(Type.VALUE)
				.setData(ByteString.copyFromUtf8(value)).build();
		fClient.getConfigurationService().setConfigOption(o);
	}
}
