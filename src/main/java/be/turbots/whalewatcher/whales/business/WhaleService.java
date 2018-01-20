package be.turbots.whalewatcher.whales.business;

import be.turbots.whalewatcher.whales.data.WhaleEntity;
import be.turbots.whalewatcher.whales.data.WhaleRepository;
import be.turbots.whalewatcher.whales.model.Whale;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

@Service
public class WhaleService {

	private final WhaleRepository whaleRepository;
	private final ObjectMapper mapper;

	public WhaleService(WhaleRepository whaleRepository, ObjectMapper mapper) {
		this.whaleRepository = whaleRepository;
		this.mapper = mapper;
	}

	@Transactional
	public Whale create(Whale whale) {
		Optional<WhaleEntity> current = this.whaleRepository.findOneByAddress(whale.getAddress());

		if (current.isPresent()) {
			throw new IllegalStateException("Whale [" + whale.getAddress() + "] already exists");
		} else {
			return mapper.convertValue(
				this.whaleRepository.save(
					mapper.convertValue(whale, WhaleEntity.class)),
				Whale.class);
		}
	}

	@Transactional
	public Optional<Whale> findByAddress(String address) {
		return this.whaleRepository.findOneByAddress(address).map(w -> mapper.convertValue(w, Whale.class));
	}

	@Transactional
	public Page<Whale> findAll(Pageable pageable) {
		return this.whaleRepository.findAll(pageable).map(w -> mapper.convertValue(w, Whale.class));
	}

	@Transactional
	public void delete(String address) {
		Optional<WhaleEntity> current = this.whaleRepository.findOneByAddress(address);

		if (current.isPresent()) {
			this.whaleRepository.delete(current.get());
		} else {
			throw new IllegalStateException("Whale [" + address + "] does not exist");
		}
	}
}
