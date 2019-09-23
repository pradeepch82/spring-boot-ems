package com.controllers;

import java.util.Date;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetController {

	public GreetController() {
		System.out.println("GreetController created....");
	}

	@GetMapping("/greet")
	public String welcome() {
		return "Greeting To Spring Web MVC-";
	}

	@GetMapping("/today")
	public String today() {
		return "Greeting :Today is :" + new Date();
	}

}
