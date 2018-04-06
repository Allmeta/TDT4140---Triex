package tdt4140.gr1836.app.ui;

import java.io.IOException;

import com.jfoenix.controls.JFXTreeTableView;
import com.jfoenix.controls.RecursiveTreeItem;
import com.jfoenix.controls.datamodels.treetable.RecursiveTreeObject;

import javafx.fxml.FXML;
import javafx.beans.property.StringProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.ReadOnlyStringWrapper;

import javafx.collections.ObservableList;
import javafx.collections.FXCollections;

import javafx.application.Platform;
import javafx.scene.control.cell.TreeItemPropertyValueFactory;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeTableColumn;
import tdt4140.gr1836.app.ui.Controller;

@SuppressWarnings("restriction")
public class HistoryController extends Controller {

	@FXML
	private JFXTreeTableView<Workout> tableView;

	@FXML
	private TreeTableColumn<Workout, String> dateColumn;

	@FXML
	private TreeTableColumn<Workout, String> typeColumn;

	@FXML
	private TreeTableColumn<Workout, String> intensityColumn;

	@FXML
	private TreeTableColumn<Workout, String> durationColumn;

	/*
	 * 
	 * @FXML private void goBack() throws IOException { showScene("MainMenu.fxml",
	 * this.getRoot(), this.app); }
	 * 
	 */

	@FXML
	public void initialize() {
		Platform.runLater(() -> {
			setWorkouts();
		});
	}

	/*
	 * private ArrayList<TempList> parseWorkouts() { return
	 * this.app.getWorkouts().getWorkoutsAsList();
	 * 
	 * }
	 */

	private void setWorkouts() {

		dateColumn.setCellValueFactory(
				(TreeTableColumn.CellDataFeatures<Workout, String> param) -> 
				new ReadOnlyStringWrapper(param.getValue().getValue().getDate()));
		typeColumn.setCellValueFactory(
				(TreeTableColumn.CellDataFeatures<Workout, String> param) -> 
				new ReadOnlyStringWrapper(param.getValue().getValue().getType()));
		intensityColumn.setCellValueFactory(
				(TreeTableColumn.CellDataFeatures<Workout, String> param) -> 
				new ReadOnlyStringWrapper(param.getValue().getValue().getIntensity()));
		durationColumn.setCellValueFactory(
				(TreeTableColumn.CellDataFeatures<Workout, String> param) -> 
				new ReadOnlyStringWrapper(param.getValue().getValue().getDuration()));

		// data
		ObservableList<Workout> workouts = FXCollections.observableArrayList();
		workouts.add(new Workout("testa", "23", "CD 1", "i"));
		workouts.add(new Workout("ddkd", "22", "Employee 1", "iii"));
		workouts.add(new Workout("kkd999d", "24", "Employee 2", "isiis"));

		// build tree
		final TreeItem<Workout> root = new RecursiveTreeItem<Workout>(workouts, RecursiveTreeObject::getChildren);
		tableView.setRoot(root);
		tableView.setShowRoot(false);

	}
	
	@FXML
	private void onBack() {
		try {
			showScene("MainMenu.fxml",this.getRoot(),this.app);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private static class Workout extends RecursiveTreeObject<Workout> {
		public final String date;
		public final String duration;
		public final String intensity;
		public final String type;

		public Workout(String date, String duration, String intensity, String type) {
			this.date = (date);
			this.duration = (duration);
			this.intensity = (intensity);
			this.type = (type);
		}

		public String getDate() {
			return this.date;
		}

		public String getDuration() {
			return this.duration;
		}

		public String getIntensity() {
			return this.intensity;
		}

		public String getType() {
			return this.type;
		}

	}

}
