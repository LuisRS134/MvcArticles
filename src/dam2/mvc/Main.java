package proven.dam2.mvc;

import proven.dam2.mvc.control.Controller;
import proven.dam2.mvc.model.Model;

public class Main {
	public static void main(String [] args) {
		Model model = new Model();
		Controller control = new Controller(model);
	}
}
