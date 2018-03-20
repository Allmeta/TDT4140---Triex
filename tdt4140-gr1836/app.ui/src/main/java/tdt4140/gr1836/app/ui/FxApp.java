package tdt4140.gr1836.app.ui;

import java.io.IOException;


import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import tdt4140.gr1836.app.core.App;


public class FxApp extends Application {
	
	@Override
	public void start(Stage primaryStage) throws IOException {
		App app = new App();

		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(FxApp.class.getResource("Login.fxml"));
		
		Parent root = loader.load();
		
		Scene scene = new Scene(root, 380, 550);
		primaryStage.setScene(scene);
		primaryStage.setTitle("Training app");
		
		//Set app to controller
		Controller controller = loader.getController();
		controller.setApp(app);
		
		primaryStage.show();
	}
	public static void main(String[] args) {
		launch(args);

	}


}
