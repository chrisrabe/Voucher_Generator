package generator.control.page;

import java.util.HashMap;
import java.util.Map;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import generator.control.display.IDisplayController;
import generator.control.manager.code.CodeManager;
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
	private CodeManager codeManager;
	private SaveEventHandler saveHandler;
	private LoadEventHandler loadHandler;
	private Map<String, IDisplayController> displayControllers;

	public IOController(CodeManager codeManager) {
		displayControllers = createControllers();
		this.codeManager = codeManager;
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
		int val = fc.showSaveDialog(navigation.getWindow());
		if (val == JFileChooser.APPROVE_OPTION) {
			if (!(saveHandler instanceof TextSaveEventHandler))
				saveHandler = new TextSaveEventHandler();
			try {
				saveHandler.save(fc.getSelectedFile().getAbsolutePath(), codeManager.getCodes());
			} catch (InvalidInputException e) {
				show(e.getMessage(), JOptionPane.ERROR_MESSAGE);
			}
		}
	}

	protected void doXMLSave() {
		JFileChooser fc = getFileChooser();
		int val = fc.showSaveDialog(navigation.getWindow());
		if (val == JFileChooser.APPROVE_OPTION) {
			if (!(saveHandler instanceof XMLSaveEventHandler))
				saveHandler = new XMLSaveEventHandler();
			try {
				saveHandler.save(fc.getSelectedFile().getAbsolutePath(), codeManager.getCodes());
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
		codeManager.clear();
		int val = fc.showOpenDialog(navigation.getWindow());
		if (val == JFileChooser.APPROVE_OPTION) {
			if (!(loadHandler instanceof TextLoadEventHandler))
				loadHandler = new TextLoadEventHandler();
			try {
				codeManager.getStorage().setCodes(loadHandler.load(fc.getSelectedFile().getAbsolutePath()));
			} catch (InvalidInputException e) {
				show(e.getMessage(), JOptionPane.ERROR_MESSAGE);
			}
		}
		// Tell the voucher controller that changes have been made to its model
		navigation.updateControllers();
	}

	protected void doXMLLoad() {
		JFileChooser fc = getFileChooser();
		codeManager.clear();
		int val = fc.showOpenDialog(navigation.getWindow());
		if (val == JFileChooser.APPROVE_OPTION) {
			if (!(loadHandler instanceof XMLLoadEventHandler))
				loadHandler = new XMLLoadEventHandler();
			try {
				codeManager.getStorage().setCodes(loadHandler.load(fc.getSelectedFile().getAbsolutePath()));
			} catch (InvalidInputException e) {
				show(e.getMessage(), JOptionPane.ERROR_MESSAGE);
			}
		}
		// Tell voucher controller that changes have been made to its model
		navigation.updateControllers();
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
			navigation.navigateTo("home");
		});
		tmp.addVouchBtnListener(e -> {
			navigation.navigateTo("voucher");
		});
		tmp.addDescBtnListener(e -> {
			navigation.navigateTo("description");
		});
		tmp.addConfigBtnListener(e -> {
			navigation.navigateTo("config");
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
