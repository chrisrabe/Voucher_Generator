package generator.view.window;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;

import generator.Main;

/**
 * Contains all the components initialisation methods.
 * 
 * @author Chris
 */
@SuppressWarnings("serial")
public abstract class Window extends JFrame {

	// Fields
	public static final Color BG_COLOUR = new Color(40, 40, 40);
	public static final Dimension APP_RESOLUTION = new Dimension(1024, 768);

	protected JPanel content;

	// Constructors

	/**
	 * Initialises the fields of this window.
	 */
	public Window() {
		this.content = new JPanel();
		content.setPreferredSize(APP_RESOLUTION);
		content.setBackground(BG_COLOUR);
	}

	// Abstract Methods

	/**
	 * Sets the content pane for this window.
	 * 
	 * @param panel
	 */
	public abstract void setContent(JPanel panel);

	// GUI Initialisation

	protected void initialiseComponents() {
		this.setTitle(String.format("Voucher Generator v%s", Main.VERSION));
		this.getContentPane().add(content);
		this.pack();
		this.setLocationRelativeToScreen();
		this.setResizable(false);
		this.setVisible(true);
	}

	/**
	 * Sets the location of this window to the center of your screen.
	 */
	private void setLocationRelativeToScreen() {
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		this.setLocation(dim.width / 2 - this.getSize().width / 2, dim.height / 2 - this.getSize().height / 2);
	}
}
