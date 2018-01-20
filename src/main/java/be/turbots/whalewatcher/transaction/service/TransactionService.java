package be.turbots.whalewatcher.transaction.service;

import be.turbots.whalewatcher.transaction.model.Transaction;
import be.turbots.whalewatcher.transaction.model.TransactionData;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON;

@Service
public class TransactionService {

    private final WebClient webClient;

    public TransactionService() {
        this.webClient = WebClient.create("https://data.ripple.com/");
    }

    public List<Transaction> getRecentTransactions(String address) {
        return this.webClient.get()
                .uri("/v2/accounts/{address}/transactions", address)
                .accept(APPLICATION_JSON)
                .exchange()
                .block()
                .bodyToMono(TransactionData.class)
                .log()
                .block().getTransactions();
    }
}
