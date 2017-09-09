package com.id.grpc.client;

import io.grpc.ManagedChannel;

public interface IManagedChannelService {

	ManagedChannel getChannel(Host host);

}