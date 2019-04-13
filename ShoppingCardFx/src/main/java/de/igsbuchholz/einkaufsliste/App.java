package de.igsbuchholz.einkaufsliste;

import java.io.IOException;
import java.util.Stack;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class App extends Application {

	private Stage primaryStage;

	@Override
	public void start(Stage primaryStage) {
		this.primaryStage = primaryStage;
		this.primaryStage.setTitle("Hello World");

		initRootLayout();
	}

	private void initRootLayout() {

		try {

			// Load root layout from fxml file.
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(App.class.getResource("view/RootLayout.fxml"));
			AnchorPane rootLayout = (AnchorPane) loader.load();

			// Show the scene containing the root layout.
			Scene scene = new Scene(rootLayout);
			primaryStage.setScene(scene);
			primaryStage.show();

		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public static void main(String[] args) {
		launch(args);
	}
}
