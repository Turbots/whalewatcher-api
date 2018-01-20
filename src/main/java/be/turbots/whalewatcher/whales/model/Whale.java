package be.turbots.whalewatcher.whales.model;

import lombok.*;

@Getter
@Builder
@AllArgsConstructor
@ToString(of = {"name", "address"})
@EqualsAndHashCode(of = "address")
public class Whale {

	private String name;
	private String address;
	private String description;
}
