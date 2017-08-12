package com.swipejobs.service.impl;

import java.io.IOException;
import java.net.URL;
import java.util.List;

import org.codehaus.jackson.map.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.swipejobs.model.Job;
import com.swipejobs.service.api.JobService;

/**
 * 
 * @author Girish Jung
 *
 */
@Service
public class JobServiceImpl implements JobService {
	
	private final static Logger logger = LoggerFactory.getLogger(JobServiceImpl.class);
	
	@Value("${job.rest.url}")
	private String JOB_REST_URL;

	@Override
	public List<Job> getAllJobs() {
		URL url = null;
		ObjectMapper mapper = new ObjectMapper();
		List<Job> jobs = null;
		
		try {
			url = new URL(JOB_REST_URL);
			jobs = mapper.readValue(url, mapper.getTypeFactory().constructCollectionType(List.class, Job.class));
		
		} catch (IOException e) {
			logger.error("Unable to fetch jobs from the API", e);
		}
		logger.debug("Total {} workers fetched", (jobs!= null ? jobs.size():0));
		return jobs;
	}

	@Override
	public List<Job> getJobById(int jobId) {
		return null;
	}

}
