package fr.m2i.panier.models;


import java.io.Serializable;



public class Article implements Serializable
{
	
	private static final long serialVersionUID = 1L;


	private String nom;
	private String description;
	private Double prix;
	private Integer quantite;

	public Article() {
	}

	public Article(String nom, Double prix) {
		this.nom = nom;
		this.prix = prix;
	}

	public Article(String nom, Double prix, Integer quantite) {
		this.nom = nom;
		this.prix = prix;
		this.quantite = quantite;
	}

	public String getNom() {
		return nom.toUpperCase();
	}
	public void setNom(String nom) {
		this.nom = nom;
	}

	public Double getPrix() {
		return prix;
	}

	public void setPrix(Double prix) {
		this.prix = prix;
	}

	public Integer getQuantite() {
		return quantite;
	}

	public void setQuantite(Integer quantite) {
		this.quantite = quantite;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
}
