package projectoop;

import java.io.Serializable;
import java.util.Vector;

public class Specialty implements Serializable {
	private String specialtyName;
	private Vector<String> specialtyPlan = new Vector<String>();
  
	public Specialty(String specialtyName) {
		super();
		this.specialtyName = specialtyName;
	}
	
	public Specialty() {
	
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((specialtyName == null) ? 0 : specialtyName.hashCode());
		result = prime * result + ((specialtyPlan == null) ? 0 : specialtyPlan.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Specialty other = (Specialty) obj;
		if (specialtyName == null) {
			if (other.specialtyName != null)
				return false;
		} else if (!specialtyName.equals(other.specialtyName))
			return false;
		if (specialtyPlan == null) {
			if (other.specialtyPlan != null)
				return false;
		} else if (!specialtyPlan.equals(other.specialtyPlan))
			return false;
		return true;
	}

	public void setSpecialtyPlan(String plan){
		specialtyPlan.add(plan);
	}
	public Vector<String> getSpecialtyPlan(){
		return specialtyPlan;
	}
	public void setSpecialtyName(String name){
		specialtyName = name;
	}
	public String getSpecialtyName(){
		return specialtyName;
	}
}
