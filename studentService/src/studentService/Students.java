package studentService;

public class Students {
	private Student[] allStudents = new Student[1000];
	
	public Students() {
		
	}
	
	public void add(Student newStudent) {
		// need to add check to prevent it from going above 100
		Student temp[] = new Student[allStudents.length + 1];
		
		for (int i = 0; allStudents.length > i; i++) {
			temp[i] = allStudents[i];
		}
		temp[allStudents.length] = newStudent;
		allStudents=temp;
	}
	
	public Student[] getStudents() {
		return allStudents;
	}
}
