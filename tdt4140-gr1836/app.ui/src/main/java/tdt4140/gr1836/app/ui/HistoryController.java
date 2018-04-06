package tdt4140.gr1836.app.ui;

import java.io.IOException;
import java.util.ArrayList;

import com.jfoenix.controls.JFXTreeTableView;
import com.jfoenix.controls.RecursiveTreeItem;
import com.jfoenix.controls.datamodels.treetable.RecursiveTreeObject;

import javafx.fxml.FXML;
import javafx.scene.control.TreeTableColumn;

import javafx.beans.binding.Bindings;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

import javafx.collections.ObservableList;
import javafx.collections.FXCollections;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TreeItem;
import javafx.scene.control.cell.PropertyValueFactory;
import tdt4140.gr1836.app.ui.Controller;
import tdt4140.gr1836.app.workouts.TempList;

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

	@FXML
	private void goBack() throws IOException {
		showScene("MainMenu.fxml", this.getRoot(), this.app);
	}
	
	*/

	@FXML
	public void initialize() {
		Platform.runLater(()->{
			setWorkouts();
		});
	}
	
	
/*
	private ArrayList<TempList> parseWorkouts() {
		return this.app.getWorkouts().getWorkoutsAsList();

	}
	*/

	private void setWorkouts() {
		/*
		date.setCellValueFactory(new PropertyValueFactory<TempList, String>("Date"));
		type.setCellValueFactory(new PropertyValueFactory<TempList, String>("Type"));
		intensity.setCellValueFactory(new PropertyValueFactory<TempList, String>("Intensity"));
		duration.setCellValueFactory(new PropertyValueFactory<TempList, String>("Duration"));
		*/
		
		// data
		ObservableList<Workout> workouts = FXCollections.observableArrayList();
        workouts.add(new Workout("testa", "23", "CD 1", "i"));
        workouts.add(new Workout("ddkd", "22", "Employee 1", "iii"));
        workouts.add(new Workout("kkd999d", "24", "Employee 2", "isiis"));
        
        //build tree
        final TreeItem<Workout> root = new RecursiveTreeItem<>(workouts, RecursiveTreeObject::getChildren);
        tableView.setRoot(root);
        tableView.setShowRoot(false);

        
	}
	
    private static final class Workout extends RecursiveTreeObject<Workout> {
        final StringProperty date;
        final StringProperty duration;
        final StringProperty intensity;
        final StringProperty type;

        public Workout(String date, String duration, String intensity, String type) {
            this.date = new SimpleStringProperty(date);
            this.duration = new SimpleStringProperty(duration);
            this.intensity = new SimpleStringProperty(intensity);
            this.type = new SimpleStringProperty(type);
        }
        
        /*
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
    	*/
    }

}
