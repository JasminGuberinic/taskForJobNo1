package com.boot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.boot.models.Subscription;

import java.util.List;

public interface SubscriptionRepository extends JpaRepository<Subscription, Long>{
	@Query("select sub from Subscription sub where sub.userId = ?1 and sub.active = ?2")
	Subscription findByUSERIDAndACTIVE(String userId, boolean active);
	
	List<Subscription> findByActive(boolean active);

	Subscription findOneByproductHistoryId(String id);
}
