package be.turbots.whalewatcher.subscription.data;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.time.LocalDateTime;

@Getter
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SubscriptionEntity {

	@Id
	@GeneratedValue
	private Long id;

	private String address;
	private String username;
	private LocalDateTime creationDateTime;
}
