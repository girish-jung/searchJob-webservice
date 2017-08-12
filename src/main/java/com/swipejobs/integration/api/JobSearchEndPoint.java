package com.swipejobs.integration.api;

import javax.ws.rs.PathParam;
import javax.ws.rs.core.Response;


/**
 * @author Girish Jung
 *
 */
public interface JobSearchEndPoint {
	
	/**
	 * Fetches top 3 job matches for a worker
	 * @param userId of the worker
	 * @return 
	 */
	public Response findSuitableJobs(@PathParam("userId") String userId);

}
