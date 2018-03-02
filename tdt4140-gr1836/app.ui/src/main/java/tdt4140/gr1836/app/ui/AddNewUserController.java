package tdt4140.gr1836.app.ui;



import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class AddNewUserController {
	
	//Contact information
	
	@FXML
	private TextField usernameField;
	
	@FXML
	private TextField nameField;
	
	@FXML
	private TextField addressField;
	
	@FXML
	private TextField cityField;
	
	@FXML
	private TextField phoneField;
	
	@FXML
	private TextField emailField;
	
	@FXML
	private PasswordField passwordField;
	
	@FXML
	private PasswordField confirmPasswordField;
	
	
	@FXML 
	public Button closeBtn;
	
	@FXML 
	public Button confirmBtn;
	
	@FXML 
	public void closeNewUserStage(ActionEvent event) throws IOException {
	    Stage stage = (Stage) closeBtn.getScene().getWindow();
	    stage.close();
	}
	
	@FXML 
	public void SubmitNewUser(ActionEvent event) throws IOException {
		
		//TODO: ON submit: Function that stores the information in the database
		
		//Database.register(String username,String name, int age, String city, String email, String adress,int phone, String password);
		
	    Stage stage = (Stage) confirmBtn.getScene().getWindow();
	    stage.close();
	}
	
	

	

}
