package staffService;

import javax.jws.WebService;

@WebService(endpointInterface="staffService.StaffsInterface")
public class StaffsImpl {
	
	public boolean loginCheck( String username, String password ) {

		return false;
	}
}
