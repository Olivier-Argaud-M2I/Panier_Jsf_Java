package fr.m2i.panier.backed;

//import fr.m2i.panier.cruds.ArticleCrud;
import fr.m2i.panier.models.Article;
import jakarta.annotation.PostConstruct;
import jakarta.enterprise.context.SessionScoped;
import jakarta.inject.Named;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


@Named
@SessionScoped
//doit implements Serializable pour utiliser SessionsScoped et stocker en session
public class MagasinBean implements Serializable
{
	// rendre serializable pour sessionScope
	private static final long serialVersionUID = 1L;


	private String nom;

	private List<Article> stock;

	@PostConstruct
	public void init(){
		nom= "Magasin";

//		ArticleCrud articleCrud = new ArticleCrud();
//		stock = articleCrud.getArticles();
		stock = new ArrayList();
		stock.add(new Article("pomme",1d,1));
		stock.add(new Article("poire",1.5d,1));
		stock.add(new Article("banane",2.5d,1));
		stock.add(new Article("prune",3.5d,1));
		stock.add(new Article("fraise",3d,1));
		stock.add(new Article("kiwi",0.5d,1));
	}

	public String getNom() {
		return nom.toUpperCase();
	}
	public void setNom(String nom) {
		this.nom = nom;
	}

	public List<Article> getStock() {
		return stock;
	}

	public void setStock(List<Article> stock) {
		this.stock = stock;
	}
}
