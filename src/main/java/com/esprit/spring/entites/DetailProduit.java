package com.esprit.spring.entites;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonIgnore;

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
//@RequiredArgsConstructor
@ToString

public class DetailProduit implements Serializable {
	@Id
	@GeneratedValue(strategy =GenerationType.IDENTITY)
	private long idDetailProduit;
	@Temporal(TemporalType.DATE)
	private Date dateCreation;
	@Temporal(TemporalType.DATE)
	private Date dateDernierModification;
	@Enumerated(EnumType.STRING)
	private CategorieProduit categorieProduit;
	
	@OneToOne(mappedBy="detailProduit")
	@JsonIgnore
	private Produit produit;

	
	public void setDateDernierModification() {
		this.dateDernierModification =new Date(System.currentTimeMillis());
	}
	
	
	
	
}
