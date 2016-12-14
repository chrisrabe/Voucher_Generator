package generator.view.page.home;

import java.awt.BorderLayout;
import java.awt.Graphics;

import javax.swing.JButton;
import javax.swing.JPanel;

import generator.view.page.PageView;
import vgcomponents.factories.VGButtonFactory;
import vgcomponents.labels.VGLabel;
import vgcomponents.panels.CenteredPanel;
import vgcomponents.panels.GridButtonPanel;
import vgcomponents.panels.WrapperPanel;

/**
 * This class initialises the components of the home page.
 * 
 * @author Chris
 */
@SuppressWarnings("serial")
public abstract class HomeView extends PageView {

	protected JButton configBtn = VGButtonFactory.createNavigationButton("config", "Settings");
	protected JButton ioBtn = VGButtonFactory.createNavigationButton("io", "Save / Load");
	protected JButton voucherBtn = VGButtonFactory.createNavigationButton("vouchers", "Vouchers");
	protected JButton descBtn = VGButtonFactory.createNavigationButton("descriptions", "Descriptions");

	@Override
	protected void initialiseComponents() {
		// Create the label
		JPanel title = new CenteredPanel(50, new VGLabel("Voucher Generator", 40));
		// Create the grid panel
		JPanel buttons = new WrapperPanel(new GridButtonPanel(500, 500, voucherBtn, ioBtn, descBtn, configBtn));
		this.setLayout(new BorderLayout());
		this.add(title, BorderLayout.NORTH);
		this.add(buttons, BorderLayout.CENTER);
	}

	@Override
	protected void drawBackground(Graphics g) {
		g.setColor(BG_COLOUR);
		g.fillRect(0, 0, getSize().width, getSize().height);
	}

}
