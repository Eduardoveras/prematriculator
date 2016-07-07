/**
 * Created by Siclait on 7/7/16.
 */
package Service;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.Style;

import Class.*;

import java.util.ArrayList;

@WebService
@SOAPBinding(style = Style.RPC)
public interface Registry {

    @WebMethod
    void AddNewStudent(String matricula, String firstName, String lastName, String career);

    @WebMethod
    boolean ModifyStudentInfo(String matricula, String firstName, String lastName, String career);

    @WebMethod
    void DeleteStudent(String matricula);

    @WebMethod
    Student FetchStudent(String matricula);

    @WebMethod
    ArrayList<Student> FetchAllStudents();

    @WebMethod
    boolean AssignCourseToStudent(String matricula, String code, String name);

    @WebMethod
    boolean RemoveStudentCourse(String matricula, String code, String name);
}
