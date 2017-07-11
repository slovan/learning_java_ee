package annotations.interceptor_binding;


import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import javax.interceptor.InterceptorBinding;

import static java.lang.annotation.RetentionPolicy.RUNTIME;
import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.ElementType.METHOD;

@InterceptorBinding
@Retention(RUNTIME)
@Target({ FIELD, TYPE, METHOD })
public @interface Loggable {
}
