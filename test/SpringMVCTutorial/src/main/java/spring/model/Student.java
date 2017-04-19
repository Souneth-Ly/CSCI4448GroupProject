package spring.model;

public class Student extends AbstractUser{
	private String report;
	private float tuition;
	public void displayClasses(){
		
	}
	public void displayReport(){
		System.out.print(report);
	}
	public void payTuition(float amount){
		this.tuition=this.tuition-amount;
	}
}
