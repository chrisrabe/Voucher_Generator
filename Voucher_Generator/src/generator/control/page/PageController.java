package generator.control.page;

import java.io.File;

import javax.swing.JFileChooser;

import generator.control.ApplicationController;
import generator.view.page.PageView;
import vgcomponents.factories.VGMessage;

/**
 * Provides a skeleton implementation of a page controller.
 * 
 * @author Chris
 */
public abstract class PageController implements IPageController {

	// Need this to be able to navigate around the application.
	protected ApplicationController main;

	private PageView view;

	/**
	 * Stores the navigationIcon and name fields.
	 * 
	 * @param navigationIcon
	 * @param name
	 */
	public PageController(ApplicationController main) {
		this.main = main;
	}

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

	// Helper Methods

	protected void show(String message) {
		VGMessage.show(message);
	}

	protected void show(String message, int type) {
		VGMessage.show(message, type);
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
