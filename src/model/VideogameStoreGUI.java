package model;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Optional;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;

public class VideogameStoreGUI {

	private VideogameStore videogame;

	@FXML
	private BorderPane mainPane;

	@FXML
	private TextField txtNumCashiers;

	@FXML
	private TextField txtNumShelves;


	@FXML
	private TextField txtIndicator;

	@FXML
	private TextField txtNumVideogames;

	@FXML
	private TableView<?> tvShelves;

	@FXML
	private TableColumn<?, ?> colIndicator;

	@FXML
	private TableColumn<?, ?> colNumVideogames;

	@FXML
	private TableView<?> tvS2;

	@FXML
	private TableColumn<?, ?> idCol;

	@FXML
	private TableColumn<?, ?> listgamesCol;

	@FXML
	private TableColumn<?, ?> timeCol;

	@FXML
	private TableView<?> tvS3;

	@FXML
	private TableColumn<?, ?> basketCol;

	@FXML
	private TableView<?> tvS4;

	@FXML
	private TableColumn<?, ?> bagCol;

	@FXML
	private TableColumn<?, ?> totalpriceCol;

	@FXML
	private BorderPane screenAddGameToClient;

	@FXML
	private TableView<Client> tvClientlList;

	@FXML
	private TableColumn<Client, String> tcIdClient;

	@FXML
	private TableColumn<Client, ArrayList> tcGamesList;

	@FXML
	private TableView<Videogame> tvGameslist;

	@FXML
	private TableColumn<Videogame, String> tcGames;

	@FXML
	private TextField txtIdClient;


	public VideogameStoreGUI(VideogameStore v) {
		videogame = v;
	}
        
        private void initializeClientsTableView() {
            ObservableList<Client> observableList;
            observableList = FXCollections.observableArrayList(videogame.getClients());
            tvClientlList.setItems(observableList);
            tcIdClient.setCellValueFactory(new PropertyValueFactory<Client, String>("id"));
            tcGamesList.setCellValueFactory(new PropertyValueFactory<Client, ArrayList>("booksCodes"));
        }
        
        private void initializeGamesCatalogueTableView() {
            ObservableList<Videogame> observableList;
            observableList = FXCollections.observableArrayList(videogame.getClients());
            tvGameslist.setItems(observableList);
            tcGames.setCellValueFactory(new PropertyValueFactory<Videogame, String>("gameName"));
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
	public void startSimulation(ActionEvent event) throws IOException {
		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/ui/numberCashiersNShelves.fxml"));
		fxmlLoader.setController(this);
		Parent menuPane = fxmlLoader.load();
		mainPane.getChildren().clear();
		mainPane.setCenter(menuPane);
		mainPane.setStyle("-fx-background-image: url(/ui/fondo2.jpg)");
	}

	@FXML
	public void nextScreenAddGameToClient(ActionEvent event) throws IOException {
		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/ui/addGameToClient.fxml"));
		fxmlLoader.setController(this);
		Parent menuPane = fxmlLoader.load();
		mainPane.getChildren().clear();
		mainPane.setCenter(menuPane);
		mainPane.setStyle("-fx-background-image: url(/ui/fondo2.jpg)");
	}

	@FXML
	public void nextScreenSection2(ActionEvent event) throws IOException {
		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/ui/section2.fxml"));
		fxmlLoader.setController(this);
		Parent menuPane = fxmlLoader.load();
		mainPane.getChildren().clear();
		mainPane.setCenter(menuPane);
		mainPane.setStyle("-fx-background-image: url(/ui/fondo2.jpg)");
	}

	@FXML
	public void goToSection3(ActionEvent event) throws IOException {
		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/ui/section3.fxml"));
		fxmlLoader.setController(this);
		Parent menuPane = fxmlLoader.load();
		mainPane.getChildren().clear();
		mainPane.setCenter(menuPane);
		mainPane.setStyle("-fx-background-image: url(/ui/fondo2.jpg)");
	}


	@FXML
	public void nextShelves(ActionEvent event) throws IOException {
		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/ui/shelves.fxml"));
		fxmlLoader.setController(this);
		Parent menuPane = fxmlLoader.load();
		mainPane.getChildren().clear();
		mainPane.setCenter(menuPane);
		mainPane.setStyle("-fx-background-image: url(/ui/fondo2.jpg)");
	}


	@FXML
	public void goToSection4(ActionEvent event) throws IOException {
		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/ui/section4.fxml"));
		fxmlLoader.setController(this);
		Parent menuPane = fxmlLoader.load();
		mainPane.getChildren().clear();
		mainPane.setCenter(menuPane);
		mainPane.setStyle("-fx-background-image: url(/ui/fondo2.jpg)");

	}



	@FXML
	public void addNumGameShelf(ActionEvent event) {

	}

	@FXML
	public void nextAddGame(ActionEvent event) throws IOException {
		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/ui/addGame.fxml"));
		fxmlLoader.setController(this);
		Parent menuPane = fxmlLoader.load();
		mainPane.getChildren().clear();
		mainPane.setCenter(menuPane);
		mainPane.setStyle("-fx-background-image: url(/ui/fondo2.jpg)");

	}

	@FXML
	public void goToEndingScreen(ActionEvent event) throws IOException {
		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/ui/ending.fxml"));

		fxmlLoader.setController(this);
		Parent menuPane = fxmlLoader.load();
		mainPane.getChildren().clear();
		mainPane.setCenter(menuPane);
		mainPane.setStyle("-fx-background-image: url(/ui/fondo2.jpg)");

	}
	@FXML
	public void buttonAddGame(ActionEvent event) {

	}




	@FXML
	public void addGametoclient(ActionEvent event) {
            
	}

	@FXML
	public void buttonAddclient(ActionEvent event) {
            if(!txtIdClient.getText().equals("")){
                Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                alert.setTitle("Confirmacion de registro");
                alert.setHeaderText("Mensaje de confirmacion");
                alert.setContentText("¿Estas seguro de confirmar esta informacion?");
                Optional<ButtonType> result = alert.showAndWait();

                if (result.get() == ButtonType.OK){
                    txtIdClient.setText("");
                }
            }
            else {
                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setTitle("Error de registro");
                alert.setHeaderText("Mensaje de advertencia");
                alert.setContentText("¡Por favor llene todos los campos que se le solicitan!");
                alert.showAndWait();
            }
	}
}