package com.sacumen.devi;

import java.net.URI;
import java.net.URISyntaxException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.offbytwo.jenkins.JenkinsServer;

@SpringBootApplication
public class JenkinsTaskApplication {

public static Logger LOGGER=LoggerFactory.getLogger(JenkinsTaskApplication.class);

	
	public static void main(String[] args) {
		SpringApplication.run(JenkinsTaskApplication.class, args);
	}
	
	
	@Bean
	public JenkinsServer getServer(){
		try {
			JenkinsServer server = new JenkinsServer(new URI("http://localhost:8080/"), "devidinesh07", "password");
			LOGGER.info("JenkinsServer :: {}", server);
			return server;
		} catch (URISyntaxException e) {
			LOGGER.error("JenkinsServer :: {}", e.getMessage());
			return null;
		}
	}

}
