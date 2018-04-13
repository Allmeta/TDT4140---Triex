package tdt4140.gr1836.app.ui;

import java.io.IOException;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import tdt4140.gr1836.app.users.UserTempList;
import javafx.scene.control.Label;

public class CoachMenuController extends Controller {

	@FXML
	private Label logoutButton;

	
	@FXML
	private Button clientsBtn;
	
	private void initialize() {
		// load username in logout button
		Platform.runLater(() -> {
			// SlogoutButton.setText("Log out (" + app.getUser().getUsername() + ")");
		});
	}

	@FXML
	private void onInbox() {
		try {
			showScene(LayoutHandler.inboxPane, this.getRoot(), this.app);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	/*@FXML
	public void initialize() {
		Platform.runLater(()->{
			setClients();
		});
	}/*

	/*private ArrayList<UserTempList> parseClients() {
		//if (user has this coach){
			
		return this.app.getUsersAsList();
		}*/
	//}
	/*private void setClients() {
		// fill stuff
		name.setCellValueFactory(new PropertyValueFactory<UserTempList, String>("name"));
		city.setCellValueFactory(new PropertyValueFactory<UserTempList, String>("city"));
		age.setCellValueFactory(new PropertyValueFactory<UserTempList, String>("age"));
		email.setCellValueFactory(new PropertyValueFactory<UserTempList, String>("email"));

		view.getItems().setAll(parseClients());
	}*/
	@FXML
	private void onLogOut() {
		try {
			showScene(LayoutHandler.loginPane, this.getRoot(), this.app);

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
