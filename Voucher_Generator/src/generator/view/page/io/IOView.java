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
	
	protected JButton homeBtn = VGButtonFactory.createNavigationButton("home");
	protected JButton configBtn = VGButtonFactory.createNavigationButton("config");
	protected JButton descBtn = VGButtonFactory.createNavigationButton("descriptions");
	protected JButton vouchBtn = VGButtonFactory.createNavigationButton("vouchers");
	
	// IO Buttons

	@Override
	protected void initialiseComponents() {
		// TODO Auto-generated method stub

	}

	@Override
	protected void drawBackground(Graphics g) {
		g.setColor(BG_COLOUR);
		g.fillRect(0, 0, getSize().width, getSize().height);
	}

}
