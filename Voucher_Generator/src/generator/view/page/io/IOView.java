package generator.view.page.io;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Graphics;

import javax.swing.JButton;
import javax.swing.JPanel;

import generator.view.page.PageView;
import vgcomponents.factories.VGButtonFactory;
import vgcomponents.panels.CenteredPanel;
import vgcomponents.panels.GridButtonPanel;
import vgcomponents.panels.AlignedPanel;

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
		// Initialise components
		JPanel navigation = new AlignedPanel(FlowLayout.LEFT, 50,
				new GridButtonPanel(110, 110, homeBtn, configBtn, descBtn, vouchBtn));
		JPanel io = new CenteredPanel(new GridButtonPanel(500, 200, loadBtn, saveBtn));
		// Set up panel
		this.setLayout(new BorderLayout());
		this.add(navigation, BorderLayout.NORTH);
		this.add(io, BorderLayout.CENTER);
	}

	@Override
	protected void drawBackground(Graphics g) {
		g.setColor(BG_COLOUR);
		g.fillRect(0, 0, getSize().width, getSize().height);
	}

}
