package generator.view.page.description;

import java.awt.BorderLayout;
import java.awt.Graphics;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import generator.view.page.PageView;
import vgcomponents.factories.VGButtonFactory;
import vgcomponents.labels.VGLabel;
import vgcomponents.lists.VGList;
import vgcomponents.panels.CenteredPanel;
import vgcomponents.panels.GridButtonPanel;
import vgcomponents.panels.VGScrollList;
import vgcomponents.panels.VerticalButtonPanel;
import vgcomponents.panels.WrapperPanel;

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

	// Scroll Panel

	protected JScrollPane display = new VGScrollList(825, 600, new VGList(new String[] {}));

	@Override
	protected void initialiseComponents() {
		JPanel title = new CenteredPanel(25, new VGLabel("Voucher Descriptions", 40));
		JPanel navigation = new GridButtonPanel(100, 100, homeBtn, ioBtn, configBtn, voucherBtn);
		JPanel toolBar = new WrapperPanel(20,
				new VerticalButtonPanel(110, 550, addBtn, delBtn, clrBtn, disBtn, navigation));
		// Set up panel
		this.setLayout(new BorderLayout());
		this.add(title, BorderLayout.NORTH);
		this.add(toolBar, BorderLayout.WEST);
		this.add(new WrapperPanel(display), BorderLayout.CENTER);
	}

	@Override
	protected void drawBackground(Graphics g) {
		g.setColor(BG_COLOUR);
		g.fillRect(0, 0, getSize().width, getSize().height);
	}

}
