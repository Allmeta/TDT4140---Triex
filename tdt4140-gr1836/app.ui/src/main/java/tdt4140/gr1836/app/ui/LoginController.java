package tdt4140.gr1836.app.ui;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

import java.io.IOException;


import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import tdt4140.gr1836.app.users.User;

@SuppressWarnings("restriction")
public class LoginController extends Controller {
	
	@FXML
    private JFXTextField usernameField;

    @FXML
    private JFXPasswordField passwordField;

    @FXML
    private JFXButton loginButton;

    @FXML
    private JFXButton signUpButton;

    @FXML
    private Label invalidLabel;
    
    @FXML
    private void onLogin() {
    	//Main.loadScene("Graph.FXML");
    }
    
    @FXML private void onSignUp() {
    	//Main.loadScene("Register.FXML");
    }
}
