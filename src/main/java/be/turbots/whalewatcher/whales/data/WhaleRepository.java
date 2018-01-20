package be.turbots.whalewatcher.whales.data;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface WhaleRepository extends PagingAndSortingRepository<WhaleEntity, Long> {

	Optional<WhaleEntity> findOneByAddress(String address);
}
