package com.sacumen.devi.service.impl;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.offbytwo.jenkins.JenkinsServer;
import com.offbytwo.jenkins.model.Job;
import com.sacumen.devi.entities.JenkinsJob;
import com.sacumen.devi.service.IJenkinsJobService;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
@AllArgsConstructor
public class JenkinsJobService implements IJenkinsJobService {

	private final JenkinsServer jServer;
	
	@Override
	public List<JenkinsJob> getAllJobs() {
		Map<String, Job> jobs;
		List<JenkinsJob> jenkinsJobList=null;
		try {
			jobs = jServer.getJobs();
			log.info("jobs :: {}", jobs);
			
			jenkinsJobList= jobs.values().stream()
					.map(j->{
						try {
							return new JenkinsJob(
									j.getName(), 
									j.details().getLastBuild().details().getResult().toString(), 
									j.details().getLastBuild().getNumber()
							);
						} catch (IOException ex) {
							log.error(ex.getMessage());
							return null;
						}
					})
					.collect(Collectors.toList());
		} catch (IOException e) {
			log.error(e.getMessage());
		}

		return jenkinsJobList;
	}

}
