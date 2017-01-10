package generator.view.display.io.save;

import java.awt.BorderLayout;
import java.awt.Graphics;

import javax.swing.JButton;
import javax.swing.JPanel;

import generator.view.display.io.IODisplay;
import vgcomponents.factories.VGButtonFactory;
import vgcomponents.labels.VGLabel;
import vgcomponents.panels.CenteredPanel;
import vgcomponents.panels.HorizontalPanel;
import vgcomponents.panels.WrapperPanel;

/**
 * This class is responsible for adding components to the save display
 * 
 * @author Chris
 */
@SuppressWarnings("serial")
public abstract class SaveDisplay extends IODisplay {

	protected JButton xmlBtn = VGButtonFactory.createIOButton("xml", "Export to XML file", 100);
	protected JButton txtBtn = VGButtonFactory.createIOButton("txt", "Export to TXT file", 100);
	protected JButton pngBtn = VGButtonFactory.createIOButton("png", "Export to a folder as PNG", 100); // TODO Implement this in another patch

	@Override
	protected void initialiseComponents() {
		JPanel title = new CenteredPanel(10, new VGLabel("Choose save operation...", 20));
		JPanel tools = new WrapperPanel(new HorizontalPanel(350, 100, xmlBtn, txtBtn));
		this.setLayout(new BorderLayout());
		this.add(title, BorderLayout.NORTH);
		this.add(tools, BorderLayout.CENTER);
	}

	@Override
	protected void drawBackground(Graphics g) {
		g.setColor(BG_COLOUR);
		g.fillRect(0, 0, getSize().width, getSize().height);
	}

}
