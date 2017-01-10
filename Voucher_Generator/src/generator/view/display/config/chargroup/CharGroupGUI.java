package generator.view.display.config.chargroup;

import java.awt.Graphics;

import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.JScrollPane;

import generator.view.display.config.ConfigDisplay;
import vgcomponents.buttons.VGButton;
import vgcomponents.lists.VGList;
import vgcomponents.panels.VGScrollList;

/**
 * This class is responsible for adding swing components to the character group
 * display.
 * 
 * @author Chris
 */
@SuppressWarnings("serial")
public class CharGroupGUI extends ConfigDisplay {

	// Buttons

	protected JButton addBtn = new VGButton(200, 50, "Add");
	protected JButton removeBtn = new VGButton(200, 50, "Remove");
	protected JButton updateBtn = new VGButton(200, 50, "Update");

	// List of character groups

	protected JList<String> content = new VGList(new String[] {});
	protected JScrollPane display = new VGScrollList(300, 500, content);
	
	// Fields

	@Override
	protected void initialiseComponents() {

	}

	@Override
	protected void drawBackground(Graphics g) {
		g.setColor(BG_COLOUR);
		g.fillRect(0, 0, getSize().width, getSize().height);
	}

}
