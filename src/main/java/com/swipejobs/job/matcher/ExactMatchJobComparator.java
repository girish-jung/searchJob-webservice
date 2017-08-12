package com.swipejobs.job.matcher;

import java.util.Comparator;

import com.swipejobs.model.ExactMatchingJob;

/**
 * Comparator to sort {@link ExactMatchingJob} based following priority
 * 	1. BillRate
 *  2. JobDistance
 *  3. StartDate
 *  
 * @author Girish Jung
 *
 */
public class ExactMatchJobComparator implements Comparator<ExactMatchingJob> {

	@Override
	public int compare(ExactMatchingJob job1, ExactMatchingJob job2) {
		if (job1.getBillRate() != job2.getBillRate()) {
			return job2.getWageRate().compareTo(job1.getWageRate());
		} else if (job2.getJobDistance() != job1.getJobDistance()) {
			return job2.getJobDistance().compareTo(job1.getJobDistance());
		} 
		return job2.getStartDate().compareTo(job1.getStartDate());
	}

}
