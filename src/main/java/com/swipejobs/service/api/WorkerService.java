package com.swipejobs.service.api;

import java.util.List;

import com.swipejobs.model.Worker;

/**
 * Service to fetch worker's data
 * @author Girish Jung
 *
 */
public interface WorkerService {
	
	/**
	 * Service to fetch all the workers in the system.
	 * @return
	 */
	public List<Worker> getAllWorkers();
	
	/**
	 * Service to fetch worker by workerID/userID
	 * @param userId
	 * @return
	 */
	public Worker findWorkerById(int userId);

}
