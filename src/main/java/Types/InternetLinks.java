package types;

public enum InternetLinks {

	ADDELEMENT("/add_remove_elements/", "Add/Remove Elements"),
	BASICAUTH("/basic_auth", "Basic Authentication"),
	CHECKBOX("/checkboxes", "Checkboxes"), 
	DROPDOWN("/dropdown", "Dropdown"),
	CONTEXTMENU("/context_menu", "Context Menu");
	
	private String link;
	private String name;

	private InternetLinks(String link, String name) {
		this.link = link;
		this.name = name;
	}

	public String getLink() {
		return this.link;
	}

	public String getName() {
		return this.name;
	}
}
