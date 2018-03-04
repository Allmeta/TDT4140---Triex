package tdt4140.gr1836.app.ui;

import java.io.IOException;


import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import tdt4140.gr1836.app.core.Database;

public class FxApp extends Application {

	private static Stage primaryStage;
	private static BorderPane mainLayout;

	@Override
	public void start(Stage primaryStage) throws IOException {
		FxApp.primaryStage = primaryStage;
		FxApp.primaryStage.setTitle("Training App");
		

		// Loads the two main menu scenes into the primary stage
		showMainView();
		showScene("MainMenu.fxml");

	}
	

	// Shows the tool bar menu at the bottom of the primary stage
	private void showMainView() throws IOException {
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(FxApp.class.getResource("BottomMenu.fxml"));
		mainLayout = loader.load();
		Scene scene = new Scene(mainLayout, 600, 600);
		primaryStage.setScene(scene);
		primaryStage.show();
	}

	// Shows the MainItems.fxml, pastWorkout.fxml, strengthWorkout.fxml,
	// cardioWorkout.fxml
	public static void showScene(String scene) throws IOException {
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(FxApp.class.getResource(scene));
		BorderPane mainItems = loader.load();
		mainLayout.setCenter(mainItems);
	}

	// Loads and shows the add new user stage
	public static void showAddStage() throws IOException {
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(FxApp.class.getResource("AddNewUser.fxml"));
		BorderPane addNewUser = loader.load();

		Stage addDialogStage = new Stage();
		addDialogStage.setTitle("Add new User");
		addDialogStage.initModality(Modality.WINDOW_MODAL);
		addDialogStage.initOwner(primaryStage);
		Scene scene = new Scene(addNewUser);
		addDialogStage.setScene(scene);
		addDialogStage.show();
	}

	// Loads and shows the login stage
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

	public static void main(String[] args) throws IOException {
		Database d=new Database();
		d.init();
		//d.register("Allmeta2", "Thomas almestad", 20, "oslo", "ole@gmail.com", "bergveien 5c", 0, "123abc");
		//d.deleteUser("Allmeta");
		
		launch(args);
		
	}

}
