package com.swipejobs.job.matcher;

import java.util.Collections;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.swipejobs.model.Job;
import com.swipejobs.model.MatchedJobContainer;
import com.swipejobs.model.Worker;
import com.swipejobs.service.api.JobService;
import com.swipejobs.service.api.WorkerService;

/**
 * Job Matcher Engine class to find suitable jobs for the workers w.r.t their personal preferences and other business logic.
 * 
 * @author Girish Jung
 *
 */
@Component
public class JobMatchingEngine {
	
	private final static Logger logger = LoggerFactory.getLogger(JobMatchingEngine.class);
	
	/** Max. number of jobs returned by the API */
	 @Value("${number.of.jobs.to.dispaly}")
	private int NUMBER_OF_JOBS_TO_DISPLAY;
	
	@Autowired
	private WorkerService workerService;
	
	@Autowired
	private JobService jobService;
	
	@Autowired
	private JobMatchingEngineHelper jmeHelper;
	
	/**
	 * Service to fetch suitable jobs for a given worker ID.
	 * @param userId
	 * @return
	 */
	public List<Job> findSuitableJobsForWorker(int userId) {
		return findSuitableJobsForWorker(workerService.findWorkerById(userId));
	}
	
	/**
	 * Overloaded method for {@link #findSuitableJobsForWorker(int)}.
	 * @param {@link Worker} 
	 */
	public List<Job> findSuitableJobsForWorker(Worker worker) {
		MatchedJobContainer matchedJobContainer = new MatchedJobContainer();
		
		if (worker != null && worker.getIsActive()) {
			List<Job> jobs = jobService.getAllJobs();
			
			for (Job job : jobs) {
				if (jmeHelper.isDLCriteriaMatches(worker.getHasDriversLicense(), job.getDriverLicenseRequired()) &&
						jmeHelper.isWorkerCertified(worker.getCertificates(), job.getRequiredCertificates()) &&
						jmeHelper.isJobAtPermissibleDistance(worker.getJobSearchAddress(), job.getLocation()) &&
						jmeHelper.hasDesiredSkill(worker.getSkills(), job.getJobTitle())) {
					
					matchedJobContainer.getExactMatchingJobs().add(jmeHelper.createExcatMatchingJob(job, worker));
				}
				
				logger.debug("No excat match between workerId {} and JobId {}", worker.getUserId(), job.getJobId());
			}
			return jmeHelper.getTopJobMatch(matchedJobContainer.getExactMatchingJobs(), NUMBER_OF_JOBS_TO_DISPLAY);
		}
		
		logger.info("Worker is not Actively looking for jobs");
		return Collections.emptyList();
	}
	
	
	
}
