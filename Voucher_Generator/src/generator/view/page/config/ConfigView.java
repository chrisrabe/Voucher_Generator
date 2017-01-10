package generator.view.page.config;

import java.awt.BorderLayout;
import java.awt.event.ActionListener;

import javax.swing.JPanel;

import vgcomponents.panels.WrapperPanel;

/**
 * Provides methods which adds action listeners to the buttons.
 * 
 * @author Chris
 */
@SuppressWarnings("serial")
public class ConfigView extends ConfigGUI {

	public ConfigView() {
		this.initialiseComponents();
	}

	// Navigation Action Listeners

	public void addHomeBtnListener(ActionListener listener) {
		homeBtn.addActionListener(listener);
	}

	public void addIoBtnListener(ActionListener listener) {
		ioBtn.addActionListener(listener);
	}

	public void addDescBtnListener(ActionListener listener) {
		descBtn.addActionListener(listener);
	}

	public void addVouchBtnListener(ActionListener listener) {
		vouchBtn.addActionListener(listener);
	}

	// Tool Bar Action Listeners

	public void addEncodBtnListener(ActionListener listener) {
		encodBtn.addActionListener(listener);
	}

	public void addGroupBtnListener(ActionListener listener) {
		groupBtn.addActionListener(listener);
	}

	public void addThemeBtnListener(ActionListener listener) {
		themeBtn.addActionListener(listener);
	}

	// Content Navigation

	public void setContent(JPanel newContent) {
		body.remove(content);
		content = newContent;
		body.add(new WrapperPanel(content), BorderLayout.CENTER);
		this.revalidate();
		this.repaint();
	}
}
