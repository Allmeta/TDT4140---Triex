package tdt4140.gr1836.app.ui;

import java.io.IOException;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class MainMenuController extends Controller {
	
	@FXML private Button goNew;
	@FXML private Button goPast;
	@FXML private Button avaiCoaches;
	@FXML private Label welcomeLabel;
	
	public void initialize() {
		Platform.runLater(()->{			
		welcomeLabel.setText("Welcome " + app.getUser().name);
		});
	}
	
	@FXML
	private void goNewWorkout() throws IOException {
		showScene("newWorkout.fxml", this.getRoot(),this.app);
	}
	
	@FXML
	private void goPastWorkout() throws IOException {
		showScene("pastWorkout.fxml",this.getRoot(),this.app);
	}
	
	@FXML
	private void goCoaches() throws IOException {
		showScene("Coaches.fxml",this.getRoot(),this.app);
	}

}
