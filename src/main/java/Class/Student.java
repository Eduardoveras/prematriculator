/**
 * Created by Siclait on 7/7/16.
 */
package Class;

import java.util.List;

public class Student {

    private String matricula;
    private String firstName;
    private String lastName;
    private String career;
    private List<Course> courses;

    public Student(){

    }

    public Student(String matricula, String firstName, String lastName, String career){

        this.setMatricula(matricula);
        this.setFirstName(firstName);
        this.setLastName(lastName);
        this.setCareer(career);
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getCareer() {
        return career;
    }

    public void setCareer(String career) {
        this.career = career;
    }

    public List<Course> getCourses() {
        return courses;
    }

    public void setCourses(List<Course> courses) {
        this.courses = courses;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
}
