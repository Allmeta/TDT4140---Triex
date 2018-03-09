package tdt4140.gr1836.app.ui;

import java.io.IOException;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class CardioWorkoutController extends Controller {
	
	
	@FXML
	public Button SubmitCardioWorkout;
	
	@FXML
	public Button CancelCardioWorkout;
	
	@FXML
	private Button homeBtn;
	
	
	public void SubmitCardioWorkout() throws IOException {
		showScene("MainMenu.fxml", this.getStage());
		
		
		//TODO: Function that sends the workout to data base.
	}
	
	
	//Sends you back to menu
	public void CancelCardioWorkout() throws IOException {
		showScene("MainMenu.fxml", this.getStage());
	}
	
	@FXML
	private void goHome() throws IOException {
		showScene("MainMenu.fxml", this.getStage());
	}
	
}
		


