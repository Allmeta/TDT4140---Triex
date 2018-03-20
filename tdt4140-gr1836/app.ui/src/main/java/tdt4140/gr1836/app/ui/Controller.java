package tdt4140.gr1836.app.ui;

import java.io.IOException;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import tdt4140.gr1836.app.core.App;

public class Controller {
	
	public App app;
	protected Stage root;
			
	public void setApp(App app) {
		this.app=app;
	}
	
	public void setRoot(Stage root) {
		this.root = root;
	}
	public Stage getRoot() {
		return this.root;
	}
	
	// Shows the MainItems.fxml, pastWorkout.fxml, strengthWorkout.fxml,
	// cardioWorkout.fxml
	public void showScene(String sceneText, Stage root, App app) throws IOException {
	    FXMLLoader loader = new FXMLLoader(getClass()
	            .getResource(sceneText));
	    BorderPane parent;
	    try 
	    {
	    	parent = (BorderPane)loader.load();
	    	//Set controller
	    	Controller controller = loader.getController();
			controller.setApp(app);
			controller.setRoot(root);
			
	        root.setScene(new Scene(parent));
	    } 
	    catch (IOException e)
	    {
	        e.printStackTrace();
	    }


	}
	// Loads and shows main stage for app
	public void showMainStage(App app) throws IOException {
	    Stage root = new Stage();
	    FXMLLoader loader = new FXMLLoader(getClass()
	            .getResource("MainMenu.fxml"));
	    BorderPane parent = (BorderPane)loader.load();
	    
	    //Set controller
	    Controller controller = loader.getController();
		controller.setApp(app);
		controller.setRoot(root);
		
	    root.setTitle("Training app");
	    root.setScene(new Scene(parent));
	    root.show();
	    
	    //Load graph
	    app.getWorkouts();
	    
	    
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
