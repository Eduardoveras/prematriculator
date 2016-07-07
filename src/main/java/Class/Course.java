/**
 * Created by Siclait on 7/7/16.
 */
package Class;

public class Course {

    private String code;
    private String name;

    public Course(){

    }

    public Course(String code, String name){

        this.setCode(code);
        this.setName(name);
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
