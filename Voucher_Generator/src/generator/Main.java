package generator;

import generator.gui.graphics.VControl;
import generator.gui.text.Controller;
import generator.gui.text.views.TextView;

public class Main {
	public static final double VERSION = 0.4;

	public static void main(String[] args) {
		// create a new view with a controller
		// new TextView(new Controller());
		new VControl();
	}
}
