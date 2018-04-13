package tdt4140.gr1836.app.ui;

import java.io.IOException;
import java.util.Map;

import com.jfoenix.controls.JFXTextField;
import com.jfoenix.controls.JFXTreeTableView;
import com.jfoenix.controls.RecursiveTreeItem;
import com.jfoenix.controls.datamodels.treetable.RecursiveTreeObject;

import javafx.application.Platform;
import javafx.beans.property.ReadOnlyStringWrapper;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeTableColumn;
import tdt4140.gr1836.app.users.User;

public class AvailableCoachesController extends Controller {
	/*
	 * @FXML private Button homeBtn;
	 */
	private Map<String, User> allCoaches;
	@FXML
	private Label coachLabel;
	@FXML
	private JFXTextField selectedCoach;

	@FXML
	private JFXTreeTableView<TempUser> tableView;

	@FXML
	private TreeTableColumn<TempUser, String> usernameColumn;

	@FXML
	private TreeTableColumn<TempUser, String> nameColumn;

	@FXML
	private TreeTableColumn<TempUser, String> cityColumn;

	@FXML
	private TreeTableColumn<TempUser, String> ageColumn;

	@FXML
	private TreeTableColumn<TempUser, String> randomColumn;

	@FXML
	public void initialize() {
		Platform.runLater(() -> {
			setCoaches();
		});
	}

	@FXML
	private void onBack() {
		try {
			showScene(LayoutHandler.mainUserPane, this.getRoot(), this.app);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	/*
	 * private ArrayList<User> parseCoaches() { return this.app.getCoachesAsList();
	 * }
	 */

	private void setCoaches() {
		// fill stuff
		/*
		 * name.setCellValueFactory(new PropertyValueFactory<UserTempList,
		 * String>("name")); city.setCellValueFactory(new
		 * PropertyValueFactory<UserTempList, String>("city"));
		 * age.setCellValueFactory(new PropertyValueFactory<UserTempList,
		 * String>("age")); email.setCellValueFactory(new
		 * PropertyValueFactory<UserTempList, String>("email"));
		 * 
		 * view.getItems().setAll(parseCoaches());
		 */
		String myCoach = this.app.getUser().getMyCoach();
		if (!myCoach.equals("")) {
			coachLabel.setText("Your current coach is " + myCoach + ", do you want someone else?");
		}
		usernameColumn.setCellValueFactory(
				(TreeTableColumn.CellDataFeatures<TempUser, String> param) -> new ReadOnlyStringWrapper(
						param.getValue().getValue().getUsername()));
		nameColumn.setCellValueFactory(
				(TreeTableColumn.CellDataFeatures<TempUser, String> param) -> new ReadOnlyStringWrapper(
						param.getValue().getValue().getName()));
		cityColumn.setCellValueFactory(
				(TreeTableColumn.CellDataFeatures<TempUser, String> param) -> new ReadOnlyStringWrapper(
						param.getValue().getValue().getCity()));
		ageColumn.setCellValueFactory(
				(TreeTableColumn.CellDataFeatures<TempUser, String> param) -> new ReadOnlyStringWrapper(
						param.getValue().getValue().getAge()));
		randomColumn.setCellValueFactory(
				(TreeTableColumn.CellDataFeatures<TempUser, String> param) -> new ReadOnlyStringWrapper(
						param.getValue().getValue().getRandom()));

		// data
		ObservableList<TempUser> coaches = FXCollections.observableArrayList();

		loadCoaches(coaches);
		// Burde sortere coaches etter username her

		// build tree
		final TreeItem<TempUser> root = new RecursiveTreeItem<TempUser>(coaches, RecursiveTreeObject::getChildren);
		tableView.setRoot(root);
		tableView.setShowRoot(false);

	}

	private void loadCoaches(ObservableList<TempUser> coaches) {
		try {
			allCoaches = app.getCoaches();

			// userList.sort(null);
			for (String s : allCoaches.keySet()) {
				coaches.add(new TempUser(allCoaches.get(s).getUsername(), allCoaches.get(s).getName(),
						allCoaches.get(s).getCity(), Integer.toString(allCoaches.get(s).getAge()), "Random shit"));
			}
		} catch (Exception e) {
			// Label: "No coaches found"
		}
	}

	@FXML
	private void updateCoach() {
		// Method which when you click on a coach this coach will be set to your user
		String coach = selectedCoach.getText();
		User updatedCoach = allCoaches.get(coach);
		if (updatedCoach != null) {
			app.setMyCoach(coach);
			coachLabel.setText("Your coach has been changed! Check your inbox!");
		} else {
			coachLabel.setText("Coach not found, check your input");
		}
	}

	private static class TempUser extends RecursiveTreeObject<TempUser> {
		private final String username;
		private final String name;
		private final String city;
		private final String age;
		private final String random;

		public TempUser(String username, String name, String city, String age, String random) {
			this.username = (username);
			this.name = (name);
			this.city = (city);
			this.age = (age);
			this.random = (random);
		}

		public String getUsername() {
			return this.username;
		}

		public String getName() {
			return this.name;
		}

		public String getCity() {
			return this.city;
		}

		public String getAge() {
			return this.age;
		}

		public String getRandom() {
			return this.random;
		}
	}
}
