package com.boot.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.boot.models.Product;
import com.boot.models.Subscription;
import com.boot.models.SubscriptionsInformation;
import com.boot.repository.ProductsRepository;
import com.boot.repository.SubscriptionRepository;

@Service
public class SubscriptionService {
	@Autowired
	private SubscriptionRepository subscriptionRepository;
	
	@Autowired
	private ProductsRepository productsRepository;
	
	public Subscription create(Subscription subscription) throws Exception {
		if(subscription.getActive()) {
			Subscription sub = subscriptionRepository.findByUSERIDAndACTIVE(subscription.getUserId(), subscription.getActive());
			if (sub != null)
				throw new Exception("User cant have two active subscriptions");
		}
		return subscriptionRepository.saveAndFlush(subscription);
	}
	
	public Subscription getActiveSuscriptionForUser(String userId) throws Exception {
		boolean isActive = true;
		Subscription sub = subscriptionRepository.findByUSERIDAndACTIVE(userId, isActive);
		return sub;
	}
	
	public List<Subscription> getAll() {
		return subscriptionRepository.findAll();
	}
	
	public Subscription get(String id) {
		return subscriptionRepository.findOneByproductHistoryId(id);
	}
	
	public Subscription update(Long id, Subscription subscription) {
		Subscription oldSubscriptionInfo =subscriptionRepository.findOne(id);
		BeanUtils.copyProperties(subscription, oldSubscriptionInfo);
		return subscriptionRepository.saveAndFlush(subscription);
	}
	
	public Subscription delete(Long id) {
		Subscription subscription =subscriptionRepository.findOne(id);
		subscriptionRepository.delete(subscription);
		return subscription;
	}
	
	public List<SubscriptionsInformation> getFullInfo() {
		boolean isActive = true;
		List<Subscription> subscriptions = (List<Subscription>) subscriptionRepository.findByActive(isActive);
		List<Product> products = productsRepository.findAll();
		List<SubscriptionsInformation> subscriptionInformation = new ArrayList<SubscriptionsInformation>();
		
		for (Subscription subscription : subscriptions) {
			for(Product product : products) {
				if(subscription.getProductId().contains(product.getId())) {
					subscriptionInformation.add(new SubscriptionsInformation(product, subscription));
				}
			}
		}
		return subscriptionInformation;
	}
}