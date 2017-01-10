package generator.view.page.description;

import java.awt.event.ActionListener;

import javax.swing.ListCellRenderer;

import vgcomponents.lists.VGList;

/**
 * This class is responsible for adding action listeners to the components of
 * the description view.
 * 
 * @author Chris
 */
@SuppressWarnings("serial")
public class DescriptionView extends DescriptionGUI {

	public DescriptionView() {
		this.initialiseComponents();
	}

	// Navigation Button Listeners

	public void addHomeBtnListener(ActionListener listener) {
		homeBtn.addActionListener(listener);
	}

	public void addIoBtnListener(ActionListener listener) {
		ioBtn.addActionListener(listener);
	}

	public void addConfigBtnListener(ActionListener listener) {
		configBtn.addActionListener(listener);
	}

	public void addVoucherBtnListener(ActionListener listener) {
		voucherBtn.addActionListener(listener);
	}

	// Description Button Listeners

	public void addAddBtnListener(ActionListener listener) {
		addBtn.addActionListener(listener);
	}

	public void addDelBtnListener(ActionListener listener) {
		delBtn.addActionListener(listener);
	}

	public void addClrBtnListener(ActionListener listener) {
		clrBtn.addActionListener(listener);
	}

	public void addDisBtnListener(ActionListener listener) {
		disBtn.addActionListener(listener);
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
	}
}
