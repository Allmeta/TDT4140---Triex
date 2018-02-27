package tdt4140.gr1836.app.ui;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class LoginController {
	
	@FXML
	private TextField userNameField;
	
	@FXML
	private TextField passwordField;
	
	@FXML
	public Button closeBtn;
	
	@FXML //Function that closes the login stage when submit button is pressed
	public void closeLoginStage(ActionEvent event) {

		//This should check that information has been entered but sadly it does not work
		if (userNameField != null || userNameField.getLength() != 0) {
	    Stage stage = (Stage) closeBtn.getScene().getWindow();
	    stage.close();
		}
	}
	
	//TODO: Function that checks login information against users in database.


}
