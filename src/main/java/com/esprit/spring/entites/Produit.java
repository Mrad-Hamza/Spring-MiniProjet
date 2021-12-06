package com.esprit.spring.entites;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.FieldDefaults;

//import lombok.Data;

@Entity
//@Data
@Table(name="Produit")
@Getter
@Setter
//dici 
@NoArgsConstructor
@AllArgsConstructor
@RequiredArgsConstructor
@ToString

// jusqua
//remplace par@Data

@FieldDefaults(level=AccessLevel.PUBLIC)
public class Produit implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy =GenerationType.IDENTITY)
	private long idProduit ;
	@NonNull
	private String codeProduit ;
	@NonNull
	private String libelleProduit;
	@NonNull
	private float prixUnitaire;
	@NonNull
	@ManyToOne
	private Stock stock;
	@ManyToOne 
	@NonNull
	private Rayon rayon;
	@OneToMany(cascade=CascadeType.ALL,mappedBy = "produit")
	@JsonIgnore
	private Set<DetailFacture> detailFactures;
	@NonNull
	
	@OneToOne
	private DetailProduit detailProduit;
	@ManyToMany(cascade=CascadeType.ALL)
	private Set<Fournisseur>  fournisseurs;
	
	
	



}
