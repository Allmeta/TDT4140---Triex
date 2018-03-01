package tdt4140.gr1836.app.ui;

import java.awt.TextField;
import java.io.IOException;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javax.swing.JFrame;
import javax.swing.WindowConstants;
import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class StrengthWorkoutController {
	
	public static void main(String[] args) throws Exception {
		Calendar cal = Calendar.getInstance();
		SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yy HH:mm a");
		File file = new File("CardioWorkout.txt");
		if (!file.exists() || file.isDirectory()) {
			PrintWriter writer = new PrintWriter("CardioWorkout.txt", "UTF-8");
			writer.close();
			}
		
		final PrintWriter output = new PrintWriter(new FileWriter(file, true));
		output.println("\n" + sdf.format(cal.getTime()));
		JFrame frame = new CardioWorkoutController();
		frame.setTitle("Cardio Workout");
		
		output.close();
		System.exit(0);
		frame.pack();
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		frame.setVisible(true); 
		}
	
	@FXML
	public Button SubmitStrengthWorkout;
	
	@FXML
	public Button CancelStrengthWorkout;
	
	@FXML
	public TextField Duration;
	
	@FXML
	public TextField Set;
	
	@FXML
	public TextField Rep;
	
	@FXML
	public TextField Performance;
	
	@FXML
	public TextField Shape;
	
	@FXML
	public TextField Information;
	
	public void SubmitStrengthWorkout() throws IOException {
		FxApp.showScene("MainMenu.fxml");
		
		
		//TODO: Function that sends the workout to data base.
	}
	
	public void CancelStrengthWorkout() throws IOException {
		FxApp.showScene("MainMenu.fxml");
	}
	
}
		


