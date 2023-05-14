package com.example.mas;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class MasApplication {

	public static void main(String[] args) {
		//SpringApplication.run(MasApplication.class, args);
		SpringApplicationBuilder builder = new SpringApplicationBuilder(MasApplication.class);

		builder.headless(false);

		ConfigurableApplicationContext context = builder.run(args);
	}

}
