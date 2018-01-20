package be.turbots.whalewatcher.subscription.web;

import be.turbots.whalewatcher.subscription.model.Subscription;
import be.turbots.whalewatcher.subscription.service.SubscriptionService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.NotEmpty;
import java.security.Principal;

@Slf4j
@RestController
@RequestMapping("/api/v1/subscription")
public class RemoveSubscriptionController {

	private final SubscriptionService subscriptionService;

	public RemoveSubscriptionController(SubscriptionService subscriptionService) {
		this.subscriptionService = subscriptionService;
	}

	@DeleteMapping
	public ResponseEntity deleteSubscription(@NotEmpty String address, Principal principal) {
		this.subscriptionService
			.deleteSubscription(Subscription.builder().address(address).username(principal.getName()).build());

		return ResponseEntity.ok().build();
	}
}
