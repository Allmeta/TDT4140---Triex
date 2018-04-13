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
		//Må sette labels til statistikkfeltene vi henter fra apps
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
	
	
	
	
	
