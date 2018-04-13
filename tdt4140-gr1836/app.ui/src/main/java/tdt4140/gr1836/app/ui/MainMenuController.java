package tdt4140.gr1836.app.ui;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import com.jfoenix.effects.JFXDepthManager;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.chart.*;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import tdt4140.gr1836.app.workouts.TempList;

public class MainMenuController extends Controller {

	@FXML
	private BarChart<String, Number> barChart;
	@FXML
	private CategoryAxis xAxis;
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
			setGraph();
		});
	}
	private void setGraph() {

		XYChart.Series<String, Number> series = new XYChart.Series<>();

		//Populate series with data
		int x = 1;
		ArrayList<TempList> workouts = app.getWorkouts().getWorkoutsAsList();
		workouts.sort(Comparator.comparing(TempList::getDate));
		Collections.reverse(workouts);
		for (TempList w : workouts) {

			if (x <= 21) {
				series.getData().add(new XYChart.Data<>(w.getDate(), w.getPulse()));
			} else {
				break;
			}
			x++;

		}
		barChart.getData().add(series);
		Platform.runLater(()->{
			setMaxBarWidth(40,3);
		});

		JFXDepthManager.setDepth(chartPane, 1);
	}
	private void setMaxBarWidth(double maxBarWidth, double minCategoryGap){
		double barWidth=0;
		do{
			double catSpace = xAxis.getCategorySpacing();
			double avilableBarSpace = catSpace - (barChart.getCategoryGap());
			barWidth = (avilableBarSpace / barChart.getData().size());
			if (barWidth >maxBarWidth){
				avilableBarSpace=(maxBarWidth);
				barChart.setCategoryGap(catSpace-avilableBarSpace);
			}
		} while(barWidth>maxBarWidth);

		do{
			double catSpace = xAxis.getCategorySpacing();
			double avilableBarSpace = catSpace - (minCategoryGap);
			barWidth = Math.min(maxBarWidth, (avilableBarSpace / barChart.getData().size()));
			avilableBarSpace=(barWidth);
			barChart.setCategoryGap(catSpace-avilableBarSpace);
		} while(barWidth < maxBarWidth && barChart.getCategoryGap()>minCategoryGap);
	}

	@FXML
	private void onInbox(){
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
