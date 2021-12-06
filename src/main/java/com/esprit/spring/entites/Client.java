package com.esprit.spring.entites;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
//@RequiredArgsConstructor
@ToString
@EqualsAndHashCode 
public class Client implements Serializable {
	@Id
	@GeneratedValue(strategy =GenerationType.IDENTITY)
	private long idClient;
	private String nom;
	private String prenom;
	@Temporal(TemporalType.DATE)
	private Date DateNaissance;
	private String email ;
	private String password;
	
	@OneToMany(cascade = CascadeType.ALL,mappedBy = "client")
	@JsonIgnore
	private Set<Facture> Facture;
	@Enumerated(EnumType.STRING)
	private  CategorieClient categorieClient;
	@Enumerated(EnumType.STRING)
	private Profession profession;

}
