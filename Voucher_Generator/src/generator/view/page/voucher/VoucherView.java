package generator.view.page.voucher;

import java.awt.Graphics;

import javax.swing.JButton;
import generator.view.page.PageView;
import vgcomponents.factories.VGButtonFactory;

/**
 * This class is responsible for drawing and placing components into this page
 * view.
 * 
 * @author Chris
 */
@SuppressWarnings("serial")
public class VoucherView extends PageView {
	// Navigation Buttons
	protected JButton homeBtn = VGButtonFactory.createNavigationButton("home", 50);
	protected JButton ioBtn = VGButtonFactory.createNavigationButton("io", 50);
	protected JButton configBtn = VGButtonFactory.createNavigationButton("config", 50);
	protected JButton descBtn = VGButtonFactory.createNavigationButton("descriptions", 50);

	// Voucher Buttons
	
	protected JButton addBtn = VGButtonFactory.createVoucherButton("add", "Add", 150);
	protected JButton delBtn = VGButtonFactory.createVoucherButton("del", "Delete", 150);
	protected JButton edtBtn = VGButtonFactory.createVoucherButton("edit", "Edit", 150);
	protected JButton genBtn = VGButtonFactory.createVoucherButton("generate", "Generate", 150);
	protected JButton clrBtn = VGButtonFactory.createVoucherButton("clear", "Clear", 150);

	@Override
	protected void initialiseComponents() {

	}

	@Override
	protected void drawBackground(Graphics g) {
		g.setColor(BG_COLOUR);
		g.fillRect(0, 0, getSize().width, getSize().height);
	}

}
