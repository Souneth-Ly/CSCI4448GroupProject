package spring.model;

public class Student extends AbstractUser{
	private String report;
	private String type="Student";
	private float tuition;
	public void displayClasses(){
		
	}
	public void displayReport(){
		System.out.print(report);
	}
	public void payTuition(float amount){
		this.tuition=this.tuition-amount;
	}
	public String getType(){
		return type;
	}
}
