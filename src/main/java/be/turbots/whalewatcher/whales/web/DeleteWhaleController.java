package be.turbots.whalewatcher.whales.web;

import be.turbots.whalewatcher.whales.business.WhaleService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/api/v1/whale")
public class DeleteWhaleController {

	private final WhaleService whaleService;

	public DeleteWhaleController(WhaleService whaleService) {
		this.whaleService = whaleService;
	}

	@DeleteMapping("/{address}")
	public ResponseEntity deleteWhale(@PathVariable String address) {
		log.info("DELETE /api/v1/whale/{}", address);

		this.whaleService.delete(address);

		return ResponseEntity.ok().build();
	}
}
