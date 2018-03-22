package tdt4140.gr1836.app.workouts;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Map;

@SuppressWarnings("serial")
public class Workouts implements Serializable {
	private Map<String, StrengthWorkout> strength;
	private Map<String, CardioWorkout> cardio;

	public Workouts() {

	}

	public ArrayList<tempList> getWorkoutsAsList() {
		ArrayList<tempList> temp = new ArrayList<tempList>();
		if (strength != null) {
			for (String s : strength.keySet()) {
				System.out.println(s);
				tempList tmplist = new tempList(s, "Strength", "" + strength.get(s).getIntensity(),
						strength.get(s).getDuration());
				temp.add(tmplist);
			}
		}
		if (cardio != null) {
			for (String s : cardio.keySet()) {
				System.out.println(s);
				tempList tmplist = new tempList(s, "Cardio", "" + cardio.get(s).getIntensity(), cardio.get(s).getDuration());
				temp.add(tmplist);
			}
		}
		return temp;
	}
	public void setWorkouts(Map<String, StrengthWorkout> strength, Map<String, CardioWorkout> cardio) {
		this.strength=strength;
		this.cardio=cardio;
	}
	public void addStrengthWorkout(StrengthWorkout sw) {
		this.strength.put(sw.getDate(), sw);
	}
	public void addCardioWorkout(CardioWorkout cw) {
		this.cardio.put(cw.getDate(), cw);
	}
	public Map<String, StrengthWorkout> getStrength(){
		return this.strength;
	}
	public Map<String, CardioWorkout> getCardio(){
		return this.cardio;
	}
}
