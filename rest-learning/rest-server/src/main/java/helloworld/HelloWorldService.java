package helloworld;

import javax.ws.rs.GET;
import javax.ws.rs.Path;

/**
 * http://www.thejavageek.com/2015/12/16/jax-rs-hello-world-example-with-wildfly/
 *
 * for testing use URL: http://localhost:8080/rest-server/rest/HelloWorld/sayHello
 */
@Path("/HelloWorld") // applied at class level means that the URI to invoke the methods of this class should have “/HelloWorld” as suffix.
public class HelloWorldService {

    @GET // annotation on sayHello() method denotes that when a HTTP GET method is invoked, then sayHello()  method should be called.
    @Path("/sayHello") // means that when HTTP GET method is called with “/sayHello” then sayHello()  method should be executed.
    public String sayHello() {
        return "<h1>Hello World</h1>";
    }
}
