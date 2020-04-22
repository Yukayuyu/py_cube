enum Cp9EnumClassNote {
    MIDDLE_C, C_SHARP, B_FLAT
}


class Instrument {
    private int i;

    public void play(Cp9EnumClassNote n) {
        System.out.println("Instrument.play()");
    }

    protected void geti() {
        i = 12;
        System.out.println("geti()" + i);
    }
}


class Wind extends Instrument {
    @Override
    public void play(Cp9EnumClassNote n) {
        System.out.println("Wind.play()" + n);
    }

    public void newM() {
        System.out.println("newM");
    }
}


public class Cp9_PolyUpcasting {
    public static void tune(Instrument i) { // Polymorphism reduce duplicated code here and only
                                            // here.
        i.play(Cp9EnumClassNote.MIDDLE_C);
        ((Wind) i).newM(); // Or cannot call newM(), since it's not in the Instrument class.
    }

    public static void main(String[] args) {
        Wind flute = new Wind();
        tune(flute); // Upcasting
        Instrument a = flute;
        tune(a); // Result unchanged.
        a.geti();
        flute.geti();
        System.out.println(a.getClass()); // class wind
    }
}
