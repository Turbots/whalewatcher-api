package be.turbots.whalewatcher.whales.web;

import be.turbots.whalewatcher.whales.business.WhaleService;
import be.turbots.whalewatcher.whales.model.Whale;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import javax.validation.Valid;

@Slf4j
@RestController
@RequestMapping("/api/v1/whale")
public class AddWhaleController {

	private final WhaleService whaleService;

	public AddWhaleController(WhaleService whaleService) {
		this.whaleService = whaleService;
	}

	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Whale> createWhale(@Valid @RequestBody Whale whale, UriComponentsBuilder builder) {
		log.info("POST /api/v1/whale/{}", whale.getName());

		Whale created = this.whaleService.create(whale);

		final UriComponents uriComponents =
			builder.path("/api/v1/whale/{address}").buildAndExpand(created.getAddress());

		return ResponseEntity.created(uriComponents.toUri()).build();
	}
}
