package com.springapp.proyjav;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ProyjavApplication {

	public static void main(String[] args) {
		try {
			SpringApplication.run(ProyjavApplication.class, args);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
