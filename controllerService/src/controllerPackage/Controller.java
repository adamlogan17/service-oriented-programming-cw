package controllerPackage;

import java.net.MalformedURLException;
import java.net.URL;

import javax.jws.WebService;
import javax.xml.namespace.QName;
import javax.xml.ws.Service;

import studentservice.Students;
import studentservice.StudentsInterface;

@WebService(endpointInterface="controllerPackage.ControllerInterface")

public class Controller implements ControllerInterface
{
	private StudentsInterface connectService() throws MalformedURLException {
		URL url = new URL( "http://localhost:8080/studentService/?wsdl" );

		QName qname = new QName( "http://studentService/", "StudentsImplService" );

		Service service = Service.create( url, qname );

		StudentsInterface obj = service.getPort( StudentsInterface.class );
		
		return obj;
	}
	
	public Students registration(int id, Students allStudents) {
		StudentsInterface obj = null;
		try {
			obj = connectService();
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		allStudents = obj.addStudent(id, allStudents);
		
		System.out.println(obj.studentDetails(allStudents));
		
		return allStudents;
	}

	public boolean loginCheck(String username, String password) {
		// TODO Auto-generated method stub
		return false;
	}

	public String studentDetails(Students allStudents) {
		StudentsInterface obj = null;
		try {
			obj = connectService();
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		String details = obj.studentDetails(allStudents);
		return details;
	}

}