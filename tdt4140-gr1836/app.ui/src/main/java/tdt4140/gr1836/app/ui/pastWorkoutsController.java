package tdt4140.gr1836.app.ui;

import java.io.IOException;
import java.util.ArrayList;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.cell.PropertyValueFactory;
import tdt4140.gr1836.app.ui.Controller;
import tdt4140.gr1836.app.workouts.tempList;

@SuppressWarnings("restriction")
public class pastWorkoutsController extends Controller {
	@FXML
	private Button back;

	@FXML
	private TableView<tempList> view;
	@FXML
	private TableColumn<tempList, String> date;
	@FXML
	private TableColumn<tempList, String> type;
	@FXML
	private TableColumn<tempList, String> intensity;
	@FXML
	private TableColumn<tempList, String> duration;

	@FXML
	private void goBack() throws IOException {
		showScene("MainMenu.fxml", this.getRoot(), this.app);
	}

	@FXML
	public void initialize() {
		Platform.runLater(()->{
			setWorkouts();
		});
	}

	private ArrayList<tempList> parseWorkouts() {
		return this.app.getWorkouts().getWorkoutsAsList();

	}

	private void setWorkouts() {
		// fill stuff
		System.out.println(this.app);
		date.setCellValueFactory(new PropertyValueFactory<tempList, String>("date"));
		type.setCellValueFactory(new PropertyValueFactory<tempList, String>("type"));
		intensity.setCellValueFactory(new PropertyValueFactory<tempList, String>("intensity"));
		duration.setCellValueFactory(new PropertyValueFactory<tempList, String>("duration"));

		view.getItems().setAll(parseWorkouts());
	}

}
