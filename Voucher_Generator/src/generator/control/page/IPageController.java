package generator.control.page;

import generator.view.page.PageView;

/**
 * Provides some compulsary getters and setters for a page controller.
 * 
 * @author Chris
 */
public interface IPageController {

	/**
	 * Returns the path to the image icon relating to this page controller.
	 * 
	 * @return an image path
	 */
	public String getNavigationIconPath();

	/**
	 * Returns the name of the page which this controller represents.
	 * 
	 * @return the page name
	 */
	public String getPageName();

	/**
	 * Returns the view which this controller is binded to.
	 * 
	 * @return
	 */
	public PageView getView();
}
