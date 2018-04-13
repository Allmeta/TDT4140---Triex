package tdt4140.gr1836.app.ui;

import java.io.IOException;

import com.jfoenix.effects.JFXDepthManager;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;

public class MainMenuController extends Controller {
	
	
	
	@FXML
	private AnchorPane pane;
	@FXML
	private LineChart<Number, Number> lineChart;
	@FXML
	private NumberAxis xAxis;
	@FXML
	private NumberAxis yAxis;
	@FXML
	private Pane chartPane;

	@FXML
	private Label logoutButton;

	@FXML
	private void initialize() {
		// load username in logout button
		Platform.runLater(() -> {
			logoutButton.setText("Log out (" + app.getUser().getUsername() + ")");
		});

		// chart
		xAxis.setLabel("Number of Month");

		XYChart.Series series = new XYChart.Series();
		series.setName("My portfolio");

		// Populate series with data
		series.getData().add(new XYChart.Data(1, 23));
		series.getData().add(new XYChart.Data(2, 14));
		series.getData().add(new XYChart.Data(3, 15));
		series.getData().add(new XYChart.Data(4, 24));
		series.getData().add(new XYChart.Data(5, 34));
		series.getData().add(new XYChart.Data(6, 36));
		series.getData().add(new XYChart.Data(7, 22));
		series.getData().add(new XYChart.Data(8, 45));
		series.getData().add(new XYChart.Data(9, 43));
		series.getData().add(new XYChart.Data(10, 17));
		series.getData().add(new XYChart.Data(11, 29));
		series.getData().add(new XYChart.Data(12, 25));

		lineChart.getData().add(series);
		lineChart.setCreateSymbols(false);

		JFXDepthManager.setDepth(chartPane, 1);
	}

	@FXML
	private void onInbox() {
		try {
			showScene(LayoutHandler.inboxPane, this.getRoot(), this.app);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@FXML
	private void onNewCardioWorkout() { /* Function for showing the Cardio Workout page */
		try {
			showScene(LayoutHandler.newWorkoutPane, this.getRoot(), this.app);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@FXML
	private void onHistory() { /* Function for showing the workout history */
		try {
			showScene(LayoutHandler.historyPane, this.getRoot(), this.app);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@FXML
	private void onCoaches() { /* Function for showing list of coaches */
		try {
			showScene(LayoutHandler.coachesPane, this.getRoot(), this.app);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@FXML
	private void onLogOut() { /* Redirect to login page */
		try {
			showScene(LayoutHandler.loginPane, this.getRoot(), this.app);

		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	

}
