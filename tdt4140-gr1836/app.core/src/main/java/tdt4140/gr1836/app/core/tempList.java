package tdt4140.gr1836.app.core;


public class tempList {
	public String date;
	public String duration;
	public String intensity;
	public String type;

	tempList(String date,String type,String intensity,String duration){
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
