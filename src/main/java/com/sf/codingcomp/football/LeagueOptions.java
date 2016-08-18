package com.sf.codingcomp.football;

public class LeagueOptions {

	private boolean partialPointsAllowed;
	private int maximumPlayersAtEachPosition;

	public boolean isPartialPointsAllowed() {
		return partialPointsAllowed;
	}

	public void setPartialPointsAllowed(boolean partialPointsAllowed) {
		this.partialPointsAllowed = partialPointsAllowed;
	}

	public int getMaximumPlayersAtEachPosition() {
		return maximumPlayersAtEachPosition;
	}

	public void setMaximumPlayersAtEachPosition(int maximumPlayersAtEachPosition) {
		this.maximumPlayersAtEachPosition = maximumPlayersAtEachPosition;
	}
	
}
