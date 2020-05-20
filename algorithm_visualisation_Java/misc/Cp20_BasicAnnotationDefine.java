import java.lang.annotation.*;

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME) // If not contained in Runtime, the processor of course won't
                                    // fking work lol.
@Documented // means that its content will be included in Javadoc
            // public @interface Cp20_ClassMetadataCustomize {
public @interface Cp20_BasicAnnotationDefine {
    String author();

    int ID();

    String date() default "N/A";

    int currentRevision() default 1;

    String lastModified() default "N/A";
    // public String lastModified() default "N/A";

    String lastModifiedBy() default "N/A";

    public String description() default "no description";

    // array
    String[] reviewers();
}
