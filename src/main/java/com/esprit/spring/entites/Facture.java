package com.esprit.spring.entites;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.data.repository.CrudRepository;

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
public class Facture implements Serializable {
	@Id
	@GeneratedValue(strategy =GenerationType.IDENTITY)
	private long idFacture;
	private float montantRemise;
	private float montantFacture;
	@Temporal(TemporalType.DATE)
	private Date dateFacture;
	private Boolean active;
	@ManyToOne 
	Client client; 
	@OneToMany(cascade = CascadeType.ALL, mappedBy="facture")
	@JsonIgnore
	private Set<DetailFacture> detailsFactures;
	
	
}
