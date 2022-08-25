package fr.m2i.panier.backed;

import fr.m2i.panier.models.Article;
import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


@Named
@SessionScoped
//doit implements Serializable pour utiliser SessionsScoped et stocker en session
public class PanierBean implements Serializable
{
	// rendre serializable pour sessionScope
	private static final long serialVersionUID = 1L;


	private String nom;

	private List<Article> liste;

	@PostConstruct
	public void init(){
		nom= "Mon panier";
		liste = new ArrayList();
	}

	public String getNom() {
		return nom.toUpperCase();
	}
	public void setNom(String nom) {
		this.nom = nom;
	}

	public List<Article> getListe() {
		return liste;
	}

	public void setListe(List<Article> liste) {
		this.liste = liste;
	}

	public void addArticle(Article article){
		for (Article art:liste) {
			if(art.getNom().equals(article.getNom())){
				art.setQuantite(art.getQuantite()+1);
			}
		}
		if(!liste.contains(article)){
			liste.add(article);
		}
	}

	public void removeArticle(Article article){
		for (Article art:liste) {
			if(art.getNom().equals(article.getNom())){
				art.setQuantite(art.getQuantite()-1);
			}
		}
		if(article.getQuantite()<1){
			liste.remove(article);
		}
	}

	public void emptyArticle(){
		this.liste = new ArrayList<>();
	}

	public Double prixTotal(){
		Double total =0d;
		for (Article article:liste) {
			total += article.getPrix()* article.getQuantite();
		}
		return total;
	}


}
