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
		AcademicStaffMembers allStaff = readStaff();

		allStaff.add(newStaff);
		
		writeStaff(allStaff);
	}
	
	public AcademicStaffMembers readStaff() throws JAXBException, IOException {
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
		
		return allStaff;
	}
	
	public void writeStaff(AcademicStaffMembers newStaff) throws JAXBException, IOException {
		JAXBContext jAXBContext = JAXBContext.newInstance( AcademicStaffMembers.class );
		OutputStream outputStream = new FileOutputStream( PATH );
		Marshaller marshaller = jAXBContext.createMarshaller();
		marshaller.marshal( newStaff, outputStream );
		
		System.out.println( "The objects serialized in this file:" + new java.io.File( PATH ).getAbsolutePath() );
	}
	
	public void assignModule(int id, ModuleCode mc, String academicYear) throws JAXBException, IOException {
		AcademicStaffMembers allStaff = readStaff();
		AcademicStaffMember staff = allStaff.getAStaffMember(id);
		Module newModule = new Module(mc, academicYear);
		staff.addModule(newModule);
		
		writeStaff(allStaff);
	}
	
	public int staffExist(int id) throws JAXBException, IOException {
		AcademicStaffMembers allStaff = null;
		JAXBContext jAXBContext = JAXBContext.newInstance( AcademicStaffMembers.class );

		if( ! new java.io.File( PATH ).exists() ) {
			return -1;
		}

		else {
			InputStream inputStream = new FileInputStream( PATH );
			jAXBContext = JAXBContext.newInstance( AcademicStaffMembers.class );
			Unmarshaller unmarshaller = jAXBContext.createUnmarshaller();
			allStaff = (AcademicStaffMembers) unmarshaller.unmarshal( inputStream );
		}
		
		for(AcademicStaffMember staff: allStaff.getAllStaff()) {
			if(staff == null) {
				return -1;
			}
			if(staff.getId() == id) {
				return 0;
			}
		}
		return -1;
	}
}
