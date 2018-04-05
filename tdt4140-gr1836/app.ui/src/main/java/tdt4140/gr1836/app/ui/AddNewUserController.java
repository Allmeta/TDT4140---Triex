
package tdt4140.gr1836.app.ui;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXRadioButton;
import com.jfoenix.controls.JFXTextField;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import tdt4140.gr1836.app.ui.Controller;

public class AddNewUserController extends Controller {
	
	@FXML JFXTextField usernameField;
	@FXML JFXTextField nameField;
	@FXML JFXTextField addressField;
	@FXML JFXTextField cityField;
	@FXML JFXTextField phoneField;
	@FXML JFXTextField emailField;
	
	@FXML JFXRadioButton coachRadioButton;
	
	@FXML JFXPasswordField passwordField;
	@FXML JFXPasswordField passwordConfirmationField;
	
	@FXML Label invalidLabel;
	
	@FXML JFXButton cancelButton;
	
	/*
	 * This function is called when user presses submit button.
	 * Check is username field and both password fields have text in them and if password is equal in the two password fields.
	 * If required fields are valid user is created and window is closed.
	 * If form is not valid a labels text will tell the user to fill out required fields.
	 */
	@FXML
	private void onSubmit() {
		if(!usernameField.getText().equals("") 
				&& !passwordField.getText().equals("")
				&& passwordField.getText().equals(passwordConfirmationField.getText())) {
		
			this.app.register(usernameField.getText(), 
					nameField.getText(),
					20, cityField.getText(),
					emailField.getText(),
					addressField.getText(),
					phoneField.getText(),
					passwordField.getText(),
					coachRadioButton.isSelected());
			
			Stage stage = (Stage) cancelButton.getScene().getWindow();
			stage.close();
		
		} else {
			invalidLabel.setText("Please fill out all required fields");
		}
	}
	
	/*
	 * Closes window when user press cancel button.
	 */
	@FXML
    private void onCancel() {
		Stage stage = (Stage) cancelButton.getScene().getWindow();
	    stage.close();
    }
	
}
