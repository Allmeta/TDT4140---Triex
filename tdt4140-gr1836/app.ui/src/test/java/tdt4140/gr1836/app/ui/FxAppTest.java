package tdt4140.gr1836.app.ui;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

import java.io.IOException;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;

import org.junit.Test;
import org.testfx.framework.junit.ApplicationTest;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)

public class FxAppTest extends ApplicationTest {
	
	@BeforeClass
	public static void headless() {
		if (Boolean.valueOf(System.getProperty("gitlab-ci", "false")))
		GitlabCISupport.headless();
	}
	private static boolean startFlag=true;
	
	@Override
    public void start(Stage stage) throws Exception {
		if (startFlag==true) {
		System.out.println("Start");
        DummyApp app = new DummyApp();
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(FxApp.class.getResource("Login.fxml"));	
		Parent root = loader.load();
		
		Scene scene = new Scene(root, 380, 550);
		stage.setScene(scene);
		stage.setTitle("Testing training app");
		
		//Set app to controller
		Controller controller = loader.getController();
		controller.setApp(app);
		
		stage.show();
		}
    }
	//@Before
	//}
	@Test
	public void t1_go_to_register_and_cancel() {
		clickOn("#RegisterBtn");
		sleep(1000);
		Button button = lookup("#closeBtn").query();
		assertEquals(button.getText(), "Cancel");
		clickOn("#closeBtn");
	}
	
	@Test
	public void t2_register_user() {
		//Registrerer ikke med dummyapp, men tester bare javafx
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
	public void t3_log_in_invalid_password() {
		clickOn("#userNameField");
		write("testFxBoy");
		clickOn("#passwordField");
		write("wrong");
		clickOn("#submitBtn");
		sleep(500);
		Label label = lookup("#loginText").query();
		assertEquals(label.getText(), "Wrong input");
	}
	@Test 
	public void t4_log_in_invalid_username() {
		clickOn("#userNameField");
		write("nonexistant");
		clickOn("#passwordField");
		write("test");
		clickOn("#submitBtn");
		sleep(500);
		Label label = lookup("#loginText").query();
		assertEquals(label.getText(), "Wrong input");
		
	}
	/*
	@Test 
    public void log_in_invalid_name() {
    	BorderPane rootNode = (BorderPane) this.scene.getRoot();//Testes som Parent
        Button button = from(rootNode).lookup("#LoginBtn").query();
        assertEquals("Log in", button.getText());*/

	@Test 
	public void t5_log_in() {
		sleep(500);
		clickOn("#userNameField");
		write("testFxBoy");
		clickOn("#passwordField");
		write("test");
		clickOn("#submitBtn");
		sleep(500);
		//Check that you are in main menu
		Button newbutton = lookup("#goNew").query();
		assertEquals(newbutton.getText(), "Add new workout");
		
		//Heretter skal ikke login eller register testes mer
		startFlag=false;
	}
	@Test
	public void t6_navigate_useless_scenes() {
		//Goes through scenes not currently in use, only to check that the system doesn't crash.
		//Goes to strength and cardio, clicks home cancel for both, goes to past, clicks home
		sleep(1000);
		Button button = new Button();
		clickOn("#goNew");
		sleep(100);
		clickOn("#cardioBtn");
		sleep(1000);
		button = lookup("#CancelCardioWorkout").query();
		assertEquals(button.getText(), "Cancel");
		clickOn("#CancelCardioWorkout");
		sleep(100);
		clickOn("#goNew");
		sleep(100);
		clickOn("#strengthBtn");
		sleep(1000);
		button = lookup("#CancelStrengthWorkout").query();
		assertEquals(button.getText(), "Cancel");
		clickOn("#CancelStrengthWorkout");
		//Test past workout
	}
/*
    @Test Denne er kanskje ikke nødvendig for ui testing
    public void delete_user_try_login() {
    	//Sletter opprettet bruker for  deretter å teste login på nytt
    	//Må endres til sletter i textfil
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
    }*/
}
