package controllerPackage;

import java.util.ArrayList;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.Style;

import studentservice.Students;


@WebService
@SOAPBinding(style=Style.RPC)
public interface ControllerInterface
{
	@WebMethod
	public @WebResult(name = "loginCheckResult") boolean loginCheck( @WebParam(name = "loginCheckUsername") String username, @WebParam(name = "loginCheckPassword") String password );

	@WebMethod
	public @WebResult(name = "registrationResult") Students registration(@WebParam(name = "addStudentId") int id, @WebParam(name = "addStudentAllStudents") Students allStudnets);
	
	@WebMethod
	public @WebResult(name = "studentDetailsResult") String studentDetails(@WebParam(name = "allStudentsDetails") Students allStudents);
}