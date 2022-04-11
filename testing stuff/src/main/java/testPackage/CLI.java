package testPackage;

import java.net.URL;
import java.net.MalformedURLException;

import javax.xml.namespace.QName;
import javax.xml.ws.Service;

import controllerpackage.ControllerInterface;
import controllerpackage.Role;

public class CLI {

	public static void main(String[] args) throws MalformedURLException {
		URL url = new URL( "http://localhost:8080/controllerService/?wsdl" );

		QName qname = new QName( "http://controllerPackage/", "ControllerService" );

		Service service = Service.create( url, qname );

		ControllerInterface cont = service.getPort( ControllerInterface.class );
		
		batchRegistration(cont);
	}
	
	private static void batchRegistration(ControllerInterface cont) {
		System.out.println("1. Batch registration of end-users");
		System.out.println();
		
		// enrolling the students
		for(int i=0; i<=4; i++) {
			cont.registration(Role.STUDENT, i);
			System.out.println("Enrolling the " + Role.STUDENT + " with ID " + i);
			System.out.println();
		}
		
		// enrolling the staff
		for(int i=5; i<=6; i++) {
			cont.registration(Role.ACADEMIC_STAFF_MEMBER, i);
			System.out.println("Enrolling the " + Role.ACADEMIC_STAFF_MEMBER + " with ID " + i);
			System.out.println();
		}
	}
}
