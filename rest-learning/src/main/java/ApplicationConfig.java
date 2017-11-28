import org.eclipse.persistence.jaxb.rs.MOXyJsonProvider;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Ponomarenko.Volodymyr on 28. 11. 2017.
 */
@ApplicationPath("rs")
public class ApplicationConfig extends Application {
    private final Set<Class<?>> classes;
    public ApplicationConfig() {
        HashSet<Class<?>> c = new HashSet<>();
        c.add(BookRestService.class);
        c.add(MOXyJsonProvider.class);
        classes = Collections.unmodifiableSet(c);
    }
    @Override
    public Set<Class<?>> getClasses() {
        return classes;
    }
}
