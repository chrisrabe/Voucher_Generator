package generator.view.window;

import javax.swing.JPanel;

/**
 * Contains all the action handlers and calls the 'initialiseComponents()'
 * method of the window.
 * 
 * @author Chris
 */
@SuppressWarnings("serial")
public class ApplicationWindow extends Window {

	// Contructors

	public ApplicationWindow() {
		this.initialiseComponents();
	}

	// Methods

	@Override
	public void setContent(JPanel panel) {
		this.content = panel;
		this.content.setPreferredSize(APP_RESOLUTION);
		this.getContentPane().removeAll();
		this.getContentPane().add(content);
		this.content.repaint();
		super.revalidate();
	}

}
