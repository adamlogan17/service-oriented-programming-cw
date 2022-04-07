package testPackage;

import java.net.URL;
import java.net.MalformedURLException;

import javax.xml.namespace.QName;
import javax.xml.ws.Service;

import controllerpackage.ControllerInterface;
import studentservice.Students;

public class MainTest {

	public static void main(String[] args) throws MalformedURLException {
		URL url = new URL( "http://localhost:8080/controllerService/?wsdl" );

		QName qname = new QName( "http://controllerPackage/", "ControllerService" );

		Service service = Service.create( url, qname );

		ControllerInterface obj = service.getPort( ControllerInterface.class );
		
		Students x = new Students();
		
		x = obj.registration(1, x);
		
		String details = obj.studentDetails(x);
		
		System.out.println(details);
		
		System.out.println("h");
	}

}
