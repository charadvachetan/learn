package com.chetan.lab3server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;


/**
 * This is config server.
 */
@SpringBootApplication
@EnableConfigServer
public class Lab3ServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(Lab3ServerApplication.class, args);
	}
}
