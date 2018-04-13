package tdt4140.gr1836.app.statistics;

import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAccessor;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import tdt4140.gr1836.app.users.User;
import tdt4140.gr1836.app.users.Users;
import tdt4140.gr1836.app.workouts.Workout;
import tdt4140.gr1836.app.workouts.Workouts;

public class Statistics implements Serializable  {
	private Map<String,Statistic> statistics;
	
	Statistics() {
		
	}
	
	public Statistic calculateAverageInCity(Map<String, User> users, String city) {
		//Må her beregne alt 
		//HUSK Å SETT CITY FØRST!
		Statistic averageStatistics = new Statistic();
		User user;
		Statistic userStatistics;
		
		//Must divide all these by totalUsers in the end
		int totalMaxPulse = 0;
		int runKm = 0;
		int bikeKm = 0;
		int swimKm = 0;
		int runMin = 0;
		int bikeMin = 0;
		int swimMin = 0;
		int totalRuns = 0;
		int totalBikes = 0;
		int totalSwims = 0;
		int avgRunPulse = 0;
		int avgBikePulse = 0;
		int avgSwimPulse = 0;
		int totalUsers = 0;
		
		Set<String> statKeys = this.statistics.keySet();
		for (String key : users.keySet()) {
			user = users.get(key);	
			if (user.getCity().equals(city)) {
				if(statKeys.contains(user.getUsername())) {
					userStatistics = statistics.get(user.getUsername());
					totalMaxPulse += userStatistics.getMaxPulse();
					
					 runKm += userStatistics.getRunKm();
					 bikeKm += userStatistics.getBikeKm();
					 swimKm += userStatistics.getSwimKm();
					 runMin += userStatistics.getRunMin();
					 bikeMin += userStatistics.getBikeMin();
					 swimMin += userStatistics.getSwimMin();
					 totalRuns += userStatistics.getTotalRuns();
					 totalBikes += userStatistics.getTotalBikes();
					 totalSwims += userStatistics.getTotalSwims();
					 avgRunPulse += userStatistics.getAvgRunPulse();
					 avgBikePulse += userStatistics.getAvgBikePulse();
					 avgSwimPulse += userStatistics.getAvgSwimPulse();
					 totalUsers += 1;
				}		
			}
		}

		if (totalUsers>0) {
			averageStatistics.setRunKm(Math.round(runKm/totalUsers));
			averageStatistics.setRunMin(Math.round(runMin/totalUsers));
			averageStatistics.setAvgRunPulse(Math.round(avgRunPulse/totalUsers));
			averageStatistics.setTotalRuns(Math.round(totalRuns/totalUsers));
			
			averageStatistics.setBikeKm(Math.round(bikeKm/totalUsers));
			averageStatistics.setBikeMin(Math.round(bikeMin/totalUsers));
			averageStatistics.setAvgBikePulse(Math.round(avgBikePulse));
			averageStatistics.setTotalBikes(Math.round(totalBikes/totalUsers));
			
			averageStatistics.setSwimKm(Math.round(swimKm/totalUsers));
			averageStatistics.setSwimMin(Math.round(swimMin/totalUsers));
			averageStatistics.setAvgSwimPulse(Math.round(avgSwimPulse/totalUsers));
			averageStatistics.setTotalSwims(Math.round(totalSwims/totalUsers));
			
			averageStatistics.setMaxPulse(Math.round(totalMaxPulse/totalUsers));
			//Sender vi totalusers?
			//totalUsers;
		}
		return averageStatistics;
	}
	
	public Map<String, Double> findPartners(Map<String, User> users, Statistic myStatistics, String city) {
		Map<String, Double> partners = new HashMap<>();
		//Finds a partner in your city based on your stats below
		double maxPulse = myStatistics.getMaxPulse();
		int runKm = myStatistics.getRunKm();
		int bikeKm = myStatistics.getBikeKm();
		int swimKm = myStatistics.getSwimKm();
		int runMin = myStatistics.getRunMin();
		int bikeMin = myStatistics.getBikeMin();
		int swimMin = myStatistics.getSwimMin();
		int totalRuns = myStatistics.getTotalRuns();
		int totalBikes = myStatistics.getTotalBikes();
		int totalSwims = myStatistics.getTotalSwims();
		int avgRunPulse = myStatistics.getAvgRunPulse();
		int avgBikePulse = myStatistics.getAvgBikePulse();
		int avgSwimPulse = myStatistics.getAvgSwimPulse();
		
		User user;
		Statistic userStatistics;
		Double matchPercent = 0.0;
		
		Set<String> statKeys = this.statistics.keySet();
		for (String key : users.keySet()) {
			user = users.get(key);	
			if (user.getCity().equals(city)) {
				if(statKeys.contains(user.getUsername())) {	
					System.out.println("TEster"+user.getUsername());

					userStatistics = statistics.get(user.getUsername());
					//Funksjon for å beregne match
					matchPercent=0.0;
					matchPercent += this.compareNumbers(runKm, userStatistics.getRunKm());
					matchPercent += this.compareNumbers(bikeKm, userStatistics.getBikeKm());
					matchPercent += this.compareNumbers(swimKm, userStatistics.getSwimKm());
					matchPercent += this.compareNumbers(runMin, userStatistics.getRunMin());
					matchPercent += this.compareNumbers(bikeMin, userStatistics.getBikeMin());
					matchPercent += this.compareNumbers(swimMin, userStatistics.getSwimMin());
					matchPercent += this.compareNumbers(totalRuns, userStatistics.getTotalRuns());
					matchPercent += this.compareNumbers(totalBikes, userStatistics.getTotalBikes());
					matchPercent += this.compareNumbers(totalSwims, userStatistics.getTotalSwims());
					
					matchPercent += this.compareDoubles((maxPulse-avgRunPulse), (userStatistics.getMaxPulse() -(double) userStatistics.getAvgRunPulse()));
					matchPercent += this.compareDoubles((maxPulse-avgBikePulse), (userStatistics.getMaxPulse() -(double) userStatistics.getAvgBikePulse()));
					matchPercent += this.compareDoubles((maxPulse-avgSwimPulse), (userStatistics.getMaxPulse() -(double) userStatistics.getAvgSwimPulse()));
					partners.put(user.getUsername(), matchPercent);
					System.out.println(matchPercent);
				}
			}
		}
		//går gjennom hver bruker i din by og finner den som har nærmest match
		return partners;
	}
	public Double compareNumbers(int xxx, int yyy) {
		double x=(int) xxx;
		double y=(int) yyy;
		Double matchPercent=0.0;
		if (x == y) {
			System.out.println("Nummer er like");
			matchPercent += 0.0833;
		}
		else if (x==0) {
			System.out.println("Mine tall er 0");
			matchPercent += 0;
		}
		else {
			if (x>y) {
				matchPercent += 0.0833*(1-(x-y)/x);
			}
			else {
				matchPercent += 0.0833*(1-(y-x)/y);
			}
		}
		System.out.println(matchPercent);

		return matchPercent;
	}
	public Double compareDoubles(Double x, Double y) {
		Double matchPercent=0.0;
		if (x == y) {
			matchPercent += 0.0833;
		}
		else if (x==0) {
			matchPercent += 0;
		}
		else {
			if (x>y) {
				matchPercent += 0.0833*(1-(x-y)/x);
			}
			else {
				matchPercent += 0.0833*(1-(y-x)/y);
			}
		}
		System.out.println(matchPercent);
		return matchPercent;
	}
	
	//Lang jævla funksjon som gjør det samme tre ganga, finn snittstats for de siste tre dagan samt din maxpuls og sett dem i statistikk
	public Statistic updateMyStatistics(Workouts workouts, int age) throws ParseException {
		Statistic statistic = new Statistic();
		//Finds date 30 days ago
		LocalDate localDate = LocalDate.now();
		LocalDate tempMonthAgo = localDate.minusDays(30);
		Date monthAgo = Date.from(tempMonthAgo.atStartOfDay(ZoneId.systemDefault()).toInstant());
		
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		//Sett avg pulse
		statistic.setMaxPulse(211-(age*0.64));
		//Funker dette hvis keySettene og Maps er tomme?!?!?
		Workout workout;
		int totalWorkouts = 0;
		int kilometers = 0;
		int minutes = 0;
		int tempPulse = 0;//Denne brukes til beregning, for hver workout tempPulse += minutes (for økt)*pulse (for økt) til slutt del på antall minutter totalt
		Map<String, Workout> tempWorkouts = workouts.getRunning();
		if (tempWorkouts!=null) {
			for (String key : tempWorkouts.keySet()){
				Date date = format.parse(key);
				if (date.after(monthAgo)) {
					workout = tempWorkouts.get(key);
					
					minutes += workout.getDuration();
					kilometers += workout.getDistance();
					totalWorkouts += 1;
					tempPulse += workout.getDuration()*workout.getPulse();
				}
			}
		}
		statistic.setRunKm(kilometers);
		statistic.setRunMin(minutes);
		statistic.setTotalRuns(totalWorkouts);
		if(minutes>0) {
			statistic.setAvgRunPulse(tempPulse/minutes);
		}
		
		kilometers = 0;
		minutes = 0;
		totalWorkouts = 0;
		tempPulse = 0;
		tempWorkouts = workouts.getBiking();
		if (tempWorkouts!=null) {
			for (String key : tempWorkouts.keySet()){
				Date date = format.parse(key);
				if (date.after(monthAgo)) {
					workout = tempWorkouts.get(key);
					
					minutes += workout.getDuration();
					kilometers += workout.getDistance();
					totalWorkouts += 1;
					tempPulse += workout.getDuration()*workout.getPulse();
				}
			}
		}
		statistic.setBikeKm(kilometers);
		statistic.setBikeMin(minutes);
		statistic.setTotalBikes(totalWorkouts);
		if(minutes>0) {
			statistic.setAvgBikePulse(tempPulse/minutes);
		}
		
		kilometers = 0;
		minutes = 0;
		totalWorkouts = 0;
		tempPulse = 0;
		tempWorkouts = workouts.getSwimming();
		if (tempWorkouts!=null) {
			for (String key : tempWorkouts.keySet()){
				Date date = format.parse(key);
				if (date.after(monthAgo)) {
					workout = tempWorkouts.get(key);
					
					minutes += workout.getDuration();
					kilometers += workout.getDistance();
					totalWorkouts += 1;
					tempPulse += workout.getDuration()*workout.getPulse();
				}
			}
		}
		statistic.setSwimKm(kilometers);
		statistic.setSwimMin(minutes);
		statistic.setTotalSwims(totalWorkouts);
		if(minutes>0) {
			statistic.setAvgSwimPulse(tempPulse/minutes);
		}
		//For nå er statistikk litt enkel, om mulig kan vi forbedre med formler som tar mer til hensyn forskjellen mellom korte og lange økter
		return statistic;
	}
	
	//Getters & Setters
	public void setStatistics(Map<String, Statistic> statistics) {
		this.statistics = statistics;
	}
	public Map<String,Statistic> getStatistics() {
		return this.statistics;
	}



}
