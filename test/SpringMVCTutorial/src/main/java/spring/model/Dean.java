package spring.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.springframework.beans.factory.annotation.Autowired;

import spring.database.DatabaseCaller;

import javax.persistence.Column;

@Entity
@Table(name="DEAN")
public class Dean extends AbstractUser {
	

	
	public Dean() {
		super();
	}

	@Column(name = "TYPE")
	private String type = "Dean";
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	

	
	public Dean(String name, String userName, String password) {
		super(name, userName, password);

	}
	
	
	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
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
		if (!(obj instanceof Dean))
			return false;
		Dean other = (Dean) obj;
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
		+ this.getPassword()  + "]";
	}
	
	
}
