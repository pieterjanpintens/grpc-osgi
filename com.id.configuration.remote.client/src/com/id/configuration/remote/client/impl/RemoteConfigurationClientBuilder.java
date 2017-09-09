package com.id.configuration.remote.client.impl;

import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import com.id.configuration.proto.ConfigurationServiceGrpc;
import com.id.configuration.remote.client.IRemoteConfigurationClientBuilder;
import com.id.grpc.client.Host;
import com.id.grpc.client.IManagedChannelService;

@Component
public class RemoteConfigurationClientBuilder implements IRemoteConfigurationClientBuilder {
	private Host fHost = new Host("localhost", (short) 8080);

	@Reference
	private IManagedChannelService fClientService;

	private ConfigurationServiceGrpc.ConfigurationServiceBlockingStub fStub;

	@Activate
	public void activate() {
		fStub = ConfigurationServiceGrpc.newBlockingStub(fClientService.getChannel(fHost));
	}

	@Override
	public ConfigurationServiceGrpc.ConfigurationServiceBlockingStub getConfigurationService() {
		return fStub;
	}

}
