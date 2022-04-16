package staffPackage;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;

@XmlAccessorType(XmlAccessType.FIELD)
public class StaffModule {
	private StaffModuleCode mc;
	private String academicYear;
	private double mark;
	
	public StaffModule() {};
	
	public StaffModule(StaffModuleCode mcForModule, String yearTaught) {
		this.mc = mcForModule;
		this.academicYear = yearTaught;
	}
	
	public void addMark(double newMark) {
		mark = newMark;
	}
	
	public double getMark() {
		return mark;
	}
	
	public StaffModuleCode getMc() {
		return mc;
	}
}