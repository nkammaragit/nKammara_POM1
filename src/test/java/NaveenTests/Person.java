package NaveenTests;

public class Person {
	private String name;
	private int empId;
	
	public void setName(String name) {
		 this.name=name;
	}
	public String getName() {
		return name; 
	}
	
	public void setEmpId(int empId) {
		if(empId<=0) throw new IllegalArgumentException("Invalid empId");
		this.empId=empId;
	}
	public int getEmpId() {
		return empId;
	}
	
	
	

}
