package org.uv.DAPP04Practica04.DAPP04Practica04;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@EnableAutoConfiguration
@EnableWebMvc
@Configuration
@ComponentScan
@SpringBootApplication
public class Dapp04Practica04Application {

	public static void main(String[] args) {
		SpringApplication.run(Dapp04Practica04Application.class, args);
	}

}
