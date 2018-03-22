package tdt4140.gr1836.app.users;

import java.io.Serializable;
	
public class User implements Serializable {
	//public String coachName;

	private String email, password, name,city,address,phone,username,b;
	private int age;
	private String salt;
	private boolean coach;
	//public String coachname Kan brukes til når en bruker skal velge EN coach

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
	/*
	public void setCoachName(String s) {
		this.coachName=s;
	}*/
	//Getters
	public String getUsername () {
		return this.username;
	}
	public String getEmail () {
		return this.email;
	}
	public String getPassword () {
		return this.password;
	}
	public String getName () {
		return this.name;
	}
	public String getCity () {
		return this.city;
	}
	public String getAddress () {
		return this.address;
	}
	public String getPhone () {
		return this.phone;
	}
	public String getSalt () {
		return this.salt;
	}/*
	public String getCoachname () {
		return this.coachName;
	}*/
	public int getAge() {
		return this.age;
	}
	public boolean getCoach() {
		return this.coach;
	}
}
