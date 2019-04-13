package de.igsbuchholz.einkaufsliste.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ShoppingCard {

	private List<ShoppingCardItem> card = new ArrayList<>();
	
	public void addItem(String description) {
		ShoppingCardItem newItem = new ShoppingCardItem(description);
		card.add(newItem);
	}
	
	public boolean containsItem(String description) {
		return card.stream().map(i -> i.getDescription()).anyMatch(s -> s.equals(description));
	}
	
	public boolean removeItem(String description) {
		boolean removed = false;
		Optional<ShoppingCardItem> maybeFirst = card.stream().filter(item -> description.equals(item.getDescription())).findFirst();
		if(maybeFirst.isPresent()) {
			ShoppingCardItem item = maybeFirst.get();
			card.remove(item);
			removed = true;
		}
		return removed; 
	}
	
}
