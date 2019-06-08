package dao;

public class User {
	
	private String name;
	private String email;
	private String pswd;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPswd() {
		return pswd;
	}
	public void setPswd(String pswd) {
		this.pswd = pswd;
	}
	public User(String name, String email, String pswd) {
		super();
		this.name = name;
		this.email = email;
		this.pswd = pswd;
	}
}
