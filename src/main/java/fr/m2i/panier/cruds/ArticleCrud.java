package fr.m2i.panier.cruds;


import fr.m2i.panier.models.Article;


import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;


public class ArticleCrud {

    private EntityManagerFactory factory;

    public ArticleCrud(){
        this.factory = Persistence.createEntityManagerFactory("panier");
    }

    public List<Article> getArticles(){
        EntityManager em = factory.createEntityManager();
        List<Article> articles = em.createNamedQuery("selectAllArticle")
                .getResultList();
        em.close();
        return articles;
    }


}
