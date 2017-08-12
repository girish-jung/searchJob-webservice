package com.swipejobs.model;

/**
 * 
 * @author Girish Jung
 *
 */
public class PartiallyMatchingJob extends Job {
	
	private int numberOfMatches;
	
	private boolean isCertified;
	
	private boolean deltaInExpectedLocation;

	public int getNumberOfMatches() {
		return numberOfMatches;
	}

	public void setNumberOfMatches(int numberOfMatches) {
		this.numberOfMatches = numberOfMatches;
	}

	public boolean isCertified() {
		return isCertified;
	}

	public void setCertified(boolean isCertified) {
		this.isCertified = isCertified;
	}

	public boolean isDeltaInExpectedLocation() {
		return deltaInExpectedLocation;
	}

	public void setDeltaInExpectedLocation(boolean deltaInExpectedLocation) {
		this.deltaInExpectedLocation = deltaInExpectedLocation;
	}
}
