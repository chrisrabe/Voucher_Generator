package generator.control.page;

/**
 * Provides a skeleton implementation of a page controller.
 * 
 * @author Chris
 */
public abstract class PageController implements IPageController {
	
	private String navigationIcon;
	private String name;
	
	/**
	 * Stores the navigationIcon and name fields.
	 * 
	 * @param navigationIcon
	 * @param name
	 */
	public PageController(String navigationIcon, String name){
		this.navigationIcon = navigationIcon;
		this.name = name;
	}
	
	// IPageController Methods

	@Override
	public String getNavigationIconPath() {
		return navigationIcon;
	}

	@Override
	public String getPageName() {
		return name;
	}
	
	// Object Methods

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PageController other = (PageController) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}
	
}
