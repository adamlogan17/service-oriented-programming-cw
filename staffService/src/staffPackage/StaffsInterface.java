package staffPackage;

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
	public void addStaff(@WebParam(name = "addStaffId") int id) throws JAXBException, IOException;
	
	@WebMethod
	public @WebResult(name = "staffExistResult") boolean staffExist(@WebParam(name = "StaffID") int id) throws JAXBException, IOException;
	
	@WebMethod
	public @WebResult(name = "assignModuleResult") int assignModule(@WebParam(name = "assignModuleStaffID") int id, @WebParam(name = "assignModuleMc") ModuleCode mc, @WebParam(name = "assignModuleYear") String academicYear) throws JAXBException, IOException;

}
