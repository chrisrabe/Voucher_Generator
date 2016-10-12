package generator;

import generator.backend.Controller;
import generator.frontend.TextView;

public class Main {
	public static void main(String[] args) {
		// create a new view with a controller
		new TextView(new Controller());
	}
}
