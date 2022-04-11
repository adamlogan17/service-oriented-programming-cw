package staffService;

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
public interface StaffsInterface {

	@WebMethod
	public void addStaff(@WebParam(name = "addStaffNewStaff") AcademicStaffMember newStaff) throws JAXBException, IOException;

}
