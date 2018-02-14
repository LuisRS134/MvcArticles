package proven.dam2.mvc.control;

import proven.dam2.mvc.model.Article;
import proven.dam2.mvc.model.Model;
import proven.dam2.mvc.view.View;

public class Controller {
	
	private Model model;
	private View view;
	
	public Controller(Model model) {
		this.model = model;
		this.view = new View(this, model);
	}

	public void listArticles() {
		model.findAllArticles();
	}	
	
	public void createNewArticle(Article art) {
		model.addArticle(art);
	}

	public void modifyArticle(String id ) {
            model.modifyArticle(id);
		// TO DO
	}
	
	public void removeArticle(String id) {
            model.removeArticle(id);
		// TO DO
	}
	
	public void searchArticleById(String id) {
		model.findArticlesById(id);
	}

	public void searchArticlesLikeDescription(String desc) {
		model.findArticlesByDesc(desc);
	}
	
}
