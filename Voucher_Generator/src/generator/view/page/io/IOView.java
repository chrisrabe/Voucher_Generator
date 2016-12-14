package generator.view.page.io;

import java.awt.Graphics;

import javax.swing.JButton;

import generator.view.page.PageView;
import vgcomponents.factories.VGButtonFactory;

/**
 * This class is responsible for providing GUI initialisation methods
 * 
 * @author Chris
 */
@SuppressWarnings("serial")
public class IOView extends PageView {
	// Navigation Buttons

	protected JButton homeBtn = VGButtonFactory.createNavigationButton("home", 50);
	protected JButton configBtn = VGButtonFactory.createNavigationButton("config", 50);
	protected JButton descBtn = VGButtonFactory.createNavigationButton("descriptions", 50);
	protected JButton vouchBtn = VGButtonFactory.createNavigationButton("vouchers", 50);

	// IO Buttons

	protected JButton loadBtn = VGButtonFactory.createIOButton("load", "Load");
	protected JButton saveBtn = VGButtonFactory.createIOButton("save", "Save");

	@Override
	protected void initialiseComponents() {
		
	}

	@Override
	protected void drawBackground(Graphics g) {
		g.setColor(BG_COLOUR);
		g.fillRect(0, 0, getSize().width, getSize().height);
	}

}
