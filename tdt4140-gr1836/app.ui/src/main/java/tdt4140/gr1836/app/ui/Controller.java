package tdt4140.gr1836.app.ui;

import java.io.IOException;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import tdt4140.gr1836.app.core.App;

public class Controller {
	protected App app;
	protected BorderPane root;
			
	public void setApp(App app) {
		this.app=app;
	}
	
	public void setRoot(BorderPane root) {
		this.root = root;
	}
	public BorderPane getRoot() {
		return this.root;
	}
	
	// Shows the MainItems.fxml, pastWorkout.fxml, strengthWorkout.fxml,
	// cardioWorkout.fxml
	public void showScene(String sceneText, BorderPane root, App app) throws IOException {
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(FxApp.class.getResource(sceneText));
		BorderPane newStage = loader.load();
		root.setCenter(newStage);

		//Set this root and this app to new controller
		Controller controller = loader.getController();
		controller.setApp(app);
		controller.setRoot(root);
		
		//Scene scene = new Scene(newStage);
		//stage.setScene(scene);
		//stage.show();

	}
	// Loads and shows main stage for app
	public void showMainStage(App app) throws IOException {
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(FxApp.class.getResource("MainMenu.fxml"));
		BorderPane root = loader.load();
		
		Stage stage = new Stage();
		stage.setTitle("Training app");
		
		//Set stage and app to controller
		Controller controller = loader.getController();
		controller.setApp(app);
		controller.setRoot(root);

		stage.initModality(Modality.WINDOW_MODAL);

		Scene scene = new Scene(root, 600, 600);
		stage.setScene(scene);
		stage.show();
	}
	
	// Loads and shows the add new user stage
	public void showRegisterStage(App app) throws IOException {
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(FxApp.class.getResource("AddNewUser.fxml"));
		BorderPane registerStage = loader.load();
		
		Stage addDialogStage = new Stage();
		addDialogStage.setTitle("Register new user");
		
		//Set this app to controller
		Controller controller = loader.getController();
		controller.setApp(app);

		addDialogStage.initModality(Modality.WINDOW_MODAL);

		Scene scene = new Scene(registerStage);
		addDialogStage.setScene(scene);
		addDialogStage.show();
	}

}
