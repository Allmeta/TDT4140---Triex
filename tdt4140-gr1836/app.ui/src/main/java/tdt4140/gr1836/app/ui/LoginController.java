package tdt4140.gr1836.app.ui;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import tdt4140.gr1836.app.core.User;

public class LoginController extends Controller {
	
	@FXML
	private TextField userNameField;
	
	@FXML
	private TextField passwordField;
	
	@FXML
	private Label loginText;
	
	@FXML
	public Button closeBtn;
	@FXML 
	public Button confirmBtn;
	
	@FXML //Function that closes the login stage when submit button is pressed
	public void submitLoginStage(ActionEvent event) {
		//Works!
		//Need to add functionality to wait for database input, it's not instantaneous
		if (userNameField != null || userNameField.getLength() != 0) {
			User user= this.app.login(userNameField.getText(), passwordField.getText());
			if (user==null) {
				loginText.setText("Wrong input");
			}
			else {
				loginText.setText("Logged in as " + user.name);
			}
		}
	}
	@FXML 
	public void closeLoginStage(ActionEvent event) {
		Stage stage = (Stage) closeBtn.getScene().getWindow();
	    stage.close();
	}

}
