package dao;

import com.sun.jmx.snmp.Timestamp;

public class Camera {
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getThreshold() {
		return threshold;
	}
	public void setThreshold(int threshold) {
		this.threshold = threshold;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public int getAccount() {
		return account;
	}
	public void setAccount(int account) {
		this.account = account;
	}
	public int getHightest() {
		return hightest;
	}
	public void setHightest(int hightest) {
		this.hightest = hightest;
	}
	public int getHour_highest() {
		return hour_highest;
	}
	public void setHour_highest(int hour_highest) {
		this.hour_highest = hour_highest;
	}
	public Timestamp getTime() {
		return time;
	}
	public void setTime(Timestamp time) {
		this.time = time;
	}
	private int id;
	private int threshold;
	private String location;
	private int account;
	private int hightest;
	private int hour_highest;
	private Timestamp time;
}
