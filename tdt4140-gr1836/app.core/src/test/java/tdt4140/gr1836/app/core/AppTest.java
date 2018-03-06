package tdt4140.gr1836.app.core;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;

import java.io.IOException;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class AppTest {
	private App app;
	private User user;
	
	@BeforeClass
	public static void oneTimeSetUp() throws IOException {
		//Registers a new user to be tested on
		App app = new App();
		app.register("TestUser", "Mr.David", 22, "Trondheim", "hasselhoff@yahoo", "bygata", "987654321", "test");
	}
	@Before
	public void setUp() throws IOException {
		app= new App();
	}
	//@Test public void register_user(){
	//@Test public void register_existing_user(){
	//@Test public void register_invalid_user(){
	
	@Test public void try_login_wrong_input() {
		user = app.login("TestUser", "BanaltPassord");
		assertEquals(user,null);
		user = app.login("Banaluser", "BanaltPassord");
		assertEquals(user,null);
	}
	@Test public void login() {
		user = app.login("TestUser", "test");
		User correctUser= new User("Mr.David", 22, "Trondheim", "hasselhoff@yahoo", "bygata", "987654321", "test");
		assertEquals(user.address,correctUser.address);
		assertEquals(user.name,correctUser.name);
		assertEquals(user.age,correctUser.age);
		assertEquals(user.city,correctUser.city);
		assertEquals(user.email,correctUser.email);
		assertEquals(user.phone,correctUser.phone);
	}
	@Test public void delete_account_and_try_login() {
		//Unødvendig da login gir alltid null
		app.deleteUser("TestUser");
		user = app.login("TestUser", "test");
		assertEquals(user,null);
	}

}
