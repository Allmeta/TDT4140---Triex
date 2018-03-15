package tdt4140.gr1836.app.ui;

import java.io.IOException;

import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class CoachesController extends Controller{
	
	@FXML
	private Button homeBtn;
	
	
	@FXML
	private void goHome() throws IOException {
		showScene("MainMenu.fxml", this.getRoot(),this.app);
	}

}
