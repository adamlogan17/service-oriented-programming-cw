package staffService;

import javax.jws.WebService;

@WebService(endpointInterface="staffService.StaffsInterface")
public class StaffsImpl implements StaffsInterface {
	
	public boolean loginCheck( String username, String password ) {

		return false;
	}
}
