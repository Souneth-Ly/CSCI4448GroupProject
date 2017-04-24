package spring.model;
public class Dean extends AbstractUser {
	private String type = "Dean";
	private static Dean theDean;

	private Dean() { }
	public static Dean getDean()
	{
		if(theDean == null){
			theDean = new Dean();
		}
		return theDean;
	}
	
	
	
	public String getType() {
		return type;
	}
	
	public void setType(String type) {
		this.type = type;
	}
	public void addClass(){
		
	}
	public void removeClass(){
		
	}
	public void setTuition(){
		
	}
	public void displayStudentList()
	{
		
	}
	public void displayTeacherList(){
		
	}
}
