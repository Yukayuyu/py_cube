package Cp20AnnotationPkg;

import java.lang.annotation.*;

@Target(ElementType.TYPE) // Class only
@Retention(RetentionPolicy.RUNTIME)
public @interface DBTable {
    public String name() default "";
}
