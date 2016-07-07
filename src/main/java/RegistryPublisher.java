/**
 * Created by Siclait on 7/7/16.
 */

import Service.RegistryImpl;

import javax.xml.ws.Endpoint;

public class RegistryPublisher {

    public static void main(String[] args){

        Endpoint.publish("http://localhost:9999/ws/PreMatrix", new RegistryImpl());
    }
}
