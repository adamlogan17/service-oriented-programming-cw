package studentService;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;

@XmlAccessorType(XmlAccessType.FIELD)
public class Student {
	private int id;
	private ModuleCode[] enrolledMcs = new ModuleCode[20];
	private Module[] enrolledModules = new Module[20];
	
	public Student() {}
	
	public Student(int newID) {
		this.id = newID;
	}
	
	public void setId(int newId) {
		this.id = newId;
	}
	
	public int getId() {
		return id;
	}
}