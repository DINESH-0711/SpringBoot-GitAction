package com.example.demo.controler;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/endpoint")
public class Student {

	@GetMapping("/hello")
	public String hello() {
		return "Hello from ";
	}
}
 

