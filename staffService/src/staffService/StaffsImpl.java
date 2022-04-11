package staffService;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import javax.jws.WebService;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

@WebService(endpointInterface="staffService.StaffsInterface")
public class StaffsImpl implements StaffsInterface {
	
	private final static String PATH = "StaffRegistration.xml";
	
	public void addStaff(AcademicStaffMember newStaff) throws JAXBException, IOException {
		AcademicStaffMembers allStaff = null;
		JAXBContext jAXBContext = JAXBContext.newInstance( AcademicStaffMembers.class );

		if( ! new java.io.File( PATH ).exists() ) {

			new java.io.File( PATH ).createNewFile();
			allStaff = new AcademicStaffMembers();
		}

		else {
			InputStream inputStream = new FileInputStream( PATH );
			jAXBContext = JAXBContext.newInstance( AcademicStaffMembers.class );
			Unmarshaller unmarshaller = jAXBContext.createUnmarshaller();
			allStaff = (AcademicStaffMembers) unmarshaller.unmarshal( inputStream );
		}

		allStaff.add(newStaff);

		OutputStream outputStream = new FileOutputStream( PATH );
		Marshaller marshaller = jAXBContext.createMarshaller();
		marshaller.marshal( allStaff, outputStream );
		
		System.out.println( "The objects serialized in this file:" + new java.io.File( PATH ).getAbsolutePath() );
	}
}
