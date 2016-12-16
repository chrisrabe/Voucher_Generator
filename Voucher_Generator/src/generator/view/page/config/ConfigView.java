package generator.view.page.config;

import java.awt.BorderLayout;
import java.awt.Graphics;

import javax.swing.JButton;
import javax.swing.JPanel;

import generator.view.page.PageView;
import generator.view.page.config.display.DefaultDisplay;
import vgcomponents.factories.VGButtonFactory;
import vgcomponents.labels.VGLabel;
import vgcomponents.panels.CenteredPanel;
import vgcomponents.panels.DockedPanel;
import vgcomponents.panels.GridButtonPanel;
import vgcomponents.panels.VerticalButtonPanel;
import vgcomponents.panels.WrapperPanel;

/**
 * This class contains all the view set up. It adds components to the view.
 * 
 * @author Chris
 */
@SuppressWarnings("serial")
public abstract class ConfigView extends PageView {
	// Navigation Buttons

	protected JButton homeBtn = VGButtonFactory.createNavigationButton("home", 50);
	protected JButton ioBtn = VGButtonFactory.createNavigationButton("io", 50);
	protected JButton descBtn = VGButtonFactory.createNavigationButton("descriptions", 50);
	protected JButton vouchBtn = VGButtonFactory.createNavigationButton("vouchers", 50);

	// Tool Bar Buttons

	protected JButton encodBtn = VGButtonFactory.createConfigButton("encoding", "Toggle character groups", 100);
	protected JButton groupBtn = VGButtonFactory.createConfigButton("chargroups", "Edit character groups", 100);
	protected JButton themeBtn = VGButtonFactory.createConfigButton("themes", "Change Theme", 100);

	// Content Panel

	protected JPanel content = new WrapperPanel(new DefaultDisplay());
	protected JPanel body = null;

	@Override
	protected void initialiseComponents() {
		JPanel navigation = new CenteredPanel(20, new GridButtonPanel(110, 110, homeBtn, ioBtn, descBtn, vouchBtn));
		JPanel toolBar = new VerticalButtonPanel(100, 330, encodBtn, groupBtn, themeBtn);
		JPanel title = new CenteredPanel(20, new VGLabel("Settings", 40));
		JPanel dock = new DockedPanel(20, navigation, null, null, null, toolBar);
		body = new DockedPanel(title, null, null, null, content);
		// Set up the panel
		this.setLayout(new BorderLayout());
		this.add(dock, BorderLayout.WEST);
		this.add(body, BorderLayout.CENTER);
	}

	@Override
	protected void drawBackground(Graphics g) {
		g.setColor(BG_COLOUR);
		g.fillRect(0, 0, getSize().width, getSize().height);
	}

}
