package tdt4140.gr1836.app.ui;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class FxApp extends Application {

	public Stage primaryStage = new Stage();
	
    @Override
    public void start(Stage primaryStage) throws Exception {
    	
	        Parent root = FXMLLoader.load(getClass().getResource("Login.fxml"));
	        primaryStage.setTitle("NTNU Workout yolo");
	        
	        //Create scene for login
			Scene loginScene = new Scene(root,1200,800);
			primaryStage.setScene(loginScene);
	        primaryStage.show();
	        
    }
    
    //Main method
    public static void main(String[] args) {
        launch(args);
    }
}