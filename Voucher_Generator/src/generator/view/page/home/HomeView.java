package generator.view.page.home;

import java.awt.BorderLayout;
import java.awt.Graphics;

import javax.swing.JButton;
import javax.swing.JPanel;

import generator.view.page.PageView;
import uicomponents.factories.VGButtonFactory;
import uicomponents.factories.VGToolTipFactory;
import uicomponents.labels.VGLabel;
import uicomponents.panels.CenteredPanel;
import uicomponents.panels.GridButtonPanel;
import uicomponents.panels.WrapperPanel;

/**
 * This class initialises the components of the home page.
 * 
 * @author Chris
 */
@SuppressWarnings("serial")
public abstract class HomeView extends PageView {

	private int fontSize = 6;

	protected JButton configBtn = VGButtonFactory.createNavigationButton("config",
			VGToolTipFactory.createToolTip("Settings", fontSize));
	protected JButton ioBtn = VGButtonFactory.createNavigationButton("io",
			VGToolTipFactory.createToolTip("Save / Load", fontSize));
	protected JButton voucherBtn = VGButtonFactory.createNavigationButton("vouchers",
			VGToolTipFactory.createToolTip("Vouchers", fontSize));
	protected JButton descBtn = VGButtonFactory.createNavigationButton("descriptions",
			VGToolTipFactory.createToolTip("Descriptions", fontSize));

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
