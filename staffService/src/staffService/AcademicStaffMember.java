package staffService;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;

@XmlAccessorType(XmlAccessType.FIELD)
public class AcademicStaffMember {
	private int id;
	private ModuleCode[] taughtMcs = new ModuleCode[2];
	private Module[] taughtModules = new Module[2];
	
	public AcademicStaffMember() {}
	
	public AcademicStaffMember(int newID) {
		this.id = newID;
	}
	
	public void setId(int newId) {
		this.id = newId;
	}
	
	public int getId() {
		return id;
	}
}