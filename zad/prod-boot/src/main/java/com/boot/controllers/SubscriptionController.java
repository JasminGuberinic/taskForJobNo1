package com.boot.controllers;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.boot.models.Product;
import com.boot.models.Subscription;
import com.boot.models.SubscriptionsInformation;
import com.boot.repository.ProductsRepository;
import com.boot.repository.SubscriptionRepository;
import com.boot.service.SubscriptionService;

@RestController
@RequestMapping("api/v1/")
public class SubscriptionController {
	@Autowired
	private SubscriptionService subscriptionService;
	
	@Autowired
	private SubscriptionRepository subscriptionRepository;
	
	@RequestMapping(value = "subscription", method = RequestMethod.POST)
	public Subscription create(@RequestBody Subscription subscription) throws Exception {
		return subscriptionService.create(subscription);
	}
	
	@RequestMapping(value = "subscription/{id}", method = RequestMethod.GET)
	public Subscription get(@PathVariable String id) {
		return subscriptionService.get(id);
	}
	
	@RequestMapping(value = "subscriptions", method = RequestMethod.GET)
	public List<Subscription> getAll() {
		return subscriptionService.getAll();
	}
	
	@RequestMapping(value = "subscription/{id}", method = RequestMethod.PUT)
	public Subscription update(@PathVariable Long id, @RequestBody Subscription subscription) {
		return subscriptionService.update(id, subscription);
	}
	
	@RequestMapping(value = "subscription/{id}", method = RequestMethod.DELETE)
	public Subscription delete(@PathVariable Long id) {
		return subscriptionService.delete(id);
	}
	
	@RequestMapping(value = "usersubscription/{id}", method = RequestMethod.GET)
	public Subscription usersubscription(@PathVariable String id) throws Exception {
		return subscriptionService.getActiveSuscriptionForUser(id);
	}
	
	@RequestMapping(value = "usersubscriptioninfo", method = RequestMethod.GET)
	public List<SubscriptionsInformation> usersubscriptionsinfo() throws Exception {
		return subscriptionService.getFullInfo();
	}
}
