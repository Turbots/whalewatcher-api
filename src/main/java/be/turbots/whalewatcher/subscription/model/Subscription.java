package be.turbots.whalewatcher.subscription.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import javax.validation.constraints.NotEmpty;

@Getter
@Builder
@AllArgsConstructor
public class Subscription {

	@NotEmpty
	private String username;
	@NotEmpty
	private String address;
}
