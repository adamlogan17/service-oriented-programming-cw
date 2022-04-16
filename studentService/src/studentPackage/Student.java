package studentPackage;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;

@XmlAccessorType(XmlAccessType.FIELD)
public class Student {
	private int id;
	private StudentModuleCode[] enrolledMcs = new StudentModuleCode[20];
	private StudentModule[] enrolledModules = new StudentModule[20];
	
	public Student() {}
	
	public Student(int newID) {
		this.id = newID;
	}
	
	public void addMc(StudentModule newModule) {
		for (int i = 0; enrolledMcs.length > i; i++) {
			if(enrolledMcs[i] == null) {
				enrolledMcs[i] = newModule.getMc();
				enrolledModules[i] = newModule;
				break;
			}
		}
	}
	
	public boolean ifMcExists(StudentModuleCode mc) {
		for(StudentModuleCode enrolledMc: enrolledMcs) {
			if(enrolledMc == mc) {
				return true;
			}
		}
		return false;
	}
	
	public void setId(int newId) {
		this.id = newId;
	}
	
	public int getId() {
		return id;
	}
	
	public void addMark(StudentModuleCode mc, double mark) {
		for (int i = 0; enrolledModules.length > i; i++) {
			if(enrolledModules[i] != null) {
				if (enrolledModules[i].getMc() == mc) enrolledModules[i].addMark(mark);
			}
		}
	}
	
	public String getModuleDetails(StudentModuleCode mc) {
		String result = "";
		for (int i = 0; enrolledModules.length > i; i++) {
			if(enrolledModules[i] != null) {
				if (enrolledModules[i].getMc() == mc) {
					 result = " " + enrolledModules[i].getMc() + " " + enrolledModules[i].getAcademicYear() + " " + Double.toString(enrolledModules[i].getMark());
				}
			}
		}
		return result;
	}
}