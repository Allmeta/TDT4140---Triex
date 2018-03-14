package tdt4140.gr1836.app.ui;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.CheckBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.control.Slider;

public class StrengthWorkoutController extends Controller {
	
	
	
	@FXML
	public Button SubmitStrengthWorkout;
	
	@FXML
	public Button CancelStrengthWorkout;
	
	@FXML
	private Button homeBtn;
	
	@FXML
	private TextField duration; 
	
	@FXML
	private DatePicker date;
	
	@FXML
	private Slider intensity;
	
	@FXML
	private TextField benchW;
	
	@FXML
	private TextField benchS;
	
	@FXML
	private TextField benchR;
	
	@FXML
	private TextField deadW;
	
	@FXML
	private TextField deadS;
	
	@FXML
	private TextField deadR;
	
	@FXML
	private TextField squatW;
	
	@FXML
	private TextField squatS;
	
	@FXML
	private TextField squatR;
	
	@FXML
	private TextField hangW;
	
	@FXML
	private TextField hangS;
	
	@FXML
	private TextField hangR;
	
	@FXML
	private TextField pressW;
	
	@FXML
	private TextField pressS;
	
	@FXML
	private TextField pressR;
	
	@FXML
	private TextField info;
	
	
	
	@SuppressWarnings("restriction")
	public void SubmitStrengthWorkout() throws IOException {
		List<String> bench= Arrays.asList(benchW.getText(),benchS.getText(),benchR.getText());
		List<String> dead= Arrays.asList(deadW.getText(),deadS.getText(),deadR.getText());
		List<String> squat= Arrays.asList(squatW.getText(),squatS.getText(),squatR.getText());
		List<String> hang= Arrays.asList(hangW.getText(), hangS.getText(),hangR.getText());
		List<String> press= Arrays.asList(pressW.getText(),pressS.getText(),pressR.getText());
		
		
		this.app.submitStrengthWorkout(duration.getText(), date.getValue().toString(), bench,dead,squat,hang,press,intensity.getValue(),info.getText());
		showScene("MainMenu.fxml", this.getRoot(),this.app);
	}
	
	
	//Sends you back to menu
	public void CancelStrengthWorkout() throws IOException {
		showScene("MainMenu.fxml", this.getRoot(),this.app);
	}
	
	@FXML
	private void goHome() throws IOException {
		showScene("MainMenu.fxml", this.getRoot(),this.app);
	}
	
}
		


