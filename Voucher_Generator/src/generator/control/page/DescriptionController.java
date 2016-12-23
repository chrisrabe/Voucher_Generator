package generator.control.page;

import generator.control.manager.description.DescriptionManager;
import generator.helper.converter.ValueConverter;
import generator.view.page.PageView;
import generator.view.page.description.Description;

/**
 * This class implements the action listeners for the description view.
 * 
 * @author Chris
 */
public class DescriptionController extends PageController {

	private Description descriptionView;
	private DescriptionManager descriptionManager;

	public DescriptionController(DescriptionManager descriptionManager) {
		this.descriptionManager = descriptionManager;
	}

	// Methods

	@Override
	public void update() {
		String[] data = ValueConverter.convertDescriptionsToArray(descriptionManager.getDescriptions());
		if (descriptionView != null)
			descriptionView.setContent(data);
	}

	@Override
	protected PageView createView() {
		if (descriptionView == null)
			descriptionView = createDescriptionView();

		return descriptionView;
	}

	private Description createDescriptionView() {
		Description tmp = new Description();
		// Add navigation listeners
		tmp.addHomeBtnListener(e -> {
			navigation.navigateTo("home");
		});
		tmp.addVoucherBtnListener(e -> {
			navigation.navigateTo("voucher");
		});
		tmp.addIoBtnListener(e -> {
			navigation.navigateTo("io");
		});
		tmp.addConfigBtnListener(e -> {
			navigation.navigateTo("config");
		});
		// Add function listeners
		tmp.addClrBtnListener(e -> {
			descriptionManager.clear();
		});
		return tmp;
	}

}
