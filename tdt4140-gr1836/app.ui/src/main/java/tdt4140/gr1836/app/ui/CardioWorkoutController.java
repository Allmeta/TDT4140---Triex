package tdt4140.gr1836.app.ui;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javafx.fxml.FXML;

import tdt4140.gr1836.app.ui.Controller;

import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXRadioButton;
import com.jfoenix.controls.JFXSlider;
import com.jfoenix.controls.JFXTextArea;
import com.jfoenix.controls.JFXTextField;

import javafx.scene.control.Label;
import javafx.scene.control.ToggleGroup;

public class CardioWorkoutController extends Controller {

    @FXML private JFXTextField durationField;
    @FXML private JFXTextField distanceField;
    @FXML private JFXTextField pulseField;
    @FXML private JFXDatePicker dateField;
    @FXML private ToggleGroup exerciseType;
    @FXML private JFXRadioButton runningRadioButton;
    @FXML private JFXRadioButton swimmingRadioButton;
    @FXML private JFXRadioButton bikingRadioButton;
    @FXML private Label invalidLabel;
	
    /*
     * Checks that user have typed a positive duration and chosen a date for new cardio workout. Then submits the data to database
     * and send user back to main menu.
     */
	@FXML
	private void onSubmit() throws IOException {
		double duration = -1;
		double distance = -1;
		double pulse = 0;
		try {
			duration = Double.parseDouble(durationField.getText());
			distance = Double.parseDouble(distanceField.getText());
			pulse = Double.parseDouble(pulseField.getText());
			
		} catch(NumberFormatException e) {
			invalidLabel.setText("Please fill out all required fields");
		}
		
		if(duration > 0 && dateField.getValue() != null && distance > 0) {
			String type;
			if (runningRadioButton.isSelected()) {
				type="Running";
			}
			else if (swimmingRadioButton.isSelected()) {
				type="Swimming";
				
			}
			else {
				type = "Biking";
				
			}
			this.app.submitCardioWorkout(type, duration, distance, pulse, dateField.getValue().toString());
			
			showScene("MainMenu.fxml", this.getRoot(),this.app);
		}
	}
	
	@FXML
	public void onCancel() throws IOException {
		showScene("MainMenu.fxml", this.getRoot(),this.app);
	}
	
}
		


