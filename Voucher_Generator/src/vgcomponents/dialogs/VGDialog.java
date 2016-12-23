package vgcomponents.dialogs;

import java.awt.BorderLayout;

import javax.swing.JDialog;
import javax.swing.JPanel;

import generator.control.manager.navigation.INavigationManager;

/**
 * This class is creates a JDialog box which contains a display.
 * 
 * @author Chris
 */
@SuppressWarnings("serial")
public class VGDialog extends JDialog {

	public VGDialog(INavigationManager navigation, JPanel display) {
		this("", navigation, display);
	}

	public VGDialog(String title, INavigationManager navigation, JPanel display) {
		this.setTitle(title);
		this.setLayout(new BorderLayout());
		this.add(display);
		this.pack();
		this.setLocationRelativeTo(navigation.getWindow());
		this.setResizable(false);
		this.setVisible(true);
	}

}
