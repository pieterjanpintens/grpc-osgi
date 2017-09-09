package com.id.grpc.client;

public class Host {
	private final String fHostName;

	private final short fPort;

	public Host(String name, short port) {
		super();
		fHostName = name;
		fPort = port;
	}

	public String getHostName() {
		return fHostName;
	}

	public short getPort() {
		return fPort;
	}

	public String getDisplayName() {
		return fHostName + ":" + fPort;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((fHostName == null) ? 0 : fHostName.hashCode());
		result = prime * result + fPort;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Host other = (Host) obj;
		if (fHostName == null) {
			if (other.fHostName != null)
				return false;
		} else if (!fHostName.equals(other.fHostName))
			return false;
		if (fPort != other.fPort)
			return false;
		return true;
	}

}
