package ui;

import java.io.IOException;
import java.util.Optional;

import exceptions.CodeLengthException;
import exceptions.NegativeValueException;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import model.Client;
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
	private ComboBox<Character> cbShelfInd;

	@FXML
	private TextField txtNumVideogames;

	@FXML
	private TableView<?> tvShelves;

	@FXML
	private TableColumn<?, ?> colIndicator;

	@FXML
	private TableColumn<?, ?> colNumVideogames;

	@FXML
	private TableView<Client> tvS2;

	@FXML
	private TableColumn<Client, String> idCol;

	@FXML
	private TableColumn<Client, String> listgamesCol;

	@FXML
	private TableColumn<Client, Integer> timeCol;

	@FXML
	private TableView<Client> tvS3;

	@FXML
	private TableColumn<Client, String> basketCol;

	@FXML
	private TableView<Client> tvS4;

	@FXML
	private TableColumn<Client, String> bagCol;

	@FXML
	private TableColumn<Client, Double> totalpriceCol;

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
	private TableView<Videogame> tvGames;

	@FXML
	private TableColumn<Videogame, Integer> tcIdentifier;

	@FXML
	private TableColumn<Videogame, Integer> tcCode;

	@FXML
	private TableColumn<Videogame, Double> tcPrice;

	@FXML
	private TableColumn<Videogame, Integer> tcExamplarGames;


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


	private void initializeTableViewS2() {
		ObservableList<Client> observableList;
		observableList = FXCollections.observableArrayList(videogame.getClients());
		tvS2.setItems(observableList);
		idCol.setCellValueFactory(new PropertyValueFactory<Client, String>("Id"));
		listgamesCol.setCellValueFactory(new PropertyValueFactory<Client, String>("StringGameList"));
		timeCol.setCellValueFactory(new PropertyValueFactory<Client, Integer>("TimeUnit"));
	}

	@FXML
	public void nextScreenSection2(ActionEvent event) throws IOException {
		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/ui/section2.fxml"));
		fxmlLoader.setController(this);
		Parent menuPane = fxmlLoader.load();
		mainPane.getChildren().clear();
		mainPane.setCenter(menuPane);
		mainPane.setStyle("-fx-background-image: url(/ui/fondo2.jpg)");
		videogame.orderClientsListsOfGames();
		initializeTableViewS2();
	}

	private void initializeTableViewS3() {
		ObservableList<Client> observableList;
		observableList = FXCollections.observableArrayList(videogame.getClients());
		tvS2.setItems(observableList);
		idCol.setCellValueFactory(new PropertyValueFactory<Client, String>("Id"));
		listgamesCol.setCellValueFactory(new PropertyValueFactory<Client, String>("StringGameList"));
		timeCol.setCellValueFactory(new PropertyValueFactory<Client, Integer>("TimeUnit"));
		basketCol.setCellValueFactory(new PropertyValueFactory<Client, String>("BasketOrder"));
	}

	@FXML
	public void goToSection3(ActionEvent event) throws IOException {
		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/ui/section3.fxml"));
		fxmlLoader.setController(this);
		Parent menuPane = fxmlLoader.load();
		mainPane.getChildren().clear();
		mainPane.setCenter(menuPane);
		mainPane.setStyle("-fx-background-image: url(/ui/fondo2.jpg)");
		videogame.saveGamesInbaskets();
		initializeTableViewS3();
	}


	@FXML
	public void nextShelves(ActionEvent event) throws IOException {
		if(!txtNumCashiers.getText().equals("") && !txtNumShelves.getText().equals("")) {
			Optional<ButtonType> result = askToContinue();
			if (result.get() == ButtonType.OK){
				try {
					int nCashiers=Integer.parseInt(txtNumCashiers.getText());
					int nShelves=Integer.parseInt(txtNumShelves.getText());
					if(nShelves>26) {
						Alert alert1 = new Alert(AlertType.INFORMATION);
						alert1.setTitle("Error");
						alert1.setHeaderText(null);
						alert1.setContentText("El número de estanterías no puede ser mayor que 26");
						alert1.showAndWait();
					}else {
						videogame.initCashiersNShelves(nCashiers, nShelves);
						FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/ui/shelves.fxml"));
						fxmlLoader.setController(this);
						Parent menuPane = fxmlLoader.load();
						mainPane.getChildren().clear();
						mainPane.setCenter(menuPane);
						mainPane.setStyle("-fx-background-image: url(/ui/fondo2.jpg)");

						initializeComboBoxShelfInd();
					}

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

	private void initializeComboBoxShelfInd() {
		ObservableList<Character> options = 
				FXCollections.observableArrayList(videogame.returnShelvesInd());
		cbShelfInd.setItems(options);
	}


	private void initializeTableViewS4() {
		ObservableList<Client> observableList;
		observableList = FXCollections.observableArrayList(videogame.getClients());
		tvS2.setItems(observableList);
		idCol.setCellValueFactory(new PropertyValueFactory<Client, String>("Id"));
		bagCol.setCellValueFactory(new PropertyValueFactory<Client, String>("BagOrder"));
		totalpriceCol.setCellValueFactory(new PropertyValueFactory<Client, Double>("purchaseValue"));
	}


	@FXML
	public void addNumGameShelf(ActionEvent event) {
		if(cbShelfInd.getValue()!=null && !txtNumVideogames.getText().isEmpty()) {
			try {
				int nVGames=Integer.parseInt(txtNumVideogames.getText());
				videogame.setNumberGamesShelf(nVGames, cbShelfInd.getValue());

				Alert alert2 = new Alert(AlertType.INFORMATION);
				alert2.setTitle("Informacion");
				alert2.setHeaderText(null);
				alert2.setContentText("Se le ha dado un número de juegos a la estantería seleccionada");
				alert2.showAndWait();

				txtNumVideogames.clear();
				cbShelfInd.getItems().clear();
				initializeComboBoxShelfInd();

			}catch(NumberFormatException num){
				Alert alert1 = new Alert(AlertType.ERROR);
				alert1.setTitle("Error de validacion");
				alert1.setHeaderText(null);
				alert1.setContentText("Debe ingresar un numero dentro de los campos presentados que asi lo requieran");
				alert1.showAndWait();
			}
		}
	}

	@FXML
	public void nextAddGame(ActionEvent event) throws IOException {
		if(cbShelfInd.getItems().isEmpty()) {
			FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/ui/addGame.fxml"));
			fxmlLoader.setController(this);
			Parent menuPane = fxmlLoader.load();
			mainPane.getChildren().clear();
			mainPane.setCenter(menuPane);
			mainPane.setStyle("-fx-background-image: url(/ui/fondo2.jpg)");	

			initializeComboBoxShelfs();
		}else {
			Alert alert1 = new Alert(AlertType.ERROR);
			alert1.setTitle("Error");
			alert1.setHeaderText(null);
			alert1.setContentText("Debe darle un número de juegos a todas las estanterías");
			alert1.showAndWait();
		}
	}

	private void initializeComboBoxShelfs() {
		ObservableList<Character> options = 
				FXCollections.observableArrayList(videogame.returnShelfs());
		cbShelfs.setItems(options);
	}

	@FXML
	public void buttonAddGame(ActionEvent event) {
		if(!txtGameCode.getText().isEmpty() && !txtGamePrice.getText().isEmpty() && cbShelfs.getValue()!=null && !txtExemplarGames.getText().isEmpty()) {
			Alert alert1 = new Alert(AlertType.INFORMATION);
			alert1.setTitle("Error de validacion");
			alert1.setHeaderText(null);
			try {
				videogame.addGame(txtGameCode.getText(), txtGamePrice.getText(), cbShelfs.getValue(), txtExemplarGames.getText());
				initializeTableViewOfGames();
			}catch(NumberFormatException num) {
				alert1.setContentText("Debe ingresar un numero dentro de los campos presentados que asi lo requieran");
				alert1.showAndWait();
			}catch(NegativeValueException value) {
				alert1.setContentText(value.getMessage());
				alert1.showAndWait();
			}catch(CodeLengthException c) {
				alert1.setContentText(c.getMessage());
				alert1.showAndWait();
			}
		}else {
			showValidationErrorAlert();
		}
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
	public void nextScreenAddGameToClient(ActionEvent event) throws IOException {
		if(cbShelfs.getItems().isEmpty()) {
			FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/ui/addGameToClient.fxml"));
			fxmlLoader.setController(this);
			Parent menuPane = fxmlLoader.load();
			mainPane.getChildren().clear();
			mainPane.setCenter(menuPane);
			mainPane.setStyle("-fx-background-image: url(/ui/fondo2.jpg)");
		}else {
			Alert alert1 = new Alert(AlertType.ERROR);
			alert1.setTitle("Error");
			alert1.setHeaderText(null);
			alert1.setContentText("Debe terminar de agregar los juegos en las estanterías");
			alert1.showAndWait();
		}
	}


	@FXML
	public void goToSection4(ActionEvent event) throws IOException {
		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/ui/section4.fxml"));
		fxmlLoader.setController(this);
		Parent menuPane = fxmlLoader.load();
		mainPane.getChildren().clear();
		mainPane.setCenter(menuPane);
		mainPane.setStyle("-fx-background-image: url(/ui/fondo2.jpg)");
		videogame.saveGamesInbags();
		initializeTableViewS4();
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
