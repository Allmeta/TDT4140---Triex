package tdt4140.gr1836.app.ui;

import java.io.IOException;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class CardioWorkoutController {
	
	
	@FXML
	public Button SubmitCardioWorkout;
	
	@FXML
	public Button CancelCardioWorkout;
	
	
	public void SubmitCardioWorkout() throws IOException {
		FxApp.showScene("MainMenu.fxml");
		
		
		//TODO: Function that sends the workout to data base.
	}
	
	
	//Sends you back to menu
	public void CancelCardioWorkout() throws IOException {
		FxApp.showScene("MainMenu.fxml");
	}
	
}
		


