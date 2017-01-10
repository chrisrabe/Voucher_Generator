package generator.view.display.voucher.add;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Graphics;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import generator.view.display.voucher.VoucherDisplay;
import vgcomponents.buttons.VGButton;
import vgcomponents.factories.VGButtonFactory;
import vgcomponents.fields.VGTextField;
import vgcomponents.labels.VGLabel;
import vgcomponents.panels.AlignedPanel;
import vgcomponents.panels.CenteredPanel;
import vgcomponents.panels.GridPanel;
import vgcomponents.panels.VerticalPanel;
import vgcomponents.panels.WrapperPanel;

/**
 * This class is responsible for implementing the swing components for the add
 * display of the voucher view.
 * 
 * @author Chris
 */
@SuppressWarnings("serial")
public abstract class AddDisplay extends VoucherDisplay {

	protected JButton confirmBtn = new VGButton(200, 100, "Confirm");
	protected JButton generateBtn = VGButtonFactory.createVoucherButton("generate", "Generate ID", 50);

	protected JTextArea lengthField = new VGTextField(1, 8);
	protected JTextArea idField = new VGTextField(1, 8, 30, false);
	protected JTextArea descriptionField = new VGTextField(4, 8);

	@Override
	protected void initialiseComponents() {
		JPanel title = new CenteredPanel(20, new VGLabel("New Voucher", 40));
		JPanel button = new CenteredPanel(10, confirmBtn);
		// Set up the grid in the middle
		JPanel lengthLbl = new AlignedPanel(FlowLayout.LEFT, 150, 50, new VGLabel("ID Length", 20));
		JPanel idLbl = new AlignedPanel(FlowLayout.LEFT, 150, 50, new VGLabel("Voucher ID", 20));
		JPanel descriptionLbl = new AlignedPanel(FlowLayout.LEFT, 150, 50, new VGLabel("Description", 20));
		JPanel fields = new GridPanel(550, 330, new WrapperPanel(new VerticalPanel(lengthLbl, idLbl)),
				new AlignedPanel(FlowLayout.LEFT, 200, 100,
						new AlignedPanel(FlowLayout.LEFT, new JScrollPane(lengthField)),
						new AlignedPanel(FlowLayout.LEFT, new JScrollPane(idField))),
				new WrapperPanel(descriptionLbl), new AlignedPanel(FlowLayout.LEFT, new JScrollPane(descriptionField)));
		// Put generate button on the right hand side
		JPanel genBtn = new VerticalPanel(new AlignedPanel(FlowLayout.LEFT, generateBtn),
				new GridPanel(200, 50), new GridPanel(200, 300), new GridPanel(200, 200),
				new GridPanel(200, 200));
		// set up the panel
		this.setLayout(new BorderLayout());
		this.add(title, BorderLayout.NORTH);
		this.add(button, BorderLayout.SOUTH);
		this.add(genBtn, BorderLayout.EAST);
		this.add(new CenteredPanel(fields), BorderLayout.CENTER);
	}

	@Override
	protected void drawBackground(Graphics g) {
		g.setColor(BG_COLOUR);
		g.fillRect(0, 0, getSize().width, getSize().height);
	}
}
