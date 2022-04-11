package controllerPackage;

import java.net.MalformedURLException;
import java.net.URL;

import javax.jws.WebService;
import javax.xml.namespace.QName;
import javax.xml.ws.Service;

import staffservice.AcademicStaffMember;
import staffservice.StaffsInterface;
import studentservice.Student;
import studentservice.StudentsInterface;

@WebService(endpointInterface="controllerPackage.ControllerInterface")

public class Controller implements ControllerInterface
{
	private StudentsInterface connectStudentService() throws MalformedURLException {
		URL url = new URL( "http://localhost:8080/studentService/?wsdl" );

		QName qname = new QName( "http://studentService/", "StudentsImplService" );

		Service service = Service.create( url, qname );

		StudentsInterface obj = service.getPort( StudentsInterface.class );
		
		return obj;
	}
	
	private StaffsInterface connectStaffService() throws MalformedURLException {
		URL url = new URL( "http://localhost:8080/staffService/?wsdl" );

		QName qname = new QName( "http://staffService/", "StaffsImplService" );

		Service service = Service.create( url, qname );

		StaffsInterface obj = service.getPort( StaffsInterface.class );
		
		return obj;
	}
	
	public void registration(Role roleOfUser, int id) {
		if(roleOfUser == Role.STUDENT) {
			StudentsInterface obj = null;
			try {
				obj = connectStudentService();
			} catch (MalformedURLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			Student newStudent = new Student();
			newStudent.setId(id);
			try {
				obj.addStudent(newStudent);
			} catch (studentservice.IOException_Exception | studentservice.JAXBException_Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else {
			StaffsInterface obj = null;
			try {
				obj = connectStaffService();
			} catch (MalformedURLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			AcademicStaffMember newStaff = new AcademicStaffMember();
			newStaff.setId(id);
			try {
				obj.addStaff(newStaff);
			} catch (staffservice.IOException_Exception | staffservice.JAXBException_Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}

	public boolean loginCheck(String username, String password) {
		// TODO Auto-generated method stub
		return false;
	}

}