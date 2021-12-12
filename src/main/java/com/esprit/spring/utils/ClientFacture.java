package com.esprit.spring.utils;

import com.esprit.spring.entites.CategorieClient;
import com.esprit.spring.entites.Profession;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import lombok.Value;

@Value
public class ClientFacture {

     long id_facture;
     long id_client;
     long FactureCount;
     @Enumerated(EnumType.STRING)
     CategorieClient CATEGORIE_CLIENT;

}

