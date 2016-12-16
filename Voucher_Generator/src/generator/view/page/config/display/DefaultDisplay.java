package generator.view.page.config.display;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.border.LineBorder;

/**
 * This class is an empty display which has a white line border around it. Since
 * it has no components, then it creates the components upon construction.
 * 
 * @author Chris
 */
@SuppressWarnings("serial")
public class DefaultDisplay extends ConfigDisplay {

	public DefaultDisplay() {
		this.initialiseComponents();
	}

	@Override
	protected void initialiseComponents() {
		this.setBorder(new LineBorder(Color.WHITE));
	}

	@Override
	protected void drawBackground(Graphics g) {
		g.setColor(BG_COLOUR);
		g.fillRect(0, 0, getSize().width, getSize().height);
	}

}
