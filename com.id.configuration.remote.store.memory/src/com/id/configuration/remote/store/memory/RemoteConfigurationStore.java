package com.id.configuration.remote.store.memory;

import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

import org.osgi.service.component.annotations.Component;

import com.id.configuration.proto.Empty;
import com.id.configuration.proto.Level;
import com.id.configuration.proto.NameList;
import com.id.configuration.proto.Option;
import com.id.configuration.proto.Path;
import com.id.configuration.proto.ValueOption;
import com.id.configuration.proto.constants.Constants;
import com.id.configuration.remote.store.IConfigurationChangeListener;
import com.id.configuration.remote.store.IConfigurationStore;

import io.grpc.stub.StreamObserver;

@Component
public class RemoteConfigurationStore implements IConfigurationStore {

	private HashMap<Integer, HashMap<String, ValueOption>> fConfiguration = new HashMap<>();

	private final Set<IConfigurationChangeListener> fListeners = new HashSet<>();

	@Override
	public void addConfigurationChangeListener(final IConfigurationChangeListener l) {
		synchronized (fListeners) {
			fListeners.add(l);
		}
	}

	@Override
	public void removeConfigurationChangeListener(final IConfigurationChangeListener l) {
		synchronized (fListeners) {
			fListeners.remove(l);
		}
	}

	private void getGlobalConfigOption(final Path request, final StreamObserver<ValueOption> responseObserver,
			final boolean onComplete) {
		synchronized (fConfiguration) {
			ValueOption v = fConfiguration.values().parallelStream().filter(m -> m.containsKey(request.getPath()))
					.map(m -> m.get(request.getPath())).collect(Collectors.maxBy(new Comparator<ValueOption>() {
						@Override
						public int compare(ValueOption o1, ValueOption o2) {
							return Integer.compare(o1.getLevel(), o2.getLevel());
						}
					})).orElse(Constants.kNOTSET);
			responseObserver.onNext(v);

			if (onComplete) {
				responseObserver.onCompleted();
			}
		}
	}

	@Override
	public void getGlobalConfigOption(final Path request, final StreamObserver<ValueOption> responseObserver) {
		getGlobalConfigOption(request, responseObserver, true);
	}

	private void getConfigOption(Option request, StreamObserver<ValueOption> responseObserver, boolean onComplete) {
		synchronized (fConfiguration) {
			final HashMap<String, ValueOption> levelMap = fConfiguration.get(request.getLevel());
			ValueOption result = Constants.kNOTSET;
			if (levelMap != null) {
				result = levelMap.get(request.getPath());
			}
			responseObserver.onNext(result);
			if (onComplete) {
				responseObserver.onCompleted();
			}
		}
	}

	@Override
	public void getLeveledConfigOption(Option request, StreamObserver<ValueOption> responseObserver) {
		getConfigOption(request, responseObserver, true);
	}

	@Override
	public StreamObserver<Option> getLeveledConfigOptions(StreamObserver<ValueOption> responseObserver) {
		synchronized (fConfiguration) {
			return new StreamObserver<Option>() {

				@Override
				public void onCompleted() {
					responseObserver.onCompleted();
				}

				@Override
				public void onError(Throwable t) {

				}

				@Override
				public void onNext(Option o) {
					getConfigOption(o, responseObserver, false);
				}

			};
		}
	}

	@Override
	public StreamObserver<Path> getGlobalConfigOptions(StreamObserver<ValueOption> responseObserver) {
		synchronized (fConfiguration) {
			return new StreamObserver<Path>() {

				@Override
				public void onCompleted() {
					responseObserver.onCompleted();
				}

				@Override
				public void onError(Throwable t) {

				}

				@Override
				public void onNext(Path o) {
					getGlobalConfigOption(o, responseObserver, false);
				}
			};
		}
	}

	@Override
	public void setConfigOption(ValueOption request, StreamObserver<Empty> responseObserver) {
		synchronized (fConfiguration) {
			HashMap<String, ValueOption> levelMap = fConfiguration.get(request.getLevel());
			if (levelMap == null) {
				levelMap = new HashMap<>();
				fConfiguration.put(request.getLevel(), levelMap);
			}
			levelMap.put(request.getPath(), request);
			responseObserver.onNext(Constants.kEMPTY);
			responseObserver.onCompleted();
		}

		synchronized (fListeners) {
			fListeners.forEach(l -> l.onSet(request));
		}
	}

	@Override
	public void unsetLeveledConfigOption(Option request, StreamObserver<Empty> responseObserver) {
		synchronized (fConfiguration) {
			final HashMap<String, ValueOption> levelMap = fConfiguration.get(request.getLevel());
			if (levelMap != null) {
				levelMap.remove(request.getPath());
			}
			responseObserver.onNext(Constants.kEMPTY);
			responseObserver.onCompleted();
		}

		synchronized (fListeners) {
			fListeners.forEach(l -> l.onRemove(request));
		}
	}

	@Override
	public void unsetGlobalConfigOption(Path request, StreamObserver<Empty> responseObserver) {
		synchronized (fConfiguration) {
			fConfiguration.values().parallelStream().forEach(m -> m.remove(request.getPath()));
			responseObserver.onNext(Constants.kEMPTY);
			responseObserver.onCompleted();
		}

		synchronized (fListeners) {
			fListeners.forEach(l -> l.onRemoveAll(request));
		}
	}

	@Override
	public void getLeveledNameList(Option request, StreamObserver<NameList> responseObserver) {
		synchronized (fConfiguration) {
			final HashMap<String, ValueOption> levelMap = fConfiguration.get(request.getLevel());
			final NameList.Builder nl = NameList.newBuilder();
			if (levelMap != null) {
				levelMap.keySet().forEach(
						path -> nl.addNamelist(Option.newBuilder().setLevel(request.getLevel()).setPath(path)));
			}
			responseObserver.onNext(nl.build());
			responseObserver.onCompleted();
		}
	}

	@Override
	public void getGlobalNameList(Path request, StreamObserver<NameList> responseObserver) {
		synchronized (fConfiguration) {

			final NameList.Builder nl = NameList.newBuilder();

			fConfiguration.forEach((level, levelMap) -> {
				levelMap.keySet()
						.forEach(path -> nl.addNamelist(Option.newBuilder().setLevel(level.intValue()).setPath(path)));
			});

			responseObserver.onNext(nl.build());
			responseObserver.onCompleted();
		}
	}

	@Override
	public void getLevel(Level request, StreamObserver<ValueOption> responseObserver) {
		synchronized (fConfiguration) {
			final HashMap<String, ValueOption> levelMap = fConfiguration.get(request.getLevel());
			if (levelMap != null) {
				levelMap.values().forEach(v -> responseObserver.onNext(v));
			}
			responseObserver.onCompleted();
		}
	}

}
