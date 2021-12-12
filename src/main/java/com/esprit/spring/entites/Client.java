package com.esprit.spring.entites;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.web.bind.annotation.RestController;


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
	
	private String username;
	
	private String email ;
	
	private String password;
	
	@OneToMany(cascade = CascadeType.ALL,mappedBy = "client")
	private Set<Facture> Facture;
	
	@Enumerated(EnumType.STRING)
	private  CategorieClient categorieClient;
	
	@Enumerated(EnumType.STRING)
	private Profession profession;
	
	private String role;
	
	private boolean enabled;
	
	@Override
	public String toString() {
		return "Client [idClient=" + idClient + ", nom=" + nom + ", prenom=" + prenom + ", DateNaissance="
				+ DateNaissance + ", email=" + email + ", password=" + password + ", Facture=" + Facture
				+ ", categorieClient=" + categorieClient + ", profession=" + profession + ", role=" + role
				+ ", enabled=" + enabled + "]";
	}
	

	

}

