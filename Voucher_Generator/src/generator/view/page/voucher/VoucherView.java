package generator.view.page.voucher;

import java.awt.BorderLayout;
import java.awt.Graphics;

import javax.swing.JButton;
import javax.swing.JPanel;

import generator.view.page.PageView;
import vgcomponents.factories.VGButtonFactory;
import vgcomponents.labels.VGLabel;
import vgcomponents.panels.CenteredPanel;
import vgcomponents.panels.DockedPanel;
import vgcomponents.panels.GridButtonPanel;
import vgcomponents.panels.HorizontalButtonPanel;
import vgcomponents.panels.VerticalButtonPanel;

/**
 * This class is responsible for drawing and placing components into this page
 * view.
 * 
 * @author Chris
 */
@SuppressWarnings("serial")
public abstract class VoucherView extends PageView {

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

	@Override
	protected void initialiseComponents() {
		JPanel topPanel = new DockedPanel(25, null, null, new GridButtonPanel(200, 1),
				new HorizontalButtonPanel(225, 50, homeBtn, ioBtn, configBtn, descBtn),
				new CenteredPanel(new VGLabel("Vouchers", 40)));
		JPanel toolBar = new CenteredPanel(20,
				new VerticalButtonPanel(100, 550, addBtn, delBtn, edtBtn, genBtn, clrBtn));
		this.setLayout(new BorderLayout());
		this.add(topPanel, BorderLayout.NORTH);
		this.add(toolBar, BorderLayout.WEST);
	}

	@Override
	protected void drawBackground(Graphics g) {
		g.setColor(BG_COLOUR);
		g.fillRect(0, 0, getSize().width, getSize().height);
	}
}
