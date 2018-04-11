package tdt4140.gr1836.app.core;

import static org.junit.Assert.assertEquals;

import java.io.IOException;
import java.util.Map;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import tdt4140.gr1836.app.users.User;
import tdt4140.gr1836.app.workouts.Workout;
import tdt4140.gr1836.app.workouts.Workouts;

public class AppTest {
	private App app;
	private User correctCoach = new User("TestCoach", "Mr.Coach", 22, 185, 80, "Oslo", true, true, "coachTest");
	private User correctUser = new User("TestUser", "Mr.David", 22, 185, 80, "Oslo", true, false, "coachTest");
	private User user;

	@BeforeClass
	public static void oneTimeSetUp() throws IOException {
		// Registers a new user to be tested on
		App app = new App();
		app.setUser(new User("TestUser", "Mr.David", 22, 185, 80, "Oslo", true, false, "coachTest"));

		app.submitCardioWorkout("Running", 90, 10, 160, "1999-09-09");

		app.register("TestUser", "Mr.David", 22, 185, 80, "Oslo", true, false, "coachTest");
		app.register("TestCoach", "Mr.Coach", 22, 185, 80, "Oslo", true, true, "coachTest");

	}

	@AfterClass
	public static void oneTimeCleanUp() throws IOException {
		App app = new App();
		app.deleteUser("TestUser");
		app.deleteUser("TestCoach");
		app.deleteWorkout("TestUser", "Running", "1999-09-09");

	}

	@Before
	public void setUp() throws IOException {
		app = new App();
	}
	// @Test public void register_user(){
	// @Test public void register_existing_user(){
	// @Test public void register_invalid_user(){

	@Test
	public void checkAndDeleteWorkouts() {
		app.setUser(correctUser);
		app.getWorkoutsFromDB();
		Workouts workouts = app.getWorkouts();
		Map<String, Workout> cardio = workouts.getRunning();
		assertEquals(cardio.get("1999-09-09").getType(), "Running");

		app.deleteWorkout(correctUser.getUsername(), "Running", "1999-09-09");
		app.getWorkoutsFromDB();
		workouts = app.getWorkouts();
		assertEquals(workouts, null);

	}

	@Test
	public void testGetCoaches() {
		app.getUsersFromDatabase();

		Map<String, User> coaches = app.getCoaches();
		/*
		 * for (UserTempList t : coaches) { if (t.getName()==correctCoach.getUsername())
		 * { assertEquals(t.getCity(),correctCoach.getCity()); } }
		 */
		User t = coaches.get("TestCoach");
		assertEquals(t.getCity(), correctCoach.getCity());

	}

	@Test
	public void try_login_wrong_input() {
		user = app.login("TestUser", "BanaltPassord");
		assertEquals(user, null);
		user = app.login("Banaluser", "BanaltPassord");
		assertEquals(user, null);
	}

	@Test
	public void login() {
		user = app.login("TestUser", "coachTest");
		assertEquals(user.getName(), correctUser.getName());
		assertEquals(user.getAge(), correctUser.getAge());
		assertEquals(user.getCity(), correctUser.getCity());
		assertEquals(user.getHeight(), correctUser.getHeight());
	}

	@Test
	public void loginCoach() {
		user = app.login("TestCoach", "coachTest");
		assertEquals(user.getName(), correctCoach.getName());
	}

	@Test
	public void delete_account_and_try_login() {
		app.getUsersFromDatabase();
		Map<String, User> users = app.getUsers();
		assertEquals(users.get("TestUser").getName(), "Mr.David");
		app.deleteUser("TestUser");
		app.getUsersFromDatabase();
		users = app.getUsers();
		assertEquals(users.get("TestUser"), null);

	}

}
