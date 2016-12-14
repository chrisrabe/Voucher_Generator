package generator.control.page;

import generator.control.ApplicationController;
import generator.view.page.PageView;
import generator.view.page.io.IO;

/**
 * This class is responsible for implementing the action listeners for the IO
 * view.
 * 
 * @author Chris
 */
public class IOController extends PageController {
	private IO ioView;

	public IOController(ApplicationController main) {
		super(main);
	}

	@Override
	protected PageView createView() {
		if (ioView == null)
			ioView = createIOView();

		return ioView;
	}

	// Helper Methods

	/**
	 * Creates the IO View and initialises the action listeners
	 * 
	 * @return
	 */
	private IO createIOView() {
		IO tmp = new IO();
		tmp.addHomeBtnListener(e -> {
			main.navigateTo("home");
		});
		return tmp;
	}

}
