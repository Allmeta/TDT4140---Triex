package tdt4140.gr1836.app.ui;

import java.io.IOException;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import tdt4140.gr1836.app.core.App;

public class Controller {

	protected App app;
	protected Stage root;

	public void setApp(App app) {
		this.app = app;
	}

	public void setRoot(Stage root) {
		this.root = root;
	}

	public Stage getRoot() {
		return this.root;
	}

	// Shows a specified scene
	public void showScene(String sceneText, Stage root, App app) throws IOException {
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(getClass().getResource(sceneText));
		Pane parent = (Pane) loader.load();
		// Set controller
		Controller controller = loader.getController();
		controller.setApp(app);
		controller.setRoot(root);

		root.setScene(new Scene(parent));

	}

	// Loads and shows main stage for app
	public void showMainStage(App app) throws IOException {
		Stage root = new Stage();
		FXMLLoader loader = new FXMLLoader(getClass().getResource(LayoutHandler.mainUserPane));
		Pane parent = (Pane) loader.load();

		// Set controller
		Controller controller = loader.getController();
		controller.setApp(app);
		controller.setRoot(root);

		root.setTitle("Triex");
		root.setScene(new Scene(parent));
		root.initModality(Modality.APPLICATION_MODAL);
		root.setResizable(false);
		root.show();

		// Load graph and get Statistics from db
		app.getWorkoutsFromDB();
		app.getStatisticsFromDB();

	}

	public void showCoachStage(App app) throws IOException {
		Stage root = new Stage();
		FXMLLoader loader = new FXMLLoader(getClass().getResource(LayoutHandler.mainCoachPane));
		Pane parent = (Pane) loader.load();

		// Set controller
		Controller controller = loader.getController();
		controller.setApp(app);
		controller.setRoot(root);

		root.setTitle("Coach Menu");
		root.setScene(new Scene(parent));
		root.initModality(Modality.APPLICATION_MODAL);
		root.setResizable(false);
		root.show();

		// Load graph
		app.getWorkoutsFromDB();

	}

	// Loads and shows the add new user stage

	public void showRegisterStage(App app) throws IOException {
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(FxApp.class.getResource(LayoutHandler.signUpPane));
		Pane pane = loader.load();

		Stage stage = new Stage();
		stage.setTitle("Register new user");

		// Set this app to controller
		Controller controller = loader.getController();
		controller.setApp(app);

		Scene scene = new Scene(pane);
		stage.setScene(scene);
		stage.initModality(Modality.APPLICATION_MODAL);
		stage.setResizable(false);
		stage.show();
	}

}
