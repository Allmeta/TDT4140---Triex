package tdt4140.gr1836.app.ui;

import java.io.IOException;
import java.util.ArrayList;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import tdt4140.gr1836.app.ui.Controller;
import tdt4140.gr1836.app.users.UserTempList;
import tdt4140.gr1836.app.workouts.tempList;

public class AvailableCoachesController extends Controller{
	@FXML
	private Button homeBtn;
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
	public void initialize() {
		Platform.runLater(()->{
			setCoaches();
		});
	}

	private ArrayList<UserTempList> parseCoaches() {
		return this.app.getCoachesAsList();
	}

	private void setCoaches() {
		// fill stuff
		name.setCellValueFactory(new PropertyValueFactory<UserTempList, String>("name"));
		city.setCellValueFactory(new PropertyValueFactory<UserTempList, String>("city"));
		age.setCellValueFactory(new PropertyValueFactory<UserTempList, String>("age"));
		email.setCellValueFactory(new PropertyValueFactory<UserTempList, String>("email"));

		view.getItems().setAll(parseCoaches());
	}
	

	@FXML
	private void setYourCoach() {
		//Method which when you click on a coach this coach will be set to your user
	}
	
	@FXML
	private void goHome() throws IOException {
		showScene("MainMenu.fxml", this.getRoot(),this.app);
	}
	

}
