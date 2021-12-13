package tn.spring.spring.entity;
import java.io.Serializable;
import java.util.Date;
import java.util.Set;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@RequiredArgsConstructor
@ToString
public class Stock implements Serializable {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="idStock")
	private Long idStock;
	@NonNull
	private int qteStock;
	@NonNull
	private int qteMin;
	@NonNull
	private String libelleStock;
	@NonNull
	public Date createdDate;
	@NonNull
	private Date updatedDate;
	@NonNull
	public Boolean state;
	@NonNull 
	public int rating;
	@NonNull 
	public String urlImage;
	@JsonIgnore
	@OneToMany(mappedBy="stock",cascade=CascadeType.ALL, fetch=FetchType.EAGER)
	private Set<Produit> produits;
}
