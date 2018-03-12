package tdt4140.gr1836.app.core;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

@SuppressWarnings("serial")
public class CardioWorkout implements Serializable{
	public String duration;
	public String date;
	public Map<String, Boolean> activities;
	public List<Boolean> intensity;
	public String info;

	CardioWorkout(){
		
	}

	public CardioWorkout(String text, String string, Map<String, Boolean> activity, List<Boolean> intensity,
			String text2) {
		this.duration=text;
		this.date=string;
		this.activities=activity;
		this.intensity=intensity;
		this.info=text2;
	}
}
