package be.turbots.whalewatcher.subscription.web;

import be.turbots.whalewatcher.subscription.model.Subscription;
import be.turbots.whalewatcher.subscription.service.SubscriptionService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import javax.validation.constraints.NotEmpty;
import java.security.Principal;

@RestController
@RequestMapping("/api/v1/subscription")
public class AddSubscriptionController {

	private final SubscriptionService subscriptionService;

	public AddSubscriptionController(
		SubscriptionService subscriptionService) {
		this.subscriptionService = subscriptionService;
	}

	@PostMapping
	public ResponseEntity<Subscription> createSubscription(@NotEmpty String address, Principal principal,
		UriComponentsBuilder builder) {
		Subscription created = this.subscriptionService
			.createSubscription(Subscription.builder().address(address).username(principal.getName()).build());

		UriComponents component = builder.path("/api/v1/subscription/{username}").buildAndExpand(created.getUsername());

		return ResponseEntity.created(component.toUri()).build();
	}
}
