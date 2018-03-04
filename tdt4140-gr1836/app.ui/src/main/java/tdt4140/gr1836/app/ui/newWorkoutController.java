package tdt4140.gr1836.app.ui;

import java.io.IOException;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import tdt4140.gr1836.app.ui.FxApp;

public class newWorkoutController extends Controller {
	@FXML
	private Button strengthBtn;
	@FXML
	private Button cardioBtn;
	

	@FXML
	private void goStrengthWorkout() throws IOException {
		this.fxAppParent.showScene("strengthWorkout.fxml");
	}
	
	@FXML
	private void goCardioWorkout() throws IOException {
		this.fxAppParent.showScene("cardioWorkout.fxml");
	}
	

}
