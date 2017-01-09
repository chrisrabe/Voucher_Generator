package generator.view.display.io.load;

import java.awt.BorderLayout;
import java.awt.Graphics;

import javax.swing.JButton;
import javax.swing.JPanel;

import generator.view.display.io.IODisplay;
import vgcomponents.factories.VGButtonFactory;
import vgcomponents.labels.VGLabel;
import vgcomponents.panels.CenteredPanel;
import vgcomponents.panels.HorizontalButtonPanel;
import vgcomponents.panels.WrapperPanel;

/**
 * This class is responsible for adding components to the load display.
 * 
 * @author Chris
 */
@SuppressWarnings("serial")
public abstract class LoadDisplay extends IODisplay {

	protected JButton xmlBtn = VGButtonFactory.createIOButton("xml", "Load an XML file", 100);
	protected JButton txtBtn = VGButtonFactory.createIOButton("txt", "Load a TXT file", 100);

	@Override
	protected void initialiseComponents() {
		JPanel title = new CenteredPanel(10, new VGLabel("Choose load operation...", 20));
		JPanel tools = new WrapperPanel(new HorizontalButtonPanel(350, 100, xmlBtn, txtBtn));
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
