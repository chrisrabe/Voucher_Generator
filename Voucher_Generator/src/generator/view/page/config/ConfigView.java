package generator.view.page.config;

import java.awt.Graphics;

import javax.swing.JButton;

import generator.view.page.PageView;
import vgcomponents.factories.VGButtonFactory;

@SuppressWarnings("serial")
public class ConfigView extends PageView {
	// Navigation Buttons

	protected JButton homeBtn = VGButtonFactory.createNavigationButton("home");
	protected JButton ioBtn = VGButtonFactory.createNavigationButton("io");
	protected JButton descBtn = VGButtonFactory.createNavigationButton("descriptions");
	protected JButton vouchBtn = VGButtonFactory.createNavigationButton("vouchers");

	// Tool Bar Buttons

	protected JButton encodBtn = VGButtonFactory.createConfigButton("encoding", "Toggle character groups");
	protected JButton groupBtn = VGButtonFactory.createConfigButton("chargroups", "Edit character groups");
	protected JButton themeBtn = VGButtonFactory.createConfigButton("themes", "Change Theme");

	@Override
	protected void initialiseComponents() {

	}

	@Override
	protected void drawBackground(Graphics g) {
		g.setColor(BG_COLOUR);
		g.fillRect(0, 0, getSize().width, getSize().height);
	}

}
