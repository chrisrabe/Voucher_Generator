package vgcomponents.factories;

import javax.swing.JOptionPane;

import generator.control.ApplicationController;

/**
 * This class is responsible for creating JDialog boxes.
 * 
 * @author Chris
 */
public abstract class VGMessage {

	public static void show(String message) {
		JOptionPane.showMessageDialog(ApplicationController.getWindow(), message);
	}

	public static void show(String message, int type) {
		JOptionPane.showMessageDialog(ApplicationController.getWindow(), message, "", type);
	}
}
