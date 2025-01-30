package com.example.java_rps;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@SpringBootApplication
public class JavaRpsApplication {

	public static void main(String[] args) {
		SpringApplication.run(JavaRpsApplication.class, args);
		System.out.println("[SpringBoot] - Running...");
	}

}
