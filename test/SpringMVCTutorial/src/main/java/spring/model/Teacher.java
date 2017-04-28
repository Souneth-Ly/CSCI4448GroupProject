package spring.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="TEACHER")
public class Teacher extends AbstractUser {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name = "REPORT")
	private String report;
	
	@Column(name = "type")
	private String type = "Teacher";
	
	
	public Teacher(String report) {
		super();
		this.report = report;
	}
	public Teacher() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Teacher(String name, String userName, String password) {
		super(name, userName, password);
		// TODO Auto-generated constructor stub
	}
	public String getReport() {
		return report;
	}
	public void setReport(String report) {
		this.report = report;
	}
	public String getType() {
		return type;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof Student))
			return false;
		Teacher other = (Teacher) obj;
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
		+ this.getPassword() + ", report=" + "]";
	}
}
