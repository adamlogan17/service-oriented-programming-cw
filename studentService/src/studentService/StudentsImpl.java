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
	
	private final static String PATH = "StudentRegistration.xml";
	
	public boolean loginCheck(String a, String b) {
		return true;
	}
	
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

		allStudents.add( newStudent );

		OutputStream outputStream = new FileOutputStream( PATH );
		Marshaller marshaller = jAXBContext.createMarshaller();
		marshaller.marshal( allStudents, outputStream );

		System.out.println( "The objects serialized in this file:" + new java.io.File( PATH ).getAbsolutePath() );
	}
	
	
	public Students addStudent2(Student newStudent) throws JAXBException, IOException {
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

		allStudents.add( newStudent );

		OutputStream outputStream = new FileOutputStream( PATH );
		Marshaller marshaller = jAXBContext.createMarshaller();
		marshaller.marshal( allStudents, outputStream );

		System.out.println( "The objects serialized in this file:" + new java.io.File( PATH ).getAbsolutePath() );
		return allStudents;
	}
	
	public String studentDetails(Students allStudents) {
		String details = "";
		
		Student[] arryOfStudents = allStudents.getStudents();
		
		for(Student stud: arryOfStudents) {
			if(stud != null) {
				details += stud.getId() + "\n";
			}
		}
		
 		return details;
	}
}