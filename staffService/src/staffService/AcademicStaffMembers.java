package staffService;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;


@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement
public class AcademicStaffMembers {
	private AcademicStaffMember[] allStaff = new AcademicStaffMember[100];
	
	public AcademicStaffMembers() {
		
	}
	
	public void add(AcademicStaffMember newStaff) {
		// need to add check to prevent it from going above 100
		System.out.println("id in add staff = " + newStaff.getId());
		for (int i = 0; allStaff.length > i; i++) {
			if(allStaff[i] == null) {
				allStaff[i] = newStaff;
				break;
			}
		}
	}
	
	public AcademicStaffMember getAStaffMember(int id) {
		for(AcademicStaffMember staff: allStaff) {
			if(staff == null) {
				return null;
			}
			if(staff.getId() == id) {
				return staff;
			}
		}
		return null;
	}
	
	public AcademicStaffMember[] getAllStaff() {
		return allStaff;
	}
}