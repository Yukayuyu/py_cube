class Cp2_Animal {
}


class Cp2_AnimalCat extends Cp2_Animal {
    void meow() {
        System.out.println("Meow");
    }
}


class Cp2_AnimalDog extends Cp2_Animal {
    void bark() {
        System.out.println("Bark");
    }
}


class Cp2_EmptyClass {
    void meow() {
        System.out.println("Meow");
    }
}


public class Cp2_Downcasting {
    public static void main(String[] args) {
        Cp2_Animal _animalx = new Cp2_AnimalCat();
        // ! Cp2_EmptyClass _animalx = new Cp2_EmptyClass();
        if (_animalx instanceof Cp2_AnimalCat) {
            Cp2_AnimalCat cat = (Cp2_AnimalCat) _animalx;
            cat.meow();
        } else if (_animalx instanceof Cp2_AnimalDog) {
            Cp2_AnimalDog dog = (Cp2_AnimalDog) _animalx;
            dog.bark();
        }
    }
}

// ArrayList<Shape> shapes = new ArrayList<Shape>();
