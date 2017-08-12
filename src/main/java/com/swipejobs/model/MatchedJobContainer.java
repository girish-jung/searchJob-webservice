package com.swipejobs.model;

import java.util.Set;
import java.util.TreeSet;

import com.swipejobs.job.matcher.ExactMatchJobComparator;
import com.swipejobs.job.matcher.NearestMatchJobComparator;


/**
 * Container for the Excath Job Match and Partial Job Match.
 * 
 * @author Girish Jung
 *
 */
public class MatchedJobContainer {
	
	/**
	 * Jobs that exactly match the worker's skill-set and personal preferences.
	 */
	private Set<ExactMatchingJob> exactMatchingJobs = new TreeSet<ExactMatchingJob>(new ExactMatchJobComparator());
	
	/**
	 * Jobs that completely match the worker's skill set with the job requirement and but doesn't match his personal preferences. 
	 */
	private Set<PartiallyMatchingJob> partiallyMatchingJobs = new TreeSet<PartiallyMatchingJob>(new NearestMatchJobComparator());

	public Set<ExactMatchingJob> getExactMatchingJobs() {
		return exactMatchingJobs;
	}

	public void setExactMatchingJobs(Set<ExactMatchingJob> exactMatchingJobs) {
		this.exactMatchingJobs = exactMatchingJobs;
	}

	public Set<PartiallyMatchingJob> getPartiallyMatchingJobs() {
		return partiallyMatchingJobs;
	}

	public void setPartiallyMatchingJobs(
			Set<PartiallyMatchingJob> partiallyMatchingJobs) {
		this.partiallyMatchingJobs = partiallyMatchingJobs;
	}

}
