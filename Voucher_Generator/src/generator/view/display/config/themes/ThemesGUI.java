package generator.view.display.config.themes;

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
import vgcomponents.labels.VGLabel;
import vgcomponents.lists.VGList;
import vgcomponents.panels.CenteredPanel;
import vgcomponents.panels.DockedPanel;
import vgcomponents.panels.GridPanel;
import vgcomponents.panels.HorizontalPanel;
import vgcomponents.panels.VGScrollList;
import vgcomponents.panels.VerticalPanel;
import vgcomponents.panels.WrapperPanel;

@SuppressWarnings("serial")
public abstract class ThemesGUI extends ConfigDisplay {

	// Buttons

	protected JButton confirmBtn = new VGButton(200, 50, "Confirm");

	// List of themes

	protected JList<String> content = new VGList(new String[] {});
	protected JScrollPane display = new VGScrollList(300, 500, content);

	@Override
	protected void initialiseComponents() {
		JPanel leftTitle = new CenteredPanel(10, new VGLabel("Themes", 20));
		JPanel left = new DockedPanel(leftTitle, null, null, null, new WrapperPanel(display));
		JPanel right = new VerticalPanel(new GridPanel(100, 100), new WrapperPanel(confirmBtn));
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
