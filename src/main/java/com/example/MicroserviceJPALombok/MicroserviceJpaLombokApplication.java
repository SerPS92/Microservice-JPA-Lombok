package com.example.MicroserviceJPALombok;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.SpringVersion;

@SpringBootApplication
public class MicroserviceJpaLombokApplication {

	public static void main(String[] args) {
		SpringApplication.run(MicroserviceJpaLombokApplication.class, args);
		System.out.println(SpringVersion.getVersion());
	}

}
