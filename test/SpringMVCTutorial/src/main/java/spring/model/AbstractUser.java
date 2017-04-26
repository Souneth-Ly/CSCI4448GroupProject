package spring.model;


import javax.persistence.MappedSuperclass;

@MappedSuperclass
public class AbstractUser {
	

	private String name;
	private String userName;
	private String password;
	

	public AbstractUser(){
		name = "";
		userName = "";
		password = "";

	}
	
	public AbstractUser(String name, String userName, String password, String[] info) {
		this.name = name;
		this.userName = userName;
		this.password = password;

	}


	
	
	public String getUserName(){
		return userName;
	}
	public String getPassword(){
		return password;
	}
	public void setUserName(String newUserName){
		this.userName=newUserName;
	}
	public void setPassword(String newPassword){
		this.password=newPassword;
	}
	
	public void logout(){
		System.out.print(name);
	}

	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}


}
