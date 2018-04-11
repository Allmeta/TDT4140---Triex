package tdt4140.gr1836.app.ui;

import java.io.IOException;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;

public class CoachMenuController extends Controller {

	@FXML
	private Label logoutButton;

	@FXML
	private void initialize() {
		// load username in logout button
		Platform.runLater(() -> {
			// logoutButton.setText("Log out (" + app.getUser().getUsername() + ")");
		});
	}

	@FXML
	private void onInbox(MouseEvent event) {

	}

	@FXML
	private void onClients() {
		try {
			showScene(LayoutHandler.clientsPane, this.getRoot(), this.app);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@FXML
	private void onLogOut(MouseEvent event) {
		try {
			showScene(LayoutHandler.loginPane, this.getRoot(), this.app);

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
