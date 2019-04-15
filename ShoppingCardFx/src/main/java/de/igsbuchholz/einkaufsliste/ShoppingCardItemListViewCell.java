package de.igsbuchholz.einkaufsliste;

import java.io.IOException;

import de.igsbuchholz.einkaufsliste.model.ShoppingCardItem;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.layout.GridPane;

public class ShoppingCardItemListViewCell extends ListCell<ShoppingCardItem> {

	@FXML
	private CheckBox checkbox;
	@FXML
	private Label label;
	@FXML
	private GridPane gridPane;
	private FXMLLoader mLLoader;

	@Override
	protected void updateItem(ShoppingCardItem item, boolean empty) {
		super.updateItem(item, empty);

		// Why? -> See Javadoc Cell.class
		if (empty || item == null) {
			setText(null);
			setGraphic(null);
		} else {

			if (mLLoader == null) {
				mLLoader = new FXMLLoader(getClass().getResource("view/ShoppingCardItemListViewCell.fxml"));
				mLLoader.setController(this);

				try {
					mLLoader.load();
				} catch (IOException e) {
					e.printStackTrace();
				}

			}

			label.setText(item.getDescription());
			checkbox.setSelected(item.isChecked());
			checkbox.setOnMouseClicked(mouseEvent -> {
				if (item.isChecked()) {
					item.setChecked(false);

				} else {
					item.setChecked(true);
				}
				checkbox.setSelected(item.isChecked());
			});

			setText(null);
			setGraphic(gridPane);

		}

	}

}
