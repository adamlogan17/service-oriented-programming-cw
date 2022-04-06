package studentService;

import javax.jws.WebService;

@WebService(endpointInterface="studentService.StudentsInterface")
public class StudentsImpl {
	
	public boolean loginCheck( String username, String password ) {

		return false;
	}
}
