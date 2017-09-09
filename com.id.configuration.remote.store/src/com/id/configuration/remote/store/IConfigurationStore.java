
package com.id.configuration.remote.store;

import org.osgi.annotation.versioning.ProviderType;

import com.id.configuration.proto.Empty;
import com.id.configuration.proto.Level;
import com.id.configuration.proto.NameList;
import com.id.configuration.proto.Option;
import com.id.configuration.proto.Path;
import com.id.configuration.proto.ValueOption;

import io.grpc.stub.StreamObserver;

@ProviderType
public interface IConfigurationStore
{
	public void addConfigurationChangeListener(IConfigurationChangeListener l);


	public void removeConfigurationChangeListener(IConfigurationChangeListener l);


	public void getGlobalConfigOption(Path request, StreamObserver<ValueOption> responseObserver);


	public void getLeveledConfigOption(Option request, StreamObserver<ValueOption> responseObserver);


	public StreamObserver<Option> getLeveledConfigOptions(StreamObserver<ValueOption> responseObserver);


	public StreamObserver<Path> getGlobalConfigOptions(StreamObserver<ValueOption> responseObserver);


	public void setConfigOption(ValueOption request, StreamObserver<Empty> responseObserver);


	public void unsetLeveledConfigOption(Option request, StreamObserver<Empty> responseObserver);


	public void unsetGlobalConfigOption(Path request, StreamObserver<Empty> responseObserver);


	public void getLeveledNameList(Option request, StreamObserver<NameList> responseObserver);


	public void getGlobalNameList(Path request, StreamObserver<NameList> responseObserver);


	public void getLevel(Level request, StreamObserver<ValueOption> responseObserver);

}
