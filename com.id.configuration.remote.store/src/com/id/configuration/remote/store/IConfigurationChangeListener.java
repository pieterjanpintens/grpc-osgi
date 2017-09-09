
package com.id.configuration.remote.store;

import org.osgi.annotation.versioning.ConsumerType;

import com.id.configuration.proto.Option;
import com.id.configuration.proto.Path;
import com.id.configuration.proto.ValueOption;

/**
 * Changelistener for configuration changes.
 * 
 * @author pjpinten
 */
@ConsumerType
public interface IConfigurationChangeListener
{
	public void onRemoveAll(final Path v);


	public void onRemove(final Option v);


	public void onSet(final ValueOption v);
}
