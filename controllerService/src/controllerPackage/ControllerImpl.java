package controllerPackage;

import java.net.MalformedURLException;
import java.net.URL;

import javax.jws.WebService;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.namespace.QName;
import javax.xml.ws.Service;

import staffservice.AcademicStaffMember;
import staffservice.StaffsInterface;
import studentservice.IOException_Exception;
import studentservice.JAXBException_Exception;
import studentservice.Student;
import studentservice.StudentsInterface;
import studentservice.ModuleCode;

@WebService(endpointInterface = "controllerPackage.ControllerInterface")
public class ControllerImpl implements ControllerInterface {
	
	// Connects the student service with the controller service
	private StudentsInterface connectStudentService() throws MalformedURLException {
		URL url = new URL("http://localhost:8080/studentService/?wsdl");
		QName qname = new QName("http://studentService/", "StudentsImplService");

		Service service = Service.create(url, qname);
		StudentsInterface obj = service.getPort(StudentsInterface.class);

		return obj;
	}

	// Connects the staff service with the controller service
	private StaffsInterface connectStaffService() throws MalformedURLException {
		URL url = new URL("http://localhost:8080/staffService/?wsdl");
		QName qname = new QName("http://staffService/", "StaffsImplService");

		Service service = Service.create(url, qname);
		StaffsInterface obj = service.getPort(StaffsInterface.class);

		return obj;
	}

	// Registers an user(Student/Staff) using an ID and a role
	public void registration(Role roleOfUser, int id) {
		if (roleOfUser == Role.STUDENT) {
			StudentsInterface obj = null;
			try {
				obj = connectStudentService();
			} catch (MalformedURLException e) {
				e.printStackTrace();
			}
			Student newStudent = new Student();
			newStudent.setId(id);
			try {
				obj.addStudent(newStudent);
			} catch (studentservice.IOException_Exception | studentservice.JAXBException_Exception e) {
				e.printStackTrace();
			}
		} else {
			StaffsInterface obj = null;
			try {
				obj = connectStaffService();
			} catch (MalformedURLException e) {
				e.printStackTrace();
			}
			AcademicStaffMember newStaff = new AcademicStaffMember();
			newStaff.setId(id);
			try {
				obj.addStaff(newStaff);
			} catch (staffservice.IOException_Exception | staffservice.JAXBException_Exception e) {
				e.printStackTrace();
			}
		}
	}

	// Enrolls a student to a given module. It returns a 0 if it was successful and -1 if it failed
	public int enroll(int staffID, ModuleCode mc, String annualYear, int studentID) {
		StaffsInterface staffService = null;
		StudentsInterface studService = null;
		try {
			staffService = connectStaffService();
			studService = connectStudentService();
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
		
		try {
			if(staffService.staffExist(staffID) == -1) {
				return -1;
			}
		} catch (staffservice.IOException_Exception | staffservice.JAXBException_Exception e1) {
			e1.printStackTrace();
		}
		
		try {
			if(studService.studentExists(studentID)) {
				studService.addModule(studentID, mc, annualYear);
				return 0;
			}
		} catch (IOException_Exception | JAXBException_Exception e) {
			e.printStackTrace();
		}
		return -1;
	}

	// Gives a student a mark in a certain module. It returns a 0 if it was successful and -1 if it failed
	public int insertMark(int staffID, ModuleCode mc, double mark, int studentID) {
		StaffsInterface staffService = null;
		StudentsInterface studService = null;
		try {
			staffService = connectStaffService();
			studService = connectStudentService();
		} catch (MalformedURLException e) {
			System.out.println("1");
			e.printStackTrace();
		}
		
		try {
			if(staffService.staffExist(staffID) == -1) {
				return -1;
			}
		} catch (staffservice.IOException_Exception | staffservice.JAXBException_Exception e1) {
			System.out.println("2");
			e1.printStackTrace();
		}
		try {
			return studService.insertMark(studentID, mc, mark);
		} catch (IOException_Exception | JAXBException_Exception e) {
			// TODO Auto-generated catch block
			System.out.println("3");
			e.printStackTrace();
		}
		return -1;
	}

	// Returns a string containing a students module code, mark and year
	public String printMark(int staffID, ModuleCode mc, int studentID) {
		String result = "";
		StaffsInterface staffService = null;
		StudentsInterface studService = null;
		try {
			staffService = connectStaffService();
			studService = connectStudentService();
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
		
		try {
			if(staffService.staffExist(staffID) == -1) {
				return result;
			}
		} catch (staffservice.IOException_Exception | staffservice.JAXBException_Exception e1) {
			e1.printStackTrace();
		}
		try {
			result = studService.printMark(studentID, mc);
		} catch (IOException_Exception | JAXBException_Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	
	// Assigns a module to a academic staff member. It returns a 0 if it was successful and -1 if it failed
	public int assign(int staffID, staffservice.ModuleCode mc, String academicYear) {
		StaffsInterface staffService = null;
		try {
			staffService = connectStaffService();
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
		
		try {
			if(staffService.staffExist(staffID) == 0) {
				staffService.assignModule(staffID, mc, academicYear);
				return 0;
			}
		} catch (staffservice.IOException_Exception | staffservice.JAXBException_Exception e1) {
			e1.printStackTrace();
		}
		
		return -1;
	}
}