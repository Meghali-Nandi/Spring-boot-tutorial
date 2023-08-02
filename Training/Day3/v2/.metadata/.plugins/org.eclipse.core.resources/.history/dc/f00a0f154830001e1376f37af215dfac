package com.walmart.api.coupon;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.walmart.api.coupon.dao.CouponDao;
import com.walmart.api.coupon.models.Coupon;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		ConfigurableApplicationContext container=SpringApplication.run(Application.class, args);
		CouponDao coupondao=container.getBean(CouponDao.class);
		
		//Write switch case with 5 options - 
		// 1. create
		//2. findbyid
		//3. findall
		//4. update
		//5.delete
		Coupon coupon=new Coupon();
		coupon.setCouponCode("c1");
		coupon.setDiscount(50);
		coupon.setId("2");
		System.out.println("Created coupon 2 with id 2");
		
		coupondao.save(coupon);
		coupondao.findById("2");
		coupondao.findAll();
		
		Coupon coupon3=new Coupon();
		coupon3.setCouponCode("c1");
		coupon3.setDiscount(100);
		coupon3.setId("2");
		
		coupondao.save(coupon3);
		coupondao.delete(coupon2);
	}
}
