package tdt4140.gr1836.app.core;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

//import org.apache.log4j.BasicConfigurator;

public class App {
	
	private Database database;
	private User user; 
	private String currentUsername;
	public boolean waitForDatabase;
	
	public App() throws IOException {
		this.database=new Database();
		this.database.init();
		this.user=null;
	}
		
	public void register(String username,String name, int age, String city, String email, String adress,String phone, String password) {
		
		this.user=this.database.register(username, name, age, city, email, adress, phone, password);
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
	public void setUser(User user) {
		this.user=user;
	}
	public User getUser() {
		return this.user;
	}
	
/*	public static void main(String[] args) throws IOException {
		App app = new App();
		app.login("Karlf","1532");
		
		
	}*/
}
