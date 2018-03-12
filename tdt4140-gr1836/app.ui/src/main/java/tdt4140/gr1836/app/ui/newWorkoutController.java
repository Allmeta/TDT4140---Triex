package tdt4140.gr1836.app.ui;

import java.io.IOException;

import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class newWorkoutController extends Controller {
	
	@FXML
	private Button strengthBtn;
	
	@FXML
	private Button cardioBtn;
	
	@FXML
	private Button homeBtn;
	

	@FXML
	private void goStrengthWorkout() throws IOException {
		showScene("strengthWorkout.fxml", this.getRoot(),this.app);
	}
	
	@FXML
	private void goCardioWorkout() throws IOException {
		showScene("cardioWorkout.fxml", this.getRoot(),this.app);
	}
	
	@FXML
	private void goHome() throws IOException {
		showScene("MainMenu.fxml", this.getRoot(),this.app);
	}
	

}
