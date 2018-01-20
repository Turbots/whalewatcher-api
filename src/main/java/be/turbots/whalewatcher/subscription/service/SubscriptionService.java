package be.turbots.whalewatcher.subscription.service;

import be.turbots.whalewatcher.subscription.data.SubscriptionEntity;
import be.turbots.whalewatcher.subscription.data.SubscriptionRepository;
import be.turbots.whalewatcher.subscription.model.Subscription;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class SubscriptionService {

	private final SubscriptionRepository subscriptionRepository;

	public SubscriptionService(SubscriptionRepository subscriptionRepository) {
		this.subscriptionRepository = subscriptionRepository;
	}

	@Transactional
	public Subscription createSubscription(Subscription subscription) {
		Optional<SubscriptionEntity> existing = subscriptionRepository
			.findOneByAddressAndUsername(subscription.getAddress(), subscription.getUsername());

		if (existing.isPresent()) {
			throw new IllegalStateException("Subscription " + subscription + " already exists");
		} else {
			SubscriptionEntity entity = SubscriptionEntity.builder()
				.address(subscription.getAddress())
				.username(subscription.getUsername())
				.creationDateTime(LocalDateTime.now())
				.build();
			entity = subscriptionRepository.save(entity);
			return Subscription.builder().username(entity.getUsername()).address(entity.getAddress()).build();
		}
	}

	@Transactional
	public void deleteSubscription(Subscription subscription) {
		Optional<SubscriptionEntity> existing =
			subscriptionRepository.findOneByAddressAndUsername(subscription.getAddress(), subscription.getUsername());

		if (existing.isPresent()) {
			subscriptionRepository.deleteByAddressAndUsername(subscription.getAddress(), subscription.getUsername());
		} else {
			throw new IllegalStateException("Subscription " + subscription + " already exists");
		}
	}
}
