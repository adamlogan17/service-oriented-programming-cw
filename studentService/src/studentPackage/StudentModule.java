package studentPackage;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;


@XmlAccessorType(XmlAccessType.FIELD)
public class StudentModule {
	private StudentModuleCode mc;
	private String academicYear;
	private double mark;
	
	public StudentModule() {};
	
	public StudentModule(StudentModuleCode mcForModule, String yearTaught) {
		this.mc = mcForModule;
		this.academicYear = yearTaught;
	}
	
	public void addMark(double newMark) {
		mark = newMark;
	}
	
	public double getMark() {
		return mark;
	}
	
	public StudentModuleCode getMc() {
		return mc;
	}
	
	public String getAcademicYear() {
		return academicYear;
	}
}
