package be.turbots.whalewatcher.transaction.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.ZonedDateTime;

@Getter
@AllArgsConstructor
public class Transaction {

    private String hash;
    private ZonedDateTime date;
    private TransactionDetail tx;

}
