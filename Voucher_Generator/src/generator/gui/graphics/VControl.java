/*	File: VControl.java
 * 
 * 	Date					Author					Changes
 * 	15 Oct 16				Chris Rabe				created VControl.java
 * 	16 Oct 16				Chris Rabe				merged addCode and addDesc to a single add method
 * 	16 Oct 16				Chris Rabe				moved all methods from the text controller to the gui controller
 */
package generator.gui.graphics;

import static generator.assets.ComponentFactory.createChooser;

import java.awt.Dimension;
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

		@Override
		public Dimension getPreferredSize() {
			return new Dimension(600, 600);
		}
	}

	private View[] views;
	private Generator generator;
	private int cur;
	private int prev;

	public VControl() {
		super(String.format("Voucher Generator v%.2f", Main.VERSION));
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
		String fname = determineFile(filename);
		File file = new File(fname);
		try {
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

	private void initialise() {
		initialiseVars();
		this.setJMenuBar(createMenuBar());
		initialiseContent();
	}

	private JMenuBar createMenuBar() {
		// Create Menu items
		JMenuItem save = new JMenuItem("Save", KeyEvent.VK_S);
		JMenuItem load = new JMenuItem("Load", KeyEvent.VK_L);
		// Add Listeners
		save.addActionListener(e -> {
			JFileChooser fc = createChooser("Save file");
			int val = fc.showSaveDialog(this);
			if (val == JFileChooser.APPROVE_OPTION) {
				String fname = fc.getSelectedFile().getAbsolutePath();
				File file = new File(fname);
				try {
					file.createNewFile();
					generator.save(file);
				} catch (IOException | InputException e1) {
					handleException(new InputException(e1.getMessage()));
				}
			}
		});
		load.addActionListener(e -> {
			JFileChooser fc = createChooser("Load file");
			int val = fc.showOpenDialog(this);
			if (val == JFileChooser.APPROVE_OPTION) {
				try {
					generator.load(fc.getSelectedFile());
				} catch (InputException e1) {
					handleException(e1);
				}
			}
		});
		// Put save-load in menu
		JMenu fileMenu = new JMenu("File");
		fileMenu.add(save);
		fileMenu.add(load);
		// Put everything together in menuBar
		JMenuBar menuBar = new JMenuBar();
		menuBar.add(fileMenu);
		return menuBar;
	}

	private void initialiseContent() {
		this.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
		addWindowListener(new java.awt.event.WindowAdapter() {
			@Override
			public void windowClosing(java.awt.event.WindowEvent windowEvent) {
				int result = JOptionPane.showConfirmDialog(null, "Are you sure you want to quit?", "Quit game",
						JOptionPane.YES_NO_OPTION);
				if (result == JOptionPane.YES_OPTION) {
					System.exit(0);
				}
			}
		});
		JPanel panel = new JPanel();
		getContentPane().add(panel);
		getContentPane().add(views[cur]);
		pack();
		setResizable(false);
		setVisible(true);
	}

	private void initialiseVars() {
		this.generator = new Generator();
		this.views = ComponentFactory.createViews(this);
		this.cur = 0;
		this.prev = 0;
	}
}
