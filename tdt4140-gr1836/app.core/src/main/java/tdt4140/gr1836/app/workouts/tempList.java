package tdt4140.gr1836.app.workouts;


public class tempList {
	private String date;
	private String duration;
	private String intensity;
	private String type;

	public tempList(String date,String type,String intensity,String duration){
		this.date=date;
		this.type=type;
		this.intensity=intensity;
		this.duration=duration;
	}
	public String getDate() {
		return this.date;
	}
	public String getDuration() {
		return this.duration;
	}
	public String getIntensity() {
		return this.intensity;
	}
	public String getType() {
		return this.type;
	}
}
