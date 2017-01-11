package generator.view.display.config.themes;

import java.awt.event.ActionListener;
import java.awt.event.MouseListener;

import javax.swing.ListCellRenderer;

import vgcomponents.lists.VGList;

@SuppressWarnings("serial")
public class ThemesDisplay extends ThemesGUI {

	public ThemesDisplay() {
		this.initialiseComponents();
	}

	// Button Listener

	public void addConfirmBtnListener(ActionListener listener) {
		confirmBtn.addActionListener(listener);
	}

	// Content Getters and Setters

	public void addContentListener(MouseListener listener) {
		content.addMouseListener(listener);
	}

	public void setCellRenderer(ListCellRenderer<String> renderer) {
		content.setCellRenderer(renderer);
		content.repaint();
	}

	public int getSelectedIndex() {
		return content.getSelectedIndex();
	}

	public String getSelectedItem() {
		return content.getSelectedValue();
	}

	public void setContent(String[] data) {
		content = new VGList(data);
		display.setViewportView(content);
		this.revalidate();
		this.repaint();
	}
}
