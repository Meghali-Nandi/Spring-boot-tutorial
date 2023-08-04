package com.walmart.api.coupon.rest.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloRestController {

	/**
	 * This uri is used by client application to invoke this method.
	 * @return
	 */
	@GetMapping("/hello")
	public String helloRest() {
		return "Hello rest";
	}
}
