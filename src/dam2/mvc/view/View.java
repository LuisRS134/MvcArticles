package proven.dam2.mvc.view;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

import proven.dam2.mvc.EventMessage;
import proven.dam2.mvc.control.Controller;
import proven.dam2.mvc.model.Article;
import proven.dam2.mvc.model.Model;

public class View implements Observer {

	private Controller control;
	private Model model;
	private Menu menu;
	
	public View(Controller control, Model model) {
		this.control = control;
		this.model = model;
		this.model.addObserver(this);
		menu = buildMenu();
		doControl();
	}

	@Override
	public void update(Observable source, Object obj) {
		if (obj instanceof EventMessage) {
			EventMessage evm = (EventMessage) obj;
			switch (evm.getAction()) {
				case INSERT:
					if (evm.getType()==EventMessage.EventType.OK) 
						alert("Successfull insertion of article:"+evm.getData().toString()+"\n");
					else 
						alert("Error in insertion of article:"+evm.getData().toString()+"\n");
					break;
				case FIND_MULTIPLE:
					if (evm.getType()==EventMessage.EventType.OK) 
						displayList( (List) evm.getData() );
					else
						alert("Error searching articles with "+evm.getData().toString()+"\n");
					break;
				default:
					alert("Unknown error\n");
					break;					
			}
		}
	}
	
	private Menu buildMenu() {
		Menu mnu = new Menu("Menu");
		mnu.add(new Option("Exit"));
		mnu.add(new Option("List all articles"));
		mnu.add(new Option("Add a  new article"));
		mnu.add(new Option("Modify an article"));
		mnu.add(new Option("Delete an article"));
		mnu.add(new Option("Search article by id"));
		mnu.add(new Option("Search articles by description"));
		return mnu;
	}	

	private void doControl() {
		boolean exit = false;
		do {
			menu.show();
			int optNumber = menu.choose();
			switch (optNumber) {
				case 0: // exit.
					exit = true;
					break;
				case 1: // list all articles.
					control.listArticles();
					break;
				case 2: // add a new article.
					Article a = Article.input();
					control.createNewArticle(a);
					break;
				case 3: // modify an article.
					break;
				case 4: // remove an article.
					break;
				case 5: // search an article by id.
					String id = inputString("Input id: ");
					control.searchArticleById(id);
					break;
				case 6: // search articles by description.
					String desc = inputString("Input description: ");
					control.searchArticlesLikeDescription(desc);
					break;
				default:
					break;
			}
			
		} while (!exit);
		System.exit(0);
	}

	private void alert(String s)  {
		System.out.print(s);
	}
	
	private void displayList(List lst) {
		for (Object o: lst) System.out.println(o.toString());
	}
	
	private String inputString(String msg) {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		String s = "";
		alert(msg);
		try {
			s = reader.readLine();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return s;
	}
	
}
