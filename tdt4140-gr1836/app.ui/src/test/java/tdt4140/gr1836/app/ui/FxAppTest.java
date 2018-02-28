package tdt4140.gr1836.app.ui;

import org.junit.BeforeClass;
import org.junit.Test;
import org.testfx.framework.junit.ApplicationTest;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class FxAppTest extends ApplicationTest {
	
	@BeforeClass
	public static void headless() {
		if (Boolean.valueOf(System.getProperty("gitlab-ci", "false")))
		GitlabCISupport.headless();
	}
	
    
	//@Override
    //public void start(Stage stage) throws Exception {
        //Parent root = FXMLLoader.load(getClass().getResource("MainView.fxml"));
        //Scene scene = new Scene(root);
       // stage.setScene(scene);
      //  stage.show();
    //}
	@Override
    public void start(Stage stage) throws Exception {
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(FxApp.class.getResource("MainView.fxml"));
		
		
        BorderPane root = loader.load();
        Scene scene = new Scene(root,600,600);        
        stage.setScene(scene);
        stage.show();
    }

    @Test
    public void testFxApp() {
    }
}
