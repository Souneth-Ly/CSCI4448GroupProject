package spring.model;


import javax.validation.constraints.Digits;
import javax.persistence.*;
//import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


//import org.hibernate.annotations.Type;
//import org.hibernate.validator.constraints.NotEmpty;
//import org.joda.time.LocalDate;
//import org.springframework.format.annotation.DateTimeFormat;

//@Entity
//@MappedSuperclass
//@Table(name="STUDENT")
public class Student extends AbstractUser{
	
	
	
//	@Id
//	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private int id;
	
//	@Size(min = 5, max = 500)
//	@Column(name = "REPORT", nullable = false)
	private String report;
	
//	@Digits(integer=6, fraction=2)
//    @Column(name = "TUITION", nullable = false)
	private float tuition;
	
	private String type = "Student";

	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public Student(int id, String report, float tuition) {
		super();
		this.id = id;
		this.report = report;
		this.tuition = tuition;
	}
	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Student(String name, String userName, String password, String[] info,int id, String report, float tuition) {
		super(name, userName, password, info);
		this.id = id;
		this.report = report;
		this.tuition = tuition;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getReport() {
		return report;
	}
	public void setReport(String report) {
		this.report = report;
	}
	public float getTuition() {
		return tuition;
	}
	public void setTuition(float tuition) {
		this.tuition = tuition;
	}
	public void displayClasses(){
		
	}
	public void displayReport(){
		System.out.print(report);
	}
	public void payTuition(float amount){
		this.tuition=this.tuition-amount;
	}
}
