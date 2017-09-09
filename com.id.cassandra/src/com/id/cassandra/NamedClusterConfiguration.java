
package com.id.cassandra;

import java.util.Arrays;

import com.datastax.driver.core.Cluster;

/**
 * A cluster configuration.
 * @author pjpinten
 *
 */
public class NamedClusterConfiguration
{
	// TODO expand...
	private final String fName;
	private final String[] fContactPoints;
	private final String fUserName;
	private final String fPassword;


	public NamedClusterConfiguration(String name, String[] contactPoints, String userName, String password)
	{
		super();
		fName = name;
		fContactPoints = contactPoints;
		fUserName = userName;
		fPassword = password;
	}


	public String getName()
	{
		return fName;
	}


	public String[] getContactPoints()
	{
		return fContactPoints;
	}


	public String getUserName()
	{
		return fUserName;
	}


	public String getPassword()
	{
		return fPassword;
	}


	public Cluster.Builder buildCluster()
	{
		final Cluster.Builder b = Cluster.builder();
		b.addContactPoints(getContactPoints());
		b.withClusterName(getName());
		if (fUserName != null)
		{
			b.withCredentials(getUserName(), getPassword());
		}
		// TODO add more..
		return b;
	}


	@Override
	public String toString() {
		//TODO must not log this with password
		return "NamedClusterConfiguration [Name=" + fName + ", ContactPoints=" + Arrays.toString(fContactPoints)
				+ ", UserName=" + fUserName + ", Password=" + fPassword  + "]";
	}
}
