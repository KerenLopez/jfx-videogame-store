package model;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.layout.BorderPane;

public class VideogameStoreGUI {

	private VideogameStore videogame;

	@FXML
	private BorderPane mainPane;

	public VideogameStoreGUI(VideogameStore v) {
		videogame = v;
	}

	public void showWelcomeWindow() throws IOException {
		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/ui/welcome.fxml"));
		fxmlLoader.setController(this);
		Parent menuPane = fxmlLoader.load();
		mainPane.getChildren().clear();
		mainPane.setCenter(menuPane);
		mainPane.setStyle("-fx-background-image: url(/ui/fondo1.jpg)");
	}

	@FXML
	public void nextScreen(ActionEvent event) {

	}

}
