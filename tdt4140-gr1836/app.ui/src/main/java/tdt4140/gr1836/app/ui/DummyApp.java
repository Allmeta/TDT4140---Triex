package tdt4140.gr1836.app.ui;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import org.json.JSONObject;

import tdt4140.gr1836.app.core.App;
import tdt4140.gr1836.app.users.User;
import tdt4140.gr1836.app.workouts.Workout;
import tdt4140.gr1836.app.workouts.StrengthWorkout;
import tdt4140.gr1836.app.workouts.Workouts;

public class DummyApp extends App {
	private User user;
	private User correctUser;
	private User coachUser;
	private Workouts workouts;
	private Map<String, User> users;
	private Map<String, User> coaches;
	
	
	public DummyApp() throws IOException {
		this.user=null;
		this.coachUser = new User("coachFxBoy","Mr.Coach", 20, "Trondheim", "coach@yahoo", "computer","1234", "coach", false);
		this.correctUser = new User("testFxBoy","Mr.TestFx", 20, "Trondheim", "hasselhoff@yahoo", "computer","1234", "test", false);
		
	}
	public void register(String username,String name, int age, String city, String email, String address,String phone, String password) {
		System.out.println("Register");
		
	}
	public User login(String username, String password) {
		
		if(username.equals("testFxBoy") && password.equals("test")) {
			return correctUser;
		}
		else if(username.equals("coachFxBoy") && password.equals("coach"))  {
			return coachUser;
		}
		else {
			return user;
		}
		
	}
	public void deleteUser(String username) {
		System.out.println("Delete user");
		this.correctUser=null;
	}
	public void getWorkoutsFromDB() {
		Map<String, StrengthWorkout> strength=new HashMap();
		Map<String, Workout> cardio=new HashMap();
		workouts=new Workouts();
		workouts.setWorkouts(strength, cardio);
		Map<String,Boolean> activity=new HashMap<>();
		activity.put("Running", true);
		activity.put("Swimming", false);
		activity.put("Biking", false);
		
		Workout cw = new Workout("90", "1999-09-09", activity, 9, "some info");
		StrengthWorkout sw = new StrengthWorkout("60", "1990-01-01", Arrays.asList("10","10","10"), Arrays.asList("10","10","10"), Arrays.asList("10","10","10"), Arrays.asList("10","10","10"), Arrays.asList("10","10","10"), 8, "some strength info");
		workouts.addCardioWorkout(cw);
		workouts.addStrengthWorkout(sw);
	}
	public void getUsersFromDatabase() {
		this.users.put(this.correctUser.getUsername(), this.correctUser);
		this.coaches.put(this.coachUser.getUsername(), this.coachUser);
	}
	public Workouts getWorkouts() {
		return this.workouts;
	}
}
