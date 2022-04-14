package mainPackage;

import java.net.MalformedURLException;
import java.net.URL;

import javax.xml.namespace.QName;
import javax.xml.ws.Service;

import controllerpackage.ControllerInterface;
import controllerpackage.Role;
import studentservice.ModuleCode;

public class CLI {

	public static void main(String[] args) throws MalformedURLException {
		URL url = new URL( "http://localhost:8080/controllerService/?wsdl" );

		QName qname = new QName( "http://controllerPackage/", "ControllerService" );

		Service service = Service.create( url, qname );

		ControllerInterface cont = service.getPort( ControllerInterface.class );
		
		batchRegistration(cont);
		
		System.out.println("2. Enrolling a student on a module\n");
		enroll(cont, 0, ModuleCode.CSC_1022, "AY_2021_22", 1);
		enroll(cont, 5, ModuleCode.CSC_1022, "AY_2021_22", 7);
		enroll(cont, 5, ModuleCode.CSC_1022, "AY_2021_22", 1);
		
		System.out.println("3. Inserting a new mark\n");
		insertMark(cont, 0, ModuleCode.CSC_1022, 100, 1);
		insertMark(cont, 5, ModuleCode.CSC_1023, 100, 1);
		insertMark(cont, 5, ModuleCode.CSC_1022, 100, 7);
		insertMark(cont, 5, ModuleCode.CSC_1022, 100, 1);
	}
	
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
	
	private static void enroll(ControllerInterface cont, int staffId, ModuleCode mc, String annualYear, int studId) {
		if(cont.enroll(staffId, mc, annualYear, studId) == -1) System.out.println("Error enrolling student with ID " + studId + " by the"
				+ " academic staff member with ID " + staffId);
		else System.out.println("Successful enrolment of the student with ID " + studId + " on the module with code " + mc +", "
				+ annualYear + " by the academic staff member with ID " + staffId);
		System.out.println();
	}
	
	private static void insertMark(ControllerInterface cont, int staffId, ModuleCode mc, double mark, int studId) {
		if(cont.insertMark(staffId, mc, mark, studId) == -1) System.out.println("Error inserting the mark " + mark + " for the student with ID " + studId
				+ "on the module with code " + mc + " by the academic staff member with ID" + staffId);
		else System.out.println("Successful insertion of the mark " + mark + " for the student with ID " + studId + " on the module with code " + mc
				+ " by the academic staff member with ID " + staffId);
		System.out.println();
	}
}
