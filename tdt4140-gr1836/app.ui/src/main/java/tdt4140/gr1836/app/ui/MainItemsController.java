package tdt4140.gr1836.app.ui;

import java.io.IOException;

import javafx.fxml.FXML;

public class MainItemsController {
	
	@FXML
	private void goNewWorkout() throws IOException {
		FxApp.showNewWorkoutScene();
	}
	
	
	@FXML
	private void goPastWorkout() throws IOException {
		FxApp.showPastWorkoutScene();
	}

}
