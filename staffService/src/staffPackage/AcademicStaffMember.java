package staffPackage;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;

@XmlAccessorType(XmlAccessType.FIELD)
public class AcademicStaffMember {
	private int id;
	private StaffModuleCode[] taughtMcs = new StaffModuleCode[2];
	private StaffModule[] taughtModules = new StaffModule[2];
	
	public AcademicStaffMember() {}
	
	public AcademicStaffMember(int newID) {
		this.id = newID;
	}
	
	public boolean ifMcExists(StaffModuleCode mc) {
		for(StaffModuleCode enrolledMc: taughtMcs) {
			if(enrolledMc == mc) {
				return true;
			}
		}
		return false;
	}
	
	public void addModule(StaffModule newModule) {
		for (int i = 0; taughtMcs.length > i; i++) {
			if(taughtMcs[i] == null) {
				taughtMcs[i] = newModule.getMc();
				taughtModules[i] = newModule;
				break;
			}
		}
	}
	
	public void setId(int newId) {
		this.id = newId;
	}
	
	public int getId() {
		return id;
	}
}