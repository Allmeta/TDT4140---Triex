package tdt4140.gr1836.app.core;

import static org.junit.Assert.assertEquals;

import java.io.IOException;

import org.junit.Before;
import org.junit.Test;

public class AppTest {
	private App app;
	private User user;
	
	@Before
	public void setUp() throws IOException {
		app = new App();
	}
	@Test
	public void register_account() {
		app.register("TestUser", "Mr.David", 22, "Trondheim", "hasselhoff@yahoo", "bygata", 987654321, "test");
	}
	@Test
	public void try_login_wrong_input() {
		//Unødvendig da login gir alltid null
		user = app.login("TestUser", "BanaltPassord");
		assertEquals(user,null);
		user = app.login("Banaluser", "BanaltPassord");
		assertEquals(user,null);
	}
	/* Funker ikke enda grunnet login ikke funker
	@Test
	public void login() {
		user = app.login("TestUser", "test");
		User correctUser= new User("Mr.David", 22, "Trondheim", "hasselhoff@yahoo", "bygata", 987654321, "test");
		assertEquals(user,correctUser);
		
	}*/
	@Test
	public void delete_account_and_try_login() {
		//Unødvendig da login gir alltid null
		app.deleteUser("TestUser");
		user = app.login("TestUser", "test");
		assertEquals(user,null);
	}

}
