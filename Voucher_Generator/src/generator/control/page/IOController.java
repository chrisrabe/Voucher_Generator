package generator.control.page;

import java.util.HashMap;
import java.util.Map;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import generator.control.ApplicationController;
import generator.control.helper.IDisplayController;
import generator.helper.eventhandler.load.LoadEventHandler;
import generator.helper.eventhandler.load.TextLoadEventHandler;
import generator.helper.eventhandler.load.XMLLoadEventHandler;
import generator.helper.eventhandler.save.SaveEventHandler;
import generator.helper.eventhandler.save.TextSaveEventHandler;
import generator.helper.eventhandler.save.XMLSaveEventHandler;
import generator.helper.exception.InvalidInputException;
import generator.view.display.io.load.Load;
import generator.view.display.io.save.Save;
import generator.view.page.PageView;
import generator.view.page.io.IO;

/**
 * This class is responsible for implementing the action listeners for the IO
 * view.
 * 
 * @author Chris
 */
public class IOController extends PageController {
	private IO ioView;
	private SaveEventHandler saveHandler;
	private LoadEventHandler loadHandler;
	private Map<String, IDisplayController> displayControllers;

	public IOController(ApplicationController main) {
		super(main);
		displayControllers = createControllers();
	}

	@Override
	protected PageView createView() {
		if (ioView == null)
			ioView = createIOView();

		return ioView;
	}

	// Methods

	protected void doTXTSave() {
		JFileChooser fc = getFileChooser();
		int val = fc.showSaveDialog(ApplicationController.getWindow());
		if (val == JFileChooser.APPROVE_OPTION) {
			if (!(saveHandler instanceof TextSaveEventHandler))
				saveHandler = new TextSaveEventHandler();
			try {
				saveHandler.save(fc.getSelectedFile().getAbsolutePath(), main.getCodeManager().getCodes());
			} catch (InvalidInputException e) {
				show(e.getMessage(), JOptionPane.ERROR_MESSAGE);
			}
		}
	}

	protected void doXMLSave() {
		JFileChooser fc = getFileChooser();
		int val = fc.showSaveDialog(ApplicationController.getWindow());
		if (val == JFileChooser.APPROVE_OPTION) {
			if (!(saveHandler instanceof XMLSaveEventHandler))
				saveHandler = new XMLSaveEventHandler();
			try {
				saveHandler.save(fc.getSelectedFile().getAbsolutePath(), main.getCodeManager().getCodes());
			} catch (InvalidInputException e) {
				show(e.getMessage(), JOptionPane.ERROR_MESSAGE);
			}
		}
	}

	protected void doPNGSave() {
		show("Feature is coming soon");
	}

	protected void doTXTLoad() {
		JFileChooser fc = getFileChooser();
		main.getCodeManager().clear();
		int val = fc.showOpenDialog(ApplicationController.getWindow());
		if (val == JFileChooser.APPROVE_OPTION) {
			if (!(loadHandler instanceof TextLoadEventHandler))
				loadHandler = new TextLoadEventHandler();
			try {
				main.getCodeManager().getStorage().setCodes(loadHandler.load(fc.getSelectedFile().getAbsolutePath()));
			} catch (InvalidInputException e) {
				show(e.getMessage(), JOptionPane.ERROR_MESSAGE);
			}
		}
		// Tell the voucher controller that changes have been made to its model
		main.updateMainModel();
	}

	protected void doXMLLoad() {
		JFileChooser fc = getFileChooser();
		main.getCodeManager().clear();
		int val = fc.showOpenDialog(ApplicationController.getWindow());
		if (val == JFileChooser.APPROVE_OPTION) {
			if (!(loadHandler instanceof XMLLoadEventHandler))
				loadHandler = new XMLLoadEventHandler();
			try {
				main.getCodeManager().getStorage().setCodes(loadHandler.load(fc.getSelectedFile().getAbsolutePath()));
			} catch (InvalidInputException e) {
				show(e.getMessage(), JOptionPane.ERROR_MESSAGE);
			}
		}
		// Tell voucher controller that changes have been made to its model
		main.updateMainModel();
	}

	// Helper Methods

	/**
	 * Creates the IO View and initialises the action listeners
	 * 
	 * @return
	 */
	private IO createIOView() {
		IO tmp = new IO();
		tmp.addHomeBtnListener(e -> {
			main.navigateTo("home");
		});
		tmp.addVouchBtnListener(e -> {
			main.navigateTo("voucher");
		});
		tmp.addDescBtnListener(e -> {
			main.navigateTo("description");
		});
		tmp.addConfigBtnListener(e -> {
			main.navigateTo("config");
		});
		tmp.addLoadBtnListener(e -> {
			ioView.setDisplayContent(displayControllers.get("load").getDisplay());
		});
		tmp.addSaveBtnListener(e -> {
			ioView.setDisplayContent(displayControllers.get("save").getDisplay());
		});
		return tmp;
	}

	private Map<String, IDisplayController> createControllers() {
		Map<String, IDisplayController> tmp = new HashMap<String, IDisplayController>();
		tmp.put("save", createSaveController());
		tmp.put("load", createLoadController());
		return tmp;
	}

	// Display Controllers

	private IDisplayController createSaveController() {
		return new IDisplayController() {
			private Save saveDisplay;

			@Override
			public JPanel getDisplay() {
				if (saveDisplay == null) {
					saveDisplay = new Save();
					saveDisplay.addXmlBtnListener(e -> {
						doXMLSave();
					});
					saveDisplay.addTxtBtnListener(e -> {
						doTXTSave();
					});
					saveDisplay.addPngBtnListener(e -> {
						doPNGSave();
					});
				}
				return saveDisplay;
			}
		};
	}

	private IDisplayController createLoadController() {
		return new IDisplayController() {
			private Load loadDisplay;

			@Override
			public JPanel getDisplay() {
				if (loadDisplay == null) {
					loadDisplay = new Load();
					loadDisplay.addXmlBtnListener(e -> {
						doXMLLoad();
					});
					loadDisplay.addTxtBtnListener(e -> {
						doTXTLoad();
					});
				}
				return loadDisplay;
			}
		};
	}
}
