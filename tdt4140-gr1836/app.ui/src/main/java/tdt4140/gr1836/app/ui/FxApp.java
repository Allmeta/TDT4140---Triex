package tdt4140.gr1836.app.ui;


import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class FxApp extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("FxApp.fxml"));
        primaryStage.setTitle("App");
        primaryStage.setScene(new Scene(root, 800, 450));
        primaryStage.show();
    }


}