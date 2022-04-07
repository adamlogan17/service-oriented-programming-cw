package staffService;

public class AcademicStaffMember {
	private int id;
	private ModuleCode[] taughtMcs = new ModuleCode[2];
	private Module[] taughtModules = new Module[2];
	
	public AcademicStaffMember(int newID) {
		this.id = newID;
	}
}
