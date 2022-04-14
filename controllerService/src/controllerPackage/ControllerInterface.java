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

	@WebMethod
    public @WebResult(name = "insertMarkResult") int insertMark(@WebParam(name = "insertMarkStaffID") int staffID, @WebParam(name = "insertMarkMC") ModuleCode mc, @WebParam(name = "insertedMark") double mark, @WebParam(name = "insertMarkStudID") int studentID);

	@WebMethod
    public @WebResult(name = "printMarkResult") String printMark(@WebParam(name = "printMarkStaffID") int staffID, @WebParam(name = "printMarkMC") ModuleCode mc, @WebParam(name = "printMarkStudID") int studentID);
}