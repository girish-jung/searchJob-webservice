package com.swipejobs.integration.api.impl;

import java.util.Collections;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.apache.commons.lang3.math.NumberUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.swipejobs.integration.api.JobSearchEndPoint;
import com.swipejobs.job.matcher.JobMatchingEngine;
import com.swipejobs.model.Job;


/**
 * Rest Endpoint for jobs search
 * @author Girish Jung
 *
 */
@Component
@Path("/findjobs")
public class JobSearchEndPointImpl implements JobSearchEndPoint {
	
	private final static Logger logger = LoggerFactory.getLogger(JobSearchEndPointImpl.class);
	
	@Autowired
	private JobMatchingEngine jobMatchingEngine;
	
	@GET
	@Path(("/json/{userId}"))
	@Produces({MediaType.APPLICATION_JSON })
	@Override
	public Response findSuitableJobs(@PathParam("userId") String userId) {
		logger.debug("Find Suitable Jobs API triggered for worker {}", userId);
		
		if (NumberUtils.isDigits(userId) && NumberUtils.isNumber(userId)) {
			
			int workerId = Integer.parseInt(userId);
			List<Job> jobs = jobMatchingEngine.findSuitableJobsForWorker(workerId);
			
			if (jobs == null) {
				jobs = Collections.emptyList();
			}
			
			logger.info("Fetched {} jobs for the worker {}", jobs.size(), userId);
			return Response.status(Status.OK).entity(jobs).build();
		}
		
		logger.error("Invalid userID {}, Please pass a valid userId", userId);
		return Response.status(Status.OK).entity(Collections.EMPTY_LIST).build();
	}

}
