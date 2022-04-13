package controllerPackage;

import java.util.ArrayList;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.Style;

import studentservice.ModuleCode;


@WebService
@SOAPBinding(style=Style.RPC)
public interface ControllerInterface
{
	@WebMethod
	public void registration(@WebParam(name = "registrationRoleOfUser") Role roleOfUser, @WebParam(name = "registrationId") int id);

	@WebMethod
	public @WebResult(name = "enrollResult") int enroll(@WebParam(name = "enrollStaffID") int staffID, @WebParam(name = "enrollMC") ModuleCode mc, @WebParam(name = "enrollYear") String annualYear, @WebParam(name = "enrollStudID") int studentID);
}