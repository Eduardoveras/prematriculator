/**
 * Created by Siclait on 7/7/16.
 */
package Service;

import java.util.HashMap;
import java.util.Map;

import Class.Student;

public class Resource {

    // Student registry
    public static Map<String, Student> registry = new HashMap<>();

    // Singleton constructor
    private Resource(){
        System.out.println("\n\nPing!!!");
    }
}
