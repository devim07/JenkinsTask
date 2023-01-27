package com.sacumen.devi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sacumen.devi.entities.JenkinsJob;
import com.sacumen.devi.service.IJenkinsJobService;

@RestController
@RequestMapping("/jenkins-jobs")
public class JenkinksJobController {
	
	
	@Autowired
	private IJenkinsJobService jenkinsJobService;
	
	
	@GetMapping("/get-all-jobs")
	public List<JenkinsJob> getAllJobs(){
		return jenkinsJobService.getAllJobs();
	}

}
