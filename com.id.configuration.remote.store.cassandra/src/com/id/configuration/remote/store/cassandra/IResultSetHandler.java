
package com.id.configuration.remote.store.cassandra;

import com.datastax.driver.core.ResultSet;

public interface IResultSetHandler
{
	public void run(ResultSet s);
}