package fr.m2i.panier.backed;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.enterprise.context.RequestScoped;
import javax.faces.annotation.ManagedProperty;
import javax.inject.Inject;
import javax.inject.Named;

import java.io.Serializable;


@Named
@RequestScoped
public class NavBean implements Serializable
{
	
	private static final long serialVersionUID = 1L;


	@Inject
	@ManagedProperty(value = "#{param.pageId}")
	private String pageId;

	@Inject
	@ManagedProperty(value = "#{param.pageIdBis}")
	private String pageIdBis;

	@PostConstruct
	public void post(){
		System.out.println("apres creation du bean");
	}

	@PreDestroy
	public void pre(){
		System.out.println("avant la destruction du bean");
	}
	
	public String index() {
		return "index?faces-redirect=true";
	}

	public String about() {
		return "about?faces-redirect=true";
	}

	public String login() {
		return "login?faces-redirect=true";
	}

	public String page1() {
		return "page1?faces-redirect=true";
	}

	public String page(){
		System.out.println(pageId);
		return this.pageId+"?faces-redirect=true";
	}


	public String pageBis(){
		System.out.println(pageIdBis);
		return this.pageIdBis;
	}

}
