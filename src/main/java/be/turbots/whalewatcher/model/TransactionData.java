package be.turbots.whalewatcher.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Getter
@Builder
@AllArgsConstructor
public class TransactionData {

    private String result;
    private int count;
    private List<Transaction> transactions;

}
