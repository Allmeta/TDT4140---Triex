package tdt4140.gr1836.app.ui;

import java.io.IOException;

import javafx.fxml.FXML;

public class MainViewController {
	
	@FXML
	private void goHome() throws IOException {
		FxApp.showMainItems();
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
