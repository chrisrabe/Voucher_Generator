package vgcomponents.themes;

import java.awt.Color;

/**
 * Voucher Generator Theme. It contains colours for the foreground of the text
 * in the list and the alternating colours of each list cell.
 * 
 * @author Chris
 */
public interface IVGTheme {

	/**
	 * Returns the colour of the text of a list cell.
	 * 
	 * @return
	 */
	public Color getForegroundColour();

	/**
	 * Returns the main colour of the list.
	 * 
	 * @return
	 */
	public Color getMainColour1();

	/**
	 * Returns the second alternate colour
	 * 
	 * @return
	 */
	public Color getMainColour2();

	/**
	 * Returns the main background colour if the cell is selected.
	 * 
	 * @return
	 */
	public Color getSelectedBGColour1();

	/**
	 * Returns the second alternate colour if the cell is selected.
	 * 
	 * @return
	 */
	public Color getSelectedBGColour2();

	/**
	 * Returns the foreground colour if the cell is selected.
	 * 
	 * @return
	 */
	public Color getSelectedFGColour();

	public Color getBorderColour();
}
