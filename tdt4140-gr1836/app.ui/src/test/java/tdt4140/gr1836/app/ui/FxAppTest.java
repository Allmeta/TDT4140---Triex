package tdt4140.gr1836.app.ui;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

import java.io.IOException;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;

import org.junit.Test;
import org.testfx.api.FxRobot;
import org.testfx.framework.junit.ApplicationTest;

import com.jfoenix.controls.JFXButton;

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
        DummyApp app = new DummyApp();
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(FxApp.class.getResource(LayoutHandler.loginPane));	
		Parent root = loader.load();
		
		Scene scene = new Scene(root, 380, 550);
		stage.setScene(scene);
		stage.setTitle("Testing training app");
		
		//Set app to controller
		NavigationHandler controller = loader.getController();
		controller.setApp(app);
		
		stage.show();
		}
    }
	//@Before
	//}
	/*
		@Test 
	public void testNavigation() {
			 Test Register
			clickOn("#signUpButton");
			sleep(1000);
			JFXButton button = lookup("#cancelButton").query();
			assertEquals(button.getText(), "Cancel");
			clickOn("#cancelButton");
			
			
			sleep(500);
			clickOn("#usernameField");
			write("testFxBoy");
			clickOn("#passwordField");
			write("test");
			clickOn("#loginButton");
			sleep(500);
			//Check that you are in main menu
			Label newbutton = lookup("#newWorkoutButton").query();
			assertEquals(newbutton.getText(), "New workout");
		
			clickOn("#newWorkoutButton");
			sleep(500);
			clickOn("#durationField");
			write("60");
			clickOn("#distanceField");
			write("10");
			clickOn("#pulseField");
			write("160");
			clickOn("#dateField");
			write("04.04.2018");
			clickOn("#submitButton");
			sleep(500);

			clickOn("#historyButton");
			sleep(500);
			clickOn("#backButton");
			
			sleep(500);
			clickOn("#statisticsButton");
			sleep(1000);
			*/
			
		/*
		velg coach
		skriv melding til coach
		se statistikk
		velg friend
		
		log ut
		log in coach
		se your clients
		se statistikk
		se history
		send melding
		*/
	}

		/*
	@Test
	public void t1_go_to_register_and_cancel(FxRobot robot) {
		robot.clickOn("#signUpButton");
		sleep(1000);
		JFXButton button = lookup("#cancelButton").query();
		assertEquals(button.getText(), "Cancel");
		robot.clickOn("#cancelButton");
		startFlag=false;
	}
	
	@Test
	public void t2_register_user() {
		//Registrerer ikke med dummyapp, men tester bare javafx
		sleep(200);
		clickOn("#signUpButton");
		sleep(2000);
		clickOn("#usernameField");
		sleep(200);
		write("testFxBoy");
		clickOn("#nameField");
		write("Mr.TestFx");
		clickOn("#ageField");
		write("22");
		clickOn("#heightField");
		write("180");
		clickOn("#weightField");
		write("80");
		clickOn("#cityField");
		write("Trondheim");
		clickOn("#passwordField");
		write("test");
		clickOn("#passwordConfirmationField");
		write("test");
		clickOn("#submitButton");
	}
	@Test 
	public void t3_log_in_invalid_password() {
		sleep(200);
		clickOn("#usernameField");
		write("testFxBoy");
		clickOn("#passwordField");
		write("wrong");
		clickOn("#loginButton");
		sleep(500);
		Label label = lookup("#invalidLabel").query();
		assertEquals(label.getText(), "Invalid login");
	}
	@Test 
	public void t4_log_in_invalid_username() {
		sleep(200);
		clickOn("#usernameField");
		write("nonexistant");
		clickOn("#passwordField");
		write("test");
		clickOn("#loginButton");
		sleep(500);
		Label label = lookup("#invalidLabel").query();
		assertEquals(label.getText(), "Invalid login");
		
	}
	@Test 
	public void t5_log_in() {
		sleep(200);
		sleep(500);
		clickOn("#usernameField");
		write("testFxBoy");
		clickOn("#passwordField");
		write("test");
		clickOn("#loginButton");
		sleep(500);
		//Check that you are in main menu
		JFXButton newbutton = lookup("#logoutButton").query();
		//sleep(500);
		//assertEquals(newbutton.getText(), "Log out (testFxBoy");
		startFlag=false;
	}
}*/