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
    @FXML private JFXDatePicker dateField;
    @FXML private JFXRadioButton runningRadioButton;
    @FXML private ToggleGroup exerciseType;
    @FXML private JFXRadioButton swimmingRadioButton;
    @FXML private JFXRadioButton bikingRadioButton;
    @FXML private JFXSlider intensityField;
    @FXML private JFXTextArea noteField;
    @FXML private Label invalidLabel;
	
    /*
     * Checks that user have typed a positive duration and chosen a date for new cardio workout. Then submits the data to database
     * and send user back to main menu.
     */
	@FXML
	private void onSubmit() throws IOException {
		double duration = -1;
		
		try {
			duration = Double.parseDouble(durationField.getText());
		} catch(NumberFormatException e) {
			invalidLabel.setText("Please fill out all required fields");
		}
		
		if(duration > 0 && dateField.getValue() != null) {
			Map<String,Boolean> activity=new HashMap<>();
			activity.put("Running", runningRadioButton.isSelected());
			activity.put("Swimming", swimmingRadioButton.isSelected());
			activity.put("Biking", bikingRadioButton.isSelected());
			
			this.app.submitCardioWorkout(durationField.getText(),dateField.getValue().toString(),activity,intensityField.getValue(),noteField.getText());
			
			
			showScene("MainMenu.fxml", this.getRoot(),this.app);
		}
	}
	
	@FXML
	public void onCancel() throws IOException {
		showScene("MainMenu.fxml", this.getRoot(),this.app);
	}
	
}
		


