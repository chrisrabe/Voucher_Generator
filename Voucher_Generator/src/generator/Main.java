package generator;

import generator.gui.text.Controller;
import generator.gui.text.views.TextView;

public class Main {
	public static void main(String[] args) {
		// create a new view with a controller
		new TextView(new Controller());
	}
}
