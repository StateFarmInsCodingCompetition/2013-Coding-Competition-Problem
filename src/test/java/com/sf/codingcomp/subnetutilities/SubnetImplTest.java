package com.sf.codingcomp.subnetutilities;

import static org.junit.Assert.*;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;

//
//Do not change anything in the following JAVA class!
//
public class SubnetImplTest {

	private SubnetImpl subnet;

	@Test
	public void testMask() throws UnknownHostException {
		InetAddress ipAddress = InetAddress.getByName("0.0.0.0");

		try {
			this.subnet = new SubnetImpl(ipAddress, 33);
			fail("Mask is too high.");
		} catch(InvalidMaskException e) {
			// pass
		}

		try {
			this.subnet = new SubnetImpl(ipAddress, 0);
			fail("Mask is invalid.");
		} catch(InvalidMaskException e) {
			// pass
		}

		for(int i = 1; i < 33; i++) {
			try {
				this.subnet = new SubnetImpl(ipAddress, i);
			} catch(InvalidMaskException e) {
				fail("All of these values should succeed.");
			}
		}
	}

	@Test
	public void testIsIPInRangeClassC() throws UnknownHostException, InvalidMaskException {
		// Set Class C
		InetAddress ipAddress = InetAddress.getByName("192.168.1.0");
		this.subnet = new SubnetImpl(ipAddress, 24);

		// Lower limit
		InetAddress testIP = InetAddress.getByName("192.168.1.0");
		assertTrue(this.subnet.isIPInRange(testIP));

		// Upper limit
		testIP = InetAddress.getByName("192.168.1.255");
		assertTrue(this.subnet.isIPInRange(testIP));

		// Regular IP
		testIP = InetAddress.getByName("192.168.1.10");
		assertTrue(this.subnet.isIPInRange(testIP));

		// Not in range (too low by 1)
		testIP = InetAddress.getByName("192.168.0.255");
		assertFalse(this.subnet.isIPInRange(testIP));

		// Not in range (too high by 1)
		testIP = InetAddress.getByName("192.168.2.0");
		assertFalse(this.subnet.isIPInRange(testIP));

		// Not in range (far too high)
		testIP = InetAddress.getByName("255.255.255.255");
		assertFalse(this.subnet.isIPInRange(testIP));

		// Not in range (far too low)
		testIP = InetAddress.getByName("0.0.0.0");
		assertFalse(this.subnet.isIPInRange(testIP));
	}

	@Test
	public void testIsIPInRangeClassB() throws UnknownHostException, InvalidMaskException {
		// Set Class B
		InetAddress ipAddress = InetAddress.getByName("10.0.0.0");
		this.subnet = new SubnetImpl(ipAddress, 16);

		// Lower limit
		InetAddress testIP = InetAddress.getByName("10.0.0.0");
		assertTrue(this.subnet.isIPInRange(testIP));

		// Upper limit
		testIP = InetAddress.getByName("10.0.255.255");
		assertTrue(this.subnet.isIPInRange(testIP));

		// Regular IP
		testIP = InetAddress.getByName("10.0.20.63");
		assertTrue(this.subnet.isIPInRange(testIP));

		// Regular IP
		testIP = InetAddress.getByName("10.0.143.255");
		assertTrue(this.subnet.isIPInRange(testIP));

		// Not in range (too low by 1)
		testIP = InetAddress.getByName("9.255.255.255");
		assertFalse(this.subnet.isIPInRange(testIP));

		// Not in range (too high by 1)
		testIP = InetAddress.getByName("10.1.0.0");
		assertFalse(this.subnet.isIPInRange(testIP));

		// Not in range (far too high)
		testIP = InetAddress.getByName("255.255.255.255");
		assertFalse(this.subnet.isIPInRange(testIP));

		// Not in range (far too low)
		testIP = InetAddress.getByName("0.0.0.0");
		assertFalse(this.subnet.isIPInRange(testIP));
	}

	/**
	 * Simple getNetworkAddress() test. Only inputting network addresses.
	 * For these it can be safely assumed that you will receive a network address in your constructor
	 * and that should be the one to return. Look at the advanced test for a more full test.
	 * @throws UnknownHostException
	 * @throws InvalidMaskException
	 */
	@Test
	public void testSimpleGetNetworkAddress() throws UnknownHostException, InvalidMaskException {
		InetAddress ipAddress = InetAddress.getByName("10.0.0.0");
		this.subnet = new SubnetImpl(ipAddress, 24);
		InetAddress networkAddress = this.subnet.getNetworkAddress();
		assertTrue(Arrays.equals(new byte[]{(byte)10, (byte)0, (byte)0, (byte)0}, networkAddress.getAddress()));

		ipAddress = InetAddress.getByName("10.0.0.0");
		this.subnet = new SubnetImpl(ipAddress, 16);
		networkAddress = this.subnet.getNetworkAddress();
		assertTrue(Arrays.equals(new byte[]{(byte)10, (byte)0, (byte)0, (byte)0}, networkAddress.getAddress()));

		ipAddress = InetAddress.getByName("192.168.1.0");
		this.subnet = new SubnetImpl(ipAddress, 24);
		networkAddress = this.subnet.getNetworkAddress();
		assertTrue(Arrays.equals(new byte[]{(byte)192, (byte)168, (byte)1, (byte)0}, networkAddress.getAddress()));

		ipAddress = InetAddress.getByName("192.168.1.64");
		this.subnet = new SubnetImpl(ipAddress, 26);
		networkAddress = this.subnet.getNetworkAddress();
		assertTrue(Arrays.equals(new byte[]{(byte)192, (byte)168, (byte)1, (byte)64}, networkAddress.getAddress()));
	}

	/**
	 * More advanced tests for getNetworkAddress(). The address passed in is NOT the network address.
	 * @throws UnknownHostException
	 * @throws InvalidMaskException
	 */
	@Test
	public void testAdvancedGetNetworkAddress() throws UnknownHostException, InvalidMaskException {
		InetAddress ipAddress = InetAddress.getByName("10.0.0.4");
		this.subnet = new SubnetImpl(ipAddress, 24);
		InetAddress networkAddress = this.subnet.getNetworkAddress();
		assertTrue(Arrays.equals(new byte[]{(byte)10, (byte)0, (byte)0, (byte)0}, networkAddress.getAddress()));

		ipAddress = InetAddress.getByName("10.0.0.8");
		this.subnet = new SubnetImpl(ipAddress, 16);
		networkAddress = this.subnet.getNetworkAddress();
		assertTrue(Arrays.equals(new byte[]{(byte)10, (byte)0, (byte)0, (byte)0}, networkAddress.getAddress()));

		ipAddress = InetAddress.getByName("192.168.1.0");
		this.subnet = new SubnetImpl(ipAddress, 24);
		networkAddress = this.subnet.getNetworkAddress();
		assertTrue(Arrays.equals(new byte[]{(byte)192, (byte)168, (byte)1, (byte)0}, networkAddress.getAddress()));

		ipAddress = InetAddress.getByName("192.168.1.66");
		this.subnet = new SubnetImpl(ipAddress, 26);
		networkAddress = this.subnet.getNetworkAddress();
		assertTrue(Arrays.equals(new byte[]{(byte)192, (byte)168, (byte)1, (byte)64}, networkAddress.getAddress()));
	}

	/**
	 * Tests for non-standard, very large networks. Considered advanced tests.
	 * @throws UnknownHostException
	 * @throws InvalidMaskException
	 */
	@Test
	public void testLargeNetworkGetNetworkAddress() throws UnknownHostException, InvalidMaskException {
		InetAddress ipAddress = InetAddress.getByName("192.168.1.1");
		this.subnet = new SubnetImpl(ipAddress, 1);
		InetAddress networkAddress = this.subnet.getNetworkAddress();
		assertTrue(Arrays.equals(new byte[]{(byte)128, (byte)0, (byte)0, (byte)0}, networkAddress.getAddress()));

		ipAddress = InetAddress.getByName("194.0.0.0");
		this.subnet = new SubnetImpl(ipAddress, 7);
		networkAddress = this.subnet.getNetworkAddress();
		assertTrue(Arrays.equals(new byte[]{(byte)194, (byte)0, (byte)0, (byte)0}, networkAddress.getAddress()));
	}

	/**
	 * Tests for non-standard, very small networks. Considered advanced tests.
	 * @throws UnknownHostException
	 * @throws InvalidMaskException
	 */
	@Test
	public void testSmallNetworkGetNetworkAddress() throws UnknownHostException, InvalidMaskException {
		InetAddress ipAddress = InetAddress.getByName("192.168.1.6");
		this.subnet = new SubnetImpl(ipAddress, 30);
		InetAddress networkAddress = this.subnet.getNetworkAddress();
		assertTrue(Arrays.equals(new byte[]{(byte)192, (byte)168, (byte)1, (byte)4}, networkAddress.getAddress()));

		ipAddress = InetAddress.getByName("192.168.1.7");
		this.subnet = new SubnetImpl(ipAddress, 32);
		networkAddress = this.subnet.getNetworkAddress();
		assertTrue(Arrays.equals(new byte[]{(byte)192, (byte)168, (byte)1, (byte)7}, networkAddress.getAddress()));
	}

	/**
	 * Simple getBroadcastAddress() test. Only inputting network addresses.
	 * See below for more advanced tests.
	 * @throws InvalidMaskException
	 * @throws UnknownHostException
	 */
	@Test
	public void testSimpleGetBroadcastAddress() throws InvalidMaskException, UnknownHostException {
		InetAddress ipAddress = InetAddress.getByName("192.168.1.0");
		this.subnet = new SubnetImpl(ipAddress, 24);
		InetAddress broadcastAddress = this.subnet.getBroadcastAddress();
		assertTrue(Arrays.equals(new byte[]{(byte)192, (byte)168, (byte)1, (byte)255}, broadcastAddress.getAddress()));

		ipAddress = InetAddress.getByName("192.168.1.0");
		this.subnet = new SubnetImpl(ipAddress, 26);
		broadcastAddress = this.subnet.getBroadcastAddress();
		assertTrue(Arrays.equals(new byte[]{(byte)192, (byte)168, (byte)1, (byte)63}, broadcastAddress.getAddress()));
	}

	/**
	 * More advanced tests for getting the broadcast address. Tests inputs of non-network addresses.
	 * @throws UnknownHostException
	 * @throws InvalidMaskException
	 */
	@Test
	public void testAdvancedGetBroadcastAddress() throws UnknownHostException, InvalidMaskException {
		InetAddress ipAddress = InetAddress.getByName("192.168.1.2");
		this.subnet = new SubnetImpl(ipAddress, 24);
		InetAddress broadcastAddress = this.subnet.getBroadcastAddress();
		assertTrue(Arrays.equals(new byte[]{(byte)192, (byte)168, (byte)1, (byte)255}, broadcastAddress.getAddress()));

		ipAddress = InetAddress.getByName("192.168.1.8");
		this.subnet = new SubnetImpl(ipAddress, 26);
		broadcastAddress = this.subnet.getBroadcastAddress();
		assertTrue(Arrays.equals(new byte[]{(byte)192, (byte)168, (byte)1, (byte)63}, broadcastAddress.getAddress()));

		ipAddress = InetAddress.getByName("192.168.1.129");
		this.subnet = new SubnetImpl(ipAddress, 26);
		broadcastAddress = this.subnet.getBroadcastAddress();
		assertTrue(Arrays.equals(new byte[]{(byte)192, (byte)168, (byte)1, (byte)191}, broadcastAddress.getAddress()));
	}

	/**
	 * getAllAddresses() is an ordered method.
	 * @throws UnknownHostException
	 * @throws InvalidMaskException
	 */
	@Test
	public void testGetAllAddresses() throws UnknownHostException, InvalidMaskException {
		InetAddress subnetAddress = InetAddress.getByName("192.168.1.0");
		this.subnet = new SubnetImpl(subnetAddress, 30);
		
		List<InetAddress> ipAddresses = this.subnet.getAllAddresses();

		assertEquals(4, ipAddresses.size());
		assertTrue(Arrays.equals(new byte[]{(byte)192, (byte)168, (byte)1, (byte)0}, ipAddresses.get(0).getAddress()));
		assertTrue(Arrays.equals(new byte[]{(byte)192, (byte)168, (byte)1, (byte)1}, ipAddresses.get(1).getAddress()));
		assertTrue(Arrays.equals(new byte[]{(byte)192, (byte)168, (byte)1, (byte)2}, ipAddresses.get(2).getAddress()));
		assertTrue(Arrays.equals(new byte[]{(byte)192, (byte)168, (byte)1, (byte)3}, ipAddresses.get(3).getAddress()));
		
		subnetAddress = InetAddress.getByName("192.168.1.4");
		this.subnet = new SubnetImpl(subnetAddress, 30);
		
		ipAddresses = this.subnet.getAllAddresses();
		
		assertEquals(4, ipAddresses.size());
		assertTrue(Arrays.equals(new byte[]{(byte)192, (byte)168, (byte)1, (byte)4}, ipAddresses.get(0).getAddress()));
		assertTrue(Arrays.equals(new byte[]{(byte)192, (byte)168, (byte)1, (byte)5}, ipAddresses.get(1).getAddress()));
		assertTrue(Arrays.equals(new byte[]{(byte)192, (byte)168, (byte)1, (byte)6}, ipAddresses.get(2).getAddress()));
		assertTrue(Arrays.equals(new byte[]{(byte)192, (byte)168, (byte)1, (byte)7}, ipAddresses.get(3).getAddress()));
	}

	/**
	 * Including network and broadcast addresses.
	 * @throws UnknownHostException 
	 * @throws InvalidMaskException 
	 */
	@Test
	public void testGetAddressCount() throws UnknownHostException, InvalidMaskException {
		InetAddress ipAddress = InetAddress.getByName("192.168.1.0");
		this.subnet = new SubnetImpl(ipAddress, 24);
		assertEquals(256, this.subnet.getAddressCount());

		this.subnet = new SubnetImpl(ipAddress, 15);
		assertEquals(131072, this.subnet.getAddressCount());

		this.subnet = new SubnetImpl(ipAddress, 30);
		assertEquals(4, this.subnet.getAddressCount());
	}

}
