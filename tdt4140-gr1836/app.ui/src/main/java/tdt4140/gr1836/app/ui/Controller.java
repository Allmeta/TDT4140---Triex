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
	protected Stage stage;
			
	public void setApp(App app) {
		this.app=app;
	}
	
	public void setStage(Stage stage) {
		this.stage = stage;
	}
	public Stage getStage() {
		return this.stage;
	}
	
	
	// Shows the MainItems.fxml, pastWorkout.fxml, strengthWorkout.fxml,
	// cardioWorkout.fxml
	public void showScene(String sceneText, Stage stage, App app) throws IOException {
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(FxApp.class.getResource(sceneText));
		BorderPane newStage = loader.load();

		//Set this fxapp and this.app to controller
		Controller controller = loader.getController();
		controller.setApp(app);
		controller.setStage(stage);
		
		Scene scene = new Scene(newStage);
		stage.setScene(scene);
		stage.show();

	}
	// Loads and shows main stage for app
	public void showMainStage(App app) throws IOException {
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(FxApp.class.getResource("MainMenu.fxml"));
		BorderPane mainStage = loader.load();
		
		Stage stage = new Stage();
		stage.setTitle("Training app");
		
		//Set this fxapp and this.app to controller
		Controller controller = loader.getController();
		controller.setApp(app);
		controller.setStage(stage);

		stage.initModality(Modality.WINDOW_MODAL);

		Scene scene = new Scene(mainStage);
		stage.setScene(scene);
		stage.show();
	}
	
	// Loads and shows the add new user stage
	public void showRegisterStage(App app) throws IOException {
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(FxApp.class.getResource("AddNewUser.fxml"));
		BorderPane registerStage = loader.load();
		
		//Set this fxapp and this.app to controller
		Controller controller = loader.getController();
		controller.setApp(app);


		Stage addDialogStage = new Stage();
		addDialogStage.initModality(Modality.WINDOW_MODAL);
		addDialogStage.setTitle("Register new user");

		Scene scene = new Scene(registerStage);
		addDialogStage.setScene(scene);
		addDialogStage.show();
	}

}
