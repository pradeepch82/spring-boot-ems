package com;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import springfox.documentation.swagger2.annotations.EnableSwagger2;


@EnableSwagger2
@SpringBootApplication
public class SpringBootEmsV1Application {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootEmsV1Application.class, args);
	}

}
