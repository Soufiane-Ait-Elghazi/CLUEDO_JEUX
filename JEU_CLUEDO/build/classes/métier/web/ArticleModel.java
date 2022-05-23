package web;

import java.util.ArrayList;
import java.util.List;
import metier.Article;


public class ArticleModel {
	private String motCle ;
	private List<Article> articles = new ArrayList<Article>();
	public String getMotCle() {
		return motCle;
	}
	public void setMotCle(String motCle) {
		this.motCle = motCle;
	}
	public List<Article> getArticles() {
		return articles;
	}
	public void setArticles(List<Article> articles) {
		this.articles = articles;
	}
	
	
	

	
}
