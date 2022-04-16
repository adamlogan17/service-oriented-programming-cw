package controllerPackage;

import java.net.MalformedURLException;
import java.net.URL;

import javax.xml.namespace.QName;
import javax.xml.ws.Service;

import staffpackage.StaffModuleCode;
import staffpackage.StaffsInterface;
import studentpackage.IOException_Exception;
import studentpackage.JAXBException_Exception;
import studentpackage.StudentModuleCode;
import studentpackage.StudentsInterface;

public class Controller {
	// Connects the student service with the controller service
	private StudentsInterface connectStudentService() throws MalformedURLException {
		URL url = new URL("http://localhost:8080/studentService/?wsdl");
		QName qname = new QName("http://studentPackage/", "StudentsImplService");

		Service service = Service.create(url, qname);
		StudentsInterface obj = service.getPort(StudentsInterface.class);

		return obj;
	}

	// Connects the staff service with the controller service
	private StaffsInterface connectStaffService() throws MalformedURLException {
		URL url = new URL("http://localhost:8080/staffService/?wsdl");
		QName qname = new QName("http://staffPackage/", "StaffsImplService");

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
			try {
				obj.addStudent(id);
			} catch (studentpackage.IOException_Exception | studentpackage.JAXBException_Exception e) {
				e.printStackTrace();
			}
		} else {
			StaffsInterface obj = null;
			try {
				obj = connectStaffService();
			} catch (MalformedURLException e) {
				e.printStackTrace();
			}
			try {
				obj.addStaff(id);
			} catch (staffpackage.IOException_Exception | staffpackage.JAXBException_Exception e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * Enrolls a student to a given module
	 * @param staffID
	 * @param mc
	 * @param annualYear
	 * @param studentID
	 * @return - It returns a 0 if it was successful and -1 if it failed
	 */
	public int enroll(int staffID, StudentModuleCode mc, String academicYear, int studentID) {
		StaffsInterface staffService = null;
		StudentsInterface studService = null;
		try {
			staffService = connectStaffService();
			studService = connectStudentService();
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}

		try {
			if (!staffService.staffExist(staffID)) {
				return -1;
			}
		} catch (staffpackage.IOException_Exception | staffpackage.JAXBException_Exception e1) {
			e1.printStackTrace();
		}

		try {
			if (studService.studentExists(studentID)) {
				return studService.addModule(studentID, mc, academicYear);
			}
		} catch (IOException_Exception | JAXBException_Exception e) {
			e.printStackTrace();
		}
		return -1;
	}

	// Gives a student a mark in a certain module. It returns a 0 if it was
	// successful and -1 if it failed
	public int insertMark(int staffID, StudentModuleCode mc, double mark, int studentID) {
		StaffsInterface staffService = null;
		StudentsInterface studService = null;
		try {
			staffService = connectStaffService();
			studService = connectStudentService();
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}

		try {
			if (!staffService.staffExist(staffID)) {
				return -1;
			}
		} catch (staffpackage.IOException_Exception | staffpackage.JAXBException_Exception e1) {
			e1.printStackTrace();
		}
		try {
			if(studService.studentExists(studentID)) {
				return studService.insertMark(studentID, mc, mark);
			}
		} catch (IOException_Exception | JAXBException_Exception e) {
			e.printStackTrace();
		}
		return -1;
	}

	// Returns a string containing a students module code, mark and year
	public String printMark(int staffID, StudentModuleCode mc, int studentID) {
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
			if (!staffService.staffExist(staffID)) {
				return result;
			}
		} catch (staffpackage.IOException_Exception | staffpackage.JAXBException_Exception e1) {
			e1.printStackTrace();
		}
		try {
			result = studService.printMark(studentID, mc);
		} catch (IOException_Exception | JAXBException_Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	// Assigns a module to a academic staff member. It returns a 0 if it was
	// successful and -1 if it failed
	public int assign(int staffID, StaffModuleCode mc, String academicYear) {
		StaffsInterface staffService = null;
		try {
			staffService = connectStaffService();
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}

		try {
			if (staffService.staffExist(staffID)) {
				return staffService.assignModule(staffID, mc, academicYear);
			}
		} catch (staffpackage.IOException_Exception | staffpackage.JAXBException_Exception e1) {
			e1.printStackTrace();
		}

		return -1;
	}
}
