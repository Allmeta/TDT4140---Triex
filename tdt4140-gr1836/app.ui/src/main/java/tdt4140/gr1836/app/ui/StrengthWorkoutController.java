package tdt4140.gr1836.app.ui;

import java.io.IOException;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class StrengthWorkoutController {
	
	
	@FXML
	public Button SubmitStrengthWorkout;
	
	@FXML
	public Button CancelStrengthWorkout;
	
	
	public void SubmitStrengthWorkout() throws IOException {
		FxApp.showScene("MainMenu.fxml");
		
		
		//TODO: Function that sends the workout to data base.
	}
	
	
	//Sends you back to menu
	public void CancelStrengthWorkout() throws IOException {
		FxApp.showScene("MainMenu.fxml");
	}
	
}
		


