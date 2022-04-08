package studentService;

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
	public @WebResult(name = "loginCheckResult") boolean loginCheck( @WebParam(name = "loginCheckUsername") String username, @WebParam(name = "loginCheckPassword") String password );

	@WebMethod
	public void addStudent(@WebParam(name = "addStudentNewStudent") Student newStudent) throws JAXBException, IOException;
	
	/*
	@WebMethod
	public @WebResult(name = "studentDetailsResult") String studentDetails(@WebParam(name = "allStudentsDetails") Students allStudents);
	*/
}