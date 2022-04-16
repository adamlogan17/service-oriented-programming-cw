package studentPackage;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import javax.jws.WebService;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

@WebService(endpointInterface="studentPackage.StudentsInterface")
public class StudentsImpl implements StudentsInterface {
	
	private final static String PATH = "StudentRegistration.xml";
	
	public void addStudent(int id) throws JAXBException, IOException {
		Students allStudents = readStudents();

		Student newStudent = new Student(id);
		allStudents.add(newStudent);

		writeStudents(allStudents);
	}
	
	public Students readStudents() throws JAXBException, IOException {
		Students allStudents = null;
		JAXBContext jAXBContext = JAXBContext.newInstance( Students.class );

		if( ! new java.io.File( PATH ).exists() ) {

			new java.io.File( PATH ).createNewFile();
			allStudents = new Students();
		}

		else {
			InputStream inputStream = new FileInputStream( PATH );
			jAXBContext = JAXBContext.newInstance( Students.class );
			Unmarshaller unmarshaller = jAXBContext.createUnmarshaller();
			allStudents = (Students) unmarshaller.unmarshal( inputStream );
		}
		
		return allStudents;
	}
	
	public void writeStudents(Students newStudents) throws JAXBException, IOException {
		JAXBContext jAXBContext = JAXBContext.newInstance( Students.class );
		OutputStream outputStream = new FileOutputStream( PATH );
		Marshaller marshaller = jAXBContext.createMarshaller();
		marshaller.marshal( newStudents, outputStream );
		
		System.out.println( "The objects serialized in this file:" + new java.io.File( PATH ).getAbsolutePath() );
	}
	
	public boolean studentExists(int id) throws JAXBException, IOException {
		Students allStudents = readStudents();
		if(allStudents == null) {
			return false;
		} else if(allStudents.getAStudent(id) != null) {
			return true;
		}
		return false;
	}
	
	public int addModule(int id, StudentModuleCode mc, String academicYear) throws JAXBException, IOException {
		Students allStudents = readStudents();
		Student newStudent = allStudents.getAStudent(id);
		StudentModule newModule = new StudentModule(mc , academicYear);
		if(!newStudent.ifMcExists(mc)) {
			newStudent.addMc(newModule);
			writeStudents(allStudents);
			return 0;
		}
		return -1;
	}
	
	public int insertMark(int id, StudentModuleCode mc, double mark) throws JAXBException, IOException {
		Students allStudents = readStudents();
		Student stud = allStudents.getAStudent(id);
		if(stud.ifMcExists(mc)) {
			stud.addMark(mc, mark);
			writeStudents(allStudents);
			return 0;
		}
		return -1;
	}
	
	public String printMark(int id, StudentModuleCode mc) throws JAXBException, IOException {
		String result = "";
		Students allStudents = readStudents();
		Student stud = allStudents.getAStudent(id);

		if(stud.ifMcExists(mc)) result = stud.getModuleDetails(mc);
		
		return result;
	}
}