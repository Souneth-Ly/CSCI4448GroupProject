package spring.model;

public class AbstractUser {
	private String name="omit";
	//private String email;
	private String userName;
	private String password;
	private String[] info={userName,password};
	
	public String[] getLogin(){
		//info={this.userName,this.password};
		return info;
	}
	public void setLogin(String newUserName,String newPassword){ //Apparently the login form sends the data into this class
		//this.info={newUserName,newPassword};
		this.info[0]=newUserName;
		this.info[1]=newPassword;
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
	public void changeName(String newName){
		this.name=newName;
	}

}
