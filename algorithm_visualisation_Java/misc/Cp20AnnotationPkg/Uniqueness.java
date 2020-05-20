package Cp20AnnotationPkg;

public @interface Uniqueness {
    Constraints constraints() default @Constraints(unique = true);
}
