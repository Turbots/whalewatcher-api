package be.turbots.whalewatcher.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class TransactionDetail {

    @JsonProperty("Amount")
    private String amount;
    @JsonProperty("Fee")
    private String fee;
    @JsonProperty("Account")
    private String account;
    @JsonProperty("Destination")
    private String destination;
}
