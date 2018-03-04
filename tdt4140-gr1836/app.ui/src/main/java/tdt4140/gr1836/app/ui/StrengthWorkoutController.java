package tdt4140.gr1836.app.ui;

import java.io.IOException;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class StrengthWorkoutController extends Controller {
	
	
	
	@FXML
	public Button SubmitStrengthWorkout;
	
	@FXML
	public Button CancelStrengthWorkout;
	
	
	public void SubmitStrengthWorkout() throws IOException {
		this.fxAppParent.showScene("MainMenu.fxml");
		
		
		//TODO: Function that sends the workout to data base.
	}
	
	
	//Sends you back to menu
	public void CancelStrengthWorkout() throws IOException {
		this.fxAppParent.showScene("MainMenu.fxml");
	}
	
}
		


