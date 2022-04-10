package controllerPackage;

import java.net.MalformedURLException;
import java.net.URL;

import javax.jws.WebService;
import javax.xml.namespace.QName;
import javax.xml.ws.Service;

import studentservice.IOException_Exception;
import studentservice.JAXBException_Exception;
import studentservice.Student;
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
	
	public void registration(Role roleOfUser, int id) {
		StudentsInterface obj = null;
		try {
			obj = connectService();
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Student newStudent = new Student();
		newStudent.setId(id);
		try {
			obj.addStudent(newStudent);
		} catch (IOException_Exception | JAXBException_Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public boolean loginCheck(String username, String password) {
		// TODO Auto-generated method stub
		return false;
	}

}