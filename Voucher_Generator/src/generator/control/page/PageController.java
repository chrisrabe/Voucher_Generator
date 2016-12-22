package generator.control.page;

import java.io.File;

import javax.swing.JFileChooser;

import generator.control.manager.navigation.INavigationManager;
import generator.view.page.PageView;
import vgcomponents.factories.VGMessage;

/**
 * Provides a skeleton implementation of a page controller.
 * 
 * @author Chris
 */
public abstract class PageController implements IPageController {

	// Need this to be able to navigate around the application.
	protected INavigationManager navigation;

	private PageView view;

	// Abstract Methods

	/**
	 * Creates the binded view to this controller.
	 * 
	 * @return
	 */
	protected abstract PageView createView();

	// IPageController Methods

	@Override
	public PageView getView() {
		if (view == null)
			view = createView();
		return view;
	}

	@Override
	public void setNavigationController(INavigationManager navigation) {
		this.navigation = navigation;
	}

	@Override
	public void update() {
		// By default, this does nothing
	}

	// Helper Methods

	protected void show(String message) {
		VGMessage.show(navigation, message);
	}

	protected void show(String message, int type) {
		VGMessage.show(navigation, message, type);
	}

	protected JFileChooser getFileChooser() {
		JFileChooser fc = new JFileChooser("");
		fc.setCurrentDirectory(new File("."));
		fc.setFileSelectionMode(JFileChooser.FILES_ONLY);
		return fc;
	}

	protected JFileChooser getFolderChooser() {
		JFileChooser fc = new JFileChooser("");
		fc.setCurrentDirectory(new File("."));
		fc.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
		return fc;
	}
}
