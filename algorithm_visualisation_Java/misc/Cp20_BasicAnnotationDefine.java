import java.lang.annotation.*;

// @Target(ElementType.METHOD)
// @Retention(RetentionPolicy.RUNTIME)
@Documented // means that its content will be included in Javadoc
@interface Cp20_ClassMetadataCustomize {
    String author();

    String date();

    int currentRevision() default 1;

    String lastModified() default "N/A";

    String lastModifiedBy() default "N/A";

    // Note use of array
    String[] reviewers();
}
