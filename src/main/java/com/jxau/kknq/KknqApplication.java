package com.jxau.kknq;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "com.jxau.kknq.*")
public class KknqApplication{

	public static void main(String[] args) {
		SpringApplication.run(KknqApplication.class, args);
	}

}
