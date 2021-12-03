package tn.spring.spring.entity;
import java.io.Serializable;
import java.util.Date;
import java.util.Set;

import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
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
@EqualsAndHashCode
public class DetailFacture implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="idDetailFacture")
	private Long idDetailFacture;
	@NonNull
	private int qte;
	@NonNull
	private float prixTotal;
	@NonNull
	private int pourcentageRemise;
	@NonNull
	private int montantRemise;
	@ManyToOne(cascade=CascadeType.ALL, fetch=FetchType.EAGER)
	private Produit produit;
	@ManyToOne(cascade=CascadeType.ALL, fetch=FetchType.EAGER)
	private Facture facture;
	
	

}
