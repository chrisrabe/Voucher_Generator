/*	File: VControl.java
 * 
 * 	Date					Author					Changes
 * 	15 Oct 16				Chris Rabe				created VControl.java
 * 	16 Oct 16				Chris Rabe				merged addCode and addDesc to a single add method
 * 	16 Oct 16				Chris Rabe				moved all methods from the text controller to the gui controller
 * 	4 Nov 16				Chris Rabe				fixed save method not adding file extensions automatically
 */
package generator.gui;

import static generator.assets.ComponentFactory.createChooser;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import generator.Main;
import generator.assets.ComponentFactory;
import generator.backend.Code;
import generator.backend.Generator;
import generator.backend.InputException;
import generator.gui.dialogs.SettingsDialog;

/**
 * Controls all the different views of the program and calls methods from the
 * Generator class.
 * 
 * @author Chris
 */
@SuppressWarnings("serial")
public class VControl extends JFrame {

	/**
	 * This compresses all the actions which essentially does the same thing,
	 * but the operation is different.
	 */
	public static enum Command {
		CODE, DESC
	}

	/**
	 * Views are essentially JPanels with different content. This abstract class
	 * should be extended by other classes.
	 */
	public static abstract class View extends JPanel {
		protected VControl controller;

		public View(VControl controller) {
			this.controller = controller;
			this.setFocusable(false);
		}

		/**
		 * Adds components to the view or performs special actions on creation.
		 */
		public abstract void initialise();

		/**
		 * Gives the focus of the key listener to the appropriate component.
		 */
		public abstract void setFocus();

		/**
		 * Updates any components inside the View
		 */
		public abstract void update();

		public VControl getController() {
			return controller;
		}

		@Override
		public Dimension getPreferredSize() {
			return new Dimension(600, 600);
		}

		public static void showMessage(JFrame parent, String text) {
			JOptionPane.showMessageDialog(parent, text);
		}

		public static void showError(JFrame parent, String text) {
			JOptionPane.showMessageDialog(parent, text, "Error", JOptionPane.ERROR_MESSAGE);
		}
	}

	private View[] views;
	private Generator generator;
	private int cur;
	private int prev;

	public VControl() {
		super(String.format("Voucher Generator v%s", Main.VERSION));
		initialise();
	}

	// Getters for the View

	public int getPrev() {
		return prev;
	}

	// View Manipulation Methods

	/**
	 * Changes view on the specified index. Should be within the boundaries of
	 * the view, otherwise it exits out.
	 * 
	 * @param index
	 */
	public void changeView(int index) {
		if (index < 0 || index >= views.length) {
			return;
		}
		if (views[index] == null) {
			return;
		}
		// Record the previous index
		this.prev = this.cur;
		this.cur = index;
		// Remove and replace the view
		getContentPane().removeAll();
		getContentPane().add(views[cur]);
		// Setting the focus allows event listeners to be activated
		views[index].repaint();
		views[index].setFocus();
		// Redraw the whole frame
		revalidate();
	}

	// Generator Methods

	/**
	 * Removes all the objects based on the type given. If the type is "CODE",
	 * then all codes are removed. If the type is "DESC", then all descriptions
	 * are removed.
	 */
	public void clearAll(Command type) {
		switch (type) {
		case CODE:
			generator.clearCodes();
			break;
		case DESC:
			generator.clearDesc();
			break;
		}
	}

	/**
	 * This method can add information inside the generator. The behaviour of
	 * this method is dependent on the Command enumeration passed in the method.
	 * If the cmd is 'CODE' then it adds a new code object into the generator.
	 * If the cmd is 'DESC' then it adds a new description into the generator.
	 * 
	 * @param cmd
	 * @param input
	 */
	public void add(Command cmd, String code, String description) {
		try {
			switch (cmd) {
			case CODE:
				generator.addCode(code, description);
				break;
			case DESC:
				generator.addDescription(description);
				break;
			}
		} catch (InputException e) {
			handleException(e);
		}
	}

	/**
	 * This method deletes a code object or a description object from the
	 * generator. If the cmd parameter is CODE, use the second string parameter
	 * to specify which code to delete. If the cmd parameter is DESC, use the
	 * third parameter to specify which description you want to delete.
	 * 
	 * @param cmd
	 * @param code
	 * @param description
	 */
	public void delete(Command cmd, String code, String description) {
		try {
			switch (cmd) {
			case CODE:
				generator.removeCode(code);
				break;
			case DESC:
				generator.removeDescription(description);
				break;
			}
		} catch (InputException e) {
			handleException(e);
		}
	}

	/**
	 * The first segment must be the code which needs to be edited and the
	 * second segment must be the description which needs to be stored within
	 * the code.
	 * 
	 * @param code
	 * @param description
	 */
	public void editCode(String code, String description) {
		try {
			generator.editCode(code, description);
		} catch (InputException e) {
			handleException(e);
		}
	}

	/**
	 * Displays information about the code.
	 * 
	 * @param code
	 */
	public Code show(String code) {
		try {
			return generator.getCode(code);
		} catch (InputException e) {
			handleException(e);
			return null;
		}
	}

	/**
	 * The first argument (n) symbolises the number of codes which the user
	 * wants to generate. The second argument (c) symbolises the length of the
	 * codes generated.
	 * 
	 * @param n
	 * @param c
	 */
	public void generate(int n, int c) {
		try {
			generator.generate(n, c);
		} catch (InputException e) {
			handleException(e);
		}
	}

	/**
	 * Reduces the size of the codes generated.
	 * 
	 * @param input
	 */
	public void reduce(int input) {
		try {
			generator.reduceCodeSize(input);
		} catch (Exception e) {
			handleException(new InputException(e.getMessage()));
		}
	}

	/**
	 * Retrieves a specific list based on the Command enumeration passed. Valid
	 * cmd enumeration are CODE and DESC.
	 * 
	 * @param cmd
	 * @return
	 */
	public List<? extends Object> getList(Command cmd) {
		switch (cmd) {
		case CODE:
			return generator.getCodes();
		case DESC:
			return generator.getDescriptions();
		default:
			return null;
		}
	}

	/**
	 * Distributes the added descriptions to the code generated by the user.
	 */
	public void distribute() {
		try {
			generator.distributeDesc();
		} catch (InputException e) {
			handleException(e);
		}
	}

	/**
	 * Saves all the codes into a file with the specified filename. The file
	 * must be in the same directory as the program.
	 * 
	 * @param filename
	 */
	public void save(String filename) {
		try {
			if (getList(Command.CODE).isEmpty()) {
				throw new InputException("There are no codes to save.");
			}
			String fname = determineFile(filename);
			File file = new File(fname);
			file.createNewFile();
			generator.save(file);
		} catch (IOException | InputException e) {
			handleException(new InputException(e.getMessage()));
		}
	}

	/**
	 * Reads the contents of the file and stores it inside the generator. The
	 * file must be in the same directory as the program.
	 * 
	 * @param filename
	 */
	public void load(String filename) {
		try {
			if (!filename.contains(".txt")) {
				throw new InputException("Must be a .txt file");
			}
			File file = new File(filename);
			generator.load(file);
			views[cur].update();
		} catch (InputException e) {
			handleException(e);
		}
	}

	// Helper Methods

	/**
	 * Extracts any strange extensions which the user may have placed into the
	 * string.
	 * 
	 * @param filename
	 * @return
	 */
	private String determineFile(String filename) {
		String[] tmp = filename.split("[.]");
		return String.format("%s.txt", tmp[0]);
	}

	/**
	 * Displays an error JDialog to the user.
	 * 
	 * @param e
	 */
	private void handleException(InputException e) {
		JOptionPane.showMessageDialog(this, e.getMessage(), "Input Exception", JOptionPane.ERROR_MESSAGE);
	}

	// GUI Initialisation Below

	private JMenuItem save;
	private JMenuItem load;
	private JMenuItem encoding;

	private void initialise() {
		initialiseVars();
		this.setJMenuBar(createMenuBar());
		initialiseContent();
		addActionListeners();
	}

	private JMenuBar createMenuBar() {
		// Create Menu items
		save = new JMenuItem("Save", KeyEvent.VK_S);
		load = new JMenuItem("Load", KeyEvent.VK_L);
		encoding = new JMenuItem("Encoding Settings");
		// Put save-load in menu
		JMenu fileMenu = new JMenu("File");
		JMenu settings = new JMenu("Settings");
		fileMenu.add(save);
		fileMenu.add(load);
		settings.add(encoding);
		// Put everything together in menuBar
		JMenuBar menuBar = new JMenuBar();
		menuBar.add(fileMenu);
		menuBar.add(settings);
		return menuBar;
	}

	private void addActionListeners() {
		save.addActionListener(e -> {
			save();
		});
		load.addActionListener(e -> {
			load();
		});
		encoding.addActionListener(e -> {
			new SettingsDialog(this);
		});
	}

	/**
	 * Prompts the user for a file name and then saves the codes to the file.
	 */
	private void save() {
		JFileChooser fc = createChooser("Save file");
		int val = fc.showSaveDialog(this);
		if (val == JFileChooser.APPROVE_OPTION) {
			save(fc.getSelectedFile().getAbsolutePath());
		}
	}

	/**
	 * Loads a selected file. If there are codes generated, it needs to prompt
	 * the user if they want to save first before loading.
	 */
	private void load() {
		if (!generator.getCodes().isEmpty()) {
			promptSave();
		}
		JFileChooser fc = createChooser("Load file");
		int val = fc.showOpenDialog(this);
		if (val == JFileChooser.APPROVE_OPTION) {
			load(fc.getSelectedFile().getAbsolutePath());
		}
	}

	private void initialiseContent() {
		this.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
		addWindowListener(new java.awt.event.WindowAdapter() {
			@Override
			public void windowClosing(java.awt.event.WindowEvent windowEvent) {
				int result = JOptionPane.showConfirmDialog(VControl.this, "Are you sure you want to quit?", "Quit game",
						JOptionPane.YES_NO_OPTION);
				if (result == JOptionPane.YES_OPTION) {
					System.exit(0);
				}
			}
		});
		// Add the contents
		JPanel panel = new JPanel();
		getContentPane().add(panel);
		getContentPane().add(views[cur]);
		pack();
		// Set the location to the middle of the screen
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		this.setLocation((dim.width/2)-(this.getSize().width/2), (dim.height/2)-(this.getSize().height/2));
		setResizable(false);
		setVisible(true);
	}

	private void initialiseVars() {
		this.generator = new Generator();
		this.views = ComponentFactory.createViews(this);
		this.cur = 0;
		this.prev = 0;
	}

	private void promptSave() {
		int n = JOptionPane.showConfirmDialog(this, "Would you like to save before loading?", "Prompt Save",
				JOptionPane.YES_NO_OPTION);
		if (n == JOptionPane.YES_OPTION) {
			save();
		}
	}
}
