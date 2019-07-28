package com.boot.models;

import java.util.Date;

public class SubscriptionsInformation {
	private Product product;
	private Subscription subscription;
	
	public SubscriptionsInformation() {}
	
	public SubscriptionsInformation(Product product,Subscription subscription) {
		this.product = product;
		this.subscription = subscription;
	}

	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}
	public Subscription getSubscription() {
		return subscription;
	}
	public void setSubscription(Subscription subscription) {
		this.subscription = subscription;
	}
}
