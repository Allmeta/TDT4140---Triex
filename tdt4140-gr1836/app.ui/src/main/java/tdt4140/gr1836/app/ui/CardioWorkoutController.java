package tdt4140.gr1836.app.ui;

import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.control.CheckBox;

@SuppressWarnings("restriction")
public class CardioWorkoutController extends Controller {
	
	
	@FXML
	public Button SubmitCardioWorkout;
	
	@FXML
	public Button CancelCardioWorkout;
	
	@FXML
	private Button homeBtn;
	
	@FXML
	private TextField info;
	
	@FXML
	private TextField duration;
	
	@FXML
	private DatePicker date;
	
	@FXML
	private CheckBox intensityL;
	
	@FXML
	private CheckBox intensityM;
	
	@FXML
	private CheckBox intensityH;
	
	@FXML
	private CheckBox swim;
	
	@FXML
	private CheckBox bike;
	
	@FXML
	private CheckBox run;
	
	
	
	
	public void SubmitCardioWorkout() throws IOException {
		Map<String,Boolean> activity=new HashMap<>();
		activity.put("Running", run.isSelected());
		activity.put("Swimming", swim.isSelected());
		activity.put("Biking", bike.isSelected());
		
		List<Boolean> intensity=Arrays.asList(intensityL.isSelected(),intensityM.isSelected(),intensityH.isSelected());
		this.app.submitCardioWorkout(duration.getText(),date.getValue().toString(),activity,intensity,info.getText());
		
		
		showScene("MainMenu.fxml", this.getRoot(),this.app);
	}
	
	
	//Sends you back to menu
	public void CancelCardioWorkout() throws IOException {
		showScene("MainMenu.fxml", this.getRoot(),this.app);
	}
	
	@FXML
	private void goHome() throws IOException {
		showScene("MainMenu.fxml", this.getRoot(),this.app);
	}
	
}
		


