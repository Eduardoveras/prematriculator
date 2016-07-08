/**
 * Created by Siclait on 7/7/16.
 */

package Client;

import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import Class.*;
import Service.Registry;

public class PreMatrixJavaClient {
    public static void main(String[] args) throws Exception {

        URL url = new URL("http://localhost:9999/ws/PreMatrix?wsdl");

        QName qName = new QName("http://Service/", "RegistryImplService");

        Service service = Service.create(url, qName);

        Registry registry = service.getPort(Registry.class);

        registry.AddNewStudent("20112319", "Djidjelly", "Siclait", "ISC");
        registry.AddNewStudent("20120844", "Eduardo", "Veras", "ISC");

        Student[] students = registry.FetchAllStudents();

        System.out.println(students.length + "\n");

        for (Student s:
             students) {
            System.out.println(s.getMatricula() + "--" + s.getFirstName());
        }
    }
}
