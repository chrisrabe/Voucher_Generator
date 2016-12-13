package generator.control.page;

import generator.control.ApplicationController;
import generator.view.page.PageView;

/**
 * Provides a skeleton implementation of a page controller.
 * 
 * @author Chris
 */
public abstract class PageController implements IPageController {

	// Need this to be able to navigate around the application.
	protected ApplicationController mainController;

	private String name;
	private String navigationIcon;
	private PageView view;

	/**
	 * Stores the navigationIcon and name fields.
	 * 
	 * @param navigationIcon
	 * @param name
	 */
	public PageController(String navigationIcon, String name) {
		this.navigationIcon = navigationIcon;
		this.name = name;
	}

	// Abstract Methods

	/**
	 * Creates the binded view to this controller.
	 * 
	 * @return
	 */
	public abstract PageView createView();

	// IPageController Methods

	@Override
	public String getNavigationIconPath() {
		return navigationIcon;
	}

	@Override
	public String getPageName() {
		return name;
	}

	@Override
	public PageView getView() {
		if (view == null)
			createView();
		return view;
	}

	// Object Methods

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PageController other = (PageController) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}

}
