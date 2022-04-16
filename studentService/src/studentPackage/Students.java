package studentPackage;

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
		for (int i = 0; allStudents.length > i; i++) {
			if(allStudents[i] == null) {
				allStudents[i] = newStudent;
				break;
			}
		}
	}
	
	public Student getAStudent(int id) {
		for(Student stud: allStudents) {
			if(stud == null) {
				return null;
			}
			if(stud.getId() == id) {
				return stud;
			}
		}
		return null;
	}
	
	public Student[] getAllStudents() {
		return allStudents;
	}
}
