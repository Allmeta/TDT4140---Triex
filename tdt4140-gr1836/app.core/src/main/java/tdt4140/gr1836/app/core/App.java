package tdt4140.gr1836.app.core;

import java.io.IOException;

//import org.apache.log4j.BasicConfigurator;

public class App {
	
	private Database database;
	private User user; 
	
	public App() throws IOException {
		this.database=new Database();
		this.database.init();
		this.user=null;
	}
		
	public void register(String username,String name, int age, String city, String email, String adress,String phone, String password) {
		this.user=this.database.register(username, name, age, city, email, adress, phone, password);
	}
	public User login(String username, String password) {
		this.user=this.database.login(username, password);
		return this.user;
	}
	public void deleteUser(String username) {
		this.database.deleteUser(username);
	}
	
/*	public static void main(String[] args) throws IOException {
		App app = new App();
		app.login("Karlf","1532");
		
		
	}*/
}
