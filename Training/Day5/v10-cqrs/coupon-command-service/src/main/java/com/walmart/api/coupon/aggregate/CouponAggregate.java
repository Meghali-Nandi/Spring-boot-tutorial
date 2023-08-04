package com.walmart.api.coupon.aggregate;

import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.modelling.command.AggregateLifecycle;
import org.axonframework.spring.stereotype.Aggregate;

import com.walmart.api.coupon.command.CreateCouponCommand;
import com.walmart.api.coupon.event.CouponCreatedEvent;

import io.axoniq.axonserver.grpc.event.Event;

@Aggregate
public class CouponAggregate {
	
	@AggregateIdentifier
	private String id;
	private String couponCode;
	private Integer discount;
	
	
	public CouponAggregate() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	//It is automatically invoked when a specific type of command is dispatched. 
	@CommandHandler
	public CouponAggregate(CreateCouponCommand command) {
		super();
		//raise the event
		CouponCreatedEvent event = new CouponCreatedEvent();
		event.setId(command.getId());
		event.setCouponCode(command.getCouponCode());
		event.setDiscount(command.getDiscount());
		
		// Once the event object is ready, dispatch it to all the event handlers. 
		AggregateLifecycle.apply(event);
	}

	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getCouponCode() {
		return couponCode;
	}
	public void setCouponCode(String couponCode) {
		this.couponCode = couponCode;
	}
	public Integer getDiscount() {
		return discount;
	}
	public void setDiscount(Integer discount) {
		this.discount = discount;
	}
	
	@EventSourcingHandler
	public void on(CouponCreatedEvent event) {
		this.id=event.getId();
		this.couponCode=event.getCouponCode();
		this.discount = event.getDiscount();
	}
	
}
