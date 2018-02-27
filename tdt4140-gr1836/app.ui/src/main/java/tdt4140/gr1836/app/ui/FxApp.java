package tdt4140.gr1836.app.ui;

import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class FxApp extends Application{
	
	private static Stage primaryStage;
	private static BorderPane mainLayout;

	
	@Override
	public void start(Stage primaryStage) throws IOException {
		FxApp.primaryStage = primaryStage;
		FxApp.primaryStage.setTitle("Training App");
		
		//Loads the two main menu scenes into the primary stage
		showMainView();
		showMainItems();
		
	}
	
	//Shows the toolbar menu at the bottom of the primary stage
	private void showMainView() throws IOException {
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(FxApp.class.getResource("MainView.fxml"));
		mainLayout = loader.load();
		Scene scene = new Scene(mainLayout,600,600);
		primaryStage.setScene(scene);
		primaryStage.show();
	}
	
	//Shows the main menu
	public static void showMainItems() throws IOException {
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(FxApp.class.getResource("MainItems.fxml"));
		BorderPane mainItems = loader.load();
		mainLayout.setCenter(mainItems);
	}
	
	//Shows the new workout scene
	public static void showNewWorkoutScene() throws IOException {
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(FxApp.class.getResource("newWorkout.fxml"));
		BorderPane newWorkout = loader.load();
		mainLayout.setCenter(newWorkout);
		
		
	}
	//Shows the part workouts scene
	public static void showPastWorkoutScene() throws IOException {
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(FxApp.class.getResource("pastWorkout.fxml"));
		BorderPane pastWorkout = loader.load();
		mainLayout.setCenter(pastWorkout);
	}
	
	//Shows the strength workout scene
	public static void showStrengthWorkoutScene() throws IOException {
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(FxApp.class.getResource("strengthWorkout.fxml"));
		BorderPane strengthWorkout = loader.load();
		mainLayout.setCenter(strengthWorkout);
		
	}	
	
	//Shows the cardio workout scene
	public static void showCardioWorkoutScene() throws IOException {
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(FxApp.class.getResource("cardioWorkout.fxml"));
		BorderPane cardioWorkout = loader.load();
		mainLayout.setCenter(cardioWorkout);
	}
	//Loads and shows the add new user stage
	public static void showAddStage() throws IOException {
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(FxApp.class.getResource("AddNewUser.fxml"));
		BorderPane addNewEmployee = loader.load();
		
		Stage addDialogStage = new Stage();
		addDialogStage.setTitle("Add new User");
		addDialogStage.initModality(Modality.WINDOW_MODAL);
		addDialogStage.initOwner(primaryStage);
		Scene scene = new Scene(addNewEmployee);
		addDialogStage.setScene(scene);
		addDialogStage.show();
	}
	
	//Loads and shows the login stage
	public static void showLoginStage() throws IOException {
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(FxApp.class.getResource("Login.fxml"));
		BorderPane Login = loader.load();
		
		Stage LoginStage = new Stage();
		LoginStage.setTitle("Log in");
		LoginStage.initModality(Modality.WINDOW_MODAL);
		LoginStage.initOwner(primaryStage);
		Scene scene = new Scene(Login);
		LoginStage.setScene(scene);
		LoginStage.show();
	}
	
	
	public static void main(String[] args) {
		launch(args);
	}
	
	
}
