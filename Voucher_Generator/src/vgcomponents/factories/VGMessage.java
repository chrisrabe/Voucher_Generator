package vgcomponents.factories;

import javax.swing.JOptionPane;

import generator.control.manager.navigation.INavigationManager;

/**
 * This class is responsible for creating JDialog boxes.
 * 
 * @author Chris
 */
public abstract class VGMessage {

	public static void show(INavigationManager navigation, String message) {
		JOptionPane.showMessageDialog(navigation.getWindow(), message);
	}

	public static void show(INavigationManager navigation, String message, int type) {
		JOptionPane.showMessageDialog(navigation.getWindow(), message, "", type);
	}
}
