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
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.RadioButton;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
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
	private TextField txtIndicator;

	@FXML
	private ComboBox<Character> cbShelfInd;

	@FXML
	private TextField txtNumVideogames;

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
	private TableView<Client> tvClientList;

	@FXML
	private TableColumn<Client, String> tcIdClient;

	@FXML
	private TableColumn<Client, String> tcGamesList;

	@FXML
	private TableView<Videogame> tvGameslist;

	@FXML
	private TableColumn<Videogame, Integer> tcGames;

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

	@FXML
	private Button btAddGameToClient;

	@FXML
	private RadioButton rbInsertion;

	@FXML
	private ToggleGroup sortsAlgorithm;

	@FXML
	private RadioButton rbSelection;
        
        @FXML
        private ComboBox<Client> comboxClients;

	public VideogameStoreGUI(VideogameStore v) {
		videogame = v;
	}

	private void initializeClientsTableView() {
		ObservableList<Client> observableList;
		observableList = FXCollections.observableArrayList(videogame.getClients());
		tvClientList.setItems(observableList);
		tcIdClient.setCellValueFactory(new PropertyValueFactory<Client, String>("Id"));
		tcGamesList.setCellValueFactory(new PropertyValueFactory<Client, String>("StringGameList"));
	}

	private void initializeGamesCatalogueTableView() {
		ObservableList<Videogame> observableList;
		observableList = FXCollections.observableArrayList(videogame.returnGames());
		tvGameslist.setItems(observableList);
		tcGames.setCellValueFactory(new PropertyValueFactory<Videogame, Integer>("Code"));
		tvGameslist.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
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
		tvS3.setItems(observableList);
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
		videogame.saveGamesInbasket();
                videogame.createCashiersQueue();
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
						alert1.setContentText("El numero de estanterias no puede ser mayor que 26");
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
		ObservableList<Character> options =FXCollections.observableArrayList(videogame.returnShelvesInd());
		cbShelfInd.setItems(options);
	}


	private void initializeTableViewS4() {
		ObservableList<Client> observableList;
		observableList = FXCollections.observableArrayList(videogame.passByCashiers());
		tvS4.setItems(observableList);
		idCol.setCellValueFactory(new PropertyValueFactory<Client, String>("Id"));
		basketCol.setCellValueFactory(new PropertyValueFactory<Client, String>("BasketOrder"));
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
				alert2.setContentText("Se le ha dado un numero de juegos a la estanteria seleccionada");
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
			alert1.setContentText("Debe darle un numero de juegos a todas las estanterias");
			alert1.showAndWait();
		}
	}

	private void initializeComboBoxShelfs() {
		ObservableList<Character> options = FXCollections.observableArrayList(videogame.returnShelfs());
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

				txtGameCode.clear();
				txtGamePrice.clear();
				txtExemplarGames.clear();
				cbShelfs.getItems().clear();
				initializeComboBoxShelfs();
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
                        
                        initializeGamesCatalogueTableView();
                        initializeClientsTableView();
		}else {
			Alert alert1 = new Alert(AlertType.ERROR);
			alert1.setTitle("Error");
			alert1.setHeaderText(null);
			alert1.setContentText("Debe terminar de agregar los juegos en las estanterias");
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
		videogame.saveGamesInbag();
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

	   public String getRadioButtonSortsAlgorithm() {
           String sort = "";
           if(rbInsertion.isSelected()) {
               sort = "INSERTION";
           } 
           else if (rbSelection.isSelected()) {
               sort = "SELECTION";
           } else {
               sort = "no";
           }
           return sort;
       }

       @FXML
        public void clickOnTableViewOfAddGameToClient(MouseEvent event) {
            Videogame selectGameInCatalogue=tvGameslist.getSelectionModel().getSelectedItem();
            String clientID = comboxClients.getValue().toString();
            Client client=videogame.findClientID(clientID);
            if(selectGameInCatalogue!=null && client!=null){
                btAddGameToClient.setDisable(false);
            }
        }

	@FXML
	public void addGametoclient(ActionEvent event) {
            Videogame selectGameInCatalogue=tvGameslist.getSelectionModel().getSelectedItem();
            Client clientID = comboxClients.getValue();
            if(clientID!=null){
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Informacion");
                alert.setHeaderText(null);
                alert.setContentText(videogame.addGameToClient(selectGameInCatalogue,clientID));
                alert.showAndWait();
                btAddGameToClient.setDisable(true);
                tvClientList.getItems().clear();
                initializeClientsTableView();
            }
            else{
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Informacion");
                alert.setHeaderText(null);
                alert.setContentText("Por favor escoger un cliente");
                alert.showAndWait();
            }
	}
	
	@FXML
	public void buttonAddclient(ActionEvent event) {
		 String strSort = getRadioButtonSortsAlgorithm();
                 String message="";
         if(!txtIdClient.getText().equals("") && strSort!="no"){
             Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
             alert.setTitle("Confirmacion de registro");
             alert.setHeaderText("Mensaje de confirmacion");
             alert.setContentText("Estas seguro de confirmar esta informacion?");
             Optional<ButtonType> result = alert.showAndWait();

             if (result.get() == ButtonType.OK){
                 message=videogame.addClient(txtIdClient.getText(), strSort);
                 txtIdClient.setText("");
                 alert.setContentText(message);
                 alert.showAndWait();
                 initializeClientsTableView();
                 ObservableList<Client> observableComboBoxClients= FXCollections.observableArrayList(videogame.getClients());
                 comboxClients.setItems(observableComboBoxClients);
             }
         }
         else {
             Alert alert = new Alert(Alert.AlertType.WARNING);
             alert.setTitle("Error de registro");
             alert.setHeaderText("Mensaje de advertencia");
             alert.setContentText("Por favor llene todos los campos que se le solicitan!");
             alert.showAndWait();
         }
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
		alert.setContentText("Esta seguro que desea continuar? Recuerde que no podra realizar ningun cambio despues.");
		Optional<ButtonType> result = alert.showAndWait();
		return result;
	}

}