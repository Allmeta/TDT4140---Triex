package tdt4140.gr1836.app.core;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import tdt4140.gr1836.app.users.User;
import tdt4140.gr1836.app.users.UserTempList;
import tdt4140.gr1836.app.workouts.Workout;
import tdt4140.gr1836.app.workouts.StrengthWorkout;
import tdt4140.gr1836.app.workouts.Workouts;
import tdt4140.gr1836.app.workouts.TempList;

public class AppTest {
	/*
	private App app;
	private User correctCoach= new User("TestCoach", "Mr.Coach", 22, "Oslo", "coach@yahoo", "bygata", "123456789", "coachTest", true);;
	private User correctUser = new User("TestUser", "Mr.David", 22, "Trondheim", "hasselhoff@yahoo", "bygata", "987654321", "test", false);
	private User user;
	
	@BeforeClass
	public static void oneTimeSetUp() throws IOException {
		//Registers a new user to be tested on
		App app = new App();
		app.setUser(new User("TestUser", "Mr.David", 22, "Trondheim", "hasselhoff@yahoo", "bygata", "987654321", "test", false));
		
		Map<String,Boolean> activity=new HashMap<>();
		activity.put("Running", true);
		activity.put("Swimming", false);
		activity.put("Biking", false);
				
		app.submitCardioWorkout("90", "1999-09-09", activity, 9, "some info");
		app.submitStrengthWorkout("60", "1990-01-01", Arrays.asList("10","10","10"), Arrays.asList("10","10","10"), Arrays.asList("10","10","10"), Arrays.asList("10","10","10"), Arrays.asList("10","10","10"), 8, "some strength info");
		
		app.register("TestUser", "Mr.David", 22, "Trondheim", "hasselhoff@yahoo", "bygata", "987654321", "test", false);
		app.register("TestCoach", "Mr.Coach", 22, "Oslo", "coach@yahoo", "bygata", "123456789", "coachTest", true);

	}
	@AfterClass
	public static void oneTimeCleanUp() throws IOException {
		App app = new App();
		app.deleteUser("TestUser");
		app.deleteUser("TestCoach");
		app.deleteWorkout("TestUser", "Strength", "1990-01-01");
		app.deleteWorkout("TestUser", "Cardio", "1999-09-09");
		
	}
	
	@Before
	public void setUp() throws IOException {
		app= new App();
	}
	//@Test public void register_user(){
	//@Test public void register_existing_user(){
	//@Test public void register_invalid_user(){
	
	@Test public void checkAndDeleteWorkouts() {
		app.setUser(correctUser);
		app.getWorkoutsFromDB();
		Workouts workouts = app.getWorkouts();
		Map<String, StrengthWorkout> strength=workouts.getStrength();
		Map<String, Workout> cardio=workouts.getCardio();
		assertEquals(strength.get("1990-01-01").getDuration(), "60");
		assertEquals(cardio.get("1999-09-09").getDuration(), "90");
		
		app.deleteWorkout(correctUser.getUsername(), "strength", "1990-01-01");
		app.deleteWorkout(correctUser.getUsername(), "cardio", "1999-09-09");
		app.getWorkoutsFromDB();
		workouts = app.getWorkouts();
		assertEquals(workouts, null);
				
	}
	@Test public void testGetCoaches() {
		app.getUsersFromDatabase();
		 ArrayList<UserTempList> coaches=app.getCoachesAsList();
		 for (UserTempList t : coaches) {
			 if (t.getName()==correctUser.getUsername()) {
				 assertEquals(t.getCity(),correctUser.getCity());
			 }
		 }
		
	}
	
	@Test public void try_login_wrong_input() {
		user = app.login("TestUser", "BanaltPassord");
		assertEquals(user,null);
		user = app.login("Banaluser", "BanaltPassord");
		assertEquals(user,null);
	}
	@Test public void login() {
		user = app.login("TestUser", "test");
		assertEquals(user.getAddress(),correctUser.getAddress());
		assertEquals(user.getName(),correctUser.getName());
		assertEquals(user.getAge(),correctUser.getAge());
		assertEquals(user.getCity(),correctUser.getCity());
		assertEquals(user.getEmail(),correctUser.getEmail());
		assertEquals(user.getPhone(),correctUser.getPhone());
	}
	@Test public void loginCoach() {
		user=app.login("TestCoach", "coachTest");
		assertEquals(user.getName(),correctCoach.getName());
	}
	@Test public void delete_account_and_try_login() {
		app.getUsersFromDatabase();
		Map<String, User> users =app.getUsers();
		assertEquals(users.get("TestUser").getName(), "Mr.David");
		app.deleteUser("TestUser");
		app.getUsersFromDatabase();
		users = app.getUsers();
		assertEquals(users.get("TestUser"), null);

	}
	*/

}
