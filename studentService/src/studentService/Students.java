package studentService;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;


@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement
public class Students {
	private Student[] allStudents = new Student[1000];
	
	public Students() {
		
	}
	
	public void add(Student newStudent) {
		// need to add check to prevent it from going above 100
		System.out.println("id in add = " + newStudent.getId());
		for (int i = 0; allStudents.length > i; i++) {
			if(allStudents[i] == null) {
				allStudents[i] = newStudent;
				break;
			}
		}
	}
	
	public Student[] getAllStudents() {
		return allStudents;
	}
}
