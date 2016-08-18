package com.sf.codingcomp.velociraptor;

public class Prey {

	private int topSpeed; // in miles per hour
	private double currentLead; // in feet

	public Prey(int topSpeed, int currentLead) {
		this.topSpeed = topSpeed;
		this.currentLead = currentLead;
	}

	public int getTopSpeed() {
		return topSpeed;
	}

	public void setTopSpeed(int topSpeed) {
		this.topSpeed = topSpeed;
	}

	public double getCurrentLead() {
		return currentLead;
	}

	public void setCurrentLead(double currentLead) {
		this.currentLead = currentLead;
	}

}
