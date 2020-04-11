package chnnn.packageTest;

public class Cp7_Package_Class {
    /**
     * @deprecated Use {@link #methodAisRefactoredAgain()} instead
     */
    public void methodA() {
        methodAisRefactoredAgain();
    }

    public void methodAisRefactoredAgain() {
        System.out.println("methodA");
    }
}
