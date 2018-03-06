package tdt4140.gr1836.app.core;

import java.io.Serializable;
	
public class User implements Serializable {
	public String email, password, name,city,adress,phone;
	public int age;

	public User(String name, int age, String city, String email, String adress,String phone, String password) {
		this.password = password;
		this.name = name;
		this.age = age;
		this.phone = phone;
		this.city=city;
		this.email=email;
		this.adress=adress;
		
	}
	public User() {
		//empty constructor to make new object based on snapshot data from login function
	}
}
