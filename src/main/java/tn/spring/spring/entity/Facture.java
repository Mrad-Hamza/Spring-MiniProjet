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
public class Facture implements Serializable{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="idFacture")
	private Long idFacture;
	@NonNull
	private float montantRemise;
	@NonNull
	private float montantFacture;
	
	private Date dateFacture;
	@NonNull
	private boolean active;
	@OneToMany(mappedBy="facture",cascade=CascadeType.ALL, fetch=FetchType.EAGER)
	private Set<DetailFacture> detailFacture;
	@ManyToOne(cascade=CascadeType.ALL, fetch=FetchType.EAGER)
	private Client client;
	
}
