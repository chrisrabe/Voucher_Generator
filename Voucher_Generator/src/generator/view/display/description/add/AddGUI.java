package generator.view.display.description.add;

import java.awt.BorderLayout;
import java.awt.Graphics;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import generator.view.display.description.DescriptionDisplay;
import vgcomponents.buttons.VGButton;
import vgcomponents.fields.VGTextField;
import vgcomponents.labels.VGLabel;
import vgcomponents.panels.CenteredPanel;

/**
 * This class is responsible for applying the graphical representation for the
 * add description display.
 * 
 * @author Chris
 */
@SuppressWarnings("serial")
public class AddGUI extends DescriptionDisplay {

	protected JButton confirmBtn = new VGButton(200, 50, "Confirm");

	protected JTextArea descriptionField = new VGTextField(10, 10);

	@Override
	protected void initialiseComponents() {
		JPanel title = new CenteredPanel(20, new VGLabel("New Description", 40));
		JPanel button = new CenteredPanel(10, confirmBtn);
		// Set up the panel
		this.setLayout(new BorderLayout());
		this.add(title, BorderLayout.NORTH);
		this.add(new JScrollPane(descriptionField), BorderLayout.CENTER);
		this.add(button, BorderLayout.SOUTH);
	}

	@Override
	protected void drawBackground(Graphics g) {
		g.setColor(BG_COLOUR);
		g.fillRect(0, 0, getSize().width, getSize().height);
	}
}
