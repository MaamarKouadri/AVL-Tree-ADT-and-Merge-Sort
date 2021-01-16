package Assignment4;

public class Student {
	
	private long StudentIDentificationCode;
	private String name;
	
	public Student(long studentIDentificationCode, String name) {
		StudentIDentificationCode = studentIDentificationCode;
		this.name = name;
	}
	
	public long getStudentIDentificationCode() {
		return StudentIDentificationCode;
	}
	public void setStudentIDentificationCode(long studentIDentificationCode) {
		StudentIDentificationCode = studentIDentificationCode;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public String toString() {
	
		//return "The name is " + this.name + " and the id is " + this.StudentIDentificationCode;
	return "The name is " + this.name + "The ID is "+this.StudentIDentificationCode;
	}

	
	public boolean equals(Student s) {
		
		if(this.name == s.name && this.StudentIDentificationCode == s.getStudentIDentificationCode()){
			return true;
		}
		else {
			return false;
		}
	}
	
	public void modifiesStudent(Student a) {
		
		this.StudentIDentificationCode = a.StudentIDentificationCode;
		this.name = a.name;
	}
	

}
