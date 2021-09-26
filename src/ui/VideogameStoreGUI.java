package ui;

import java.io.IOException;
import java.util.Optional;

import exceptions.NegativeValueException;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import model.Videogame;
import model.VideogameStore;

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
	private TableView<?> tvClientlList;

	@FXML
	private TableColumn<?, ?> tcIdClient;

	@FXML
	private TableColumn<?, ?> tcGamesList;

	@FXML
	private TableView<?> tvGameslist;

	@FXML
	private TableColumn<?, ?> tcGames;

	@FXML
	private TextField txtIdClient;

	@FXML
	private BorderPane screenAddGame;

	@FXML
	private TextField txtGameCode;
	
    @FXML
    private TextField txtShelfGame;

	@FXML
	private TextField txtGamePrice;
	
	@FXML
    private ComboBox<Character> cbShelfs;

	@FXML
	private TextField txtExemplarGames;

	@FXML
	private TableView<?> tvGames;

	@FXML
	private TableColumn<?, ?> tcIdentifier;

	@FXML
	private TableColumn<?, ?> tcCode;

	@FXML
	private TableColumn<?, ?> tcPrice;

	@FXML
	private TableColumn<?, ?> tcExamplarGames;


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
	
	private void initializeTableViewS2() {
		ObservableList<Videogame> observableList;
		observableList = FXCollections.observableArrayList(videogame.returnGames());
		tvS2.setItems(observableList);
		idCol.setCellValueFactory(new PropertyValueFactory<Client, String>("Id"));
		listgamesCol.setCellValueFactory(new PropertyValueFactory<Client, String>("ListOfGames"));
		timeCol.setCellValueFactory(new PropertyValueFactory<Client, Integer>("time"));
	}

	@FXML
	public void nextScreenSection2(ActionEvent event) throws IOException {
		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/ui/section2.fxml"));
		fxmlLoader.setController(this);
		Parent menuPane = fxmlLoader.load();
		mainPane.getChildren().clear();
		mainPane.setCenter(menuPane);
		mainPane.setStyle("-fx-background-image: url(/ui/fondo2.jpg)");
		initializeTableViewS2();
	}

	private void initializeTableViewS3() {
		ObservableList<Videogame> observableList;
		observableList = FXCollections.observableArrayList(videogame.returnGames());
		tvS2.setItems(observableList);
		idCol.setCellValueFactory(new PropertyValueFactory<Client, String>("Id"));
		listgamesCol.setCellValueFactory(new PropertyValueFactory<Client, String>("ListOfGames"));
		timeCol.setCellValueFactory(new PropertyValueFactory<Client, Integer>("time"));
		basketCol.setCellValueFactory(new PropertyValueFactory<Client, String>("ListOfGames"));
	}
	
	@FXML
	public void goToSection3(ActionEvent event) throws IOException {
		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/ui/section3.fxml"));
		fxmlLoader.setController(this);
		Parent menuPane = fxmlLoader.load();
		mainPane.getChildren().clear();
		mainPane.setCenter(menuPane);
		mainPane.setStyle("-fx-background-image: url(/ui/fondo2.jpg)");
		initializeTableViewS3();
	}


	@FXML
	public void nextShelves(ActionEvent event) throws IOException {
		if(!txtNumCashiers.getText().equals("") && !txtNumShelves.getText().equals("")) {
			Optional<ButtonType> result = askToContinue();
			if (result.get() == ButtonType.OK){
				try {
					FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/ui/shelves.fxml"));
					fxmlLoader.setController(this);
					Parent menuPane = fxmlLoader.load();
					mainPane.getChildren().clear();
					mainPane.setCenter(menuPane);
					mainPane.setStyle("-fx-background-image: url(/ui/fondo2.jpg)");
					initializeTableViewOfGames();
				}catch(NumberFormatException num) {
					Alert alert1 = new Alert(AlertType.INFORMATION);
					alert1.setTitle("Error de validacion");
					alert1.setHeaderText(null);
					alert1.setContentText("Debe ingresar un numero dentro de los campos presentados que asi lo requieran");
					alert1.showAndWait();
				}
			}
		}else {
			showValidationErrorAlert();
		}
	}

	private void initializeTableViewS4() {
		ObservableList<Videogame> observableList;
		observableList = FXCollections.observableArrayList(videogame.returnGames());
		tvS2.setItems(observableList);
		idCol.setCellValueFactory(new PropertyValueFactory<Client, String>("Id"));
		bagCol.setCellValueFactory(new PropertyValueFactory<Client, String>("ListOfGames"));
		totalpriceCol.setCellValueFactory(new PropertyValueFactory<Client, Double>("purchaseValue"));
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
	
	private void initializeTableViewOfGames() {
		ObservableList<Videogame> observableList;
		observableList = FXCollections.observableArrayList(videogame.returnGames());
		tvGames.setItems(observableList);
		tcIdentifier.setCellValueFactory(new PropertyValueFactory<Videogame, Integer>("Shelf"));
		tcCode.setCellValueFactory(new PropertyValueFactory<Videogame, Integer>("Code"));
		tcPrice.setCellValueFactory(new PropertyValueFactory<Videogame, Double>("Price"));
		tcExamplarGames.setCellValueFactory(new PropertyValueFactory<Videogame, Integer>("Amount"));
	}
	
	@FXML
	public void buttonAddGame(ActionEvent event) {
		if(!txtGameCode.getText().equals("") && !txtGamePrice.getText().equals("") && !txtShelfGame.getText().equals("") && !txtExemplarGames.getText().equals("")) {
			Alert alert1 = new Alert(AlertType.INFORMATION);
			alert1.setTitle("Error de validacion");
			alert1.setHeaderText(null);
			try {
				videogame.addGame(txtGameCode.getText(), txtGamePrice.getText(), txtShelfGame.getText().toUpperCase().charAt(0), txtExemplarGames.getText());
			}catch(NumberFormatException num) {
				alert1.setContentText("Debe ingresar un numero dentro de los campos presentados que asi lo requieran");
				alert1.showAndWait();
			}catch(NegativeValueException value) {
				alert1.setContentText(value.getMessage());
				alert1.showAndWait();
			}
		}else {
			showValidationErrorAlert();
		}
		initializeTableViewOfGames();
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
	public void addGametoclient(ActionEvent event) {

	}

	@FXML
	public void buttonAddclient(ActionEvent event) {

	}

	public void showValidationErrorAlert() {
		Alert alert = new Alert(AlertType.ERROR);
		alert.setTitle("Error de validacion");
		alert.setHeaderText(null);
		alert.setContentText("Recuerde diligenciar cada uno de los campos");
		alert.showAndWait();
	}
	
	public Optional<ButtonType> askToContinue() {
		Alert alert = new Alert(AlertType.CONFIRMATION);
		alert.setContentText("¿Esta seguro que desea continuar? Recuerde que no podra realizar ningun cambio despues.");
		Optional<ButtonType> result = alert.showAndWait();
		return result;
	}

}
