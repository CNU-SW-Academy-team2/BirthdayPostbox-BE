package com.project.BirthdayPostbox;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

//@SpringBootApplication(exclude={DataSourceAutoConfiguration.class})
@EnableScheduling
@SpringBootApplication
public class BirthdayPostboxApplication {

	public static void main(String[] args) {
		SpringApplication.run(BirthdayPostboxApplication.class, args);
	}

}
