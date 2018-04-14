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
import tdt4140.gr1836.app.statistics.Statistic;
import tdt4140.gr1836.app.statistics.Statistics;


public class StatisticsController extends Controller {
	

	@FXML
	private Statistics statObj;

	@FXML
	private Label profileLabel;
	@FXML
	private Label kmRanLabel, kmSwamLabel, kmBikedLabel;
	@FXML
	private Label invalidLabel;
	
    @FXML
    private Label myRun, mySwim, myBike;
    
    @FXML
    private Label avgCityRun, avgCitySwim, avgCityBike;
    
    @FXML
    private Label estMaxPulse;
    
    @FXML
    private Label avgPulseRun, avgPulseSwim, avgPulseBike;
    
    @FXML
    private Label timeSpentRunning, timeSpentSwimming, timeSpentBiking;
    
    @FXML
    private Label userName, compName;

	/*
	 * Checks that user have typed a positive duration and chosen a date for new
	 * cardio workout. Then submits the data to database and send user back to main
	 * menu.
	 */
	@FXML
	private void initialize() {
		Platform.runLater(() -> {
			Statistics statObj = this.app.getStatistics();
			loadStatistics(statObj.calculateAverageInCity(app.getUsers(), app.getUser().getCity()));
		});
	}
	@FXML
	private void loadStatistics(Statistic average) {
		
		userName.setText(app.getUser().getUsername());
		compName.setText(app.getUser().getCity());
	
		
		//Calculates average once to save time.
		
		Statistic myStats = this.app.getMyStatistics();
		
		
		//Card 1 - Distance ran compared to other users in city for the last 30 days.
		myRun.setText(""+ myStats.getRunKm() + " Km");
		avgCityRun.setText(""+ average.getRunKm() + " Km");
		
		

		
		//Card 2 - Distance swam? compared to other users in city for the last 30 days.
		mySwim.setText(""+ myStats.getSwimKm() + " Km");
		avgCitySwim.setText(""+ average.getSwimKm() + " Km");
		
		
		//Card 3 - Distance biked compared to other users in city for the last 30 days.
		myBike.setText(""+ myStats.getBikeKm() + " Km");
		avgCityBike.setText(""+ average.getBikeKm() + " Km");
		
		
		//Card 4 - Time spent on each excercise type
		timeSpentRunning.setText("Running: "+myStats.getRunMin() + " Minutes");
		timeSpentSwimming.setText("Swimming: "+myStats.getSwimMin()+ " Minutes");
		timeSpentBiking.setText("Biking: "+myStats.getBikeMin()+ " Minutes");

		
		
		//Card 5 - Shows your estimated max pulse.
		estMaxPulse.setText(""+myStats.getMaxPulse());
		
		//Card 6 - Shows your average pulse separately for biking, swimming and running for the last 30 days.
		avgPulseRun.setText("Running: "+myStats.getAvgRunPulse());
		avgPulseSwim.setText("Swimming: "+myStats.getAvgSwimPulse());
		avgPulseBike.setText("Biking: "+myStats.getAvgBikePulse());
		
		
		
		
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
	
	
	
	
	
