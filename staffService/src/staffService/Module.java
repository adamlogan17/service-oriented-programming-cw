package staffService;

public class Module {
	ModuleCode mc;
	String academicYear;
	double mark;
	
	public Module(ModuleCode mcForModule, String yearTaught) {
		this.mc = mcForModule;
		this.academicYear = yearTaught; // need to do regex check here
	}
	
	public void addMark(int newMark) {
		// need to do check for 0 to 100 here
		mark = newMark;
	}
	
	public double getMark() {
		return mark;
	}
	
	public ModuleCode getMc() {
		return mc;
	}
}