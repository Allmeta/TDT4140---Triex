package tdt4140.gr1836.app.ui;

import java.io.IOException;


import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import tdt4140.gr1836.app.core.App;
import tdt4140.gr1836.app.core.Database;
import tdt4140.gr1836.app.core.User;

public class FxApp extends Application {


	
	private App app;
	
	@Override
	public void start(Stage primaryStage) throws IOException {
		//this.database=new Database();
		this.app = new App();

		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(FxApp.class.getResource("Login.fxml"));
		
		Parent root = loader.load();
		
		Scene scene = new Scene(root, 380, 550);
		
		primaryStage.setScene(scene);
		primaryStage.setTitle("Training app");
		
		//Set this fxapp and this.app to controller
		Controller controller = loader.getController();
		controller.setApp(this.app);
		
		primaryStage.show();

	}
	

	public void deleteUser(String username) {
		//Helper method for testing
		this.app.deleteUser(username);
	}
	public void setApp(DummyApp app) throws IOException {
		//Helper method for testing, setting app to a dummyApp communicating with a local JSON-file
		this.app=app;
		//showMainView();
		//showScene("MainMenu.fxml");
		
	}
	/*public static void main(String[] args) throws IOException {
		//Database d=new Database();
		//d.init();
		//d.register("Mathias4", "Thomas almestad", 20, "oslo", "ole@gmail.com", "bergveien 5c", 0, "123abc");
		//d.deleteUser("Allmeta");
		//d.login("Karlf","5213");
		App app = new App();
		//app.deleteUser("Mathias7");
		//app.register("Mathias7", "Thomas almestad", 20, "oslo", "ole@gmail.com", "bergveien 5c", 0, "123abc");
		app.login("Karlf", "5213");

	}*/


}
