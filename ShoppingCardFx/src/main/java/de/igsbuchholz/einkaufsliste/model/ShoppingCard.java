package de.igsbuchholz.einkaufsliste.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class ShoppingCard {

	private List<ShoppingCardItem> card = new ArrayList<>();
	private ObservableList<ShoppingCardItem> observableCard = FXCollections.observableList(card);

	public void addItem(String description) {
		ShoppingCardItem newItem = new ShoppingCardItem(description);
		observableCard.add(newItem);
	}

	public boolean containsItem(String description) {
		return observableCard.stream().map(i -> i.getDescription()).anyMatch(s -> s.equals(description));
	}

	public boolean removeItem(String description) {
		boolean removed = false;
		Optional<ShoppingCardItem> maybeFirst = observableCard.stream().filter(item -> description.equals(item.getDescription()))
				.findFirst();
		if (maybeFirst.isPresent()) {
			ShoppingCardItem item = maybeFirst.get();
			observableCard.remove(item);
			removed = true;
		}
		return removed;
	}
	
	public void clearCard() {
		observableCard.clear();
	}

	public ObservableList<ShoppingCardItem> getObservableCard() {
		return observableCard;
	}

}
