package br.com.testes.api_rest.entities;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/*@Getter
 * @Setter
 * @ToString
 * @EqualsAndHashCode
 */
@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name="tb_user")
public class User {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	private String name;
	
	@Column(unique=true)
	private String email;
	
	@JsonProperty(access= JsonProperty.Access.WRITE_ONLY)
	private String password;

}
