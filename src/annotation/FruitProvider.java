package annotation;

import java.lang.annotation.*;

@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface FruitProvider {
    public int id() default -1;

    public String name()  default " ";

    public String address() default " ";
 }
