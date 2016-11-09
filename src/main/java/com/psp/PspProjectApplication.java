package com.psp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

@SpringBootApplication
public class PspProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(PspProjectApplication.class, args);
	}
}
