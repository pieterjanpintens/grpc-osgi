
package com.id.cassandra.provider;

import java.util.Dictionary;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;

import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceRegistration;
import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Deactivate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.datastax.driver.core.Cluster;
import com.datastax.driver.core.ProtocolVersion;
import com.id.cassandra.NamedCluster;
import com.id.cassandra.NamedClusterConfiguration;

/**
 * Component that links cluster objects to configuration of cluster objects.
 * This component is thus responsible to limit the amount of Cluster instances alive in an application.
 * This is required because:
 * 1) The API doc of Cluster says so
 * 2) A cluster starts a bunch of threads, we don't want that to explode
 * 
 * If cluster configurations are added in the configuration this component will publish them as {@link NamedCluster}
 * services. If cluster configurations are removed from the configuration this component will unpublish them
 * accordingly.
 * 
 * Other components can thus listen for {@link NamedCluster} services.
 * 
 * 
 * @author pjpinten
 */
@Component
public class NamedClusterProvider
{
	// TODO link with configuration

	private final Map<String, ServiceRegistration<NamedCluster>> fClusters = new HashMap<>();
	private final Map<String, Cluster> fClustersObjects = new HashMap<>();
	
	private Logger fLog = LoggerFactory.getLogger(getClass());

	private BundleContext fContext;

	@Activate
	public void activate(final BundleContext context)
	{
		fContext = context;

		// TODO remove this
		addCluster(new NamedClusterConfiguration("localhost", new String[] { "127.0.0.1" }, null, null));
	}


	@Deactivate
	public void deactivate(final BundleContext context)
	{
		synchronized (fClusters)
		{
			fClusters.values().stream().forEach(ServiceRegistration::unregister);
			fClusters.clear();

			fClustersObjects.values().stream().forEach(Cluster::close);
			fClustersObjects.clear();
		}
		fContext = null;
	}


	/**
	 * Attempt to connect to a cluster that given configuration describes.
	 * If the connection succeeds this will register a {@link NamedCluster} service.
	 */
	public void addCluster(final NamedClusterConfiguration configuration)
	{
		fLog.info("Adding new cassandra cluster: {}", configuration);
		synchronized (fClusters)
		{
			final Cluster.Builder b = configuration.buildCluster();
			// TODO global config
			b.withProtocolVersion(ProtocolVersion.V3);
			final Cluster c = b.build();

			fClustersObjects.put(configuration.getName(), c);
			// TODO check if cluster is valid if not add it to some retry list but do no publish it yet!

			// publish named cluster as a service
			final NamedCluster namedCluster = new NamedCluster(configuration, c);
			final ServiceRegistration<NamedCluster> s = fContext.registerService(NamedCluster.class, namedCluster, getDictionary(configuration));
			fClusters.put(configuration.getName(), s);
		}

	}


	/**
	 * Remove a configuration, this will unregister the corresponding {@link NamedCluster}.
	 * It will also close the connection.
	 */
	public void removeCluster(final NamedClusterConfiguration configuration)
	{
		fLog.info("Removing cassandra cluster: {}", configuration);
		synchronized (fClusters)
		{
			// remove it and unregister the service
			final ServiceRegistration<NamedCluster> s = fClusters.remove(configuration.getName());
			if (s != null)
			{
				s.unregister();
			}

			// close the cluster
			final Cluster c = fClustersObjects.remove(configuration.getName());
			if (c != null)
			{
				c.close();
			}
		}
	}


	private static Dictionary<String, ?> getDictionary(final NamedClusterConfiguration configuration)
	{
		Hashtable<String, String> p = new Hashtable<>();
		p.put("cluster.name", configuration.getName());
		return p;
	}

}
