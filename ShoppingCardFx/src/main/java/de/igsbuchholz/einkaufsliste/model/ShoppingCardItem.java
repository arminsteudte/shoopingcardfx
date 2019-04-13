package de.igsbuchholz.einkaufsliste.model;

public class ShoppingCardItem {

	private boolean checked = false;
	private final String description;

	public ShoppingCardItem(String description) {
		this.description = description;
	}

	public boolean isChecked() {
		return checked;
	}

	public void check() {
		this.checked = true;
	}

	public void uncheck() {
		this.checked = false;
	}

	public void setChecked(boolean checked) {
		this.checked = checked;
	}

	public String getDescription() {
		return description;
	}

}
