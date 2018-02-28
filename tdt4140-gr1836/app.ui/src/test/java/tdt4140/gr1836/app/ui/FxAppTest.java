package tdt4140.gr1836.app.ui;

import org.junit.BeforeClass;
import org.junit.Test;
import org.testfx.framework.junit.ApplicationTest;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class FxAppTest extends ApplicationTest {
	
	@BeforeClass
	public static void headless() {
		if (Boolean.valueOf(System.getProperty("gitlab-ci", "false")))
		GitlabCISupport.headless();
	}
	
    private MainViewController controller;
    
	//@Override
    //public void start(Stage stage) throws Exception {
        //Parent root = FXMLLoader.load(getClass().getResource("MainView.fxml"));
        //Scene scene = new Scene(root);
       // stage.setScene(scene);
      //  stage.show();
    //}
	@Override
    public void start(Stage stage) throws Exception {
		FXMLLoader loader = new FXMLLoader(getClass().getResource("MainView.fxml"));
        Parent root = loader.load();
        this.controller = loader.getController();
        Scene scene = new Scene(root);
        
        stage.setTitle("JavaFX and Maven");
        stage.setScene(scene);
        stage.show();
    }

    @Test
    public void testFxApp() {
    }
}
