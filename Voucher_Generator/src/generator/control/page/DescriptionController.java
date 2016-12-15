package generator.control.page;

import generator.control.ApplicationController;
import generator.view.page.PageView;
import generator.view.page.description.Description;

/**
 * This class implements the action listeners for the description view.
 * 
 * @author Chris
 */
public class DescriptionController extends PageController {
	private Description descriptionView;

	public DescriptionController(ApplicationController main) {
		super(main);
	}

	@Override
	protected PageView createView() {
		if (descriptionView == null)
			descriptionView = createDescriptionView();

		return descriptionView;
	}

	private Description createDescriptionView() {
		Description tmp = new Description();
		return tmp;
	}

}
