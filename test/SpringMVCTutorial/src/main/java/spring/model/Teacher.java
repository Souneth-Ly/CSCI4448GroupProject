package spring.model;

public class Teacher extends AbstractUser {
	private String report;
	private String type="Teacher";
	public void displayReport(){
		System.out.print(report);
	}
	public void getStudent(){
		
	}
	public void getClasses(){
		
	}
	public String getType(){
		return type;
	}
}
