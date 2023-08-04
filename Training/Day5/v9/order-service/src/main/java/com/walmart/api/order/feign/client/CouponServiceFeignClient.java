package com.walmart.api.order.feign.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.walmart.api.order.rest.response.CouponResponse;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;


@FeignClient(name="api-gateway") // name here mentioned is the logical name of the coupon-service as it is registered with eureka
public interface CouponServiceFeignClient {
	
//	@CircuitBreaker(name="cs",fallbackMethod = "findDiscountByCouponIdFallback")
	@GetMapping("coupon-service/api/coupon/{id}")
	public CouponResponse findDiscountByCouponId(@PathVariable String id);
	
//	default public CouponResponse findDiscountByCouponIdFallback(@PathVariable String id, Throwable t) {
//		System.out.println("In fallback method");
//		CouponResponse c = new CouponResponse();
//		c.setDiscount(0);
//		return c;
//	}
}
