package studentPackage;

import java.io.IOException;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.Style;
import javax.xml.bind.JAXBException;


@WebService
@SOAPBinding(style=Style.RPC)
public interface StudentsInterface {

	@WebMethod
	public void addStudent(@WebParam(name = "addStudentId") int id) throws JAXBException, IOException;

	@WebMethod
	public @WebResult(name = "insertMarkResult") int insertMark(@WebParam(name = "insertMarkId") int id, @WebParam(name = "mc") StudentModuleCode mc, @WebParam(name = "mark") double mark) throws JAXBException, IOException;

	@WebMethod
	public @WebResult(name = "printMarkResult") String printMark(@WebParam(name = "printMarkId") int id, @WebParam(name = "printMarkMc") StudentModuleCode mc) throws JAXBException, IOException;
	
	@WebMethod
	public @WebResult(name = "addModuleResult") int addModule(@WebParam(name = "addModuleId") int id, @WebParam(name = "addModuleMc") StudentModuleCode mc, @WebParam(name = "addModuleYear") String academicYear) throws JAXBException, IOException;
	
	@WebMethod
	public @WebResult(name = "getStudentResult") boolean studentExists(@WebParam(name = "getStudentId") int id) throws JAXBException, IOException;

}