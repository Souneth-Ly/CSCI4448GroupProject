package spring.model;

public class UserFactory {
	public static AbstractUser newUser(String type)
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
