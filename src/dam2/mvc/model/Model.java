package proven.dam2.mvc.model;

import java.util.*;

import proven.dam2.mvc.EventMessage;

public class Model extends Observable {
	
	// Observers list to implement Observer/Observable pattern.
	private List<Observer> observers;
	// Data store.
	private List<Article> articles;
	
	// Constructors.
	
	public Model() {
		this.observers = new LinkedList<Observer>();
		this.articles = new ArrayList<Article>();
		initData();
	}
	
	// methods to implement Observer/Observable pattern.
	
	public void addObserver(Observer o) {
		observers.add(o);
	}
	
	public void notifyObservers(Object o) {
		for (Observer obs: observers) {
			obs.update(this, o);
		}
	}
	
	// Methods to manage data.

	public void findAllArticles() {
		List<Article> resultList = articles;
		EventMessage evm = new EventMessage(
				EventMessage.EventAction.FIND_MULTIPLE, 
				EventMessage.EventType.OK, 
				EventMessage.EventTarget.ARTICLE, 
				resultList);
		notifyObservers(evm);
	}
	
	public void findArticlesById(String id) {
		List<Article> resultList = new ArrayList();
		for (Article a: articles) {
			if ( id.equalsIgnoreCase(a.getId()) ) resultList.add(a);
		}
		EventMessage evm; 
		if (resultList.size() > 0) 
			evm = new EventMessage(
						EventMessage.EventAction.FIND_MULTIPLE, 
						EventMessage.EventType.OK, 
						EventMessage.EventTarget.ARTICLE, 
						resultList);
		else 
			evm = new EventMessage(
						EventMessage.EventAction.FIND_MULTIPLE, 
						EventMessage.EventType.FAIL, 
						EventMessage.EventTarget.ARTICLE, 
						new String("id="+id));
		notifyObservers(evm);
	}
	
	public void findArticlesByDesc(String desc) {
		List<Article> resultList = new ArrayList();
		for (Article a: articles) {
			if ( desc.equalsIgnoreCase(a.getDesc()) ) resultList.add(a);
		}
		EventMessage evm; 
		if (resultList.size() > 0) 
			evm = new EventMessage(
						EventMessage.EventAction.FIND_MULTIPLE, 
						EventMessage.EventType.OK, 
						EventMessage.EventTarget.ARTICLE, 
						resultList);
		else 
			evm = new EventMessage(
						EventMessage.EventAction.FIND_MULTIPLE, 
						EventMessage.EventType.FAIL, 
						EventMessage.EventTarget.ARTICLE, 
						new String("desc="+desc));
		notifyObservers(evm);
	}
	
	public void addArticle(Article art) {
		EventMessage evm; 
		if (articles.indexOf(art)<0)  {
			articles.add(art);			
			evm = new EventMessage(
					EventMessage.EventAction.INSERT, 
					EventMessage.EventType.OK, 
					EventMessage.EventTarget.ARTICLE, 
					art);		
		}
		else {
			evm = new EventMessage(
					EventMessage.EventAction.INSERT, 
					EventMessage.EventType.FAIL, 
					EventMessage.EventTarget.ARTICLE, 
					art);
		}
		notifyObservers(evm);
	}
	
	private void initData() {
		articles.add( new Article("TV1", "TV23", 900.0) );
		articles.add( new Article("DVD1", "DVD player", 100.0) );
		articles.add( new Article("Fridge1", "Fridge combo", 2000.0) );
		articles.add( new Article("PC1", "Computer", 800.0) );
		articles.add( new Article("MP", "Mobile phone", 300.0) );
	}
	
}
