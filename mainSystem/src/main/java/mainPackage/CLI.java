package mainPackage;

import java.net.MalformedURLException;
import java.net.URL;

import javax.xml.namespace.QName;
import javax.xml.ws.Service;

import controllerpackage.ControllerInterface;
import controllerpackage.Role;
import staffpackage.StaffModuleCode;
import studentpackage.StudentModuleCode;

public class CLI {

	public static void main(String[] args) throws MalformedURLException {
		URL url = new URL( "http://localhost:8080/controllerService/?wsdl" );

		QName qname = new QName( "http://controllerPackage/", "ControllerImplService" );

		Service service = Service.create( url, qname );

		ControllerInterface cont = service.getPort( ControllerInterface.class );
		
		batchRegistration(cont);
		
		System.out.println("\n2. Enrolling a student on a module\n");
		enroll(cont, 0, StudentModuleCode.CSC_1022, "AY_2021_22", 1);
		enroll(cont, 5, StudentModuleCode.CSC_1022, "AY_2021_22", 7);
		enroll(cont, 5, StudentModuleCode.CSC_1022, "AY_2021_22", 1);
		
		System.out.println("\n3. Inserting a new mark\n");
		insertMark(cont, 0, StudentModuleCode.CSC_1022, 100, 1);
		insertMark(cont, 5, StudentModuleCode.CSC_1023, 100, 1);
		insertMark(cont, 5, StudentModuleCode.CSC_1022, 100, 7);
		insertMark(cont, 5, StudentModuleCode.CSC_1022, 100, 1);
		
		System.out.println("\n4. Reporting the mark of a student\n");
		printMark(cont, 2, StudentModuleCode.CSC_1022, 1);
		printMark(cont, 5, StudentModuleCode.CSC_1022, 1);
		
		System.out.println("\n5. Assigning a module to an academic staff member\n");
		assign(cont, 2, StaffModuleCode.CSC_1022, "AY_2021_22");
		assign(cont, 5, StaffModuleCode.CSC_1022, "AY_2021_22");
	}
	
	// Use case 1 - Batch Registration
	private static void batchRegistration(ControllerInterface cont) {
		System.out.println("1. Batch registration of end-users\n");
		
		// Enrolling the students
		for(int i=0; i<=4; i++) {
			cont.registration(Role.STUDENT, i);
			System.out.println("Enrolling the " + Role.STUDENT + " with ID " + i + "\n");
		}
		
		// Enrolling the staff
		for(int i=5; i<=6; i++) {
			cont.registration(Role.ACADEMIC_STAFF_MEMBER, i);
			System.out.println("Enrolling the " + Role.ACADEMIC_STAFF_MEMBER + " with ID " + i + "\n");
		}
	}
	
	// Use case 2 - Enrolling a student on a module
	private static void enroll(ControllerInterface cont, int staffId, StudentModuleCode mc, String academicYear, int studId) {
		if(cont.enroll(staffId, mc, academicYear, studId) == -1) System.out.println("Error enrolling student with ID " + studId + " by the"
				+ " academic staff member with ID " + staffId);
		else System.out.println("Successful enrolment of the student with ID " + studId + " on the module with code " + mc.toString().replaceAll("_", "") +", "
				+ academicYear + " by the academic staff member with ID " + staffId);
		System.out.println();
	}

	// Use case 3 - Giving a student a mark on a module
	private static void insertMark(ControllerInterface cont, int staffId, StudentModuleCode mc, double mark, int studId) {
		if(cont.insertMark(staffId, mc, mark, studId) == -1) System.out.println("Error inserting the mark " + mark + " for the student with ID " + studId
				+ " on the module with code " + mc.toString().replaceAll("_", "") + " by the academic staff member with ID " + staffId);
		else System.out.println("Successful insertion of the mark " + mark + " for the student with ID " + studId + " on the module with code " + mc.toString().replaceAll("_", "")
				+ " by the academic staff member with ID " + staffId);
		System.out.println();
	}

	// Use case 4 - Reports the mark of a student in a given module
	private static void printMark(ControllerInterface cont, int staffId, StudentModuleCode mc, int studId) {
		String result = cont.printMark(staffId, mc, studId);
		if(result.equals("")) {
			System.out.println("Error reporting the module for the student with ID " + studId + " by the academic staff member with "
					+ "ID " + staffId);
		} else {
			System.out.println("Reporting the module for the student with ID " + studId + " by the academic staff member with ID "
					+ staffId + result);
		}
		System.out.println();
	}

	// Use case 5 - Assigns a staff member to a module
	private static void assign(ControllerInterface cont, int staffId, StaffModuleCode mc, String academicYear) {
		if(cont.assign(staffId, mc, academicYear) == -1) System.out.println("Error assignment of the module " + mc.toString().replaceAll("_", "") + ", " + academicYear + " to the academic staff member with"
				+ " ID " + staffId);
		else System.out.println("Successful assignment of the module " + mc.toString().replaceAll("_", "") + ", " + academicYear + " to the academic staff member"
				+ " with ID " + staffId);
		System.out.println();
	}
}