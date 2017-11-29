package helloworld;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

/**
 * http://www.thejavageek.com/2015/12/16/jax-rs-hello-world-example-with-wildfly/
 */
@ApplicationPath("/rest") //means that all web services will have a context root as “/rest”
public class ExampleApplication extends Application {
}
