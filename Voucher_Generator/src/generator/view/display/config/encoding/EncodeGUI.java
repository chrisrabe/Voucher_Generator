package generator.view.display.config.encoding;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.LineBorder;

import generator.view.display.config.ConfigDisplay;
import vgcomponents.buttons.VGButton;
import vgcomponents.factories.VGImagePanelFactory;
import vgcomponents.labels.VGLabel;
import vgcomponents.lists.VGList;
import vgcomponents.panels.CenteredPanel;
import vgcomponents.panels.DockedPanel;
import vgcomponents.panels.HorizontalPanel;
import vgcomponents.panels.VGScrollList;
import vgcomponents.panels.VerticalPanel;
import vgcomponents.panels.WrapperPanel;

/**
 * This class is responsible for displaying items in the encoding display.
 * 
 * @author Chris
 */
@SuppressWarnings("serial")
public abstract class EncodeGUI extends ConfigDisplay {

	protected static final int IMAGE_SIZE = 100;

	// Buttons

	protected JButton enableBtn = new VGButton(200, 50, "Enable");
	protected JButton disableBtn = new VGButton(200, 50, "Disable");

	// Image

	protected JPanel image = VGImagePanelFactory.createConfigImagePanel("inactive_icon", IMAGE_SIZE);
	protected JPanel indicator = new CenteredPanel(image);

	// List of character groups

	protected JList<String> content = new VGList(new String[] {});
	protected JScrollPane display = new VGScrollList(300, 500, content);

	@Override
	protected void initialiseComponents() {
		JPanel rightTop = new DockedPanel(new CenteredPanel(20, new VGLabel("Activated", 20)), null, null, null,
				indicator);
		JPanel buttons = new VerticalPanel(220, 220, new WrapperPanel(enableBtn), new WrapperPanel(disableBtn));
		JPanel right = new VerticalPanel(220, 520, rightTop, new WrapperPanel(buttons));
		JPanel title = new CenteredPanel(10, new VGLabel("Character Groups", 20));
		JPanel left = new DockedPanel(title, null, null, null, new WrapperPanel(display));
		JPanel body = new HorizontalPanel(new WrapperPanel(10, left), new WrapperPanel(right));
		// set up panel
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
