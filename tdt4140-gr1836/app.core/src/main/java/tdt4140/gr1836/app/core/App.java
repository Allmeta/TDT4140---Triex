package tdt4140.gr1836.app.core;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import tdt4140.gr1836.app.db.Database;
import tdt4140.gr1836.app.inbox.Message;
import tdt4140.gr1836.app.inbox.Messages;
import tdt4140.gr1836.app.users.User;
import tdt4140.gr1836.app.users.UserTempList;
import tdt4140.gr1836.app.users.Users;
import tdt4140.gr1836.app.workouts.Workout;
import tdt4140.gr1836.app.workouts.Workouts;

public class App {
	private Database database;
	private User user;
	private Workouts workouts;
	private Map<String, User> users;
	private Map<String, User> coaches;
	private Map<String, Messages> messages;

	private boolean waitForDatabase;

	public App() throws IOException {
		this.database = new Database();
		this.database.init();
		this.user = null;
	}

	// User managment to DB
	public void register(String username, String name, int age, int height, int weight, String city, boolean isMale,
			boolean isCoach, String password) {
		this.user = this.database.register(username, name, age, height, weight, city, isMale, isCoach, password);
	}

	public User login(String username, String password) {
		this.waitForDatabase = true;
		int timer = 0;

		this.database.login(username, password, this);
		// Wait loop while waiting for login, should not last more than 30 seconds
		// before giving error
		while (this.waitForDatabase) {
			try {
				Thread.sleep(300);
				timer += 1;
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			if (timer > 100) {
				System.out.println("Login took more than 30 seconds, cancel.");
				break;
			}
		}
		return this.user;
	}

	public void deleteUser(String username) {
		this.database.deleteUser(username);
	}

	public void getUsersFromDatabase() {// GEts all users and sets it to either coach or user
		this.waitForDatabase = true;
		int timer = 0;

		this.database.getUsers(this);
		// Wait loop while waiting for login, should not last more than 30 seconds
		// before giving error
		while (this.waitForDatabase) {
			try {
				Thread.sleep(300);
				timer += 1;
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			if (timer > 100) {
				System.out.println("Getting users took more than 30 seconds, cancel.");
				break;
			}
		}
	}

	public void submitCardioWorkout(String type, double duration, double distance, double pulse, String date) {
		Workout cdw = new Workout(type, duration, distance, pulse, date);
		this.database.submitCardioWorkout(cdw, this);
		// oppdater workouts liste
		getWorkoutsFromDB();
	}

	public void getWorkoutsFromDB() {
		this.setWorkouts(null);
		this.waitForDatabase = true;
		int timer = 0;
		this.database.getWorkouts(this);
		while (this.waitForDatabase) {
			try {
				Thread.sleep(300);
				timer += 1;
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			if (timer > 100) {
				System.out.println("Getting workouts took more than 30 seconds, cancel.");
				break;
			}
		}
	}

	public void deleteWorkout(String username, String type, String date) {
		this.database.deleteWorkout(username, type, date);
	}
	
	

	// Helper method for presenting coaches
	public ArrayList<UserTempList> getCoachesAsList() {
		ArrayList<UserTempList> temp = new ArrayList<UserTempList>();
		for (String s : coaches.keySet()) {
			UserTempList tmplist = new UserTempList(coaches.get(s).getUsername(),s, coaches.get(s).getCity(),
					Integer.toString(coaches.get(s).getAge()), "");
			temp.add(tmplist);
		}
		return temp;
	}
	
	
	public ArrayList<UserTempList> getUsersAsList() {
		ArrayList<UserTempList> temp = new ArrayList<UserTempList>();
		for (String s : users.keySet()) {
			UserTempList tmplist = new UserTempList(users.get(s).getUsername(),s, users.get(s).getCity(),
					Integer.toString(users.get(s).getAge()), "");
			temp.add(tmplist);
		}
		return temp;
	}

	// GETTER & SETTERS
	public void setUsers(Users value) {
		Map<String, User> tempCoach = new HashMap<String, User>();
		Map<String, User> tempUsers = new HashMap<String, User>();
		for (String key : value.getUsers().keySet()) {
			if (value.getUsers().get(key).getIsCoach()) {
				tempCoach.put(key, value.getUsers().get(key));
			} else {
				tempUsers.put(key, value.getUsers().get(key));
			}
		}
		this.users = tempUsers;
		this.coaches = tempCoach;

	}

	public Map<String, User> getUsers() {
		return this.users;
	}

	public Map<String, User> getCoaches() {
		return this.coaches;
	}

	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public void setWaitForDatabase(boolean b) {
		this.waitForDatabase = b;
	}

	public Workouts getWorkouts() {
		return this.workouts;
	}

	public void setWorkouts(Workouts value) {
		this.workouts = value;
	}

	public void sendMessage(String message, String referant) {
		database.sendMessage(message,referant,user.getUsername());		
	}

	public void loadMessages(String referant) {
		this.messages=null;
		this.waitForDatabase = true;
		int timer = 0;

		this.database.loadMessages(referant, user.getUsername(), this);
		// Wait loop while waiting for login, should not last more than 30 seconds
		// before giving error
		while (this.waitForDatabase) {
			try {
				Thread.sleep(300);
				timer += 1;
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			if (timer > 100) {
				System.out.println("Loading chat messages took more than 30 seconds, cancel.");
				break;
			}
		}
	}
	public void setMessages(String referant,Messages m) {
		if(messages==null) {
			messages=new HashMap<String,Messages>();
		}
		this.messages.put(referant, m);
	}
	public ArrayList<Message> getMessages(String ref) {
		if(messages==null || messages.get(ref)==null) {
			loadMessages(ref);
		}
		if(messages.get(ref) == null) {
			return null;
		}
		return messages.get(ref).toList();
	}

}
