package fr.epsi.myEpsi.beans;


public class User {

	private String id;
	private String password;
	private Boolean administrator;
	
	public User(String id, String password, boolean administrator) {
		this.id = id;
		this.password = password;
		this.administrator = administrator;
	}
	public User() {
		// TODO Auto-generated constructor stub
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Boolean getAdministrator() {
		return administrator;
	}
	public void setAdministrator(Boolean administrator) {
		this.administrator = administrator;
	}
	
}
