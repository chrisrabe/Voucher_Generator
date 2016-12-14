package generator.view.page.home;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

import javax.swing.JLabel;

import generator.view.page.PageView;

/**
 * This class initialises the components of the home page.
 * 
 * @author Chris
 */
@SuppressWarnings("serial")
public abstract class HomeView extends PageView {

	@Override
	protected void initialiseComponents() {
		JLabel label = new JLabel("Home");
		Font font = new Font("Cooper Black", Font.PLAIN, 20);
		label.setFont(font);
		label.setForeground(Color.WHITE);
		this.add(label);
	}

	@Override
	protected void drawBackground(Graphics g) {
		g.setColor(BG_COLOUR);
		g.fillRect(0, 0, getSize().width, getSize().height);
	}

}
