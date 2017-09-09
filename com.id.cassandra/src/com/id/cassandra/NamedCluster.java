
package com.id.cassandra;

import com.datastax.driver.core.Cluster;

/**
 * A {@link NamedCluster} is a service that will be publised.
 * Other components can listern for them.
 * @author pjpinten
 *
 */
public class NamedCluster
{
	private final NamedClusterConfiguration fConfiguration;
	private final Cluster fCluster;


	public NamedCluster(final NamedClusterConfiguration configuration, final Cluster cluster)
	{
		super();
		fConfiguration = configuration;
		fCluster = cluster;
	}


	public String getName()
	{
		return fConfiguration.getName();
	}


	public NamedClusterConfiguration getConfiguration()
	{
		return fConfiguration;
	}


	public Cluster getCluster()
	{
		return fCluster;
	}

}
