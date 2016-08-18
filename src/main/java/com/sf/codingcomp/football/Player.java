package com.sf.codingcomp.football;

public abstract class Player {

	protected int touchdowns;
	protected int yardsGained;
	protected boolean active;

	public Player(int touchdowns, int yardsGained, boolean active) {
		this.touchdowns = touchdowns;
		this.yardsGained = yardsGained;
		this.active = active;
	}

	public abstract double calculateTotalScore(boolean partialPointsAllowed);

	public int getTouchdowns() {
		return touchdowns;
	}

	public void setTouchdowns(int touchdowns) {
		this.touchdowns = touchdowns;
	}

	public int getYardsGained() {
		return yardsGained;
	}

	public void setYardsGained(int yardsGained) {
		this.yardsGained = yardsGained;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

}
