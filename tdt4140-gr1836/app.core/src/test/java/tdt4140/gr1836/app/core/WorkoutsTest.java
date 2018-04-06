package tdt4140.gr1836.app.core;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;

import tdt4140.gr1836.app.workouts.CardioWorkout;
import tdt4140.gr1836.app.workouts.StrengthWorkout;
import tdt4140.gr1836.app.workouts.Workouts;
import tdt4140.gr1836.app.workouts.TempList;

public class WorkoutsTest {
	private Workouts workouts;
	private Map<String, StrengthWorkout> strength=new HashMap();
	private Map<String, CardioWorkout> cardio=new HashMap();
	
	@Before
	public void setUp(){
		workouts=new Workouts();
		workouts.setWorkouts(strength, cardio);
		Map<String,Boolean> activity=new HashMap<>();
		activity.put("Running", true);
		activity.put("Swimming", false);
		activity.put("Biking", false);
		
		CardioWorkout cw = new CardioWorkout("90", "1999-09-09", activity, 9, "some info");
		StrengthWorkout sw = new StrengthWorkout("60", "1990-01-01", Arrays.asList("10","10","10"), Arrays.asList("10","10","10"), Arrays.asList("10","10","10"), Arrays.asList("10","10","10"), Arrays.asList("10","10","10"), 8, "some strength info");
		workouts.addCardioWorkout(cw);
		workouts.addStrengthWorkout(sw);
		
		//Lag workouts med to strength og to cardio workouts og kjør get og set på de og workout
		
	}
	//Create new strenth and cardio workout set to workouts return with get
	//getaslist
	@Test public void getWorkoutsAndCheckValues() {
		
		Map<String, StrengthWorkout> swmap=workouts.getStrength();
		Map<String, CardioWorkout> cwmap=workouts.getCardio();
		assertEquals(swmap.get("1990-01-01").getDuration(),"60");
		assertEquals(cwmap.get("1999-09-09").getDuration(),"90");
	}
	@Test public void testWorkoutsAsList() {
		
		ArrayList<TempList>temp=workouts.getWorkoutsAsList();
		for (TempList t:temp) {
			if(t.getDate()=="1990-01-01") {
				assertEquals(t.getDuration(),"60");
			}
			else if(t.getDate()=="1999-09-09"){
				assertEquals(t.getDuration(),"90");
			}
		}
	}
	

}
