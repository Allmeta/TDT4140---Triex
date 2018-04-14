package tdt4140.gr1836.app.core;

import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

import tdt4140.gr1836.app.db.Database;
import tdt4140.gr1836.app.inbox.Message;
import tdt4140.gr1836.app.inbox.Messages;
import tdt4140.gr1836.app.statistics.Statistic;
import tdt4140.gr1836.app.statistics.Statistics;
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
	
	private Statistic myStatistics;
	private Statistics statistics; 
	private Map<String, Statistic> allStatistics;

	private ArrayList<User> conversations;

	private boolean waitForDatabase;
	private Map<String, User> allUsers;

	public App() throws IOException {
		this.database = new Database();
		this.database.init();
		this.user = null;
		
	}

	// User managment to DB
	public void setMyCoach(String coachname) {
		this.database.setMyCoach(coachname, this.user.getUsername());
		this.user.setMyCoach(coachname);

	}

	public void register(String username, String name, int age, int height, int weight, String city, boolean isMale,
			boolean isCoach, String password) {
		this.user = this.database.register(username, name, age, height, weight, city, isMale, isCoach, password);
		try {
			this.workouts = new Workouts();
			this.statistics = new Statistics();
			this.myStatistics = this.statistics.updateMyStatistics(this.workouts, this.user.getAge());
		} catch (ParseException e) {
			e.printStackTrace();
			//Error happened while parsing date from database, see statisticsAnalyzer updateMyStatistics()
		}	
		this.database.updateStatistics(this.myStatistics, this.user.getUsername());
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
				break;
			}
		}
		return this.user;
	}

	public void deleteUser(String username) {
		this.database.deleteUser(username);
	}

	public void getUsersFromDatabase() {// Gets all users and sets it to either coach or user
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
				break;
			}
		}
	}
	public void onlySubmitWorkout(String type, double duration, double distance, double pulse, String date) {
		Workout cdw = new Workout(type, duration, distance, pulse, date);
		this.database.submitCardioWorkout(cdw, this);
		this.getWorkoutsFromDB(); //Burde denne kjøres hvis vi kan oppdaterer lokalt i stede?
		//this.workouts.addWorkout(cdw); Sånn som her?

	}

	public void submitCardioWorkout(String type, double duration, double distance, double pulse, String date) {
		Workout cdw = new Workout(type, duration, distance, pulse, date);
		this.database.submitCardioWorkout(cdw, this);
		this.getWorkoutsFromDB(); //Burde denne kjøres hvis vi kan oppdaterer lokalt i stede?
		//this.workouts.addWorkout(cdw); Sånn som her?
		try {
			this.myStatistics = this.statistics.updateMyStatistics(this.workouts, this.user.getAge());
		} catch (ParseException e) {
			e.printStackTrace();
			//Error happened while parsing date from database, see statisticsAnalyzer updateMyStatistics()
		}	
		this.database.updateStatistics(this.myStatistics, this.user.getUsername());
	}
	public void getStatisticsFromDB() {
		this.waitForDatabase = true;
		int timer = 0;
		this.database.getStatistics(this);
		while (this.waitForDatabase) {
			try {
				Thread.sleep(300);
				timer += 1;
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			if (timer > 100) {
				break;
			}
		}
	}
	public LinkedHashMap<String, Double> findPartners(){
		
		return this.statistics.findPartners(this.users, this.myStatistics, this.user.getCity());
	}
	public void getClientsWorkouts(String client) {
		this.setWorkouts(null);
		this.waitForDatabase = true;
		int timer = 0;
		this.database.getWorkouts(this, client);
		while (this.waitForDatabase) {
			try {
				Thread.sleep(300);
				timer += 1;
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			if (timer > 100) {
				break;
			}
		}
	}
	public void getWorkoutsFromDB() {
		this.setWorkouts(null);
		this.waitForDatabase = true;
		int timer = 0;
		this.database.getWorkouts(this, this.getUser().getUsername());
		while (this.waitForDatabase) {
			try {
				Thread.sleep(300);
				timer += 1;
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			if (timer > 100) {
				break;
			}
		}
	}

	public void deleteWorkout(String username, String type, String date) {
		this.database.deleteWorkout(username, type, date);
	}

	// Helper method for presenting coaches
	public ArrayList<UserTempList> getCoachesAsList() {

		ArrayList<UserTempList> temp = new ArrayList<>();
		for (String s : coaches.keySet()) {
			UserTempList tmplist = new UserTempList(coaches.get(s).getUsername(), coaches.get(s).getName(), coaches.get(s).getCity(),
					Integer.toString(coaches.get(s).getAge()));
			temp.add(tmplist);
		}
		return temp;
	}

	public ArrayList<UserTempList> getUsersAsList() {
		ArrayList<UserTempList> temp = new ArrayList<UserTempList>();
		for (String s : users.keySet()) {
			UserTempList tmplist = new UserTempList(users.get(s).getUsername(), users.get(s).getName(), users.get(s).getCity(),
					Integer.toString(users.get(s).getAge()));
			temp.add(tmplist);
		}
		return temp;
	}

	// GETTER & SETTERS
	public void setUsers(Users value) {
		allUsers=value.getUsers();
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
		database.sendMessage(message, referant, user.getUsername());
		this.conversations.add(this.users.get(referant));
	}

	public void loadMessages(String referant) {
		this.messages = null;
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
				break;
			}
		}
	}

	public void setMessages(String referant, Messages m) {
		if (messages == null) {
			messages = new HashMap<>();
		}
		this.messages.put(referant, m);
	}

	public ArrayList<Message> getMessages(String ref) {
		if (messages == null || messages.get(ref) == null) {
			loadMessages(ref);
		}
		if (messages.get(ref) == null) {
			return null;
		}
		return messages.get(ref).toList();
	}
	public Statistic getMyStatistics () {
		return this.myStatistics;
	}
	public void setMyStatistics(Statistic statistics) {
		this.myStatistics = statistics;
	}
	public void setStatistics(Statistics statistics) {
		this.statistics = statistics;
		this.myStatistics = statistics.getStatistics().get(user.getUsername());
		
	}
	public Statistics getStatistics() {
		return this.statistics;
	}
	

	public static void main(String[] args) throws ParseException, IOException {
		App app = new App();
		app.login("dinaarnesen", "test");
		app.getStatisticsFromDB();
		
		app.submitCardioWorkout("Biking", 90, 10, 100, "2018-02-02");
		app.getUsersFromDatabase();
		
		System.out.println(app.statistics.findPartners(app.getUsers(), app.myStatistics, app.user.getCity()));
	}


	public ArrayList<User> getConversations() {
		if(conversations==null){
			conversations=new ArrayList<>();
			getConversationsFromDB();
		}
		return conversations;
	}
	public void setConversationItem(String user){
		User temp = allUsers.get(user);
		conversations.add(temp);
		System.out.println(user);
	}

	private void getConversationsFromDB() {
		setWaitForDatabase(true);
		int timer=0;
		database.getConversations(getUser().getUsername(),this);
		while (this.waitForDatabase) {
			try {
				Thread.sleep(300);
				timer += 1;
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			if (timer > 100) {
				System.out.println("CONV: Wait too long");
				break;
			}
		}
	}

	public User getMyCoach() {
		return coaches.get(getUser().getMyCoach());
	}

	public ArrayList<UserTempList> getClients() {
		ArrayList<UserTempList> allClients = new ArrayList<UserTempList>();
		try {
			allUsers = this.getUsers();
			String myName = this.getUser().getUsername();
			String clientCoach;
			// userList.sort(null);
			for (String s : allUsers.keySet()) {
				clientCoach = allUsers.get(s).getMyCoach();
				if (clientCoach.equals(myName)) {
					allClients.add(new UserTempList(allUsers.get(s).getUsername(), allUsers.get(s).getName(),
							allUsers.get(s).getCity(), Integer.toString(allUsers.get(s).getAge())));
				}
			}
		}

		catch (NullPointerException e) {
		}
		//My lages for coach pls
		return allClients;
	}
}
