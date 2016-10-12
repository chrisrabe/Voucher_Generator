package generator;

import generator.backend.Controller;
import generator.frontend.View;

public class Main {
	public static void main(String[] args) {
		// create a new view with a controller
		new View(new Controller());
	}
}
