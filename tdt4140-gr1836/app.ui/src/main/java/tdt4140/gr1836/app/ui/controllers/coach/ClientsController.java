package tdt4140.gr1836.app.ui.controllers.coach;

import java.io.IOException;
import java.util.ArrayList;
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
import tdt4140.gr1836.app.ui.NavigationHandler;
import tdt4140.gr1836.app.ui.LayoutHandler;
import tdt4140.gr1836.app.users.User;

public class ClientsController extends NavigationHandler {
	/*
	 * @FXML private Button homeBtn;
	 */
	private Map<String, User> allUsers;
	private ArrayList<String> allClients = new ArrayList<String>();
	@FXML
	private Label clientLabel;
	@FXML
	private JFXTextField selectedClient;

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
			setClients();
		});
	}

	@FXML
	private void onBack() {
		try {
			loadScene(LayoutHandler.mainCoachPane, this.getRoot(), this.app);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	/*
	 * private ArrayList<User> parseCoaches() { return this.app.getCoachesAsList();
	 * }
	 */

	private void setClients() {
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
		ObservableList<TempUser> clients = FXCollections.observableArrayList();

		loadClients(clients);
		// Burde sortere coaches etter username her

		// build tree
		final TreeItem<TempUser> root = new RecursiveTreeItem<TempUser>(clients, RecursiveTreeObject::getChildren);
		tableView.setRoot(root);
		tableView.setShowRoot(false);

	}

	private void loadClients(ObservableList<TempUser> clients) {
		try {
			allUsers = app.getUsers();
			String myName = app.getUser().getUsername();
			String clientCoach;
			// userList.sort(null);
			for (String s : allUsers.keySet()) {
				clientCoach = allUsers.get(s).getMyCoach();
				if (clientCoach.equals(myName)) {
					allClients.add(s);
					clients.add(new TempUser(allUsers.get(s).getUsername(), allUsers.get(s).getName(),
							allUsers.get(s).getCity(), Integer.toString(allUsers.get(s).getAge()), "Random shit"));
				}
			}
		}

		catch (NullPointerException e) {
			clientLabel.setText("Something went wrong loading your clients");
		}
	}

	@FXML
	private void viewClient() {
		// Method which when you click on a coach this coach will be set to your user
		String client = selectedClient.getText();
		if (allClients.contains(client)) {
			setClient(client);
			try {
				//History checks if user is coach and presents clients data
				loadScene(LayoutHandler.statisticsPane, this.getRoot(), this.app);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else {
			clientLabel.setText("Client not found, check your input");
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
