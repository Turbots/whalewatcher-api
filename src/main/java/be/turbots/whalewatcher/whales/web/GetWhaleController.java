package be.turbots.whalewatcher.whales.web;

import be.turbots.whalewatcher.whales.business.WhaleService;
import be.turbots.whalewatcher.whales.model.Whale;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@Slf4j
@RestController
@RequestMapping("/api/v1/whale")
public class GetWhaleController {

	private final WhaleService whaleService;

	public GetWhaleController(WhaleService whaleService) {
		this.whaleService = whaleService;
	}

	@GetMapping("/{address}")
	public ResponseEntity<Whale> findWhale(@PathVariable String address) {
		log.info("GET /api/v1/whale/{}" + address);

		Optional<Whale> whale = whaleService.findByAddress(address);

		return whale.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
	}

	@GetMapping("/")
	public ResponseEntity<Page<Whale>> allWhales(
		@PageableDefault(size = 50, direction = Sort.Direction.ASC) Pageable pageable) {
		log.info("GET /api/v1/whale");

		return ResponseEntity.ok(whaleService.findAll(pageable));
	}
}
