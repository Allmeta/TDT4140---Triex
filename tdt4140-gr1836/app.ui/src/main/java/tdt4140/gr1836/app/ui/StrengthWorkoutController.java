package tdt4140.gr1836.app.ui;

import java.io.IOException;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class StrengthWorkoutController extends Controller {
	
	
	
	@FXML
	public Button SubmitStrengthWorkout;
	
	@FXML
	public Button CancelStrengthWorkout;
	
	@FXML
	private Button homeBtn;
	
	
	public void SubmitStrengthWorkout() throws IOException {
		showScene("MainMenu.fxml", this.getStage(),this.app);
		
		
		//TODO: Function that sends the workout to data base.
	}
	
	
	//Sends you back to menu
	public void CancelStrengthWorkout() throws IOException {
		showScene("MainMenu.fxml", this.getStage(),this.app);
	}
	
	@FXML
	private void goHome() throws IOException {
		showScene("MainMenu.fxml", this.getStage(),this.app);
	}
	
}
		


