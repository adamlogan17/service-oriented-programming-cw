package testPackage;

import java.net.URL;
import java.net.MalformedURLException;

import javax.xml.namespace.QName;
import javax.xml.ws.Service;

import controllerpackage.ControllerInterface;
import controllerpackage.Role;
import studentservice.Students;

public class MainTest {

	public static void main(String[] args) throws MalformedURLException {
		URL url = new URL( "http://localhost:8080/controllerService/?wsdl" );

		QName qname = new QName( "http://controllerPackage/", "ControllerService" );

		Service service = Service.create( url, qname );

		ControllerInterface obj = service.getPort( ControllerInterface.class );
		
		obj.registration(Role.ACADEMIC_STAFF_MEMBER, 6);
		
		//String details = obj.studentDetails(x);
	}

}
