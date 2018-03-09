package tdt4140.gr1836.app.ui;

import java.io.IOException;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
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
	public void showScene(String sceneText, Stage stage) throws IOException {
		
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(FxApp.class.getResource(sceneText));
		BorderPane newStage = loader.load();

		//Set this fxapp and this.app to controller
		Controller controller = loader.getController();
		controller.setApp(this.app);
		controller.setStage(stage);
		
		Scene scene = new Scene(newStage);
		stage.setScene(scene);
		stage.show();

	}
	// Loads and shows the add new user stage
	public void showMainStage(String sceneText) throws IOException {
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(FxApp.class.getResource(sceneText));
		BorderPane mainStage = loader.load();
		
		this.stage = new Stage();
		//Set this fxapp and this.app to controller
		Controller controller = loader.getController();
		controller.setApp(this.app);
		controller.setStage(this.stage);

		stage.initModality(Modality.WINDOW_MODAL);

		Scene scene = new Scene(mainStage);
		stage.setScene(scene);
		stage.show();
	}
	
	// Loads and shows the add new user stage
	public void showRegisterStage() throws IOException {
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(FxApp.class.getResource("AddNewUser.fxml"));
		BorderPane registerStage = loader.load();
		
		//Set this fxapp and this.app to controller
		Controller controller = loader.getController();
		controller.setApp(this.app);


		Stage addDialogStage = new Stage();
		addDialogStage.initModality(Modality.WINDOW_MODAL);

		Scene scene = new Scene(registerStage);
		addDialogStage.setScene(scene);
		addDialogStage.show();
	}

}
