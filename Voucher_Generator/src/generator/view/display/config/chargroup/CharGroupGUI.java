package generator.view.display.config.chargroup;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;

import generator.view.display.config.ConfigDisplay;
import vgcomponents.buttons.VGButton;
import vgcomponents.fields.VGTextField;
import vgcomponents.labels.VGLabel;
import vgcomponents.lists.VGList;
import vgcomponents.panels.CenteredPanel;
import vgcomponents.panels.DockedPanel;
import vgcomponents.panels.GridPanel;
import vgcomponents.panels.HorizontalPanel;
import vgcomponents.panels.VGScrollList;
import vgcomponents.panels.VerticalPanel;
import vgcomponents.panels.WrapperPanel;

/**
 * This class is responsible for adding swing components to the character group
 * display.
 * 
 * @author Chris
 */
@SuppressWarnings("serial")
public abstract class CharGroupGUI extends ConfigDisplay {

	// Buttons

	protected JButton addBtn = new VGButton(100, 50, "Add");
	protected JButton removeBtn = new VGButton(100, 50, "Remove");
	protected JButton updateBtn = new VGButton(200, 50, "Update");

	// List of character groups

	protected JList<String> content = new VGList(new String[] {});
	protected JScrollPane display = new VGScrollList(300, 450, content);

	// Fields

	protected JTextField charactersField = new VGTextField(300, 50);
	protected JTextField nameField = new VGTextField(300, 50);

	@Override
	protected void initialiseComponents() {
		// Set up left pane components
		JPanel leftTitle = new CenteredPanel(10, new VGLabel("Character Groups", 20));
		JPanel leftButtons = new HorizontalPanel(new WrapperPanel(addBtn), new WrapperPanel(removeBtn));
		// Set up right pane components
		JPanel characters = new DockedPanel(new CenteredPanel(5, new VGLabel("Characters", 20)), null, null, null,
				new WrapperPanel(new JScrollPane(charactersField)));
		JPanel name = new DockedPanel(new CenteredPanel(5, new VGLabel("Group Name", 20)), null, null, null,
				new WrapperPanel(new JScrollPane(nameField)));
		JPanel rightButton = new CenteredPanel(updateBtn);
		JPanel padding = new GridPanel(100, 100);
		// Put everything together
		JPanel left = new DockedPanel(leftTitle, leftButtons, null, null, new WrapperPanel(display));
		JPanel right = new VerticalPanel(padding, characters, name, rightButton);
		JPanel body = new HorizontalPanel(new WrapperPanel(5, left), new WrapperPanel(right));
		// Add it to the pane
		this.setLayout(new BorderLayout());
		this.setBorder(new LineBorder(Color.WHITE));
		this.add(body, BorderLayout.CENTER);
	}

	@Override
	protected void drawBackground(Graphics g) {
		g.setColor(BG_COLOUR);
		g.fillRect(0, 0, getSize().width, getSize().height);
	}
}
