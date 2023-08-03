package com.walmart.api.order.rest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloRestController {

	@Autowired
	private Environment env;
	
	@Value("${organization}")
	private String company;
	/**
	 * This uri is used by client application to invoke this method.
	 * @return
	 */
	@GetMapping("/hello")
	public String helloRest() {
		return ("Welcome to rest"+env.getProperty("local.server.port")+" : "+company);
	}
}
