package tdt4140.gr1836.app.ui;

import java.io.IOException;

import javafx.fxml.FXML;
import tdt4140.gr1836.app.ui.FxApp;

public class newWorkoutController {

	@FXML
	private void goStrengthWorkout() throws IOException {
		FxApp.showScene("StrengthWorkout.fxml");
	}
	
	@FXML
	private void goCardioWorkout() throws IOException {
		FxApp.showScene("cardioWorkout.fxml");
	}
	

}
