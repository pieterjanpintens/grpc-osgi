package com.id.grpc.client.impl;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Deactivate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.id.grpc.client.Host;
import com.id.grpc.client.IManagedChannelService;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;

/**
 * Service responsible for managing {@link ManagedChannel} to different hosts.
 * This service keeps the number of channels limited, only one will be created for each host.
 * @author Pieter-Jan
 */
@Component
public class ManagedChannelService implements IManagedChannelService {

	private Logger fLog = LoggerFactory.getLogger(getClass());
	
	private Map<Host,ManagedChannel> fChannels = new HashMap<>();
	
	@Deactivate
	public void deactive()
	{
		synchronized (fChannels) {
			fChannels.forEach((host,ch) -> {
				fLog.debug("Closing channel for host {}", host.getDisplayName());
				ch.shutdown();
				try {
					ch.awaitTermination(50, TimeUnit.MILLISECONDS);
				} catch (InterruptedException e) {
					fLog.warn("Failed to close channel for host {} within 50 ms", host.getDisplayName());
				}
			});
			fChannels.clear();			
		}
	}

	@Override
	public ManagedChannel getChannel(final Host host)
	{
		synchronized (fChannels) {
			ManagedChannel result = fChannels.get(host);
			if(result == null)
			{
				result = buildChannel(host);
				fChannels.put(host, result);
			}
			return result;
		}
	}
	
	private ManagedChannel buildChannel(final Host h)
	{
		return ManagedChannelBuilder.forAddress(h.getHostName(), h.getPort())
				.usePlaintext(true)
				.build();
	}
}
