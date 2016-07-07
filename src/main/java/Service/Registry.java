/**
 * Created by Siclait on 7/7/16.
 */
package Service;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.Style;

import Class.*;

import java.util.List;

@WebService
@SOAPBinding(style = Style.RPC)
public interface Registry {

    @WebMethod
    void AddNewStudent(String matricula, String firstName, String lastName, String career);

    @WebMethod
    boolean ModifyStudentInfo(String firstName, String lastName, String career);

    @WebMethod
    boolean DeleteStudent(String matricula);

    @WebMethod
    Student FetchStudent(String matricula);

    @WebMethod
    List<Student> FetchAllStudents();
}
