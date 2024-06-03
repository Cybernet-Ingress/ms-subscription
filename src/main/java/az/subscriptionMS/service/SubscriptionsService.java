package az.subscriptionMS.service;

import az.subscriptionMS.model.Subscription;

import java.util.List;
import java.util.Optional;

public interface SubscriptionsService {

	Subscription createSubscription(Subscription subscription);
	Optional<Subscription> getSubscription(Long id);
	List<Subscription> getAllSubscriptions();
	Subscription updateSubscription(Subscription subscription);
	void deleteSubscription(Long id);
}
