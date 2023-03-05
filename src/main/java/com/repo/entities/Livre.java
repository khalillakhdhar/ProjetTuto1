package com.repo.entities;

import java.io.Serializable;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Livre implements Serializable {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private int id;
private int iban;
@Column(nullable = false)
private String titre;
private String description;
private int prix;
@ManyToOne(optional = false)
@OnDelete(action = OnDeleteAction.CASCADE)

private Auteur auteur;

@ManyToOne(optional = false,fetch = FetchType.EAGER)
@JoinColumn(name = "categorie",referencedColumnName = "titre")
private Categorie categorie;
@ManyToOne(fetch = FetchType.LAZY,optional = false)
private Bibliotheque bibliotheque;
}
