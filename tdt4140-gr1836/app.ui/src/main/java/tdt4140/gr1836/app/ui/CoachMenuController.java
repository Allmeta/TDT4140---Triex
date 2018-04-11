package tdt4140.gr1836.app.ui;

import java.io.IOException;
import java.util.ArrayList;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import tdt4140.gr1836.app.users.UserTempList;

public class CoachMenuController extends Controller{
	@FXML
	private TableView<UserTempList> view;
	@FXML
	private TableColumn<UserTempList, String> name;
	@FXML
	private TableColumn<UserTempList, String> city;
	@FXML
	private TableColumn<UserTempList, String> age;
	@FXML
	private TableColumn<UserTempList, String> email;

	
	@FXML
	private Button clientsBtn;
	
	@FXML
	private void goClients() throws IOException {
		showScene("CoachClients.fxml", this.getRoot(),this.app);
	}
	@FXML
	public void initialize() {
		Platform.runLater(()->{
			setClients();
		});
	}

	private ArrayList<UserTempList> parseClients() {
		//if (user has this coach){
			
		return this.app.getUsersAsList();
		}
	//}
	private void setClients() {
		// fill stuff
		name.setCellValueFactory(new PropertyValueFactory<UserTempList, String>("name"));
		city.setCellValueFactory(new PropertyValueFactory<UserTempList, String>("city"));
		age.setCellValueFactory(new PropertyValueFactory<UserTempList, String>("age"));
		email.setCellValueFactory(new PropertyValueFactory<UserTempList, String>("email"));

		view.getItems().setAll(parseClients());
	}
	@FXML
	private void goHome() throws IOException {
		showScene("MainMenu.fxml", this.getRoot(),this.app);
	}
	
}
