package com.demo.example.NoteTakingBackend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class NoteTakingBackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(NoteTakingBackendApplication.class, args);
		/*
		 * Facing issue that port 8080 is already in use I was unable to find where this port is being used
		 * the below can be executed in bash terminal to achieve the same.
		 * lsof -i :8080 -- will return the PID
		 * kill -9 <PID>
		 */
		System.out.println("Hello!!");
	}

}
