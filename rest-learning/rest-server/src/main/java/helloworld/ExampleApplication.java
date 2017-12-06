package helloworld;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;
import java.util.HashSet;
import java.util.Set;

/**
 * http://www.thejavageek.com/2015/12/16/jax-rs-hello-world-example-with-wildfly/
 */
@ApplicationPath("/rest")
public class ExampleApplication extends Application {
    private Set<Object> singletons = new HashSet<Object>();

    public ExampleApplication() {
        singletons.add(new HelloWorldService());
    }

    @Override
    public Set<Object> getSingletons() {
        return singletons;
    }
}
