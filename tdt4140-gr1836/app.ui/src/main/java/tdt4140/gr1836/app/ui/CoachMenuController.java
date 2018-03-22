package tdt4140.gr1836.app.ui;

import java.io.IOException;

import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class CoachMenuController extends Controller{
	
	
	@FXML
	private Button clientsBtn;
	
	@FXML
	private void goClients() throws IOException {
		showScene("CoachClients.fxml", this.getRoot(),this.app);
	}

}
