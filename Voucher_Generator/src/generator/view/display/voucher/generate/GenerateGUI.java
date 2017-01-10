package generator.view.display.voucher.generate;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Graphics;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import generator.view.display.voucher.VoucherDisplay;
import vgcomponents.buttons.VGButton;
import vgcomponents.fields.VGTextField;
import vgcomponents.labels.VGLabel;
import vgcomponents.panels.AlignedPanel;
import vgcomponents.panels.CenteredPanel;
import vgcomponents.panels.GridPanel;
import vgcomponents.panels.WrapperPanel;

/**
 * This class is responsible for applying swing components of the generate
 * function display.
 * 
 * @author Chris
 */
@SuppressWarnings("serial")
public abstract class GenerateGUI extends VoucherDisplay {

	protected JButton generateBtn = new VGButton(200, 100, "Generate");

	protected JTextArea charsField = new VGTextField(1, 8);
	protected JTextArea sizeField = new VGTextField(1, 8);

	@Override
	protected void initialiseComponents() {
		JPanel title = new CenteredPanel(20, new VGLabel("Generate Voucher", 40));
		JPanel button = new CenteredPanel(20, generateBtn);
		// set up the grid in the middle
		JPanel charsLbl = new AlignedPanel(FlowLayout.LEFT, 200, 50, new VGLabel("ID Length", 20));
		JPanel sizeLbl = new AlignedPanel(FlowLayout.LEFT, 200, 50, new VGLabel("Amount Generated", 20));
		JPanel fields = new GridPanel(700, 330, new WrapperPanel(charsLbl),
				new AlignedPanel(FlowLayout.LEFT, new JScrollPane(charsField)), new WrapperPanel(sizeLbl),
				new AlignedPanel(FlowLayout.LEFT, new JScrollPane(sizeField)));
		// set up the panel
		this.setLayout(new BorderLayout());
		this.add(title, BorderLayout.NORTH);
		this.add(button, BorderLayout.SOUTH);
		this.add(new CenteredPanel(fields), BorderLayout.CENTER);
	}

	@Override
	protected void drawBackground(Graphics g) {
		g.setColor(BG_COLOUR);
		g.fillRect(0, 0, getSize().width, getSize().height);
	}
}
