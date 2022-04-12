package controllerPackage;

import java.util.ArrayList;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.Style;


@WebService
@SOAPBinding(style=Style.RPC)
public interface ControllerInterface
{
	@WebMethod
	public void registration(@WebParam(name = "registrationRoleOfUser") Role roleOfUser, @WebParam(name = "registrationId") int id);

	@WebMethod
	public void enroll(@WebParam(name = "staffID") int staffID, @WebParam(name = "studentID") int studentID);
}