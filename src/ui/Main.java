package ui;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import model.VideogameStore;
import model.VideogameStoreGUI;

public class Main extends Application{

	private VideogameStore videogame;
	private VideogameStoreGUI videogameGUI;
	
	public Main() {
		videogame= new VideogameStore();
		videogameGUI= new VideogameStoreGUI(videogame);	
	}
	
	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("mainPane.fxml"));
		
		fxmlLoader.setController(videogameGUI);
		Parent root= fxmlLoader.load();
		
		Scene scene= new Scene(root);
		
		primaryStage.setScene(scene);
		primaryStage.setTitle("Tienda de videojuegos");
		primaryStage.show();
		videogameGUI.showWelcomeWindow();
	}

}
