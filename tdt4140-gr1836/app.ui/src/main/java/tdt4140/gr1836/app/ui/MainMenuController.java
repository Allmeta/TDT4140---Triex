package tdt4140.gr1836.app.ui;

import java.io.IOException;

import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class MainMenuController extends Controller {
	
	@FXML
	private Button goNew;
	@FXML
	private Button goPast;
	
	@FXML
	private void goNewWorkout() throws IOException {
		showScene("newWorkout.fxml", this.getStage(),this.app);
	}
	
	
	@FXML
	private void goPastWorkout() throws IOException {
		showScene("pastWorkout.fxml",this.getStage(),this.app);
	}

}
