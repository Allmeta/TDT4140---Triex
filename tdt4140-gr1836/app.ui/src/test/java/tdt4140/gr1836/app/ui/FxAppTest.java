package tdt4140.gr1836.app.ui;

import static org.junit.Assert.assertFalse;

import java.io.IOException;

import org.junit.Before;
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
    
	@Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("MainMenu.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
	//Må lage override som setter opp får kontroller og deretter legger til nye
	//brukere og treningsøkter i en egen tom json fil, bruker deretter assert for å sjeke at
	//det stemmer
	
	//private FxApp fxApp;
			
	//@Before
	//public void setUp(Stage stage) throws IOException {
		//fxApp = new FxApp();
		//fxApp.start(stage);
	//}

    @Test
    public void testFxApp() {
    }
}
