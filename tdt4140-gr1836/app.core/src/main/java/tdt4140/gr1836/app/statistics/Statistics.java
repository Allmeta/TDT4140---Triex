package tdt4140.gr1836.app.statistics;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAccessor;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import tdt4140.gr1836.app.users.User;
import tdt4140.gr1836.app.users.Users;
import tdt4140.gr1836.app.workouts.Workout;
import tdt4140.gr1836.app.workouts.Workouts;

public class Statistics {
	private Map<String,Statistic> statistics;
	private Statistic averageStatistics;
	private String city;
	
	public Statistics() {
		
	}
	
	public Statistic calculateAverageInCity(Users users) {
		//Må her beregne alt s
		this.averageStatistics = new Statistic();
		return this.averageStatistics;
	}
	
	public Statistic updateMyStatistics(Workouts workouts) throws ParseException {
		Statistic statistic = new Statistic();
		//Finds date 30 days ago
		LocalDate localDate = LocalDate.now();
		LocalDate tempMonthAgo = localDate.minusDays(30);
		Date monthAgo = Date.from(tempMonthAgo.atStartOfDay(ZoneId.systemDefault()).toInstant());
		
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		
		//Funker dette hvis keySettene og Maps er tomme?!?!?
		int kilometers = 0;
		Map<String, Workout> tempWorkouts = workouts.getRunning();
		for (String key : tempWorkouts.keySet()){
			Date date = format.parse(key);
			if (date.after(monthAgo)) {
				kilometers += tempWorkouts.get(key).getDistance();
			}
		}
		statistic.setRunKm(kilometers);
		
		kilometers = 0;
		tempWorkouts = workouts.getBiking();
		if (tempWorkouts!=null) {
			for (String key : tempWorkouts.keySet()){
				Date date = format.parse(key);
				if (date.after(monthAgo)) {
					kilometers += tempWorkouts.get(key).getDistance();
				}
			}
		}
		statistic.setBikeKm(kilometers);
		
		kilometers = 0;
		tempWorkouts = workouts.getSwimming();
		if (tempWorkouts!=null) {
			for (String key : tempWorkouts.keySet()){
				Date date = format.parse(key);
				if (date.after(monthAgo)) {
					kilometers += tempWorkouts.get(key).getDistance();
				}
			}
		}
		statistic.setSwimKm(kilometers);
		
		return statistic;
	}
	public void setStatistics(Map<String, Statistic> statistics) {
		this.statistics = statistics;
	}
	public Map<String,Statistic> getStatistics() {
		return this.statistics;
	}
	public Statistic getaverageStatistics() {
		return this.averageStatistics;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String  getCity() {
		return this.city;
	}

	public static void main(String[] args) throws ParseException {


	}

}
