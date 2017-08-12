package com.swipejobs.service.api;

import java.util.List;

import com.swipejobs.model.Job;

/**
 * Service to fetch Jobs
 * @author Girish Jung
 *
 */
public interface JobService {
	
	/**
	 * Service to fetch all the jobs in the market.
	 * @return
	 */
	public List<Job> getAllJobs();
	
	/**
	 * Service to fetch job by JobID
	 * @param Id
	 * @return
	 */
	public List<Job> getJobById(int Id);

}
