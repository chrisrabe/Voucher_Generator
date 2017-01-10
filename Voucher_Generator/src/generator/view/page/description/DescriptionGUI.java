package generator.view.page.description;

import java.awt.BorderLayout;
import java.awt.Graphics;

import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import generator.view.page.PageView;
import vgcomponents.factories.VGButtonFactory;
import vgcomponents.labels.VGLabel;
import vgcomponents.lists.VGList;
import vgcomponents.panels.CenteredPanel;
import vgcomponents.panels.DockedPanel;
import vgcomponents.panels.GridPanel;
import vgcomponents.panels.VGScrollList;
import vgcomponents.panels.VerticalPanel;
import vgcomponents.panels.WrapperPanel;

/**
 * This class is responsible for initialising the components needed for the
 * description view.
 * 
 * @author Chris
 */
@SuppressWarnings("serial")
public abstract class DescriptionGUI extends PageView {
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

	protected JList<String> content = new VGList(new String[] {});
	protected JScrollPane display = new VGScrollList(750, 600, content);

	@Override
	protected void initialiseComponents() {
		JPanel navigation = new CenteredPanel(20, new GridPanel(110, 110, homeBtn, ioBtn, configBtn, voucherBtn));
		JPanel toolBar = new VerticalPanel(100, 440, addBtn, delBtn, clrBtn, disBtn);
		JPanel title = new CenteredPanel(20, new VGLabel("Voucher Descriptions", 40));
		JPanel dock = new DockedPanel(20, navigation, null, null, null, new WrapperPanel(toolBar));
		JPanel body = new DockedPanel(title, null, null, null, new WrapperPanel(display));
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
