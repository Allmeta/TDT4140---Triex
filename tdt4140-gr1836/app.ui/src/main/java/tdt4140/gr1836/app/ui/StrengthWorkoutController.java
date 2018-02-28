package tdt4140.gr1836.app.ui;

import java.awt.TextField;
import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class StrengthWorkoutController {
	
	@FXML
	public Button SubmitStrengthWorkout;
	
	@FXML
	public Button CancelStrengthWorkout;
	
	@FXML
	public TextField duration;
	
	@FXML
	public TextField goal;
	
	@FXML
	public TextField other;
	
	@FXML
	public TextField type;
	
	@FXML
	public TextField bodypart;

	
	
	public void SubmitStrengthWorkout() throws IOException {
		FxApp.showMainItems();
	}
	
	public void CancelStrengthWorkout() throws IOException {
		FxApp.showMainItems();
	}
	

	}
		


