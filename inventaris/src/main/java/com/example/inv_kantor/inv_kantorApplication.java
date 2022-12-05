package com.example.inv_kantor;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "com.example.*")
public class inv_kantorApplication {

	public static void main(String[] args) {
		SpringApplication.run(inv_kantorApplication.class, args);
	}

}
