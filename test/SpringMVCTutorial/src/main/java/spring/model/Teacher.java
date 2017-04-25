package spring.model;

public class Teacher extends AbstractUser {
	private String report;
	private String type = "Teacher";
	
	public String getReport() {
		return report;
	}
	public void setReport(String report) {
		this.report = report;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public void displayReport(){
		System.out.print(report);
	}
	public void getStudent(){
		
	}
	public void getClasses(){
		
		//super.name="bob";
	}
}
