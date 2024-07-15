package com.datricle.JpaTuts.JpaTutorial;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class JpaTutorialApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(JpaTutorialApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println("Application Started Running");
	}
}