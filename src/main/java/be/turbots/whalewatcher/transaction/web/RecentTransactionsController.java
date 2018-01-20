package be.turbots.whalewatcher.transaction.web;

import be.turbots.whalewatcher.transaction.model.Transaction;
import be.turbots.whalewatcher.transaction.service.TransactionService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/api/v1/transactions/")
public class RecentTransactionsController {

	private final TransactionService transactionService;

	public RecentTransactionsController(TransactionService transactionService) {
		this.transactionService = transactionService;
	}

	@GetMapping(value = "/{address}")
	public List<Transaction> streamRecentTransactions(@PathVariable String address) {
		log.info("GET /api/transactions/{}", address);

		return this.transactionService.getRecentTransactions(address);
	}
}
