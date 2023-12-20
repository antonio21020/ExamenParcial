package com.paz.denunciaservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class ApiDenunciaApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApiDenunciaApplication.class, args);
	}

}
