
package com.id.configuration.remote.store.cassandra;

import java.util.HashMap;
import java.util.Map;

import com.id.configuration.proto.Option;
import com.id.configuration.proto.Path;
import com.id.configuration.proto.ValueOption;

/**
 * In memory representation of a remote configuration.
 * 
 * 
 * @author pjpinten
 */
public class RemoteConfiguration
{
	private Map<String, Map<String, ValueOption>> fData = new HashMap<>();


	public ValueOption getOption(final Option p)
	{
		synchronized (fData)
		{
			final String levelKey = Integer.toString(p.getLevel());
			Map<String, ValueOption> level = fData.get(levelKey);
			if (level != null)
			{
				return level.get(p.getPath());
			}
			return null;
		}
	}

	public void add(final ValueOption o)
	{
		synchronized (fData)
		{
			final String levelKey = Integer.toString(o.getLevel());
			Map<String, ValueOption> level = fData.get(levelKey);
			if (level == null)
			{
				level = new HashMap<>();
				fData.put(levelKey, level);
			}
			level.put(o.getPath(), o);
		}
	}


	public void remove(final Option o)
	{
		synchronized (fData)
		{
			final String levelKey = Integer.toString(o.getLevel());
			Map<String, ValueOption> level = fData.get(levelKey);
			if (level != null)
			{
				level.remove(o.getPath());
			}
		}
	}


	public void remove(final Path p)
	{
		synchronized (fData)
		{
			fData.forEach((k, v) -> {
				v.remove(p.getPath());
			});
		}
	}
}
