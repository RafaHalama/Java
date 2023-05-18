package com.example.mas;

import com.example.mas.service.GraRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
public class MasApplication {

	public static void main(String[] args) {
		//SpringApplication.run(MasApplication.class, args);
		SpringApplicationBuilder builder = new SpringApplicationBuilder(MasApplication.class);

		builder.headless(false);

		ConfigurableApplicationContext context = builder.run(args);
	}

}
