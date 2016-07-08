/**
 * Created by Siclait on 7/7/16.
 */
package Service;

import javax.jws.WebService;

import Class.*;

import java.util.ArrayList;
import java.util.List;

@WebService(endpointInterface = "Service.Registry")
public class RegistryImpl implements Registry{

    @Override
    public void AddNewStudent(String matricula, String firstName, String lastName, String career){
        Resource.registry.put(matricula, new Student(matricula, firstName, lastName, career));
        System.out.println("\n\nAdd new Student!!!");
        System.out.println("Database size: " + Resource.registry.size() + " students");

    }

    @Override
    public boolean ModifyStudentInfo(String matricula, String firstName, String lastName, String career){
        Student student = Resource.registry.remove(matricula);
        boolean modified = false;

        if(student == null){
            System.out.println("\n\nNo changes made. Student does not exist");
            return false;
        }

        if(!student.getFirstName().equals(firstName)){
            student.setFirstName(firstName);
            System.out.println("\n\nModified first name!!!");
            modified = true;
        }

        if(!student.getLastName().equals(lastName)){
            student.setLastName(lastName);
            System.out.println("\n\nModified last name!!!");
            modified = true;
        }

        if(!student.getCareer().equals(career)){
            student.setCareer(career);
            System.out.println("\n\nModify career!!!");
            modified = true;
        }

        Resource.registry.put(matricula, student);

        return modified;
    }

    @Override
    public void DeleteStudent(String matricula){
        Resource.registry.remove(matricula);
        System.out.println("\n\nDeleted Student!!!");
    }

    @Override
    public Student FetchStudent(String matricula){
        System.out.println("\n\nFetching Student " + matricula + "!!!");
        return Resource.registry.get(matricula);
    }

    @Override
    public Student[] FetchAllStudents(){

        System.out.println("\n\nFetching database!!!");
        Student[] students = new Student[Resource.registry.size()];

        int count = 0;

        for (String matricula:
                Resource.registry.keySet()) {
            students[count] = Resource.registry.get(matricula);
            count++;
        }

        System.out.println("Database size: " + students.length + " students");
        return students;
    }

    @Override
    public boolean AssignCourseToStudent(String matricula, String code, String name){

        Student student = Resource.registry.remove(matricula);

        if(student.getCourses() == null){
            student.setCourses(new ArrayList<>());
            student.getCourses().add(new Course(code, name));
            System.out.println(matricula + " " + code + " " + name);

            Resource.registry.put(matricula, student);
            System.out.println("\n\nAdding new course!!!");
            return true;
        }
        else if(!isCourseIncluded(code, student.getCourses())){
            student.getCourses().add(new Course(code, name));

            Resource.registry.put(matricula, student);
            System.out.println("\n\nAdding new course!!!");
            return true;
        }
        else{

            Resource.registry.put(matricula, student);
            System.out.println("\n\nCourse already registered!!!");
            return false;
        }
    }

    @Override
    public boolean RemoveStudentCourse(String matricula, String code, String name){
        Student student = Resource.registry.remove(matricula);

        try {
            student.getCourses().remove(new Course(code, name));
            System.out.println("\n\nRemoved course!!!");
            return true;
        } catch(Exception exp){
            System.out.println(exp.getMessage());
            System.out.println("\n\nError!!!");
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
