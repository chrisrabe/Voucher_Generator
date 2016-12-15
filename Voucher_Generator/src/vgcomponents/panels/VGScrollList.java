package vgcomponents.panels;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.border.LineBorder;

@SuppressWarnings("serial")
public class VGScrollList extends JScrollPane {

	public VGScrollList(JList<String> list) {
		super(list);
		this.setBorder(new LineBorder(Color.WHITE));
	}

	public VGScrollList(int width, int height, JList<String> list) {
		this(list);
		this.setPreferredSize(new Dimension(width, height));
	}
}
