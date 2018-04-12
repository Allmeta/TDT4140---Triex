package tdt4140.gr1836.app.ui;

import java.io.IOException;

import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class StatisticsController extends Controller {

	
	//Buttons
	@FXML
	private Button HomeBtn;
	
	//Function to return to home screen
	@FXML
	private void goHome() {
		try {
			showScene(LayoutHandler.mainUserPane, this.getRoot(), this.app);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
	
	
	
	
}
