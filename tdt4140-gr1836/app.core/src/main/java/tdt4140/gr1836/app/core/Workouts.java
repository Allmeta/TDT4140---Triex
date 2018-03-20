package tdt4140.gr1836.app.core;

import java.io.Serializable;
import java.util.ArrayList;
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
	public ArrayList<tempList> getWorkoutsAsList(){
		ArrayList<tempList> temp=new ArrayList<tempList>();
		for(String s : this.strength.keySet()) {
			System.out.println(s);
			tempList tmplist=new tempList(s,"Strength",""+this.strength.get(s).intensity,this.strength.get(s).duration);
			temp.add(tmplist);
		}
		for(String s : this.cardio.keySet()) {
			System.out.println(s);
			tempList tmplist=new tempList(s,"Cardio",""+this.cardio.get(s).intensity,this.cardio.get(s).duration);
			temp.add(tmplist);
		}
		return temp;
	}
}
