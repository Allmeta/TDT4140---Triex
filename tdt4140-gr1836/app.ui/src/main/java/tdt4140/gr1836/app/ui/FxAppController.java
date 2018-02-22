package tdt4140.gr1836.app.ui;


import java.awt.Button;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.PrintWriter;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class FxAppController {
	
	@FXML 
	private Label labelStatus;
	
	@FXML 
	private TextField txtUsername;
	
	@FXML 
	private TextField txtPassword;
	
	@FXML 
	private TextField newUsername;
	
	@FXML 
	private TextField newPassword;
	
	//Create primarystage
	Stage primaryStage = new Stage();
	
	//Login
	public void Login(ActionEvent event) throws Exception{
		if(txtUsername.getText().equals("username") && txtPassword.getText().equals("password")) {
			labelStatus.setText("Login Succeded");
			
			
	
			//Open primary window
			Parent root = FXMLLoader.load(getClass().getResource("Main.fxml"));
			Scene primaryScene = new Scene(root,1200,800);
			primaryStage.setScene(primaryScene);
			primaryStage.show();
			
			

		} else {
			labelStatus.setText("Login Failed");
		}
		
	}
	
	
	
	//Create new user
	public void CreateUser(ActionEvent event) throws Exception {
		
		//Open create user window
		Parent root = FXMLLoader.load(getClass().getResource("NewUser.fxml"));
		Scene createUserScene = new Scene(root,300,500);
		primaryStage.setScene(createUserScene);
		primaryStage.show();
		
		
	}
	
	
	//Submit new user - write to "database"
	public void Submit(ActionEvent event) throws Exception {

	    BufferedWriter writer = new BufferedWriter(new FileWriter("database.txt", true));
	    
	    String temp1 = ("NEW USER ");
	    String temp2 = ("Username: ");
	    String temp3 = ("Password: ");
	    
	    writer.append(temp1);
	    writer.append(temp2);
	    writer.append(newUsername.getText());
	    writer.append(temp3);
	    writer.append(newPassword.getText());
	    writer.append(' ');
	    writer.close();
	}
	
	
	
	

	
	
}
