package studentService;

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

@WebService(endpointInterface="studentService.StudentsInterface")
public class StudentsImpl implements StudentsInterface {
	
	private final static String PATH = "C:/Users/Smcke/Desktop/StudentRegistration.xml";
	
	public void addStudent(Student newStudent) throws JAXBException, IOException {
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

		allStudents.add(newStudent);

		OutputStream outputStream = new FileOutputStream( PATH );
		Marshaller marshaller = jAXBContext.createMarshaller();
		marshaller.marshal( allStudents, outputStream );
		
		System.out.println( "The objects serialized in this file:" + new java.io.File( PATH ).getAbsolutePath() );
	}
	
	public int studentExist(int id, ModuleCode mc) throws JAXBException, IOException {
		Students allStudents = null;
		JAXBContext jAXBContext = JAXBContext.newInstance( Students.class );

		if( ! new java.io.File( PATH ).exists() ) {
			return -1;
		}

		else {
			InputStream inputStream = new FileInputStream( PATH );
			jAXBContext = JAXBContext.newInstance( Students.class );
			Unmarshaller unmarshaller = jAXBContext.createUnmarshaller();
			allStudents = (Students) unmarshaller.unmarshal( inputStream );
		}
		
		for(Student stud: allStudents.getAllStudents()) {
			if(stud.getId() == id) {
				if(!stud.ifMcExists(mc)) {
					return 0;
				} else {
					return -1;
				}
			}
		}
		return -1;
	}
	
	public int enroll(int id, ModuleCode mc, String annualYear) throws JAXBException, IOException {
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

		for(Student stud: allStudents.getAllStudents()) {
			if(stud == null) {
				return -1;
			}
			if(stud.getId() == id) {
				if(!stud.ifMcExists(mc)) {
					stud.addMc(mc, annualYear);
					OutputStream outputStream = new FileOutputStream( PATH );
					Marshaller marshaller = jAXBContext.createMarshaller();
					marshaller.marshal( allStudents, outputStream );
					
					System.out.println( "The objects serialized in this file:" + new java.io.File( PATH ).getAbsolutePath() );
					
					return 0;
				} else {
					return -1;
				}
			}
		}
		return -1;
	}
	
	public int insertMark(int id, ModuleCode mc, double mark) throws JAXBException, IOException {
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

		for(Student stud: allStudents.getAllStudents()) {
			if(stud == null) {
				return -1;
			}
			if(stud.getId() == id) {
				if(stud.ifMcExists(mc)) {
					stud.addMark(mc, mark);
					OutputStream outputStream = new FileOutputStream( PATH );
					Marshaller marshaller = jAXBContext.createMarshaller();
					marshaller.marshal( allStudents, outputStream );
					
					System.out.println( "The objects serialized in this file:" + new java.io.File( PATH ).getAbsolutePath() );
					
					return 0;
				} else {
					return -1;
				}
			}
		}
		return -1;
	}
}