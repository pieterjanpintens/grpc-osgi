
package com.id.configuration.remote.store.cassandra;

import java.io.IOException;
import java.util.Dictionary;
import java.util.Hashtable;

import org.osgi.service.cm.Configuration;
import org.osgi.service.cm.ConfigurationAdmin;
import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import org.osgi.service.component.annotations.ReferenceCardinality;

@Component
public class RemoveConfigurationStoreConfigurator
{
	private ConfigurationAdmin fAdmin;


	@Activate
	public void activate()
	{
		try
		{
			configurationChanged("localhost");
		}
		catch (Exception e)
		{
			// TODO: handle exception
		}
	}


	public void configurationChanged(final String newClusterName) throws IOException
	{
		final Configuration config = fAdmin.getConfiguration(RemoteConfigurationStore.class.getName());
		final Dictionary<String, Object> props;
		if (config != null && config.getProperties() != null)
		{
			props = config.getProperties();
		}
		else
		{
			props = new Hashtable<String, Object>();
		}

		// switch the state
		final StringBuilder filter = new StringBuilder("(cluster.name=");
		filter.append(newClusterName == null ? "DISABLED" : newClusterName).append(")");
		props.put("NamedCluster.target", filter.toString());
		config.update(props);
	}


	@Reference(cardinality = ReferenceCardinality.MANDATORY)
	public void setConfigurationAdmin(final ConfigurationAdmin a)
	{
		fAdmin = a;
	}
}
