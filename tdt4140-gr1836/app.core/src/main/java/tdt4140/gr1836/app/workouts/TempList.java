package tdt4140.gr1836.app.workouts;

import com.jfoenix.controls.datamodels.treetable.RecursiveTreeObject;

public class TempList extends RecursiveTreeObject<TempList> {
	private String date;
	private double duration, pulse, distance;
	private String type;

	public TempList(String date, String type, double pulse, double duration, Double distance) {
		this.date = date;
		this.type = type;
		this.pulse = pulse;
		this.duration = duration;
		this.distance = distance;
	}

	public String getDate() {
		return this.date;
	}

	public double getDuration() {
		return this.duration;
	}

	public double getPulse() {
		return this.pulse;
	}

	public String getType() {
		return this.type;
	}

	public Double getDistance() {
		return this.distance;
	}
}
