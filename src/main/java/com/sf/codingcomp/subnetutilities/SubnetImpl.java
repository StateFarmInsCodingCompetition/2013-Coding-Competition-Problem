package com.sf.codingcomp.subnetutilities;

import java.net.InetAddress;
import java.util.List;

public class SubnetImpl implements Subnet {
	public SubnetImpl(InetAddress subnet, int mask) throws InvalidMaskException {
		// TODO Auto-generated method stub

	}
	
	public boolean isIPInRange(InetAddress ipAddress) {
		// TODO Auto-generated method stub
		return false;
	}

	public InetAddress getNetworkAddress() {
		// TODO Auto-generated method stub
		return null;
	}

	public InetAddress getBroadcastAddress() {
		// TODO Auto-generated method stub
		return null;
	}

	public List<InetAddress> getAllAddresses() {
		// TODO Auto-generated method stub
		return null;
	}

	public int getAddressCount() {
		// TODO Auto-generated method stub
		return 0;
	}	
}
