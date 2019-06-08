package dao;

import java.sql.Timestamp;

public class Cameralog {

	public Cameralog(String no, int id, int account, Timestamp time) {
		super();
		this.no = no;
		this.id = id;
		this.account = account;
		this.time = time;
	}

	public String getNo() {
		return no;
	}

	public void setNo(String no) {
		this.no = no;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getAccount() {
		return account;
	}

	public void setAccount(int account) {
		this.account = account;
	}

	public Timestamp getTime() {
		return time;
	}

	public void setTime(Timestamp time) {
		this.time = time;
	}

	private String no;
	private int id;
	private int account;
	private Timestamp time;
}
