package com.simplilearn.devops.testdevops.monitoring.service;


import java.util.Optional;

import org.springframework.stereotype.Service;

@Service
public class HelloService {

	public String sayHello(String serviceCaller) {
		String sc = Optional.ofNullable(serviceCaller).orElseGet(() -> "Guest");
		return "Hello "+sc;
	}
}
