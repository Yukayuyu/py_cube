public class Cp20_BasicAnnotationRun {
    @Cp20_BasicAnnotationDefine(author = "k", ID = 01, reviewers = {"k", "k again"})
    public void useCase01() {
        System.out.println("Executing..");
    };

    @Cp20_BasicAnnotationDefine(author = "k", ID = 02, reviewers = {"k", "k again"})
    public boolean useCase02() {
        return false;
    }

    public static void main(String[] args) {}
}
