package com.simplilearn.devops.testdevops.monitoring.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.simplilearn.devops.testdevops.monitoring.service.HelloService;

@RestController
public class HelloController {

	private HelloService helloService;

	public HelloController(HelloService helloService) {
		this.helloService = helloService;
	}
	
	@GetMapping("/sayHello/{user}")
	public String sayHello(@PathVariable("user") String serviceCaller) {
		return helloService.sayHello(serviceCaller);
	}
	
	@GetMapping("/sayHello")
	public String sayHello1(String serviceCaller) {
		return helloService.sayHello(serviceCaller);
	}
	
}
