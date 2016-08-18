package com.sf.codingcomp.subnetutilities;

import java.net.InetAddress;
import java.util.List;

//
//Do not change anything in the following JAVA class!
//
public interface Subnet {		
	public boolean isIPInRange(InetAddress ipAddress);
	/**
	 * Get the network address as InetAddress.
	 * @return InetAddress network address.
	 */
	public InetAddress getNetworkAddress();
	
	/**
	 * Get the broadcast address as InetAddress.
	 * @return InetAddress broadcast address.
	 */
	public InetAddress getBroadcastAddress();
	
	/**
	 * Get all addresses in the subnet. This method is ordered.
	 * @return List<InetAddress> where each InetAddress is an address within the subnet.
	 */
	public List<InetAddress> getAllAddresses();
	
	/**
	 * Get the count of addresses in the subnet.
	 * @return integer count of addresses in the subnet.
	 */
	public int getAddressCount();
}
