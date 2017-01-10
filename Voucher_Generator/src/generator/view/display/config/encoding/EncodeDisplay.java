package generator.view.display.config.encoding;

import java.awt.event.ActionListener;

import javax.swing.ListCellRenderer;

import vgcomponents.factories.VGImagePanelFactory;
import vgcomponents.lists.VGList;

/**
 * This class is responsible for implementing methods that add listeners to the
 * GUI components.
 * 
 * @author Chris
 */
@SuppressWarnings("serial")
public class EncodeDisplay extends EncodeGUI {

	public EncodeDisplay() {
		this.initialiseComponents();
	}

	// Button Listeners

	public void addEnableBtnListener(ActionListener listener) {
		enableBtn.addActionListener(listener);
	}

	public void addDisableBtnListener(ActionListener listener) {
		disableBtn.addActionListener(listener);
	}

	// Image Replacement

	public void setImage(String imageName) {
		indicator.remove(image);
		image = VGImagePanelFactory.createConfigImagePanel(imageName, IMAGE_SIZE);
		indicator.add(image);
		this.revalidate();
		this.repaint();
	}

	// Content Getters and Setters

	public void setCellRenderer(ListCellRenderer<String> renderer) {
		content.setCellRenderer(renderer);
		content.repaint();
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
