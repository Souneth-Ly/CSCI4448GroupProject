package spring.model;

public class AbstractUser {
	private String name="omit";
	//private String email;
	private String userName;
	private String password;
	public String[] login(){
		String[] array={userName,password};
		return array;
	}
	public String getUserName(){
		return userName;
	}
	public String getPassword(){
		return password;
	}
	public void logout(){
		System.out.print(name);
	}
	public void changeName(String newName){
		this.name=newName;
	}
}
