package fr.m2i.panier.models;


import javax.persistence.*;
import java.io.Serializable;


@Entity
@Table(name = "article")
@NamedNativeQueries({
		@NamedNativeQuery(name = "selectAllArticle",query = "SELECT article FROM Article article")
})
public class Article implements Serializable
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@Basic
	@Column(name = "nom")
	private String nom;
	@Basic
	@Column(name = "description")
	private String description;
	@Basic
	@Column(name = "prix")
	private Double prix;
	@Basic
	@Column(name = "quantity")
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

	public Article(String nom, String description, Double prix, Integer quantite) {
		this.nom = nom;
		this.description = description;
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


