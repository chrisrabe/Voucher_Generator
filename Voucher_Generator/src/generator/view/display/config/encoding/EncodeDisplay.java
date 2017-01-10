package generator.view.display.config.encoding;

import java.awt.Graphics;

import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import generator.view.display.config.ConfigDisplay;
import vgcomponents.buttons.VGButton;
import vgcomponents.factories.VGImagePanelFactory;
import vgcomponents.labels.VGLabel;
import vgcomponents.lists.VGList;
import vgcomponents.panels.HorizontalPanel;
import vgcomponents.panels.VGScrollList;

/**
 * This class is responsible for displaying items in the encoding display.
 * 
 * @author Chris
 */
@SuppressWarnings("serial")
public class EncodeDisplay extends ConfigDisplay {

	// Buttons

	protected JButton enableBtn = new VGButton(200, 100, "Enable");
	protected JButton disableBtn = new VGButton(200, 100, "Disable");

	// Image

	protected JPanel image = VGImagePanelFactory.createConfigImagePanel("inactive_icon", 50);
	protected JPanel indicator = new HorizontalPanel(new VGLabel("Activated:", 40), image);

	// List of character groups

	protected JList<String> content = new VGList(new String[] {});
	protected JScrollPane display = new VGScrollList(700, 600, content);

	@Override
	protected void initialiseComponents() {
		
	}

	@Override
	protected void drawBackground(Graphics g) {
		g.setColor(BG_COLOUR);
		g.fillRect(0, 0, getSize().width, getSize().height);
	}

}
