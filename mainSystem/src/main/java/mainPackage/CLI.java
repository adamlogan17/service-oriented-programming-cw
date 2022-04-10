package mainPackage;

import java.net.MalformedURLException;
import java.net.URL;

import javax.xml.namespace.QName;
import javax.xml.ws.Service;

import controllerpackage.ControllerInterface;
import controllerpackage.Role;

public class CLI {

	public static void main(String args[])
	{
		try {
			URL url;
			url = new URL( "http://localhost:8080/controllerService/?wsdl" );
			QName qname = new QName( "http://controllerPackage/", "ControllerService" );
			Service service = Service.create( url, qname );
			ControllerInterface obj = service.getPort(ControllerInterface.class);
			
			obj.registration(Role.ACADEMIC_STAFF_MEMBER, 6);
			
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}


	}
}
