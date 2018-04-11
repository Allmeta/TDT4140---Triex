package tdt4140.gr1836.app.core;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.io.IOException;

import java.util.UUID;

import tdt4140.gr1836.app.db.Database;
import tdt4140.gr1836.app.workouts.Workout;

 


public class Teststuff {
	

	private int height;
	private int weight;
	private String name;
	private String username;
	private double distance;
	private String date;
	private Database database;
	private Workout workout;
	
	
	public Teststuff() throws IOException {
		database=new Database();
		database.init();
		
		
	}
	 
	public void addUser() throws IOException {
		Random random = new Random();
		
		List<String> malename= new ArrayList<>();
		Collections.addAll(malename, "Per","Pål","Espen","Jon","Fredrik","Karl","Greg","Lars","Ola","Arne");
		
		List<String> femalename= new ArrayList<>();
		Collections.addAll(femalename, "Kari","Anne","Marie","Marit","Line","Jenny","Dina","Josefine","Pia","Lara");
		List<String> surname= new ArrayList<>();
		Collections.addAll(surname, "Larsen","Olsen","Hansen","Arnesen","Iversen","Bjørndalen","Bjørgen","Lauritzen","Persen","Nordmann");
		
		int age = random.nextInt(22 - 20 + 1) + 20;
	    boolean isMale = (new Random().nextInt() < 0) ?
	            true : false;
	    if (isMale == true) {
	            this.height = random.nextInt(200 - 160 + 1) + 160;
	            this.weight = random.nextInt(150 - 70 + 1) + 70;
	            this.name=malename.get(random.nextInt(10))+" "+surname.get(random.nextInt(10));
	            
	            }
	            else {
	                this.height = random.nextInt(180 - 150 + 1) + 150;
	                this.weight = random.nextInt(100 - 50 + 1) + 50;
	                this.name=femalename.get(random.nextInt(10))+" "+surname.get(random.nextInt(10));}
	    			
	    String city = (new Random().nextInt() < 0) ?
	            "Trondheim": "Oslo";
	    
	   
	    this.username = this.name.replaceAll("\\s", "").toLowerCase();
	    
	    String pass = "test";
	    
	   
	    
	    System.out.println(" age ="+age+" sex "+isMale +" height " + height +" weight " + weight +" city " + city +" username "+ username+"  " +name);
	    this.database.register(username, name, age, height, weight, city, isMale, false, pass);
	          
	}
	
	public String getUsername() {
		return username;
	} 
	 
	public void addWorkout(String username) throws IOException {
		Random rand = new Random();
		
		for(int i=1;i<31;i++) {
			if(i<10) {
				date="2018-04-0"+i;
			}
			else {
				date="2018-04-"+i;
			}
			
		List<String> activitylist= new ArrayList<>();
		Collections.addAll(activitylist, "Biking","Running","Swimming");
		String activity = activitylist.get(rand.nextInt(3)); 
	            if (activity == "Biking") {
	            	distance = rand.nextInt(100 - 10 + 1) + 10;
	            			}
	                else if (activity == "Running") {
	                    distance = rand.nextInt(20 - 5 + 1) + 5;
	                }
	                else {
	                    distance = rand.nextInt(5 - 1 + 1) + 1;}
	            
		double time = rand.nextInt(120 -30 + 1) + 30;
		double puls = rand.nextInt(200 - 100 + 1) + 100;
		
		
		
		Workout workout= new Workout(activity,time,distance,puls,date);
		this.database.submitWorkoutWithoutApp(workout, username);
		}
		
	
	}
	public static void main(String[] args) throws IOException, InterruptedException {
		Teststuff a = new Teststuff();
		
		
		for (int i = 0; i < 20; i++) {
			a.addUser();
			Thread.sleep(1000);
			a.addWorkout(a.getUsername());
			}
			
		
		
		}
		
		
	



	
	
	
}

