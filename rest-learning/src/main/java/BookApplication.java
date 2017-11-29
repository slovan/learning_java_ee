import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Ponomarenko.Volodymyr on 28. 11. 2017.
 */
@ApplicationPath("rs")
public class BookApplication extends Application {
    @Override
    public Set<Class<?>> getClasses() {
        Set<Class<?>> resources = new HashSet<>();
        resources.add(BookRestService.class);
        return resources;
    }
}
