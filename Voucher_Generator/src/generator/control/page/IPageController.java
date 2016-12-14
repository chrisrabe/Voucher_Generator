package generator.control.page;

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
}
