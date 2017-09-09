package com.id.configuration.remote.client;

import com.id.configuration.proto.ConfigurationServiceGrpc;

public interface IRemoteConfigurationClientBuilder {

	ConfigurationServiceGrpc.ConfigurationServiceBlockingStub getConfigurationService();

}