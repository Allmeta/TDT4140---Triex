package tdt4140.gr1836.app.ui;

import java.io.IOException;

import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class BottomMenuController extends Controller {
	
	@FXML
	private Button LoginBtn;
	@FXML
	private Button RegisterBtn;
	@FXML
	private Button HomeBtn;
	
	
	@FXML
	private void goHome() throws IOException {
		this.fxAppParent.showScene("MainMenu.fxml");
	}
	
	@FXML
	private void addBtn() throws IOException {
		this.fxAppParent.showAddStage();
	}
	
	@FXML
	private void LoginBtn() throws IOException {
		this.fxAppParent.showLoginStage();
	}
}
