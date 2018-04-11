package tdt4140.gr1836.app.ui;

import java.io.IOException;
import java.util.ArrayList;

import com.jfoenix.controls.JFXTextField;
import com.sun.prism.paint.Color;
import com.jfoenix.controls.JFXSpinner;

import javafx.fxml.FXML;
import tdt4140.gr1836.app.inbox.Message;
import tdt4140.gr1836.app.users.UserTempList;
import javafx.application.Platform;
import javafx.scene.layout.*;
import javafx.scene.text.Text;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextArea;
import javafx.scene.image.ImageView;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;

public class InboxController extends Controller {

	@FXML
	private JFXTextField messageField;
	@FXML
	private JFXTextField searchField;
	@FXML
	private VBox messageFrame;
	@FXML
	private VBox coaches;
	@FXML private ScrollPane scrollpane;
	String currentChat = "default";
	Image profile;

	public void initialize() {
		// Get coaches/users
		// Also make listeners to load chat for EACH label :(
		Platform.runLater(() -> {
			generateCoaches();
			scrollpane.vvalueProperty().bind(messageFrame.heightProperty());
		});
	}

	private void generateCoaches() { //works for coaches and users!!
		// TODO Auto-generated method stub
		ArrayList<UserTempList> tempcoaches = parsePeople();
		// add hbox to coaches
		// with image and label
		boolean first = false;
		profile=new Image(getClass().getResourceAsStream("ic_account_circle_white_24dp_2x.png"));

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

			coaches.getChildren().add(hbox);

			// event listener
			hbox.addEventFilter(MouseEvent.MOUSE_CLICKED, mouseEvent -> {
				loadChat(u);
			});

		}

	}

	private void loadChat(UserTempList u) {

		// Check if not clicked on same thing
		if (!currentChat.equals(u.getUsername())) {
			currentChat=u.getUsername();
			
			//remove children
			messageFrame.getChildren().clear();

			// First make preloader
			JFXSpinner s = new JFXSpinner();
			messageFrame.getChildren().add(s);

			// Get chatlog from database
			ArrayList<Message> messages = app.getMessages(u.getUsername());

			// Then remove preloader
			messageFrame.getChildren().remove(s);

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
		HBox hbox=new HBox();
		ImageView imv=new ImageView(profile);
		TextArea ta=new TextArea();
		
		//only difference is alignment and where children are placed
		if(app.getUser().getUsername().equals(m.getFrom())) {
			hbox.getChildren().add(ta);
			hbox.getChildren().add(imv);
			hbox.setAlignment(Pos.TOP_RIGHT);
			
		}else {
			hbox.getChildren().add(imv);
			hbox.getChildren().add(ta);
			hbox.setAlignment(Pos.TOP_LEFT);
		}
		hbox.setSpacing(10);
		
		imv.setFitHeight(31);
		imv.setPreserveRatio(true);
		
		
		ta.setEditable(false);
		ta.setWrapText(true);
		ta.setMinHeight(31);
		ta.setMaxWidth(250);
		
		//calc text layout bounds :SS
		Text text=new Text(m.getMessage());
		double width=text.getLayoutBounds().getWidth();
		double height=text.getLayoutBounds().getHeight();
		
		ta.setPrefHeight(200);
		ta.setPrefRowCount((int) (Math.ceil(width/250)*height));
		ta.setPrefWidth(width+10);
		
		ta.setText(m.getMessage());
		
		ta.getStyleClass().add("message");
		
		messageFrame.getChildren().add(hbox);
	}
	private ArrayList<UserTempList> parsePeople() {
		if (app.getUser().getIsCoach())
			return app.getUsersAsList();
		else
			return app.getCoachesAsList();
	}

	@FXML
	private void send() { // Function to send string to database lol
		app.sendMessage(messageField.getText(), currentChat);
		addMessage(new Message(messageField.getText(),currentChat,app.getUser().getUsername()));
		messageField.setText("");

	}


	@FXML
	private void goBack() throws IOException { // go to main menu
		this.showScene("MainMenu.fxml", getRoot(), this.app);
	}

}
