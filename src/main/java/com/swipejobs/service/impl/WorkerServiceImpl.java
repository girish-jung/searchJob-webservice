package com.swipejobs.service.impl;

import java.io.IOException;
import java.net.URL;
import java.util.List;

import org.codehaus.jackson.map.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.swipejobs.job.matcher.JobMatchingEngine;
import com.swipejobs.model.Worker;
import com.swipejobs.service.api.WorkerService;

/**
 * 
 * @author Girish Jung
 *
 */
@Service
public class WorkerServiceImpl implements WorkerService {

	private final static Logger logger = LoggerFactory.getLogger(JobMatchingEngine.class);
	
	@Value("${worker.rest.url}")
	private String WORKERS_REST_URL;

	@Override
	public List<Worker> getAllWorkers() {
		URL url = null;
		ObjectMapper mapper = new ObjectMapper();
		List<Worker> workers = null;
		
		try {
			url = new URL(WORKERS_REST_URL);
			workers = mapper.readValue(url, mapper.getTypeFactory().constructCollectionType(List.class, Worker.class));
		
		} catch (IOException e) {
			logger.error("Exception while fetching workers from the API", e );
		}
		logger.debug("Total {} workers fetched", (workers!= null ? workers.size():0));
		return workers;
	}

	@Override
	public Worker findWorkerById(int userId) {
		List<Worker> workers = getAllWorkers();
		// TODO GJ: Lambda Expression are not working with sun.jerey. Find a solution later
		/*Optional<Worker> value = workers.stream().filter(entry -> entry.getUserId() == userId).findAny();
		if (value.isPresent()) {
			return value.get();
		} */
		if (workers != null) {
			for (Worker worker : workers) {
				if (worker.getUserId() == userId) {
					return worker;
				}
			}
		}
		logger.error("No worker found with the worker id : {}", userId);
		return null;
	}

}
