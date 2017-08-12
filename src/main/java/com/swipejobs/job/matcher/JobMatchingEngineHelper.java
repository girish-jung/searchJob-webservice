package com.swipejobs.job.matcher;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.swipejobs.model.ExactMatchingJob;
import com.swipejobs.model.Job;
import com.swipejobs.model.JobSearchAddress;
import com.swipejobs.model.Location;
import com.swipejobs.model.Worker;
import com.swipejobs.utils.CommonNumberUtils;


/**
 * Helper class for {@link JobMatchingEngine}
 * @author Girish Jung
 *
 */
@Component
public class JobMatchingEngineHelper {
	
	@Autowired
	private Mapper dozerBeanMapper;
	
	/*
	 * Returns the top best job matches for a worker 
	 */
	public List<Job> getTopJobMatch(Set<ExactMatchingJob> exactMatchingJobs, int numOfJobs) {
		List<Job> bestSuitableJobs = new ArrayList<Job>(numOfJobs);
		Iterator<ExactMatchingJob> iterator = exactMatchingJobs.iterator();
		
		while(iterator.hasNext() && bestSuitableJobs.size() < numOfJobs) {
			bestSuitableJobs.add(iterator.next());
		}
		return bestSuitableJobs;
	}
	
	
	public boolean isDLCriteriaMatches(boolean workerDLStatus, boolean dlRequiredForJob) {
		boolean dlCheckStatus = workerDLStatus == dlRequiredForJob;
		return dlCheckStatus;
	}
	
	public boolean isWorkerCertified(List<String> workerCertificates, List<String> certRequired) {
		return workerCertificates.containsAll(certRequired);
	}
	
	public boolean isJobAtPermissibleDistance(JobSearchAddress jobSearchAdd, Location jobLocation) {
		double travelDistance = CommonNumberUtils.distanceBetweenTwoLocations(jobSearchAdd.getLatitude(), jobSearchAdd.getLongitude(), 
				jobLocation.getLatitude(), jobLocation.getLongitude());
		return travelDistance <= jobSearchAdd.getMaxJobDistance();
	}
	
	public boolean hasDesiredSkill(List<String> workerSkills, String jobTitle) {
		return workerSkills.contains(jobTitle);
	}
	
	public ExactMatchingJob createExcatMatchingJob(Job job, Worker worker) {
		ExactMatchingJob exactMatchingJob = dozerBeanMapper.map(job, ExactMatchingJob.class);
		populateJobDistance(exactMatchingJob, worker);
		return exactMatchingJob;
	}
	
	public void populateJobDistance(ExactMatchingJob exactMatchingJob, Worker worker) {
		JobSearchAddress jobSearchAdd = worker.getJobSearchAddress();
		Location jobLocation = exactMatchingJob.getLocation();
		
		double jobDistance = CommonNumberUtils.distanceBetweenTwoLocations(jobSearchAdd.getLatitude(), 
				jobSearchAdd.getLongitude(),jobLocation.getLatitude(), jobLocation.getLongitude());
		
		exactMatchingJob.setJobDistance(jobDistance);
	}

}
