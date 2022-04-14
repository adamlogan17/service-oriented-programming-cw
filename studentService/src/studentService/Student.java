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
	
	public void addMc(ModuleCode mc, String annualYear) {
		Module newModule = new Module(mc , annualYear);
		
		for (int i = 0; enrolledMcs.length > i; i++) {
			if(enrolledMcs[i] == null) {
				enrolledMcs[i] = mc;
				enrolledModules[i] = newModule;
				break;
			}
		}
	}
	
	public boolean ifMcExists(ModuleCode mc) {
		for(ModuleCode enrolledMc: enrolledMcs) {
			System.out.println(enrolledMc);
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
	
	public void addMark(ModuleCode mc, double mark) {
		for (int i = 0; enrolledModules.length > i; i++) {
			if(enrolledModules[i] != null) {
				if (enrolledModules[i].getMc() == mc) enrolledModules[i].addMark(mark);
			}
		}
	}
	
	public String getModuleDetails(ModuleCode mc) {
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