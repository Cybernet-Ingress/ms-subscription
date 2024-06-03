package az.subscriptionMS.service.impl;

import az.subscriptionMS.service.SubscriptionsService;
import org.springframework.beans.factory.annotation.Autowired;
import az.subscriptionMS.model.Subscription;
import az.subscriptionMS.repository.SubscriptionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.stereotype.Service;
import org.springframework.cache.annotation.Cacheable;
import java.util.Optional;


import java.util.List;

@Service
@RequiredArgsConstructor
public class SubscriptionServiceImpl implements SubscriptionsService {

	@Autowired
	private SubscriptionRepository subscriptionRepository;

	@Override
	public Subscription createSubscription(Subscription subscription) {
		Subscription savedSubscription = subscriptionRepository.save(subscription);
		//message
		return savedSubscription;
	}
	@Override
	@Cacheable(value = "Subscriptions", key = "#id")
	public Optional<Subscription> getSubscription(Long id) {
		return subscriptionRepository.findById(id);
		//return subscriptionRepository.findById(id).orElseThrow(() -> new RuntimeException("Subscription not found !"));
	}
	@Override
	public List<Subscription> getAllSubscriptions() {
		return subscriptionRepository.findAll();
	}
	@Override
	@CacheEvict(value = "subscriptions", key = "#id")
	public Subscription updateSubscription(Subscription subscription) {
		//message
		return subscriptionRepository.saveAndFlush(subscription);
	}
	@Override
	@CacheEvict(value = "subscriptions", key = "#id")
	public void deleteSubscription(Long id) {
		//message
		subscriptionRepository.deleteById(id);
	}
}
