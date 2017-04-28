package spring.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;



@Entity
@Table(name="STUDENT")
public class Student extends AbstractUser{
	
	public Student() {
		super();
	}

	public Student(String name, String userName, String password) {
		super(name, userName, password);
	}

	
	@Column(name = "TYPE")
	private String type = "Student";

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name = "REPORT")
	private String report;
	
	@Column(name = "TUITION", nullable = false)
	private double tuition;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	
	public String getReport(){
		return report;
	}
	
	public void setReport(String report){
		this.report = report;
	}
	
	public double getTuition(){
		return tuition;
	}
	
	public void setTuition(double tuition){
		this.tuition = tuition;
	}
	
	public String getType(){
		return type;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		result = prime * result + ((this.getName() == null) ? 0 : this.getName().hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof Student))
			return false;
		Student other = (Student) obj;
		if (id != other.id)
			return false;
		if (!this.getName().equals(other.getName())) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + this.getName() 
		+ ", username=" + this.getUserName() + ", password=" 
		+ this.getPassword() + ", report="
		+ report + ", tuition=" + tuition + "]";
	}
	
	
	

}
