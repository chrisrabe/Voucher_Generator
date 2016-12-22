package generator.control.page;

import generator.control.manager.navigation.INavigationManager;
import generator.view.page.PageView;

/**
 * Provides some compulsary getters and setters for a page controller.
 * 
 * @author Chris
 */
public interface IPageController {

	/**
	 * Returns the view which this controller is binded to.
	 * 
	 * @return
	 */
	public PageView getView();

	/**
	 * Sets the navigation controller for this page controller.
	 * 
	 * @param navigation
	 */
	public void setNavigationController(INavigationManager navigation);

	/**
	 * Updates the display.
	 */
	public void update();
}
