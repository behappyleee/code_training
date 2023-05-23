package com.my.study_toby;

import com.my.study_toby.config.TobyApplication;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.net.ServerSocket;

// @SpringBootApplication
@TobyApplication
public class StudyTobyApplication {

	ServerSocket sc;


	// This is Test
	// FROM my_toby Branch Test

	public static void main(String[] args) {
		SpringApplication.run(StudyTobyApplication.class, args);
	}

}
