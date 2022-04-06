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
	public @WebResult(name = "loginCheckResult") boolean loginCheck( @WebParam(name = "loginCheckUsername") String username, @WebParam(name = "loginCheckPassword") String password );

}