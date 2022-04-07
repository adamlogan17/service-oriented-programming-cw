package studentService;

import javax.jws.WebService;

@WebService(endpointInterface="studentService.StudentsInterface")
public class StudentsImpl implements StudentsInterface {
	
	public boolean loginCheck(String a, String b) {
		return true;
	}
	
	public Students addStudent(int id, Students allStudents) {
		Student newStudent = new Student(id);
		allStudents.add(newStudent);
		return allStudents;
	}
	
	public String studentDetails(Students allStudents) {
		String details = "";
		
		Student[] arryOfStudents = allStudents.getStudents();
		
		for(Student stud: arryOfStudents) {
			if(stud != null) {
				details += stud.getId() + "\n";
			}
		}
		
 		return details;
	}
}
