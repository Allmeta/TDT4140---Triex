package tdt4140.gr1836.app.ui;

import java.io.IOException;

import javafx.fxml.FXML;

public class MainViewController {
	
	private FxApp main;
	
	
	@FXML
	private void goHome() throws IOException {
		main.showMainItems();
	}
	
	@FXML
	private void addBtn() throws IOException {
		main.showAddStage();
	}
	
	@FXML
	private void LoginBtn() throws IOException {
		main.showLoginStage();
	}
}
