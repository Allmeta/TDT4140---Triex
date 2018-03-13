package tdt4140.gr1836.app.core;

import java.io.Serializable;
import java.util.Map;

@SuppressWarnings("serial")
public class Workouts implements Serializable{
	public Map<String,StrengthWorkout> strength;
	public Map<String,CardioWorkout> cardio;
	public Workouts() {
		
	}
	public void printTest() {
		for(String key : cardio.keySet()) {
			System.out.println(cardio.get(key).info);
		}
	}
}
