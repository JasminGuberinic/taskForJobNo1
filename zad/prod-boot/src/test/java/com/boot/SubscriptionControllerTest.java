package com.boot;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.boot.controllers.SubscriptionController;
import com.boot.models.Subscription;
import com.boot.service.SubscriptionService;

public class SubscriptionControllerTest {
	@Mock
	private SubscriptionService subscriptionService;
	
	@InjectMocks
	private SubscriptionController subscriptionController;
	
	@Before
	public void init() {
		MockitoAnnotations.initMocks(this);
	}
	
	@Test
    public void testGetProduct()
    {
		Subscription subscription = new Subscription();
		subscription.setProductHistoryId("4455");
        when(subscriptionService.get("4455")).thenReturn(subscription);
        
        verify(subscriptionService).get("4455");
        
        Subscription sub = subscriptionController.get("4455");
        assertEquals("4455", sub.getProductHistoryId());
    }
	
	@Test
    public void testGetAllProducts()
    {
		List<Subscription> subs = new ArrayList<Subscription>();
		Subscription subscription = new Subscription();
		subscription.setProductHistoryId("4455");
		subscription.setProductId("qweere");
		subscription.setUserId("2344");
		subs.add(subscription);
        when(subscriptionService.getAll()).thenReturn(subs);
        
        List<Subscription> subscriptions = subscriptionController.getAll();
        assertEquals("4455", subscriptions.get(0).getProductHistoryId());
        assertEquals("qweere", subscriptions.get(0).getProductId());
    }
}
