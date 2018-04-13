package tdt4140.gr1836.app.statistics;

import java.io.Serializable;

@SuppressWarnings("serial")
public class Statistic implements Serializable {
	//Saves stats for the last 30 days, each time you add a new value, your stats should be updated.
	/*bikeKm = sum
	
	swimKm = sum
	
	runKm = sum
	runSpeed = sum / sum runKm
	runPulse = sum / sum duration/ 10km, 60min, 100 puls, 2km, 10 min, 150 puls = 
	totalRuns = antall ganger løpt
	totalBikes
	totalSwims
	
	maxpulse based on age = formula
	
	powerLevel
	*/
	private int runKm, bikeKm, swimKm;
	
	// Empty constructor to make new object based on snapshot data from login
	public Statistic() {
		
	}
	public Statistic(int runKm, int bikeKm, int swimKm) {
		this.runKm = runKm;
		this.bikeKm = bikeKm;
		this.swimKm = swimKm;
	}
	//Getters
	public int getRunKm() {
		return this.runKm;
	}
	public int getBikeKm() {
		return this.bikeKm;
	}
	public int getSwimKm() {
		return this.swimKm;
	}
	//Setters
	public void setRunKm(int r) {
		this.runKm = r;
	}
	public void setBikeKm(int b) {
		this.bikeKm = b;
	}
	public void setSwimKm(int s) {
		this.swimKm = s;
	}

}
