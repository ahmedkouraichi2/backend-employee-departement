package com.enotes;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
public class SbtEnotesApplication {

	public static void main(String[] args) {
		SpringApplication.run(SbtEnotesApplication.class, args);
		System.out.println("hhhh");
	}

}
