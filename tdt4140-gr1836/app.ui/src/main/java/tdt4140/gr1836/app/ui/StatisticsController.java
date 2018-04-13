package tdt4140.gr1836.app.ui;

import java.io.IOException;

import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXRadioButton;
import com.jfoenix.controls.JFXTextField;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ToggleGroup;
import tdt4140.gr1836.app.statistics.Statistics;

public class StatisticsController extends Controller {

	@FXML
	private Label profileLabel;
	@FXML
	private Label kmRanLabel;
	@FXML
	private Label kmSwamLabel;
	@FXML
	private Label kmBikedLabel;
	@FXML
	private Label invalidLabel;
	
    @FXML
    private Label myRun;
    
    
    

	/*
	 * Checks that user have typed a positive duration and chosen a date for new
	 * cardio workout. Then submits the data to database and send user back to main
	 * menu.
	 */
	@FXML
	private void initialize() {
		Platform.runLater(() -> {
			loadStatistics();
		});
	}
	@FXML
	private void loadStatistics() {
		
		
		Statistics statObj = this.app.getStatistics();
		
		
		//Card 1 - Distance ran compared to other users in city for the last 30 days.
		
		System.out.println("hjhg: " + statObj.getaverageStatistics());
		myRun.setText(Integer.toString(statObj.getaverageStatistics().getRunKm()));
		
		//Card 2 - Distance swam? compared to other users in city for the last 30 days.
		
		//Card 3 - Distance biked compared to other users in city for the last 30 days.
		
		//Card 4 - Piechart to compare time spent on running vs swimming vs biking for the last 30 days.
		
		//Card 5 - Shows your estimated max pulse.
		
		//Card 6 - Shows your average pulse separately for biking, swimming and running for the last 30 days.
		
		
		
	}
	@FXML
	private void onSubmit() throws IOException {
		//Find partners, show their profiles?
	}

	@FXML
	public void onCancel() throws IOException {
		try {
			showScene(LayoutHandler.mainUserPane, this.getRoot(), this.app);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
	
	
	
	
	
