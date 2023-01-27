package com.sacumen.devi.entities;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(Include.NON_NULL)
public class JenkinsJob {
	
	@JsonProperty(value = "job_name")
	private String jobName;

	private String status;
	
	@JsonProperty(value = "last_build_number")
	private Integer lastBuildNumber;
}
