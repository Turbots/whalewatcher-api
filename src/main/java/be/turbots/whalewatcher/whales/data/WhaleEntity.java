package be.turbots.whalewatcher.whales.data;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString(of = { "name", "address" })
public class WhaleEntity {

	@Id
	@GeneratedValue
	private Long id;
	private String name;
	private String address;
	private String description;
}
