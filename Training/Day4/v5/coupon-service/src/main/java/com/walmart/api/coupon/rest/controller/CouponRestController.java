package com.walmart.api.coupon.rest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.walmart.api.coupon.dao.CouponDao;
import com.walmart.api.coupon.models.Coupon;

@RestController
public class CouponRestController {

	@Autowired
	private CouponDao couponDao;
	
	@GetMapping("/api/coupon/{couponCode}")
	public Coupon findByCouponCode(@PathVariable String couponCode) {
		return couponDao.findByCouponCode(couponCode);
	}
	
}
