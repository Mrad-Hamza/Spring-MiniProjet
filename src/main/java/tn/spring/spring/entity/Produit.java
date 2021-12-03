package tn.spring.spring.entity;


import java.io.Serializable;
import java.util.List;
import java.util.Set;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonView;

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

public class Produit implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="idProduit")
	private Long idProduit;
	@NonNull
	private String code;
	@NonNull
	private String libelle;
	@NonNull
	private float prixUnitaire;
	@ManyToMany(cascade = CascadeType.ALL, fetch=FetchType.EAGER)
	private List<Fournisseur> fournisseurs;	
   
    @JsonIgnore
	@ManyToOne(cascade=CascadeType.ALL,fetch=FetchType.EAGER)
	Rayon rayon;
	
	@ManyToOne(cascade=CascadeType.ALL,fetch=FetchType.EAGER)
	Stock stock;
	@OneToOne(cascade=CascadeType.ALL,fetch=FetchType.EAGER)
	private DetailProduit detailProduit;
	@OneToMany(mappedBy="facture",cascade=CascadeType.ALL)
	private List<DetailFacture> detailFacture;




}
