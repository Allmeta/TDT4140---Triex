package tdt4140.gr1836.app.workouts;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

@SuppressWarnings("serial")
public class Workout implements Serializable{
	private String duration;
	private String date;
	private Map<String, Boolean> activities;
	private double intensity;
	private String info;

	Workout(){
		
	}

	public Workout(String text, String string, Map<String, Boolean> activity, double d,
			String text2) {
		this.duration=text;
		this.date=string;
		this.activities=activity;
		this.intensity=d;
		this.info=text2;
	}
	public String getDuration() {
		return this.duration;
	}
	public String getDate() {
		return this.date;
	}
	public String getInfo() {
		return this.info;
	}
	public Map<String, Boolean> getActivities(){
		return this.activities;
	}
	public double getIntensity() {
		return this.intensity;
	}
}
