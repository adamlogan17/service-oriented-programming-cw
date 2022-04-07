
package controllerpackage;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.Action;
import studentservice.ObjectFactory;
import studentservice.Students;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.4-b01
 * Generated source version: 2.2
 * 
 */
@WebService(name = "ControllerInterface", targetNamespace = "http://controllerPackage/")
@SOAPBinding(style = SOAPBinding.Style.RPC)
@XmlSeeAlso({
    ObjectFactory.class
})
public interface ControllerInterface {


    /**
     * 
     * @param addStudentId
     * @param addStudentAllStudents
     * @return
     *     returns studentservice.Students
     */
    @WebMethod
    @WebResult(name = "registrationResult", partName = "registrationResult")
    @Action(input = "http://controllerPackage/ControllerInterface/registrationRequest", output = "http://controllerPackage/ControllerInterface/registrationResponse")
    public Students registration(
        @WebParam(name = "addStudentId", partName = "addStudentId")
        int addStudentId,
        @WebParam(name = "addStudentAllStudents", partName = "addStudentAllStudents")
        Students addStudentAllStudents);

    /**
     * 
     * @param loginCheckPassword
     * @param loginCheckUsername
     * @return
     *     returns boolean
     */
    @WebMethod
    @WebResult(name = "loginCheckResult", partName = "loginCheckResult")
    @Action(input = "http://controllerPackage/ControllerInterface/loginCheckRequest", output = "http://controllerPackage/ControllerInterface/loginCheckResponse")
    public boolean loginCheck(
        @WebParam(name = "loginCheckUsername", partName = "loginCheckUsername")
        String loginCheckUsername,
        @WebParam(name = "loginCheckPassword", partName = "loginCheckPassword")
        String loginCheckPassword);

    /**
     * 
     * @param allStudentsDetails
     * @return
     *     returns java.lang.String
     */
    @WebMethod
    @WebResult(name = "studentDetailsResult", partName = "studentDetailsResult")
    @Action(input = "http://controllerPackage/ControllerInterface/studentDetailsRequest", output = "http://controllerPackage/ControllerInterface/studentDetailsResponse")
    public String studentDetails(
        @WebParam(name = "allStudentsDetails", partName = "allStudentsDetails")
        Students allStudentsDetails);

}
