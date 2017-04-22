package spring.model;

public class AbstractUser {
	private String name;
	//private String email;
	private String username;
	private String password;
	public AbstractUser(){
		this.name="Ivan";
		this.username="tsar";
		this.password="rule";
	}
	
	public AbstractUser(String name,String username,String password){
		this.name=name;
		this.username=username;
		this.password=password;
	}
//	private String[] info={userName,password};
	
//	public String[] getLogin(){
//		info={this.userName,this.password};
//		return info;
//	}
//	public void setLogin(String newUserName,String newPassword){ //Apparently the login form sends the data into this class
		//this.info={newUserName,newPassword};
//		this.info[0]=newUserName;
//		this.info[1]=newPassword;
//	}
	
	
	public String getUserName(){
		return username;
	}
	public String getName(){
		return name;
	}
	public void setName(String newName){
		this.name=newName;
	}
	
	public String getPassword(){
		return password;
	}
	public void setUserName(String newUserName){
		this.username=newUserName;
	}
	public void setPassword(String newPassword){
		this.password=newPassword;
	}
	public void logout(){
		System.out.print(name);
	}
	public void changeName(String newName){
		this.name=newName;
	}

}
