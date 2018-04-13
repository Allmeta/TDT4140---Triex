package tdt4140.gr1836.app.users;

public class UserTempList {
	private String name;
	private String city;
	private String age;
	private String username;

	public UserTempList(String username,String name,String city,String age){
		this.name=name;
		this.city=city;
		this.age=age;
		this.username=username;
	}
	public String getName() {
		return this.name;
	}
	public String getCity() {
		return this.city;
	}
	public String getAge() {
		return this.age;
	}
	public String getUsername() {
		return this.username;
	}
	
}
