package controllerPackage;

import java.util.ArrayList;
import java.util.List;

import javax.jws.WebService;

@WebService(endpointInterface="controllerPackage.ControllerInterface")

public class Controller implements ControllerInterface
{
	public boolean loginCheck( String username, String password ) {

		return false;
	}
}
