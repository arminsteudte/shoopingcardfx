package de.igsbuchholz.einkaufsliste;

import de.igsbuchholz.einkaufsliste.model.ShoppingCard;
import de.igsbuchholz.einkaufsliste.model.ShoppingCardItem;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

public class ShoppingCardController {

	private ShoppingCard card;

	@FXML
	private Button addItem;
	@FXML
	private Button removeItem;
	@FXML
	private TextField tfItem;
	@FXML
	private ListView<ShoppingCardItem> lvShoppingCard;

	public ShoppingCardController() {

		this.card = new ShoppingCard();

	}

	public ShoppingCardController(ShoppingCard card) {
		this.card = card;
	}

	@FXML
	public void initialize() {
		lvShoppingCard.setCellFactory(shoppingCardListView -> new ShoppingCardItemListViewCell());
		ObservableList<ShoppingCardItem> observableCard = card.getObservableCard();
		lvShoppingCard.setItems(observableCard);
	}
	
	
	public void addItemToCard() {
	
		String description = tfItem.getText();
		card.addItem(description);
		
	}
	
	public void clearShoppingCard() {
		
	}
	
	public void removeItem() {
		
	}

}
