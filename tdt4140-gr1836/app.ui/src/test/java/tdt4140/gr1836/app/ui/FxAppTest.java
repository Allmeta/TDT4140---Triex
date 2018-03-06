package tdt4140.gr1836.app.ui;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

import java.io.IOException;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.testfx.framework.junit.ApplicationTest;

import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import tdt4140.gr1836.app.core.Database;

public class FxAppTest extends ApplicationTest {
	
	@BeforeClass
	public static void headless() {
		if (Boolean.valueOf(System.getProperty("gitlab-ci", "false")))
		GitlabCISupport.headless();
	}
	
    //private Scene scene;
	@Override
    public void start(Stage stage) throws Exception {
        /*Parent root = FXMLLoader.load(getClass().getResource("BottomMenu.fxml"));
        this.scene = new Scene(root);
        root.getCo
        stage.setScene(this.scene);
        stage.show();*/
    	FxApp fxApp = new FxApp();
        fxApp.start(stage);
        //Må gå tilbake til home etter hver test for at de skal plukke opp fra start
		
		
    }
	//private FxApp fxApp;
			
	//@Before
	//public void setUp(Stage stage) throws IOException {
		
	//}
	@Test
	public void go_to_register_and_cancel() {
		clickOn("#RegisterBtn");
		sleep(1000);
		Button button = lookup("#closeBtn").query();
		assertEquals(button.getText(), "Cancel");
		clickOn("#closeBtn");
	}
	@Test
	public void navigate_useless_scenes() {
		//Goes through scenes not currently in use, only to check that the system doesn't
		//crash.
		//Goes to strength and cardio, clicks home cancel for both, goes to past, clicks home
		Button button = new Button();
		clickOn("#goNew");
		sleep(1000);
		clickOn("#cardioBtn");
		sleep(1000);
		button = lookup("#CancelCardioWorkout").query();
		assertEquals(button.getText(), "Cancel");
		clickOn("#CancelCardioWorkout");
		sleep(1000);
		clickOn("#goNew");
		sleep(1000);
		clickOn("#strengthBtn");
		sleep(1000);
		button = lookup("#CancelStrengthWorkout").query();
		assertEquals(button.getText(), "Cancel");
		clickOn("#CancelStrengthWorkout");
		//Test past workout
		sleep(1000);
		clickOn("#goPast");
		sleep(1500);
		button = lookup("#HomeBtn").query();
		assertEquals(button.getText(), "Home");
		clickOn("#HomeBtn");
		
	}
	@Test
	public void register_user() {
		clickOn("#RegisterBtn");
		sleep(1000);
		clickOn("#usernameField");
		write("testFxBoy");
		clickOn("#nameField");
		write("Mr.TestFx");
		clickOn("#addressField");
		write("computer");
		clickOn("#cityField");
		write("Trondheim");
		clickOn("#phoneField");
		write("1234");
		clickOn("#emailField");
		write("hasselhoff@yahoo");
		clickOn("#passwordField");
		write("test");
		clickOn("#confirmPasswordField");
		write("test");
		clickOn("#confirmBtn");
	}
	
	//TEster ikke login mye enda da login ikke fungerer
	@Test 
	public void log_in_invalid_password() {
		clickOn("#LoginBtn");
		sleep(500);
		clickOn("#userNameField");
		write("testFxBoy");
		clickOn("#passwordField");
		write("wrong");
		clickOn("#confirmBtn");
		sleep(3000);
		Label label = lookup("#loginText").query();
		assertEquals(label.getText(), "Wrong input");
		clickOn("#closeBtn");
	}
	@Test 
	public void log_in_invalid_username() {
		clickOn("#LoginBtn");
		sleep(500);
		clickOn("#userNameField");
		write("nonexistant");
		clickOn("#passwordField");
		write("test");
		clickOn("#confirmBtn");
		sleep(3000);
		Label label = lookup("#loginText").query();
		assertEquals(label.getText(), "Wrong input");
		clickOn("#closeBtn");
	}
	/*
	@Test 
    public void log_in_invalid_name() {
    	BorderPane rootNode = (BorderPane) this.scene.getRoot();//Testes som Parent
        Button button = from(rootNode).lookup("#LoginBtn").query();
        assertEquals("Log in", button.getText());*/
    	//clickOn("#LoginBtn");
        // expect:
    	//Button btn = find("#LoginBtn");
        //verifyThat("#LoginBtn", containsString("Log in"));
        //assertEquals("test@gmail.com", lookup("#email").<TextField>().getText());
	@Test 
	public void log_in() {
		clickOn("#LoginBtn");
		sleep(500);
		clickOn("#userNameField");
		write("testFxBoy");
		clickOn("#passwordField");
		write("test");
		clickOn("#confirmBtn");
		sleep(3000);
		Label label = lookup("#loginText").query();
		assertEquals(label.getText(), "Logged in as Mr.TestFx");
		clickOn("#closeBtn");
	}

    @Test
    public void delete_user_try_login() {
    	//Sletter opprettet bruker for  deretter å teste login på nytt
    	Database dbTest = new Database();
    	dbTest.deleteUser("testFxBoy");
    	
    	clickOn("#LoginBtn");
		sleep(500);
		clickOn("#userNameField");
		write("testFxBoy");
		clickOn("#passwordField");
		write("test");
		clickOn("#confirmBtn");
		sleep(3000);
		Label label = lookup("#loginText").query();
		assertEquals(label.getText(), "Wrong input");
		clickOn("#closeBtn");
    }
}
