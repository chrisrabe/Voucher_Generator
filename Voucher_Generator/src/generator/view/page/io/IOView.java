package generator.view.page.io;

import java.awt.BorderLayout;
import java.awt.Graphics;

import javax.swing.JButton;
import javax.swing.JPanel;

import generator.view.display.io.DefaultDisplay;
import generator.view.page.PageView;
import vgcomponents.factories.VGButtonFactory;
import vgcomponents.labels.VGLabel;
import vgcomponents.panels.CenteredPanel;
import vgcomponents.panels.DockedPanel;
import vgcomponents.panels.GridButtonPanel;
import vgcomponents.panels.HorizontalButtonPanel;
import vgcomponents.panels.WrapperPanel;

/**
 * This class is responsible for providing GUI initialisation methods
 * 
 * @author Chris
 */
@SuppressWarnings("serial")
public abstract class IOView extends PageView {
	// Navigation Buttons

	protected JButton homeBtn = VGButtonFactory.createNavigationButton("home", 50);
	protected JButton configBtn = VGButtonFactory.createNavigationButton("config", 50);
	protected JButton descBtn = VGButtonFactory.createNavigationButton("descriptions", 50);
	protected JButton vouchBtn = VGButtonFactory.createNavigationButton("vouchers", 50);

	// IO Buttons

	protected JButton loadBtn = VGButtonFactory.createIOButton("load", "Load");
	protected JButton saveBtn = VGButtonFactory.createIOButton("save", "Save");

	// Display content

	protected JPanel content = new WrapperPanel(new DefaultDisplay());
	protected JPanel display = null;

	@Override
	protected void initialiseComponents() {
		// Initialise components
		JPanel navigation = new CenteredPanel(20, new GridButtonPanel(110, 110, homeBtn, configBtn, descBtn, vouchBtn));
		JPanel toolBar = new DockedPanel(null, new WrapperPanel(new HorizontalButtonPanel(550, 200, loadBtn, saveBtn)),
				null, null, null);
		display = new CenteredPanel(content);
		JPanel toolDisp = new DockedPanel(null, display, null, null, toolBar);
		JPanel title = new CenteredPanel(20, new VGLabel("Load or Save", 40));
		JPanel dock = new DockedPanel(20, navigation, null, null, null, null);
		JPanel body = new DockedPanel(title, null, null, null, toolDisp);
		// Set up panel
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
