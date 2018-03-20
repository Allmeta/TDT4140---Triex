package tdt4140.gr1836.app.core;

import java.io.Serializable;
	
public class User implements Serializable {
	public String email, password, name,city,address,phone,username,b;
	public int age;
	public String salt;
	public boolean coach;

	public User(String username, String name, int age, String city, String email, String address,String phone, String password, boolean b) {
		this.password = password;
		this.name = name;
		this.age = age;
		this.phone = phone;
		this.city=city;
		this.email=email;
		this.address=address;
		this.username=username;
		this.coach=b;
		
	}
	public User() {
		//empty constructor to make new object based on snapshot data from login function
	}
	public void setSalt(String salt) {
		this.salt=salt;
	}
}
