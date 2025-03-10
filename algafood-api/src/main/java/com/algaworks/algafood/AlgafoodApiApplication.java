package com.algaworks.algafood;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.TimeZone;

@SpringBootApplication
public class AlgafoodApiApplication {

	public static void main(String[] args) {
		TimeZone.setDefault(TimeZone.getTimeZone("UTC")); //Mudei o TimeZone apenas na aplicação, para não ficar dependendo do sistema operacional
		SpringApplication.run(AlgafoodApiApplication.class, args);
	}

}
