package tdt4140.gr1836.app.ui;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import com.jfoenix.controls.JFXTextField;

import javafx.application.Platform;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import tdt4140.gr1836.app.inbox.Message;
import tdt4140.gr1836.app.users.UserTempList;

@SuppressWarnings("restriction")
public class InboxController extends Controller {

	@FXML
	private JFXTextField messageField;
	@FXML
	private JFXTextField searchField;
	@FXML
	private VBox messageFrame;
	@FXML
	private VBox people;
	@FXML
	private ScrollPane scrollpane;
	@FXML
	private VBox infoPanel;
	String currentChat = "default";
	Image profile;
	boolean first = false;
	Map<String, UserTempList> nodeMap = new HashMap<String, UserTempList>();

	public void initialize() {
		// Get coaches/users
		// Also make listeners to load chat for EACH label :(
		Platform.runLater(() -> {
			generatePeople();
			// For auto scroll on new message
			scrollpane.vvalueProperty().bind(messageFrame.heightProperty());

			initSearchListener();
		});
	}

	private void initSearchListener() {
		searchField.textProperty().addListener(new ChangeListener<String>() {
			@Override
			public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
				if (oldValue != newValue) {
					search(newValue);
				}
			}
		});

	}

	private void search(String newValue) {
		// generateCoaches with search value
		for (Node n : people.getChildren()) {
			if (nodeMap.get(n.getId()).getName().matches("(?i)(" + newValue + ").*")) {
				n.setManaged(true);
				n.setVisible(true);
			} else {
				n.setManaged(false);
				n.setVisible(false);
			}
		}

	}

	private void generatePeople() { // works for coaches and users!!
		// TODO Auto-generated method stub
		ArrayList<UserTempList> tempcoaches = parsePeople();
		// add hbox to coaches
		// with image and label
		profile = new Image(getClass().getResourceAsStream("images/ic_account_circle_white_24dp_2x.png"));

		for (UserTempList u : tempcoaches) {

			ImageView imageView = new ImageView(profile);
			HBox hbox = new HBox();
			Label label = new Label();

			imageView.setFitHeight(31);
			imageView.setPreserveRatio(true);

			label.textProperty().setValue(u.getName());
			label.setStyle("-fx-padding: 15 10 15 10;");

			hbox.setStyle("-fx-pref-height: 40; -fx-pref-width: 219; -fx-padding:0 0 0 30;");
			hbox.getStyleClass().add("btn");
			hbox.setAlignment(Pos.CENTER_LEFT);

			hbox.getChildren().add(imageView);
			hbox.getChildren().add(label);

			people.getChildren().add(hbox);

			// map to find nodes when searching
			hbox.setId("" + new Date().getTime());
			nodeMap.put(hbox.getId(), u);

			// event listener
			hbox.addEventFilter(MouseEvent.MOUSE_CLICKED, mouseEvent -> {
				loadChat(u);
			});
			// load first coach as default
			if (!first) {
				first = true;
				loadChat(u);
			}

		}

	}

	private void loadChat(UserTempList u) {

		// Check if not clicked on same thing
		if (!currentChat.equals(u.getUsername())) {
			currentChat = u.getUsername();

			// remove children
			messageFrame.getChildren().clear();
			infoPanel.getChildren().clear();

			// Set infoPanel
			ImageView imv = new ImageView(profile);
			Label label = new Label(u.getName());
			infoPanel.getChildren().add(imv);
			infoPanel.getChildren().add(label);

			// Get chatlog from database
			ArrayList<Message> messages = app.getMessages(u.getUsername());

			// change styling of messageframe to fit messages
			messageFrame.setAlignment(Pos.BOTTOM_CENTER);
			messageFrame.setSpacing(20);
			messageFrame.setPadding(new Insets(20));

			// Then add hboxes with chatboxes n imageframes nais

			if (messages != null) {
				for (Message m : messages) {
					addMessage(m);
				}
			}

		}

	}

	private void addMessage(Message m) {
		HBox hbox = new HBox();
		ImageView imv = new ImageView(profile);
		Label label = new Label();

		// only difference is alignment and where children are placed
		if (app.getUser().getUsername().equals(m.getFrom())) {
			hbox.getChildren().add(label);
			hbox.getChildren().add(imv);
			hbox.setAlignment(Pos.TOP_RIGHT);

		} else {
			hbox.getChildren().add(imv);
			hbox.getChildren().add(label);
			hbox.setAlignment(Pos.TOP_LEFT);
		}
		hbox.setSpacing(10);
		hbox.setFillHeight(true);

		imv.setFitHeight(31);
		imv.setPreserveRatio(true);

		label.setWrapText(true);
		label.setMaxWidth(250);

		// calc text layout bounds :SS
		Text text = new Text(m.getMessage());
		text.setWrappingWidth(0);
		text.maxWidth(250);

		double width = text.getLayoutBounds().getWidth();

		label.setText(m.getMessage());
		label.setPrefWidth(width + 10);
		// label.setPrefHeight(Math.ceil(width/250)*height+10);

		label.getStyleClass().add("message");

		messageFrame.getChildren().add(hbox);
	}

	private ArrayList<UserTempList> parsePeople() {
		ArrayList<UserTempList> temp;
		if (app.getUser().getIsCoach()) {
			temp = app.getUsersAsList();
		} else {
			temp = app.getCoachesAsList();
		}
		// old search implementation
		/*
		 * Iterator<UserTempList> i = temp.iterator(); while (i.hasNext()) { if
		 * (!i.next().getUsername().matches("(?i)(" + searchText + ").*")) { i.remove();
		 * }
		 * 
		 * }
		 */
		return temp;
	}

	@FXML
	private void send() { // Function to send string to database lol
		app.sendMessage(messageField.getText(), currentChat);
		addMessage(new Message(messageField.getText(), currentChat, app.getUser().getUsername()));
		messageField.setText("");

	}

	@FXML
	private void goBack() throws IOException { // go to main menu
		this.showScene(LayoutHandler.mainCoachPane, getRoot(), this.app);
	}

}
