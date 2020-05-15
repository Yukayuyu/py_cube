import java.lang.annotation.*;

@Cp20_ClassMetadataCustomize(author = "k", date = "05/15/2020", reviewers = {"k", "k again"})
public class Cp20_BasicAnnotationRun {
    public void methodToBeTest() {
        System.out.println("Executing..");
    };

    void testExecute() {
        methodToBeTest();
    }

    public static void main(String[] args) {}
}
