package tdt4140.gr1836.app.ui;

import java.io.IOException;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import tdt4140.gr1836.app.core.App;

public class MainMenuController extends Controller {
	
	@FXML
	private Button goNew;
	@FXML
	private Button goPast;
	
	@FXML
	private void goNewWorkout() throws IOException {
		showScene("newWorkout.fxml", this.getStage());
	}
	
	
	@FXML
	private void goPastWorkout() throws IOException {
		showScene("pastWorkout.fxml",this.getStage());
	}

}
