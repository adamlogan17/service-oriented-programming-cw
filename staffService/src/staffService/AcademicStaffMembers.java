package staffService;

public class AcademicStaffMembers {
	private AcademicStaffMember[] allStaff = new AcademicStaffMember[100];
	
	public AcademicStaffMembers() {
		
	}
	
	public void add(AcademicStaffMember newStaff) {
		// need to add check to prevent it from going above 100
		AcademicStaffMember temp[] = new AcademicStaffMember[allStaff.length + 1];

		for (int i = 0; allStaff.length > i; i++) {
			temp[i] = allStaff[i];
		}
		temp[allStaff.length + 1] = newStaff;
		allStaff = temp;
	}
	
	public AcademicStaffMember[] getAllStaff() {
		return allStaff;
	}
}
