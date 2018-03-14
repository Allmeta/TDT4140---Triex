package tdt4140.gr1836.app.core;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

@SuppressWarnings("serial")
public class CardioWorkout implements Serializable{
	public String duration;
	public String date;
	public Map<String, Boolean> activities;
	public double intensity;
	public String info;

	CardioWorkout(){
		
	}

	public CardioWorkout(String text, String string, Map<String, Boolean> activity, double d,
			String text2) {
		this.duration=text;
		this.date=string;
		this.activities=activity;
		this.intensity=d;
		this.info=text2;
	}
}
