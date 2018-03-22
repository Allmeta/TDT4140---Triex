
package tdt4140.gr1836.app.ui;



import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.stage.Stage;
@SuppressWarnings("restriction")
public class AddNewUserController extends Controller {
	
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
	private RadioButton standardUser;
	
	@FXML
	private RadioButton coachUser;
	
	@FXML
	private ToggleGroup asd;
	
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
		if ((usernameField != null || usernameField.getLength() != 0) && (passwordField != null || passwordField.getLength() != 0)) {
			this.app.register(usernameField.getText(), nameField.getText(), 20, cityField.getText(), emailField.getText(), addressField.getText(), phoneField.getText(), passwordField.getText(),coachUser.isSelected());
			//age and sex must be added
			Stage stage = (Stage) confirmBtn.getScene().getWindow();
			stage.close();
		}
		//Trenger label til å presentere konfirmasjon
	}
	
	



}
