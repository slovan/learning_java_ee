package resteasy.jackson;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Ponomarenko.Volodymyr on 29. 11. 2017.
 */
@ApplicationPath("/stud")
public class StudentApplication extends Application {
    @Override
    public Set<Class<?>> getClasses() {
        Set<Class<?>> resources = new HashSet<>();
        resources.add(RESTEasyJSONServices.class);
        return resources;
    }
}
