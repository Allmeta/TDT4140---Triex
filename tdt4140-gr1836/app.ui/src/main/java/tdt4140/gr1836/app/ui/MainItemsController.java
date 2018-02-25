package tdt4140.gr1836.app.ui;

import java.io.IOException;

import javafx.fxml.FXML;

public class MainItemsController {
	
	private FxApp main;
	
	
	@FXML
	private void goNewWorkout() throws IOException {
		main.showNewWorkoutScene();
	}
	
	
	@FXML
	private void goPastWorkout() throws IOException {
		main.showPastWorkoutScene();
	}

}
