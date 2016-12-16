package generator.view.display.io;

import java.awt.Graphics;

/**
 * This class is an empty display which has a white line border around it. Since
 * it has no components, then it creates the components upon construction.
 * 
 * @author Chris
 */
@SuppressWarnings("serial")
public class DefaultDisplay extends IODisplay {

	public DefaultDisplay() {
		this.initialiseComponents();
	}

	@Override
	protected void initialiseComponents() {
		// It's just invisible
	}

	@Override
	protected void drawBackground(Graphics g) {
		g.setColor(BG_COLOUR);
		g.fillRect(0, 0, getSize().width, getSize().height);
	}

}
