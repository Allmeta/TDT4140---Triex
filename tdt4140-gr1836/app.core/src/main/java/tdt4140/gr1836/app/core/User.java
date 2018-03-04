package tdt4140.gr1836.app.core;

import java.io.Serializable;
	
public class User implements Serializable {
	public String email, password, name,city,adress;
	public int age, phone;

	public User(String name, int age, String city, String email, String adress,int phone, String password) {
		this.password = password;
		this.name = name;
		this.age = age;
		this.phone = phone;
		this.city=city;
		this.email=email;
		this.adress=adress;
		
	}
}
