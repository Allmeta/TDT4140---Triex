package tdt4140.gr1836.app.core;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import tdt4140.gr1836.app.db.Database;
import tdt4140.gr1836.app.users.User;
import tdt4140.gr1836.app.users.UserTempList;
import tdt4140.gr1836.app.users.Users;
import tdt4140.gr1836.app.workouts.CardioWorkout;
import tdt4140.gr1836.app.workouts.StrengthWorkout;
import tdt4140.gr1836.app.workouts.Workouts;
import tdt4140.gr1836.app.workouts.TempList;

//import org.apache.log4j.BasicConfigurator;

public class App {
	private Database database;
	private User user; 
	private Workouts workouts;
	private Map<String, User> users;
	private Map<String, User> coaches;
	
	private boolean waitForDatabase;
	
	public App() throws IOException {
		this.database=new Database();
		this.database.init();
		this.user=null;
	}
	//User managment to DB
	public void register(String username,String name, int age, String city, String email, String adress,String phone, String password, boolean b) {	
		this.user=this.database.register(username, name, age, city, email, adress, phone, password, b);
	}
	public User login(String username, String password) {
		this.waitForDatabase = true;
		int timer=0;
		
		this.database.login(username, password, this);
		//Wait loop while waiting for login, should not last more than 30 seconds before giving error
		while(this.waitForDatabase) {
			try {
				Thread.sleep(300);
				timer+=1;
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			if (timer>100) {
				System.out.println("Login took more than 30 seconds, cancel.");
				break;
			}
		}
		return this.user;
	}
	public void deleteUser(String username) {
		this.database.deleteUser(username);
	}	
	
	public void getUsersFromDatabase() {//GEts all users and sets it to either coach or user
		this.waitForDatabase = true;
		int timer=0;
		
		this.database.getUsers(this);
		//Wait loop while waiting for login, should not last more than 30 seconds before giving error
		while(this.waitForDatabase) {
			try {
				Thread.sleep(300);
				timer+=1;
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			if (timer>100) {
				System.out.println("Getting users took more than 30 seconds, cancel.");
				break;
			}
		}
	}
	
	//Workouts managment to DB
	public void submitStrengthWorkout(String value, String string, List<String> bench, List<String> dead, List<String> squat,
			List<String> hang, List<String> press, double d, String text) {
		StrengthWorkout str=new StrengthWorkout(value,string,bench,dead,squat,hang,press,d,text);
		this.database.submitStrengthWorkout(str, this);
		//oppdater workouts liste
		getWorkoutsFromDB();
	}
	public void submitCardioWorkout(String text, String string, Map<String, Boolean> activity, double d,
			String text2) {
		CardioWorkout cdw=new CardioWorkout(text,string,activity,d,text2);
		this.database.submitCardioWorkout(cdw,this);
		//oppdater workouts liste
		getWorkoutsFromDB();
	}
	public void getWorkoutsFromDB() {
		this.setWorkouts(null);
		this.database.getWorkouts(this);
		this.waitForDatabase = true;
		int timer=0;
		this.database.getWorkouts(this);
		while(this.waitForDatabase) {
			try {
				Thread.sleep(300);
				timer+=1;
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			if (timer>100) {
				System.out.println("Getting workouts took more than 30 seconds, cancel.");
				break;
			}
		}
	}
	public void deleteWorkout(String username, String type, String date) {
		this.database.deleteWorkout(username, type, date);
	}
	
	//Helper method for presenting coaches
	public ArrayList<UserTempList> getCoachesAsList() {
		ArrayList<UserTempList> temp = new ArrayList<UserTempList>();
		for (String s : coaches.keySet()) {
			UserTempList tmplist = new UserTempList(s, coaches.get(s).getCity(),  Integer.toString(coaches.get(s).getAge()),
					coaches.get(s).getEmail());
			temp.add(tmplist);
		}
		return temp;
	}
	
	//GETTER & SETTERS
	public void setUsers(Users value) {
		// TODO Auto-generated method stub
		Map<String,User> tempCoach=new HashMap<String,User>();
		Map<String,User> tempUsers=new HashMap<String,User>();
		for(String key : value.getUsers().keySet()) {
			if(value.getUsers().get(key).getCoach()) {
				tempCoach.put(key, value.getUsers().get(key));
			}else {
				tempUsers.put(key, value.getUsers().get(key));
			}
		}
		this.users=tempUsers;
		this.coaches=tempCoach;
		
	}
	
	public Map<String, User> getUsers() {
		return this.users;
	}
	public Map<String,User> getCoaches(){
		return this.coaches;
	}
	public User getUser() {	
		return this.user;
	}
	public void setUser(User user) {
		this.user=user;
	}
	
	public void setWaitForDatabase(boolean b) {
		this.waitForDatabase=b;
	}
	public Workouts getWorkouts() {
		return this.workouts;
	}
	public void setWorkouts(Workouts value) {
		this.workouts=value;
	}

}
