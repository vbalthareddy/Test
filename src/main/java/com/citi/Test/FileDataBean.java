package com.citi.Test;

public class FileDataBean {
	private int satisfaction;
	private int time;
	private double satisfactionPerSec;

	public int getSatisfaction() {
		return satisfaction;
	}
	public void setSatisfaction(int satisfaction) {
		this.satisfaction = satisfaction;
	}
	public int getTime() {
		return time;
	}
	public void setTime(int time) {
		this.time = time;
	}	
	public double getSatisfactionPerSec() {
		return satisfactionPerSec;
	}
	public void setSatisfactionPerSec(double satisfactionPerSec) {
		this.satisfactionPerSec = satisfactionPerSec;
	}
	@Override
	public String toString() {
		return "FileDataBean [satisfaction=" + satisfaction + ", time=" + time + ", satisfactionPerSec="
				+ satisfactionPerSec + "]\n";
	}
	
	
}
