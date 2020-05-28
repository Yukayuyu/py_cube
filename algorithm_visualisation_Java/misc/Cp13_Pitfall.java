@SuppressWarnings("all")
class Cp13_MinorException extends Exception {
}


@SuppressWarnings("all")
class Cp13_MajorException extends Exception {
}


class Cp13_PitfallCase1 {

    void f() throws Cp13_MinorException {
        throw new Cp13_MinorException();
    }

    void g() throws Cp13_MajorException {
        throw new Cp13_MajorException();
    }

    void run() {
        Cp13_PitfallCase1 x = new Cp13_PitfallCase1();
        try {
            try {
                x.g(); // Which throw a severe major exception.
            } finally {
                x.f(); // Which throw a minor exception.
            }
        } catch (Exception e) {
            e.printStackTrace(); // Major exception is overwritten.
        }
    }
}


class Cp13_PitfallCase2 {

    void g() throws Cp13_MajorException {
        throw new Cp13_MajorException();
    }

@SuppressWarnings("all")
    void run() {
        Cp13_PitfallCase2 x = new Cp13_PitfallCase2();
        try {
            try {
                x.g(); // Which throw a severe major exception.
            } catch (Cp13_MajorException e) {
                throw e;
            } finally {
                return; // All exceptions are muted.
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}


public class Cp13_Pitfall {

    public static void main(String[] args) {
        Cp13_PitfallCase1 x = new Cp13_PitfallCase1();
        x.run();
        System.out.println("-------------------------");
        Cp13_PitfallCase2 y = new Cp13_PitfallCase2();
        y.run();
    }
}
