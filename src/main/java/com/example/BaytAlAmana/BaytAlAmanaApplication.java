package com.example.BaytAlAmana;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.boot.autoconfigure.security.servlet.UserDetailsServiceAutoConfiguration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(exclude = {SecurityAutoConfiguration.class, UserDetailsServiceAutoConfiguration.class})
@EnableJpaRepositories(basePackages = "com.example.BaytAlAmana.repo")
public class BaytAlAmanaApplication {
	public static void main(String[] args) {
		SpringApplication.run(BaytAlAmanaApplication.class, args);
	}

}
