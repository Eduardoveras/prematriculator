/**
 * Created by Siclait on 7/7/16.
 */
package Service;

import javax.jws.WebService;

import Class.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@WebService(endpointInterface = "Service.Registry")
public class RegistryImpl implements Registry{

    private Map<String, Student> registry = new HashMap<>();

    @Override
    public void AddNewStudent(String matricula, String firstName, String lastName, String career){
        registry.put(matricula, new Student(matricula, firstName, lastName, career));
    }

    @Override
    public boolean ModifyStudentInfo(String matricula, String firstName, String lastName, String career){
        Student student = registry.remove(matricula);
        boolean modified = false;

        if(student == null)
            return false;

        if(!student.getFirstName().equals(firstName)){
            student.setFirstName(firstName);
            modified = true;
        }

        if(!student.getLastName().equals(lastName)){
            student.setLastName(lastName);
            modified = true;
        }

        if(!student.getCareer().equals(career)){
            student.setCareer(career);
            modified = true;
        }

        registry.put(matricula, student);

        return modified;
    }

    @Override
    public void DeleteStudent(String matricula){
        registry.remove(matricula);
    }

    @Override
    public Student FetchStudent(String matricula){

        return registry.get(matricula);
    }

    @Override
    public ArrayList<Student> FetchAllStudents(){

        ArrayList<Student> students = new ArrayList<>();

        for (String matricula:
             registry.keySet()) {
            students.add(registry.get(matricula));
        }

        return students;
    }

    @Override
    public boolean AssignCourseToStudent(String matricula, String code, String name){

        Student student = registry.remove(matricula);

        if(student.getCourses() == null){
            student.getCourses().add(new Course(code, name));

            registry.put(matricula, student);

            return true;
        }
        else if(!isCourseIncluded(code, student.getCourses())){
            student.getCourses().add(new Course(code, name));

            registry.put(matricula, student);

            return true;
        }
        else{

            registry.put(matricula, student);

            return false;
        }
    }

    @Override
    public boolean RemoveStudentCourse(String matricula, String code, String name){
        Student student = registry.remove(matricula);

        try {
            student.getCourses().remove(new Course(code, name));
            return true;
        } catch(Exception exp){
            System.out.println(exp.getMessage());
            return false;
        }
    }

    //Auxiliary Functions
    private boolean isCourseIncluded(String code, List<Course> courses){

        for (Course c:
             courses) {
            if (c.getCode().equals(code))
                return true;
        }

        return false;
    }
}
