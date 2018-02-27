package tdt4140.gr1836.app.ui;



import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class AddNewUserController {
	
	//Contact information
	
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
	
	@FXML public Button closeBtn;
	
	@FXML 
	public void closeNewUserStage(ActionEvent event) {
	    Stage stage = (Stage) closeBtn.getScene().getWindow();
	    stage.close();
	}
	
	
	//TODO: ON submit: Function that stores the information in the database
	

}
