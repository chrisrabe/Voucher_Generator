package generator.view.page.description;

import java.awt.Graphics;

import javax.swing.JButton;

import generator.view.page.PageView;
import vgcomponents.factories.VGButtonFactory;

/**
 * This class is responsible for initialising the components needed for the
 * description view.
 * 
 * @author Chris
 */
@SuppressWarnings("serial")
public class DescriptionView extends PageView {
	// Navigation Buttons

	protected JButton homeBtn = VGButtonFactory.createNavigationButton("home", 50);
	protected JButton ioBtn = VGButtonFactory.createNavigationButton("io", 50);
	protected JButton configBtn = VGButtonFactory.createNavigationButton("config", 50);
	protected JButton voucherBtn = VGButtonFactory.createNavigationButton("vouchers", 50);

	// Description Buttons

	protected JButton addBtn = VGButtonFactory.createDescriptionButton("add", "Add", 100);
	protected JButton delBtn = VGButtonFactory.createDescriptionButton("remove", "Delete", 100);
	protected JButton clrBtn = VGButtonFactory.createDescriptionButton("clear", "Clear", 100);
	protected JButton disBtn = VGButtonFactory.createDescriptionButton("distribute", "Distribute", 100);

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
