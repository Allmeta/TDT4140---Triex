package tdt4140.gr1836.app.ui;

import java.io.IOException;

import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class BottomMenuController {
	
	@FXML
	private Button LoginBtn;
	
	@FXML
	private void goHome() throws IOException {
		FxApp.showScene("MainMenu.fxml");
	}
	
	@FXML
	private void addBtn() throws IOException {
		FxApp.showAddStage();
	}
	
	@FXML
	private void LoginBtn() throws IOException {
		FxApp.showLoginStage();
	}
}
