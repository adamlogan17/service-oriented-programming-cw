package controllerPackage;

import javax.jws.WebService;

import staffpackage.StaffModuleCode;
import studentpackage.StudentModuleCode;

@WebService(endpointInterface = "controllerPackage.ControllerInterface")
public class ControllerImpl implements ControllerInterface {
	private static Controller cont = new Controller();
	
	public void registration(Role roleOfUser, int id) {
		cont.registration(roleOfUser, id);
		
	}

	public int enroll(int staffID, StudentModuleCode mc, String annualYear, int studentID) {
		return cont.enroll(staffID, mc, annualYear, studentID);
	}

	public int insertMark(int staffID, StudentModuleCode mc, double mark, int studentID) {
		return cont.insertMark(staffID, mc, mark, studentID);
	}

	public String printMark(int staffID, StudentModuleCode mc, int studentID) {
		return cont.printMark(staffID, mc, studentID);
	}

	public int assign(int staffID, StaffModuleCode mc, String academicYear) {
		return cont.assign(staffID, mc, academicYear);
	}
	
	
}