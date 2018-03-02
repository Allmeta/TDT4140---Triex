package tdt4140.gr1836.app.ui;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import org.json.JSONObject;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class FxApp extends Application {

	private static Stage primaryStage;
	private static BorderPane mainLayout;
	public class User implements Serializable{
		public String name,food;
		
		public User(String name, String food) {
			this.name=name;
			this.food=food;
		}
	}

	@Override
	public void start(Stage primaryStage) throws IOException {
		FxApp.primaryStage = primaryStage;
		FxApp.primaryStage.setTitle("Training App");

		// init firebase
		FileInputStream serviceAccount = new FileInputStream("tdt4140-g36-firebase-adminsdk-u74mt-fa295def3e.json");

		FirebaseOptions options = new FirebaseOptions.Builder()
				.setCredentials(GoogleCredentials.fromStream(serviceAccount))
				.setDatabaseUrl("https://tdt4140-g36.firebaseio.com").build();

		FirebaseApp.initializeApp(options);

		DatabaseReference ref = FirebaseDatabase.getInstance().getReference();
		ref.addListenerForSingleValueEvent(new ValueEventListener() {
			@Override
			public void onDataChange(DataSnapshot dataSnapshot) {
				Object res = dataSnapshot.getValue();
				System.out.println(res);
			}

			@Override
			public void onCancelled(DatabaseError arg0) {
				// TODO Auto-generated method stub
				System.out.println("fk");
				
			}
		});
		
		//Pushe til database
		//DatabaseReference child=ref.push();
		//User test= new User("Johan", "Eple");
		//child.setValueAsync(test);
		

		// Loads the two main menu scenes into the primary stage
		showMainView();
		showScene("MainMenu.fxml");

	}
	

	// Shows the tool bar menu at the bottom of the primary stage
	private void showMainView() throws IOException {
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(FxApp.class.getResource("BottomMenu.fxml"));
		mainLayout = loader.load();
		Scene scene = new Scene(mainLayout, 600, 600);
		primaryStage.setScene(scene);
		primaryStage.show();
	}

	// Shows the MainItems.fxml, pastWorkout.fxml, strengthWorkout.fxml,
	// cardioWorkout.fxml
	public static void showScene(String scene) throws IOException {
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(FxApp.class.getResource(scene));
		BorderPane mainItems = loader.load();
		mainLayout.setCenter(mainItems);
	}

	// Loads and shows the add new user stage
	public static void showAddStage() throws IOException {
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(FxApp.class.getResource("AddNewUser.fxml"));
		BorderPane addNewUser = loader.load();

		Stage addDialogStage = new Stage();
		addDialogStage.setTitle("Add new User");
		addDialogStage.initModality(Modality.WINDOW_MODAL);
		addDialogStage.initOwner(primaryStage);
		Scene scene = new Scene(addNewUser);
		addDialogStage.setScene(scene);
		addDialogStage.show();
	}

	// Loads and shows the login stage
	public static void showLoginStage() throws IOException {
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(FxApp.class.getResource("Login.fxml"));
		BorderPane Login = loader.load();

		Stage LoginStage = new Stage();
		LoginStage.setTitle("Log in");
		LoginStage.initModality(Modality.WINDOW_MODAL);
		LoginStage.initOwner(primaryStage);
		Scene scene = new Scene(Login);
		LoginStage.setScene(scene);
		LoginStage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}

}
