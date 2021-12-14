package tn.spring.spring.entity;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Set;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

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

public class Rayon implements Serializable{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="idRayon")
	private Long idRayon;
	@NonNull
	private String codeRayon;
	@NonNull
	private String libelleRayon;
	
	@OneToMany(mappedBy="rayon",cascade=CascadeType.ALL, fetch=FetchType.EAGER)
	private List<Produit> produits;
	
	@NonNull
	@OneToMany(mappedBy="rayon",cascade=CascadeType.ALL)
	private List<ImagesRayon> imgs;
	
	@NonNull
	private Date createdAt;
	
	@NonNull
	private Date updatedAt;
	
	@NonNull
	private Date deleteAt;
	
	private Boolean state;
	
}
