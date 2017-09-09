
package com.id.configuration.remote.store.cassandra;

import java.nio.ByteBuffer;
import java.util.UUID;

import com.datastax.driver.core.ConsistencyLevel;
import com.datastax.driver.core.ResultSet;
import com.datastax.driver.core.querybuilder.Insert;
import com.datastax.driver.core.querybuilder.QueryBuilder;

import com.id.configuration.proto.Type;

import io.grpc.stub.StreamObserver;

/**
 * Table that contains changes to configuration
 * 
 * @author pjpinten
 */
public class ConfigurationChangeEventTable
{
	private static final String kTIME = "timestamp";
	private static final String kLEVEL = "level";
	private static final String kPATH = "path";
	private static final String kTYPE = "type";
	private static final String kDATA = "data";

	private final RemoteConfigurationStore fStore;
	private final String fKeySpace;
	private final String fTable;


	public ConfigurationChangeEventTable(final RemoteConfigurationStore store, final String keyspace, final String table)
	{
		fStore = store;
		fKeySpace = keyspace;
		fTable = table;
	}


	public void createTable()
	{
		final String query = String.format("CREATE TABLE IF NOT EXISTS %s.%s (%s %s, %s %s, %s %s, %s %s, %s %s, PRIMARY KEY (%s));", fKeySpace, fTable, kTIME, "timeuuid", kLEVEL, "text", kPATH, "text", kTYPE, "int", kDATA, "blob", kTIME);
		fStore.query(query);
	}


	public void insert(final String level, final String path, final Type type, ByteBuffer data, final StreamObserver<?> o, final IResultSetHandler h)
	{
		Insert insert = QueryBuilder.insertInto(fKeySpace, fTable)
				.value(kTIME, QueryBuilder.now());
		if (type != null)
		{
			insert.value(kTYPE, type.getNumber());
		}
		if (level != null)
		{
			insert.value(kLEVEL, level);
		}
		if (data != null)
		{
			insert.value(kDATA, data);
		}
		if (path != null)
		{
			insert.value(kPATH, data);
		}
		insert.setConsistencyLevel(ConsistencyLevel.QUORUM);
		fStore.query(insert, o, h);
	}


	public void select(final UUID since, final StreamObserver<?> o, final IResultSetHandler h)
	{
		fStore.query(QueryBuilder.select().from(fKeySpace, fTable).where(QueryBuilder.gt(kTIME, since)), o, h);
	}


	public UUID currentTimeStamp()
	{
		ResultSet r = fStore.query(QueryBuilder.select(kTIME).from(fKeySpace, fTable).limit(1));
		return r.one().getUUID(kTIME);
	}
}
