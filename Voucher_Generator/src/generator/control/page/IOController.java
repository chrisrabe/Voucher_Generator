package generator.control.page;

import java.util.HashMap;
import java.util.Map;

import javax.swing.JPanel;

import generator.control.ApplicationController;
import generator.control.display.IDisplayController;
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
		return tmp;
	}

	private Map<String, IDisplayController> createControllers() {
		Map<String, IDisplayController> tmp = new HashMap<String, IDisplayController>();
		tmp.put("save", createSaveController());
		tmp.put("load", createLoadController());
		return tmp;
	}

	// Display Controllers

	private IDisplayController createLoadController() {
		return new IDisplayController() {
			private Save saveDisplay;

			@Override
			public JPanel getDisplay() {
				if (saveDisplay == null) {
					saveDisplay = new Save();
					saveDisplay.addXmlBtnListener(e -> {
						// XML Save Event Handler
					});
					saveDisplay.addTxtBtnListener(e -> {
						// TXT Save Event Handler
					});
					saveDisplay.addPngBtnListener(e -> {
						// PNG Save Event Handler
					});
				}
				return saveDisplay;
			}
		};
	}

	private IDisplayController createSaveController() {
		return new IDisplayController() {
			private Load loadDisplay;

			@Override
			public JPanel getDisplay() {
				if (loadDisplay == null) {
					loadDisplay = new Load();
					loadDisplay.addXmlBtnListener(e -> {
						// XML Load Event Handler
					});
					loadDisplay.addTxtBtnListener(e -> {
						// TXT Load Event Handler
					});
				}
				return loadDisplay;
			}
		};
	}
}
