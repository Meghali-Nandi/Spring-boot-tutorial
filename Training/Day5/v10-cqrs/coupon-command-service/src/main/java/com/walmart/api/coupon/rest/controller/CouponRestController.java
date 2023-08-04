package com.walmart.api.coupon.rest.controller;

import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.walmart.api.coupon.command.CreateCouponCommand;
import com.walmart.api.coupon.dao.CouponDao;
import com.walmart.api.coupon.models.Coupon;

@RestController
public class CouponRestController {

	@Autowired
	private CommandGateway commandGateway;
	
	@PostMapping("/api/coupon")
	public String createCoupon(@RequestBody Coupon c) {
		// We need to create command object.
		CreateCouponCommand command= new CreateCouponCommand();
		command.setId("1");
		command.setDiscount(50);
		command.setCouponCode("c1");
		
		//When the command object is ready, we need to send the object to command bus. 
		// In order to do this we need to inject commandGateway in this controller. 
		// To use CommandGateway, we need Axon dependency
		
		String returnValue = commandGateway.sendAndWait(command);
		return returnValue;
	}
	
}
