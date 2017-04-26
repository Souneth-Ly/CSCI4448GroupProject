package spring.model;
//this needs to be updated to put the classes in database
public class UserFactory {
	public static AbstractUser newUser(String type,String name,String username,String password)
	{
		if (type.equals("Dean")) {
			return Dean.getDean();
		} else if (type.equals("Student")) {
			return new Student();
		} else if (type.equals("Teacher")) {
			return new Teacher();
		} else return null;
	}
}
