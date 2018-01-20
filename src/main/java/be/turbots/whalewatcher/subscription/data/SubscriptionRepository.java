package be.turbots.whalewatcher.subscription.data;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import javax.validation.constraints.NotEmpty;
import java.util.Optional;

@Repository
public interface SubscriptionRepository extends PagingAndSortingRepository<SubscriptionEntity, Long> {

	Optional<SubscriptionEntity> findOneByAddressAndUsername(@NotEmpty String address, @NotEmpty String username);

	void deleteByAddressAndUsername(@NotEmpty String address, String username);
}

