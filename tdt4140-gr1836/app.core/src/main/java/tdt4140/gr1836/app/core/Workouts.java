package tdt4140.gr1836.app.core;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Map;

@SuppressWarnings("serial")
public class Workouts implements Serializable {
	public Map<String, StrengthWorkout> strength;
	public Map<String, CardioWorkout> cardio;

	public Workouts() {

	}

	public void printTest() {
		for (String key : cardio.keySet()) {
			System.out.println(cardio.get(key).info);
		}
	}

	public ArrayList<tempList> getWorkoutsAsList() {
		ArrayList<tempList> temp = new ArrayList<tempList>();
		if (strength != null) {
			for (String s : strength.keySet()) {
				System.out.println(s);
				tempList tmplist = new tempList(s, "Strength", "" + strength.get(s).intensity,
						strength.get(s).duration);
				temp.add(tmplist);
			}
		}
		if (cardio != null) {
			for (String s : cardio.keySet()) {
				System.out.println(s);
				tempList tmplist = new tempList(s, "Cardio", "" + cardio.get(s).intensity, cardio.get(s).duration);
				temp.add(tmplist);
			}
		}
		return temp;
	}
}
