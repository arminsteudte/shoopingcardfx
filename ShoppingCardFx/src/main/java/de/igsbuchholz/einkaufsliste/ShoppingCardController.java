package de.igsbuchholz.einkaufsliste;

import java.util.ArrayList;

import de.igsbuchholz.einkaufsliste.model.ShoppingCard;
import de.igsbuchholz.einkaufsliste.model.ShoppingCardItem;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

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
		lvShoppingCard.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
		lvShoppingCard.setCellFactory(shoppingCardListView -> new ShoppingCardItemListViewCell());
		ObservableList<ShoppingCardItem> observableCard = card.getObservableCard();
		lvShoppingCard.setItems(observableCard);
	}

	@FXML
	public void onTextFieldEnterPressed(KeyEvent e) {
		if (KeyCode.ENTER == e.getCode()) {
			addItemToCard();
		}
	}

	@FXML
	public void addItemToCard() {

		String description = tfItem.getText();
		card.addItem(description);
		tfItem.clear();

	}

	@FXML
	public void clearShoppingCard() {
		card.clearCard();
	}

	@FXML
	public void removeItem() {
		ObservableList<ShoppingCardItem> selectedItems = lvShoppingCard.getSelectionModel().getSelectedItems();

		ArrayList<ShoppingCardItem> items = new ArrayList<>(selectedItems);

		for (ShoppingCardItem item : items) {
			card.removeItem(item.getDescription());
		}

	}

}
