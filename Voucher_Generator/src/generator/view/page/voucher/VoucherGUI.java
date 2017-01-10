package generator.view.page.voucher;

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
 * This class is responsible for drawing and placing components into this page
 * view.
 * 
 * @author Chris
 */
@SuppressWarnings("serial")
public abstract class VoucherGUI extends PageView {

	// Navigation Buttons
	protected JButton homeBtn = VGButtonFactory.createNavigationButton("home", 50);
	protected JButton ioBtn = VGButtonFactory.createNavigationButton("io", 50);
	protected JButton configBtn = VGButtonFactory.createNavigationButton("config", 50);
	protected JButton descBtn = VGButtonFactory.createNavigationButton("descriptions", 50);

	// Voucher Buttons

	protected JButton addBtn = VGButtonFactory.createVoucherButton("add", "Add", 100);
	protected JButton delBtn = VGButtonFactory.createVoucherButton("del", "Delete", 100);
	protected JButton edtBtn = VGButtonFactory.createVoucherButton("edit", "Edit", 100);
	protected JButton genBtn = VGButtonFactory.createVoucherButton("generate", "Generate", 100);
	protected JButton clrBtn = VGButtonFactory.createVoucherButton("clear", "Clear", 100);

	// The voucher display

	protected JList<String> content = new VGList(new String[] {});
	protected JScrollPane display = new VGScrollList(700, 600, content);

	@Override
	protected void initialiseComponents() {
		JPanel navigation = new CenteredPanel(20, new GridPanel(110, 110, homeBtn, ioBtn, configBtn, descBtn));
		JPanel toolBar = new VerticalPanel(100, 550, addBtn, delBtn, edtBtn, genBtn, clrBtn);
		JPanel title = new CenteredPanel(20, new VGLabel("Vouchers", 40));
		JPanel dock = new DockedPanel(20, navigation, null, null, null, new WrapperPanel(toolBar));
		JPanel body = new DockedPanel(title, null, null, null, new WrapperPanel(20, display));
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
