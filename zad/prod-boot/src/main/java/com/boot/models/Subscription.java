package com.boot.models;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name="PRODUCT_HISTORY")
public class Subscription {
	@Id
	String productHistoryId;
	@Column(name="USERID")
	String userId;
	@Column(name="PRODUCTID")
	String productId;
	@Column(name="TIME_OF_SUBSCRIPTION")
	Date timeOfSubscription;
	@Column(name="ACTIVE")
	boolean active;
	public Subscription() {}
	
	public Subscription(String id,String userId,String productId,Date timeOfSubscription) {
		this.userId = userId;
		this.productId = productId;
		this.timeOfSubscription = timeOfSubscription;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getProductId() {
		return productId;
	}

	public void setProductId(String productId) {
		this.productId = productId;
	}

	public Date getTimeOfSubscription() {
		return timeOfSubscription;
	}

	public void setTimeOfSubscription(Date timeOfSubscription) {
		this.timeOfSubscription = timeOfSubscription;
	}

	public String getProductHistoryId() {
		return productHistoryId;
	}

	public void setProductHistoryId(String productHistoryId) {
		this.productHistoryId = productHistoryId;
	}

	public boolean getActive() {
		return active;
	}

	public void setActive(boolean isActive) {
		this.active = isActive;
	}
}
