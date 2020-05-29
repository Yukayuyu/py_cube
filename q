[33mcommit 5ac046bc428d0d7aca6070afd77b1ec52c9843b8[m[33m ([m[1;36mHEAD -> [m[1;32mmaster[m[33m, [m[1;31morigin/master[m[33m)[m
Author: chnnn <chnnn.git@gmail.com>
Date:   Tue Mar 31 14:42:57 2020 +0900

    java

[1mdiff --git a/algorithm_visualisation_Java/misc/Cp8_CompileOrder.java b/algorithm_visualisation_Java/misc/Cp8_CompileOrder.java[m
[1mnew file mode 100644[m
[1mindex 0000000..dd5c84f[m
[1m--- /dev/null[m
[1m+++ b/algorithm_visualisation_Java/misc/Cp8_CompileOrder.java[m
[36m@@ -0,0 +1,35 @@[m
[32m+[m[32mclass Base00{[m
[32m+[m[32m    Base00(){[m
[32m+[m	[32mSystem.out.println("Base00Constructor");[m
[32m+[m[32m    }[m
[32m+[m[32m    static void base00Static(){[m
[32m+[m	[32mSystem.out.println("base00StaticMethod");[m
[32m+[m[32m    }[m
[32m+[m[32m}[m
[32m+[m[32mclass Base01{[m
[32m+[m[32m    Base01(){[m
[32m+[m	[32mSystem.out.println("Base01Constructor");[m
[32m+[m[32m    }[m
[32m+[m[32m    static void base01FirstMethod(){[m
[32m+[m	[32mSystem.out.println("base01FirstMethod");[m
[32m+[m[32m    }[m
[32m+[m[32m}[m
[32m+[m[32mclass Extend01 extends Base01{[m
[32m+[m[32m    Extend01(){[m
[32m+[m	[32mSystem.out.println("Extend01Constructor");[m
[32m+[m[32m    }[m
[32m+[m[32m    private static void extend01SecondMethod(){ // not called[m
[32m+[m	[32mSystem.out.println("extend01SecondMethod");[m[41m [m
[32m+[m[32m    }[m
[32m+[m[32m}[m
[32m+[m[32mpublic class Cp8_CompileOrder{[m
[32m+[m[32m    Cp8_CompileOrder(){[m
[32m+[m	[32mSystem.out.println("Cp8_CompileOrderConstructor"); // not called[m
[32m+[m[32m    }[m
[32m+[m[32m    public static void main (String[] args){[m
[32m+[m	[32mBase00.base00Static(); //a static method is called. but the constructor is not loaded.[m
[32m+[m	[32mSystem.out.println("Cp8_CompileOrderMain");[m
[32m+[m	[32mExtend01 x = new Extend01();[m
[32m+[m	[32mx.base01FirstMethod();[m
[32m+[m[32m    }[m
[32m+[m[32m}[m
[1mdiff --git a/algorithm_visualisation_Java/misc/Cp9_PolyPitfall.java b/algorithm_visualisation_Java/misc/Cp9_PolyPitfall.java[m
[1mnew file mode 100644[m
[1mindex 0000000..fad6fc1[m
[1m--- /dev/null[m
[1m+++ b/algorithm_visualisation_Java/misc/Cp9_PolyPitfall.java[m
[36m@@ -0,0 +1,15 @@[m
[32m+[m[32mclass Super {[m
[32m+[m[32m    public int i = 0;[m
[32m+[m[32m    public int getI(){return i;}[m
[32m+[m[32m}[m
[32m+[m[32mclass Sub extends Super{[m
[32m+[m[32m    public int i = 1;[m
[32m+[m[32m    public int getI(){return i;}[m
[32m+[m[32m    public int getSuperI(){return super.i;}[m
[32m+[m[32m}[m
[32m+[m[32mpublic class Cp9_PolyPitfall{[m
[32m+[m[32m    public static void main (String[] args){[m
[32m+[m	[32mSuper sup = new Sub();[m
[32m+[m	[32mSystem.out.println("sup.i " + sup.i + " sup.getI()" + sup.getI());[m
[32m+[m[32m    }[m
[32m+[m[32m}[m
[1mdiff --git a/algorithm_visualisation_Java/misc/Cp9_PolyUpcasting.java b/algorithm_visualisation_Java/misc/Cp9_PolyUpcasting.java[m
[1mnew file mode 100644[m
[1mindex 0000000..0badcbc[m
[1m--- /dev/null[m
[1m+++ b/algorithm_visualisation_Java/misc/Cp9_PolyUpcasting.java[m
[36m@@ -0,0 +1,33 @@[m
[32m+[m[32menum Note{[m
[32m+[m[32m    MIDDLE_C, C_SHARP, B_FLAT[m
[32m+[m[32m}[m
[32m+[m[32mclass Instrument {[m
[32m+[m[32m    private int i;[m
[32m+[m[32m    public void play(Note n){[m
[32m+[m	[32mSystem.out.println("Instrument.play()");[m
[32m+[m[32m    }[m
[32m+[m[32m    protected void geti(){[m
[32m+[m	[32mi = 12;[m
[32m+[m	[32mSystem.out.println("geti()" + i);[m
[32m+[m[32m    }[m
[32m+[m[32m}[m
[32m+[m[32mclass Wind extends Instrument{[m
[32m+[m[32m    @Override[m
[32m+[m[32m    public void play(Note n){[m[41m [m
[32m+[m	[32mSystem.out.println("Wind.play()" + n);[m
[32m+[m[32m    }[m
[32m+[m[32m}[m
[32m+[m[32mpublic class Cp9_PolyUpcasting{[m
[32m+[m[32m    public static void tune(Instrument i){ //Polymorphism reduce duplicated code here and only here.[m
[32m+[m	[32mi.play(Note.MIDDLE_C);[m
[32m+[m[32m    }[m
[32m+[m[32m    public static void main(String[] args){[m
[32m+[m[32m    Wind flute = new Wind();[m
[32m+[m[32m    tune(flute); //Upcasting[m
[32m+[m[32m    Instrument a = flute;[m
[32m+[m[32m    tune(a); //Result unchanged.[m
[32m+[m[32m    a.geti();[m
[32m+[m[32m    flute.geti();[m
[32m+[m[32m    System.out.println(a.getClass()); //class wind[m
[32m+[m[32m    }[m
[32m+[m[32m}[m
[1mdiff --git a/algorithm_visualisation_Java/misc/Cp9_Shape.java b/algorithm_visualisation_Java/misc/Cp9_Shape.java[m
[1mnew file mode 100644[m
[1mindex 0000000..4dfc0f7[m
[1m--- /dev/null[m
[1m+++ b/algorithm_visualisation_Java/misc/Cp9_Shape.java[m
[36m@@ -0,0 +1,23 @@[m
[32m+[m[32mclass Shape{[m
[32m+[m[32m    void draw(){[m
[32m+[m	[32mSystem.out.println("Shape.draw");[m
[32m+[m[32m    }[m
[32m+[m[32m}[m
[32m+[m[32mclass Circle extends Shape{[m
[32m+[m[32m    void draw(){[m
[32m+[m	[32mSystem.out.println("Circle.draw");[m
[32m+[m[32m    }[m
[32m+[m[32m    void drawP(){[m
[32m+[m	[32mSystem.out.println("Circle.drawP");[m
[32m+[m[32m    }[m
[32m+[m[32m}[m
[32m+[m[32mpublic class Cp9_Shape{[m
[32m+[m[32m    public static void main (String[] args){[m
[32m+[m	[32mShape x = new Circle();[m
[32m+[m	[32mx.draw();[m
[32m+[m	[32mSystem.out.println(x.getClass()); //Class Circle[m
[32m+[m	[32mCircle y = new Circle();[m
[32m+[m	[32my.drawP();[m
[32m+[m	[32m//! x.drawP(); //cannot find symble[m
[32m+[m[32m    }[m
[32m+[m[32m}[m
[1mdiff --git a/algorithm_visualisation_Java/misc/README b/algorithm_visualisation_Java/misc/README[m
[1mindex 66fff87..13af072 100644[m
[1m--- a/algorithm_visualisation_Java/misc/README[m
[1m+++ b/algorithm_visualisation_Java/misc/README[m
[36m@@ -593,4 +593,41 @@[m [mTo manipulate objects, C/C++ use &* pointers, which is treated as special object[m
 //Mar 27, ~p189[m
 ** Initialization with inheritance[m
    [[./Cp8_ConstructorsWithoutArgument.java::5][Cp8_ConstructorsWithoutArguent::5]][m
[32m+[m[32m   //Mind the Order.[m[41m [m
[32m+[m[32m   [[./Cp8_CompileOrder.java][Cp8_CompileOrder.java]][m
    [m
[32m+[m[32m   1. The main function first[m
[32m+[m[32m   2. The constructor, parents first[m
[32m+[m[32m   3. other fields are load on call.[m
[32m+[m[32m   //The behavoir varies, depends on compiler versions.[m
[32m+[m[41m   [m
[32m+[m[32m* Polymorphism[m
[32m+[m[32m  *decoupling different types*[m
[32m+[m[32m  This is also called *dynamic binding, or late binding, or run-time binding*[m
[32m+[m[41m  [m
[32m+[m[32m** Upcasting[m
[32m+[m[32m   [[./Cp9_PolyUpcasting.java][Cp9_PolyUpcasting.java]][m
[32m+[m[32m   *Once override, the Super method cannot be called. Any call would redirect to the method in the sub-class.*[m
[32m+[m[41m   [m
[32m+[m[32m** Binding[m
[32m+[m[32m   [[./Cp9_PolyUpcasting.java::21][Cp9_PolyUpcasting.java::21]][m
[32m+[m[32m   //tune(Instrument i); How compiler knows the right class to point to?[m
[32m+[m[32m*** Binding[m
[32m+[m[32m    *dynamic binding, or late binding, or run-time binding*[m
[32m+[m[32m    //in contract, C only have early binding[m
[32m+[m[32m    All methods in JAVA are latebinding.[m
[32m+[m[32m    Except static, final(or private which is implicitly final)[m
[32m+[m[41m    [m
[32m+[m[32m    So the *final* call turn off dynamic binding, thus prevent method being overridden.[m
[32m+[m[41m    [m
[32m+[m[32m*** Producing the right behavior[m
[32m+[m[32m    //Shape-Circle situation[m
[32m+[m[32m    *Shape s = new Circle();*[m[41m [m
[32m+[m[32m    s.draw(); //Circle.draw() will be called.[m
[32m+[m[32m    //And s.getClass() returns "Circle"[m
[32m+[m[32m    [[./Cp9_Shape.java][Cp9_Shape.java]][m
[32m+[m[32m    //However, if a new method is decleared in sub-class, it may not behave as expected.[m
[32m+[m[32m    //The base class must have all methods/interfaces[m
[32m+[m
[32m+[m[32m*** Pitfall: fields and static method[m
[32m+[m[32m    [[./Cp9_PolyPitfall.java][Cp9_PolyPitfall.java]][m

[33mcommit ac7c9161f5702cab04c1c3fa883078b68ea45b49[m
Author: chnnn <chnnn.git@gmail.com>
Date:   Fri Mar 27 01:02:22 2020 +0900

    java

[1mdiff --git a/algorithm_visualisation_Java/misc/Cp8_ConstructorsWithoutArgument.java b/algorithm_visualisation_Java/misc/Cp8_ConstructorsWithoutArgument.java[m
[1mnew file mode 100644[m
[1mindex 0000000..3f769c9[m
[1m--- /dev/null[m
[1m+++ b/algorithm_visualisation_Java/misc/Cp8_ConstructorsWithoutArgument.java[m
[36m@@ -0,0 +1,27 @@[m
[32m+[m[32mclass Base01{[m
[32m+[m[32m    int i = 1;[m
[32m+[m[32m    int k = 5;[m
[32m+[m[32m    Base01(){[m
[32m+[m	[32mint i = 2;[m
[32m+[m	[32mSystem.out.println("Base01Constructor");[m
[32m+[m[32m    }[m
[32m+[m[32m}[m
[32m+[m[32mpublic class Cp8_ConstructorsWithoutArgument extends Base01{[m
[32m+[m[32m    int k = 3;[m
[32m+[m[32m    Integer j;[m
[32m+[m[32m    Cp8_ConstructorsWithoutArgument(){[m
[32m+[m	[32mj = new Integer(4);[m
[32m+[m	[32mSystem.out.println("mainConstructor");[m
[32m+[m[32m    }[m
[32m+[m[32m    public static void main (String[] args){[m
[32m+[m	[32mCp8_ConstructorsWithoutArgument x = new Cp8_ConstructorsWithoutArgument();[m
[32m+[m	[32mSystem.out.println(x.i);[m[41m	[m
[32m+[m	[32mSystem.out.println(x.j);[m[41m	[m
[32m+[m	[32mSystem.out.println(x.k); // x.k == 3;[m[41m	[m
[32m+[m	[32m//[m
[32m+[m	[32mBase01 y = x;[m
[32m+[m	[32mSystem.out.println(y.i);[m[41m	[m
[32m+[m	[32mSystem.out.println(y.k); // y.k == 5;[m
[32m+[m	[32m//! System.out.println(y.j);[m[41m	[m
[32m+[m[32m    }[m
[32m+[m[32m}[m
[1mdiff --git a/algorithm_visualisation_Java/misc/Cp8_Final.java b/algorithm_visualisation_Java/misc/Cp8_Final.java[m
[1mnew file mode 100644[m
[1mindex 0000000..4372199[m
[1m--- /dev/null[m
[1m+++ b/algorithm_visualisation_Java/misc/Cp8_Final.java[m
[36m@@ -0,0 +1,20 @@[m
[32m+[m[32mimport java.util.Arrays;[m
[32m+[m[32mpublic class Cp8_Final{[m
[32m+[m[32m    final Integer[] a = {1,2,3};[m
[32m+[m[32m    final int[] b = {1,2,3};[m
[32m+[m[32m    private final int i; //blank finals[m
[32m+[m[32m    Cp8_Final(){[m
[32m+[m[32m        this.i = 1;[m
[32m+[m[32m        //this.i = 2; //variable i might already have been assigned.[m
[32m+[m[32m    }[m
[32m+[m[32m    public static void main (String[] args){[m
[32m+[m	[32mCp8_Final x = new Cp8_Final();[m
[32m+[m	[32mx.a[1] = 99;[m
[32m+[m	[32mx.b[1] = 99;[m
[32m+[m	[32mSystem.out.println(Arrays.toString(x.a));[m
[32m+[m	[32mSystem.out.println(Arrays.toString(x.b));[m
[32m+[m	[32mSystem.out.println(x.a);[m
[32m+[m	[32mSystem.out.println(x.b);[m
[32m+[m	[32mSystem.out.println(x.i);[m
[32m+[m[32m    }[m
[32m+[m[32m}[m
[1mdiff --git a/algorithm_visualisation_Java/misc/Cp8_FinalMethods.java b/algorithm_visualisation_Java/misc/Cp8_FinalMethods.java[m
[1mnew file mode 100644[m
[1mindex 0000000..810c692[m
[1m--- /dev/null[m
[1m+++ b/algorithm_visualisation_Java/misc/Cp8_FinalMethods.java[m
[36m@@ -0,0 +1,24 @@[m
[32m+[m[32mimport java.util.Arrays;[m
[32m+[m[32mclass Base01{[m
[32m+[m[32m    private int i = 1;[m
[32m+[m[32m    final void method01(){ i++; }[m
[32m+[m[32m    private void method02() { i = i * 2;}[m
[32m+[m[32m    final int get(){return i;}[m
[32m+[m[32m}[m
[32m+[m[32mclass E01 extends Base01{[m
[32m+[m[32m    private int i = 2;[m
[32m+[m[32m    //@Override[m
[32m+[m[32m    //method does not override or implement a method from a supertype[m
[32m+[m[32m    private void method03() { i = i * 3;}[m
[32m+[m[32m    //@Override[m
[32m+[m[32m    //void method01(){ i++; } //Cannot Override[m
[32m+[m[32m}[m
[32m+[m[32mpublic class Cp8_FinalMethods{[m
[32m+[m[32m    public static void main (String[] args){[m
[32m+[m	[32mE01 x = new E01();[m[41m [m
[32m+[m	[32mx.method01();[m
[32m+[m	[32m//x.method03();[m
[32m+[m	[32m//method03() has private access in E01[m
[32m+[m	[32mSystem.out.println(x.get());[m
[32m+[m[32m    }[m
[32m+[m[32m}[m
[1mdiff --git a/algorithm_visualisation_Java/misc/Cp8_Protected.java b/algorithm_visualisation_Java/misc/Cp8_Protected.java[m
[1mnew file mode 100644[m
[1mindex 0000000..9b914f0[m
[1m--- /dev/null[m
[1m+++ b/algorithm_visualisation_Java/misc/Cp8_Protected.java[m
[36m@@ -0,0 +1,30 @@[m
[32m+[m[32mclass Base01{[m
[32m+[m[32m    private static int i;[m
[32m+[m[32m    private int j = 9;[m
[32m+[m[32m    protected static int h = 10;[m
[32m+[m[32m    protected void setI(int k){[m
[32m+[m	[32mthis.i = k;[m
[32m+[m[32m    }[m
[32m+[m[32m    void getI(){[m
[32m+[m	[32mSystem.out.println(this.i);[m
[32m+[m[32m    }[m
[32m+[m[32m    private void setJ(int k){[m
[32m+[m	[32mthis.j = k;[m
[32m+[m	[32mSystem.out.println(this.j);[m
[32m+[m[32m    }[m
[32m+[m[32m}[m
[32m+[m[32mpublic class Cp8_Protected extends Base01{[m
[32m+[m[32m    //private static int i = 3;[m[41m [m
[32m+[m[32m    private static int i = 4;[m
[32m+[m[32m    private static int h = 11;[m
[32m+[m[32m    public static void main (String[] args){[m
[32m+[m	[32mCp8_Protected x = new Cp8_Protected();[m
[32m+[m	[32mx.setI(1);[m
[32m+[m	[32mx.getI();[m
[32m+[m	[32mSystem.out.println(i);[m
[32m+[m	[32mSystem.out.println(h);[m
[32m+[m	[32m//System.out.println(j); //j has private access in Base01[m
[32m+[m	[32m//x.setJ(2); //invalid because the method is private.[m
[32m+[m	[32m//System.out.println(j); // j has private access in Base01;[m
[32m+[m[32m    }[m
[32m+[m[32m}[m
[1mdiff --git a/algorithm_visualisation_Java/misc/README b/algorithm_visualisation_Java/misc/README[m
[1mindex 1266919..66fff87 100644[m
[1m--- a/algorithm_visualisation_Java/misc/README[m
[1m+++ b/algorithm_visualisation_Java/misc/README[m
[36m@@ -1,5 +1,14 @@[m
 //Thinking in Java, by Bruce Eckel, 1033 pages[m
[31m-[m
[32m+[m[32m==============================================[m
[32m+[m[32m* The common-error[m
[32m+[m[32m** the local variables is always not public;[m
[32m+[m[32m   [[./Cp8_ConstructorsWithoutArgument.java::5][Cp8_ConstructorsWithoutArguent::5]][m
[32m+[m[32m==============================================[m
[32m+[m[32m* The disadvantage of Java.[m
[32m+[m[32m  1. "How compiler work" is just some heavy knowledge. Hard to debug (e.g. gbc binary walk style, or even compare to python.)[m[41m [m
[32m+[m[32m  2. GUI/Simple math(arrays, matrix, calculation, statics) is hard to implement, compare to R, python.[m
[32m+[m[32m  3. Since Java's performance heavily rely on Compiler/JVM's algorithm, the Legacy code shall be heavy. This increase the Long-term upgrade cost.[m
[32m+[m[32m==============================================[m
 //Mar 3, p0 ~ p33[m
 * Chapter 2. Introduction to Objects.[m
 Java 1. > C++ when objects are more "dynamic". e.g. handling data that with an always changing size. Reasons: variables declaration conventions (effect how to compile). (cpp automatic/scoped variables or static in size) vs (Java's convention, the dynamic approach, e.g. the heap).[m
[36m@@ -482,10 +491,12 @@[m [mTo manipulate objects, C/C++ use &* pointers, which is treated as special object[m
    class sub-class extends super-class{}[m
    //if constructor *without* arguments.[m
    //the constructor will be called outward.[m
[32m+[m[32m** Constructors without argument[m[41m   [m
[32m+[m[32m   [[./Cp8_ConstructorsWithoutArgument.java][Cp8_ConstructorsWithoutArguent]][m
 [m
 ** Constructors with argument[m
    *super*[m
[31m-   [[./Cp8_Super.java::20][Cp8_Super.java,L20]][m
[32m+[m[32m   [[./Cp8_Super.java::20][Cp8_Super.java::20]][m
    //The *super* is just like *this*[m
    //super.methodA(); to call methodA() in super.[m
    [m
[36m@@ -514,4 +525,72 @@[m [mTo manipulate objects, C/C++ use &* pointers, which is treated as special object[m
    [m
 //Mar 21, ~179[m
 ** protected[m
[32m+[m[32m   [[./Cp8_Protected.java][Cp8_Protected.java]][m[41m [m
[32m+[m[32m   //the private field cannot be accessed even in sub-classes.[m
[32m+[m[32m   //private field using set/get method.[m
[32m+[m[32m   // *However a new private static int call with the same name will not override* see line 24[m
[32m+[m
[32m+[m[32m** Upcasting[m
[32m+[m[32m   class Instrument {[m
[32m+[m[32m     public void play(){}[m
[32m+[m[32m     static void tune(Instrument i){[m
[32m+[m[32m       // ...[m
[32m+[m[32m       i.play();[m
[32m+[m[32m     }[m
[32m+[m[32m   }[m
[32m+[m[32m   public class Wind extends Instrument{[m
[32m+[m[32m     public static void main(String[] args){[m
[32m+[m[32m       Wind flute = new Wind();[m
[32m+[m[32m       Instrument.tune(flute); //Upcasting[m
[32m+[m[32m     }[m
[32m+[m[32m   }[m
[32m+[m
[32m+[m[32m   //Ask: do I need upcasting.[m
[32m+[m[32m   //Upcasting(inheritance) or Composition?[m
[32m+[m[32m   //in Polymorphism.[m
[32m+[m
[32m+[m[32m** *Final*[m
[32m+[m[32m   Either a *compile-time constant* that won't ever change.[m
[32m+[m[32m   Or can be a value initialized at run time that you don't want changed. (?)[m[41m [m
[32m+[m[41m   [m
[32m+[m[32m   *static final* has only one picece of storge that cannot be changed.[m
[32m+[m[32m   //Naming convention: static final *ALL_CAPS_WITH_UNDERBARS*[m
[32m+[m[41m   [m
[32m+[m[32m   *final* primitive cannot be changed.[m
[32m+[m[32m   *final* pointer cannot be pointing to other objects. Though the objects can be modified.[m
[32m+[m[32m   [[./Cp8_Final.java][Cp8_Final.java]][m
[32m+[m[41m   [m
[32m+[m[32m** Blank finals[m
[32m+[m[32m   [[./Cp8_Final.java::8][Cp8_Final.java::Line8]][m
[32m+[m[41m   [m
[32m+[m[32m** final argsList[m
[32m+[m[32m   void f(final int i), then {i++} becomes illegal.[m
[32m+[m[32m   //primaily used to pass data to anonymous inner classes.[m
[32m+[m[41m   [m
[32m+[m[32m** When to use *final methods*[m
[32m+[m[32m   1. Only use it to *prevent inhiritage / override.*[m
[32m+[m[32m   2. (Deprecated, esp. after the *Hotspot* engine) Before Java SE 5/6, increase efficiency in some situations. When compile, invoke *inline calls*, which replace the method call with a copy of the actual code. As a result, the overhead is eliminated.[m
[32m+[m[32m   [[./Cp8_FinalMethods.java][Cp8_FinalMethods.java]][m
[32m+[m[41m   [m
[32m+[m[32m** final classes[m
[32m+[m[32m   cannot be inherited (extended).[m
[32m+[m[32m   1. for Design reason.[m
[32m+[m[32m   2. for Security reason.[m
[32m+[m
[32m+[m[32m*** the demerit of final.[m
[32m+[m[32m    the Java 1.0/1.1 *Vector* class's methods are all final, which is bad. Due to:[m
[32m+[m[32m    1. eliminated the possibility of overriding. e.g. the *Stack* inherit from *Vector*.[m
[32m+[m[32m    2. inefficient when dealing with *Concurrency*. Because import methods, e.g. addElement(), elementAt(), are all synchronized.[m[41m [m
[32m+[m[41m     [m
[32m+[m[32m** Initialization and class loading[m
[32m+[m[32m   different from C++, in Java, the static field's order does not matter.[m
[32m+[m[32m   The loading start whenever a static member is accessed.[m[41m [m
[32m+[m[32m   All constructors are by default static.[m
[32m+[m[32m   So when a new constructor is called, the class code is loaded.[m
[32m+[m[32m   Loading also happens when other static methods or field is called.[m
[32m+[m[32m   And the initialization happends only once.[m
[32m+[m
[32m+[m[32m//Mar 27, ~p189[m
[32m+[m[32m** Initialization with inheritance[m
[32m+[m[32m   [[./Cp8_ConstructorsWithoutArgument.java::5][Cp8_ConstructorsWithoutArguent::5]][m
    [m

[33mcommit 6082ca2439d4ada66cfbf133a6b0c618d9a7e67a[m
Author: chnnn <chnnn.git@gmail.com>
Date:   Sun Mar 22 00:36:25 2020 +0900

    java

[1mdiff --git a/algorithm_visualisation_Java/misc/Cp8_Override.java b/algorithm_visualisation_Java/misc/Cp8_Override.java[m
[1mnew file mode 100644[m
[1mindex 0000000..573efe9[m
[1m--- /dev/null[m
[1m+++ b/algorithm_visualisation_Java/misc/Cp8_Override.java[m
[36m@@ -0,0 +1,25 @@[m
[32m+[m[32mclass Lisa {[m
[32m+[m[32m    void method(String str){[m
[32m+[m	[32mSystem.out.println(str);[m
[32m+[m[32m    }[m
[32m+[m[32m    void method(int i){[m
[32m+[m	[32mSystem.out.println(i + i);[m
[32m+[m[32m    }[m
[32m+[m[32m}[m
[32m+[m[32mclass LisaOverride extends Lisa {[m
[32m+[m[32m    //@Override[m[41m [m
[32m+[m[32m    void method(char c){[m
[32m+[m	[32mSystem.out.println("char");[m
[32m+[m[32m    }[m
[32m+[m[32m}[m
[32m+[m[41m    [m
[32m+[m[32mpublic class Cp8_Override{[m
[32m+[m[32m    public static void main (String[] args){[m
[32m+[m	[32mLisaOverride x = new LisaOverride();[m
[32m+[m	[32mchar c = 'C';[m
[32m+[m	[32mint i = 9;[m
[32m+[m	[32mx.method(c);[m
[32m+[m	[32mx.method(i);[m
[32m+[m[41m	    [m
[32m+[m[32m    }[m
[32m+[m[32m}[m
[1mdiff --git a/algorithm_visualisation_Java/misc/Cp8_Super.java b/algorithm_visualisation_Java/misc/Cp8_Super.java[m
[1mnew file mode 100644[m
[1mindex 0000000..66c4bb8[m
[1m--- /dev/null[m
[1m+++ b/algorithm_visualisation_Java/misc/Cp8_Super.java[m
[36m@@ -0,0 +1,40 @@[m
[32m+[m[32mclass A{[m
[32m+[m[32m    Integer i;[m
[32m+[m[32m    A(int i){[m
[32m+[m	[32mthis.i = i;[m
[32m+[m	[32mSystem.out.println("A, this.i = " + this.i.toString());[m
[32m+[m[32m  }[m
[32m+[m[32m    void methodA(){[m
[32m+[m	[32mSystem.out.println("methodA");[m
[32m+[m[32m    }[m[41m	[m
[32m+[m[32m}[m
[32m+[m[32mclass B extends A{[m
[32m+[m[32m    B(int i){[m
[32m+[m	[32msuper(i);[m
[32m+[m[32m    }[m
[32m+[m[32m    void getB() {[m
[32m+[m	[32mSystem.out.println("B, this.i = " + this.i.toString());[m
[32m+[m[32m    }[m
[32m+[m[32m    void methodA(){[m
[32m+[m[32m        System.out.println("methodA in B");[m
[32m+[m	[32msuper.methodA();[m
[32m+[m[32m    }[m
[32m+[m[32m}[m
[32m+[m[32mclass B2 extends A{[m
[32m+[m[32m    B2(int i){[m
[32m+[m	[32msuper(i);[m
[32m+[m[32m    }[m
[32m+[m[32m    B2(int i, int j){[m
[32m+[m	[32msuper(i);[m
[32m+[m	[32mthis.i = i + j;[m
[32m+[m[32m    System.out.println("B2, this.i = " + this.i.toString());[m
[32m+[m[32m  }[m
[32m+[m[32m}[m
[32m+[m[32mpublic class Cp8_Super {[m
[32m+[m[32m    public static void main (String[] args){[m
[32m+[m	[32mB x = new B(2);[m
[32m+[m	[32mx.getB();[m
[32m+[m	[32mx.methodA();[m
[32m+[m	[32mB2 y = new B2(2,3);[m
[32m+[m[32m    }[m
[32m+[m[32m}[m
[1mdiff --git a/algorithm_visualisation_Java/misc/Cp8_ToString.java b/algorithm_visualisation_Java/misc/Cp8_ToString.java[m
[1mindex 8e84378..8526238 100644[m
[1m--- a/algorithm_visualisation_Java/misc/Cp8_ToString.java[m
[1m+++ b/algorithm_visualisation_Java/misc/Cp8_ToString.java[m
[36m@@ -5,7 +5,7 @@[m [mclass Temp{[m
     }[m
     public String toString() {[m
 	return[m
[31m-	    s + "and toString overloading";[m
[32m+[m	[32m    s + "and toString overloadiXCX";[m
     }[m
 }[m
 public class Cp8_ToString{[m
[1mdiff --git a/algorithm_visualisation_Java/misc/README b/algorithm_visualisation_Java/misc/README[m
[1mindex 82b4e75..1266919 100644[m
[1m--- a/algorithm_visualisation_Java/misc/README[m
[1m+++ b/algorithm_visualisation_Java/misc/README[m
[36m@@ -479,4 +479,39 @@[m [mTo manipulate objects, C/C++ use &* pointers, which is treated as special object[m
    [m
 //Mar 19, ~p168[m
 ** Inheritance syntax[m
[32m+[m[32m   class sub-class extends super-class{}[m
[32m+[m[32m   //if constructor *without* arguments.[m
[32m+[m[32m   //the constructor will be called outward.[m
[32m+[m
[32m+[m[32m** Constructors with argument[m
[32m+[m[32m   *super*[m
[32m+[m[32m   [[./Cp8_Super.java::20][Cp8_Super.java,L20]][m
[32m+[m[32m   //The *super* is just like *this*[m
[32m+[m[32m   //super.methodA(); to call methodA() in super.[m
[32m+[m[41m   [m
[32m+[m[32m** Delegation[m
[32m+[m[32m   public class SpaceShipControls{[m
[32m+[m[32m     void up(int v){}[m
[32m+[m[32m   }[m
[32m+[m[32m   //delegation[m
[32m+[m[32m   public class SpaceShip extends SpaceShipControls[m
[32m+[m[32m     {public void up (int v){controls.up(v)}[m
[32m+[m[32m   }[m
[32m+[m
[32m+[m[32m** Guaranteeing proper cleanup[m
[32m+[m[32m   //If cleanup is necessary,[m
[32m+[m[32m   //use[m[41m [m
[32m+[m[32m   try{[m
[32m+[m[32m     //...[m
[32m+[m[32m   } finally {[m
[32m+[m[32m     x.disposeFunction();//...[m
[32m+[m[32m   }[m
 [m
[32m+[m[32m** Name hiding @Override[m
[32m+[m[32m   //To prevent unintentionally overloading in sub-classes.[m
[32m+[m[32m   //Use the annotation. after Java SE5[m
[32m+[m[32m   [[./Cp8_Override.java][Cp8_Override.java]][m
[32m+[m[41m   [m
[32m+[m[32m//Mar 21, ~179[m
[32m+[m[32m** protected[m
[32m+[m[41m   [m

[33mcommit 8c44f3a731d129a29718a252a464c646faf7a5cc[m
Author: chnnn <chnnn.git@gmail.com>
Date:   Fri Mar 20 00:01:14 2020 +0900

    java

[1mdiff --git a/algorithm_visualisation_Java/misc/README b/algorithm_visualisation_Java/misc/README[m
[1mindex f2ee847..82b4e75 100644[m
[1m--- a/algorithm_visualisation_Java/misc/README[m
[1m+++ b/algorithm_visualisation_Java/misc/README[m
[36m@@ -477,5 +477,6 @@[m [mTo manipulate objects, C/C++ use &* pointers, which is treated as special object[m
    in the book section, the code overwrited non-primitive object's *toString()* method.[m
    [[./Cp8_ToString.java][Cp8_ToString.java]][m
    [m
[32m+[m[32m//Mar 19, ~p168[m
 ** Inheritance syntax[m
 [m

[33mcommit 0c58467eb3b4cd552b4d2c8cc49be3bcf3cc02ed[m
Author: chnnn <chnnn.git@gmail.com>
Date:   Thu Mar 19 23:58:36 2020 +0900

    java
    
            new file:   Cp7_Private.java
            new file:   Cp8_ToString.java
            modified:   README
            modified:   README
    
            modified:   README

[1mdiff --git a/algorithm_visualisation_Java/misc/Cp7_Private.java b/algorithm_visualisation_Java/misc/Cp7_Private.java[m
[1mnew file mode 100644[m
[1mindex 0000000..eee7f08[m
[1m--- /dev/null[m
[1m+++ b/algorithm_visualisation_Java/misc/Cp7_Private.java[m
[36m@@ -0,0 +1,21 @@[m
[32m+[m[32mclass AClass{[m
[32m+[m[32m    private AClass(){}[m
[32m+[m[32m    static AClass makeAClass(){[m
[32m+[m	[32mreturn new AClass();[m
[32m+[m[32m    }[m
[32m+[m[32m}[m
[32m+[m[32mpublic class Cp7_Private{[m
[32m+[m[32m    /**[m
[32m+[m[32m       class AClass{[m
[32m+[m	[32mprivate AClass(){}[m
[32m+[m	[32mstatic AClass makeAClass(){[m
[32m+[m	[32m    return new AClass(); //non-static variable this cannot be referenced from a static context[m
[32m+[m	[32m}[m
[32m+[m[32m       }[m
[32m+[m[32m    */[m
[32m+[m[41m	[m
[32m+[m[32m    public static void main (String[] args){[m
[32m+[m	[32mAClass x = AClass.makeAClass();[m
[32m+[m	[32mSystem.out.println(x);[m
[32m+[m[32m    }[m
[32m+[m[32m}[m
[1mdiff --git a/algorithm_visualisation_Java/misc/Cp8_ToString.java b/algorithm_visualisation_Java/misc/Cp8_ToString.java[m
[1mnew file mode 100644[m
[1mindex 0000000..8e84378[m
[1m--- /dev/null[m
[1m+++ b/algorithm_visualisation_Java/misc/Cp8_ToString.java[m
[36m@@ -0,0 +1,16 @@[m
[32m+[m[32mclass Temp{[m
[32m+[m[32m    private String s;[m
[32m+[m[32m    Temp() {[m
[32m+[m	[32ms = "the temp's constructor";[m
[32m+[m[32m    }[m
[32m+[m[32m    public String toString() {[m
[32m+[m	[32mreturn[m
[32m+[m	[32m    s + "and toString overloading";[m
[32m+[m[32m    }[m
[32m+[m[32m}[m
[32m+[m[32mpublic class Cp8_ToString{[m
[32m+[m[32m    public static void main (String[] args){[m
[32m+[m	[32mTemp x = new Temp();[m
[32m+[m	[32mSystem.out.println(x);[m
[32m+[m[32m    }[m
[32m+[m[32m}[m
[1mdiff --git a/algorithm_visualisation_Java/misc/README b/algorithm_visualisation_Java/misc/README[m
[1mindex 371bdea..f2ee847 100644[m
[1m--- a/algorithm_visualisation_Java/misc/README[m
[1m+++ b/algorithm_visualisation_Java/misc/README[m
[36m@@ -381,7 +381,7 @@[m [mTo manipulate objects, C/C++ use &* pointers, which is treated as special object[m
    //the keyword seems to create some default methods.[m
    //which include toString(), ordinal()[m
 [m
[31m-** Non-static variable cannot be referenced from a static context   [m
[32m+[m[32m* Non-static variable cannot be referenced from a static context[m[41m   [m
    *The Solution*:[m
      class method{[m
        public static void main(String[] args){[m
[36m@@ -396,6 +396,7 @@[m [mTo manipulate objects, C/C++ use &* pointers, which is treated as special object[m
    //then call the method of the instance.[m
    [[./Cp7_PackageRun.java::6][PackageRun.java]][m
    [[./Cp5_Burrito.java][Cp5_Burrito.java]][m
[32m+[m[32m   [[./Cp7_Private.java][Cp7_Private.java]][m
 [m
 * Chapter 7, Access Control[m
   *Public, protected, package access, private*[m
[36m@@ -422,5 +423,59 @@[m [mTo manipulate objects, C/C++ use &* pointers, which is treated as special object[m
 //Mar 18, ~p152[m
 ** Java Access specifiers[m
 *** Package access[m
[32m+[m[32m   |                | Class | Package | Subclass(same pkg) | Subclass(diff pkg) | World |[m
[32m+[m[32m   | Public         | +     | +       | +                  | +                  | +     |[m
[32m+[m[32m   | protected      | +     | +       | +                  | +                  |       |[m
[32m+[m[32m   | package access | +     | +       | +                  |                    |       |[m
[32m+[m[32m   | private        | +     |         |                    |                    |       |[m
[32m+[m[41m  [m
[32m+[m[32m  *private*[m
[32m+[m[32m  //private is import especially when multithreading.[m
[32m+[m[32m  [[./Cp7_Private.java][Cp7_Private.java]][m
[32m+[m[32m  //getter/setter[m
[32m+[m[32m  private String Xxx[m
[32m+[m[32m  public String getXxx(){[m
[32m+[m[32m    return XXX;[m
[32m+[m[32m  }[m
[32m+[m[32m  public String setXxx(String name){[m
[32m+[m[32m    this.XXX = name;[m
[32m+[m[32m  }[m
[32m+[m
[32m+[m[32m  *protected*[m
[32m+[m[32m  //protected is to deal with inheritance.[m
[32m+[m
[32m+[m[32m  *default*[m
[32m+[m[32m  //default package. i.e. classes in the same directory.[m
[32m+[m
[32m+[m[32m*** Interface and implementation[m
[32m+[m[32m    *encapsulation*[m
[32m+[m[32m    //convention: public at top.[m
 [m
[32m+[m[32m    *Class level control*[m
[32m+[m[32m    //Since a class cannot be private or protected, in case that want to limit class access,[m
[32m+[m[32m    //use a private constructor. and a static method to call it.[m
[32m+[m[32m    *method1* //useful if extra process needed, when creating an instance. Say a count.[m
[32m+[m[32m    class Soup1 {[m
[32m+[m[32m      private Soup1(){}[m
[32m+[m[32m      public static Soup1 makeSoup(){[m
[32m+[m[32m        return new Soup1();[m
[32m+[m[32m      }[m
[32m+[m[32m    }[m
[32m+[m[32m    *method2* //a *design pattern*, <<Thinking in Patterns>>. It only allows one single object to be created.[m
[32m+[m[32m    class Soup2 {[m
[32m+[m[32m      private Soup2(){}[m
[32m+[m[32m      //the "Singleton" pattern[m
[32m+[m[32m      private static Soup2 ps1 = new Soup2();[m[41m [m
[32m+[m[32m      public static Soup2 access(){[m
[32m+[m[32m        return ps1;[m
[32m+[m[32m      }[m
[32m+[m[32m      public void f(){}[m
[32m+[m[32m    }[m
[32m+[m
[32m+[m[32m* Chapter 8, Reusing Classes[m
[32m+[m[32m** Composition syntax[m
[32m+[m[32m   in the book section, the code overwrited non-primitive object's *toString()* method.[m
[32m+[m[32m   [[./Cp8_ToString.java][Cp8_ToString.java]][m
[32m+[m[41m   [m
[32m+[m[32m** Inheritance syntax[m
 [m

[33mcommit d561c14ab2dd63e21943d9c62fb4bff14b3bbb81[m
Author: chnnn <chnnn.git@gmail.com>
Date:   Wed Mar 18 23:54:02 2020 +0900

    java

[1mdiff --git a/algorithm_visualisation_Java/misc/Cp7_Package.java b/algorithm_visualisation_Java/misc/Cp7_Package.java[m
[1mnew file mode 100644[m
[1mindex 0000000..3292cf5[m
[1m--- /dev/null[m
[1m+++ b/algorithm_visualisation_Java/misc/Cp7_Package.java[m
[36m@@ -0,0 +1,6 @@[m
[32m+[m[32mpackage chnnn.packageTest;[m
[32m+[m[32mpublic class Cp7_Package{[m
[32m+[m[32m    public void methodA(){[m[41m [m
[32m+[m	[32mSystem.out.println("methodA");[m
[32m+[m[32m    }[m
[32m+[m[32m}[m
[1mdiff --git a/algorithm_visualisation_Java/misc/Cp7_PackageRun.java b/algorithm_visualisation_Java/misc/Cp7_PackageRun.java[m
[1mnew file mode 100644[m
[1mindex 0000000..75f6917[m
[1m--- /dev/null[m
[1m+++ b/algorithm_visualisation_Java/misc/Cp7_PackageRun.java[m
[36m@@ -0,0 +1,13 @@[m
[32m+[m[32mimport chnnn.packageTest.Cp7_Package;[m
[32m+[m[32mpublic class Cp7_PackageRun{[m
[32m+[m[32m    public static void main(String[] args){[m
[32m+[m	[32mCp7_PackageRun x = new Cp7_PackageRun();[m
[32m+[m	[32mx.methodRun();[m
[32m+[m	[32mCp7_Package z = new Cp7_Package();[m
[32m+[m	[32mz.methodA();[m
[32m+[m[32m    }[m
[32m+[m[32m    public void methodRun(){[m
[32m+[m	[32mCp7_Package y = new Cp7_Package();[m
[32m+[m	[32my.methodA();[m
[32m+[m[32m    }[m
[32m+[m[32m}[m

[33mcommit e7b148b808bc7df370e820ef16ecd031de7f3ca7[m
Author: chnnn <chnnn.git@gmail.com>
Date:   Wed Mar 18 23:53:43 2020 +0900

    java

[1mdiff --git a/algorithm_visualisation_Java/misc/README b/algorithm_visualisation_Java/misc/README[m
[1mindex 812559b..371bdea 100644[m
[1m--- a/algorithm_visualisation_Java/misc/README[m
[1m+++ b/algorithm_visualisation_Java/misc/README[m
[36m@@ -261,6 +261,7 @@[m [mTo manipulate objects, C/C++ use &* pointers, which is treated as special object[m
    }[m
      [m
 * Chapter 6, Initialization & Cleanup[m
[32m+[m[32m  //The Cp5_ is a joke. or a simple mistake.[m
 ** Constructor [m
    Same name as the class[m
 ** Method overloading[m
[36m@@ -387,12 +388,39 @@[m [mTo manipulate objects, C/C++ use &* pointers, which is treated as special object[m
          method mypgn = new method();[m
 	 mypgn.start();[m
        }[m
[31m-       void start{}{}[m
[32m+[m[32m       void start(){}[m
      }[m
[31m-   //Literally, call *new* only on the main class.[m
[31m-   //And use only the methods of the main class.[m
[32m+[m[32m   //Literally, call *new* only on the main class.?[m
[32m+[m[32m   //And use only the methods of the main classs.?[m
[32m+[m[32m   //in Cp7_PackageRun.java, we can see a resolve, by simply create a new instance of the non-static class.[m
[32m+[m[32m   //then call the method of the instance.[m
[32m+[m[32m   [[./Cp7_PackageRun.java::6][PackageRun.java]][m
    [[./Cp5_Burrito.java][Cp5_Burrito.java]][m
 [m
 * Chapter 7, Access Control[m
   *Public, protected, package access, private*[m
[32m+[m[32m** package: the library unit[m
[32m+[m[32m   package access.mypackage;[m
[32m+[m[32m   import access.mypackage;[m
[32m+[m[32m   [[./Cp7_Package.java][Package.java]][m
[32m+[m[32m   [[./Cp7_PackageRun.java::6][PackageRun.java]][m
[32m+[m[32m   //Note the path. and java's CLASSPATH env variable. echo $CLASSPATH, which is normally the current folder.[m
[32m+[m
[32m+[m[32m*** Collisions[m
[32m+[m[32m    the Collisions happens when trying to *new* a classname which is collided.[m
[32m+[m[32m    Could be avoided by stating the full path, say java.util.Vector v, instead of Vector v.[m
[32m+[m[32m*** Custom tool library[m
[32m+[m[32m    //However in order to use that, the main package structure shall remain unchanged.[m
[32m+[m[32m    //Which require some work.[m
[32m+[m[32m    //However, this should be considered a way to write all data structures, sorting, etc.[m
[32m+[m
[32m+[m[32m*** Use imports to change behavior.[m
[32m+[m[32m    *alike C's conditional compilation*[m
[32m+[m[32m    can be used in such as debugging code.[m
[32m+[m[32m    Two packages, *debug* and *debugoff*[m
[32m+[m[41m    [m
[32m+[m[32m//Mar 18, ~p152[m
[32m+[m[32m** Java Access specifiers[m
[32m+[m[32m*** Package access[m
[41m+[m
 [m

[33mcommit 1890075d44c03dc88c6b64789bc3929f9c801d67[m
Author: chnnn <chnnn.git@gmail.com>
Date:   Wed Mar 18 12:52:01 2020 +0900

    Java Cp6

[1mdiff --git a/algorithm_visualisation_Java/misc/Cp5_Burrito.java b/algorithm_visualisation_Java/misc/Cp5_Burrito.java[m
[1mnew file mode 100644[m
[1mindex 0000000..1b68d00[m
[1m--- /dev/null[m
[1m+++ b/algorithm_visualisation_Java/misc/Cp5_Burrito.java[m
[36m@@ -0,0 +1,22 @@[m
[32m+[m[32mpublic class Cp5_Burrito{[m
[32m+[m[32m    Spiciness degree;[m
[32m+[m[32m    public Cp5_Burrito (Spiciness degree){this.degree = degree;}[m
[32m+[m[32m    public void describe(){[m
[32m+[m	[32mswitch (degree){[m
[32m+[m	[32mcase NOT:[m
[32m+[m	[32mcase MILD:[m
[32m+[m	[32mcase MediUM: System.out.println("below Medium");[m
[32m+[m	[32m    break;[m
[32m+[m	[32mcase HOT:[m
[32m+[m	[32mcase FLAMING: System.out.println("Somehow Hot");[m
[32m+[m	[32m    break;[m
[32m+[m	[32m}[m
[32m+[m[32m    }[m
[32m+[m[32m    public static void main(String[] args){[m
[32m+[m	[32mCp5_Burrito[m
[32m+[m	[32m    plain = new Cp5_Burrito(Spiciness.NOT),[m
[32m+[m	[32m    chill = new Cp5_Burrito(Spiciness.HOT);[m
[32m+[m	[32mplain.describe();[m
[32m+[m	[32mchill.describe();[m
[32m+[m[32m    }[m
[32m+[m[32m}[m
[1mdiff --git a/algorithm_visualisation_Java/misc/Cp5_Enum.java b/algorithm_visualisation_Java/misc/Cp5_Enum.java[m
[1mnew file mode 100644[m
[1mindex 0000000..f01c5c4[m
[1m--- /dev/null[m
[1m+++ b/algorithm_visualisation_Java/misc/Cp5_Enum.java[m
[36m@@ -0,0 +1,13 @@[m
[32m+[m[32mpublic class Cp5_Enum{[m
[32m+[m[32m    public enum Spiciness{[m
[32m+[m	[32mNOT, MILD, MediUM, HOT, FLAMING[m
[32m+[m[32m    }[m
[32m+[m[32m    public static void main (String[] args){[m
[32m+[m	[32mSpiciness howHOT = Spiciness.MediUM;[m
[32m+[m	[32mSystem.out.println(howHOT + "ordinal" + howHOT.ordinal() + howHOT.toString());[m
[32m+[m	[32mInteger[m
[32m+[m	[32m    i = new Integer(1),[m
[32m+[m	[32m    j = new Integer(2);[m
[32m+[m	[32mSystem.out.println(" " + i + j);[m
[32m+[m[32m    }[m
[32m+[m[32m}[m
[1mdiff --git a/algorithm_visualisation_Java/misc/README b/algorithm_visualisation_Java/misc/README[m
[1mindex e134f6a..812559b 100644[m
[1m--- a/algorithm_visualisation_Java/misc/README[m
[1m+++ b/algorithm_visualisation_Java/misc/README[m
[36m@@ -375,6 +375,24 @@[m [mTo manipulate objects, C/C++ use &* pointers, which is treated as special object[m
     and when an constructor is used, the default constructor is nullified. So be aware of the f() situation[m
 //Mar 17, ~p140[m
 ** Enumerated types[m
[32m+[m[32m   the *enum* keyword.[m
[32m+[m[32m   [[./Cp5_Enum.java][Cp5_Enum.java]][m
[32m+[m[32m   //the keyword seems to create some default methods.[m
[32m+[m[32m   //which include toString(), ordinal()[m
 [m
[32m+[m[32m** Non-static variable cannot be referenced from a static context[m[41m   [m
[32m+[m[32m   *The Solution*:[m
[32m+[m[32m     class method{[m
[32m+[m[32m       public static void main(String[] args){[m
[32m+[m[32m         method mypgn = new method();[m
[32m+[m	[32m mypgn.start();[m
[32m+[m[32m       }[m
[32m+[m[32m       void start{}{}[m
[32m+[m[32m     }[m
[32m+[m[32m   //Literally, call *new* only on the main class.[m
[32m+[m[32m   //And use only the methods of the main class.[m
[32m+[m[32m   [[./Cp5_Burrito.java][Cp5_Burrito.java]][m
[32m+[m
[32m+[m[32m* Chapter 7, Access Control[m
[32m+[m[32m  *Public, protected, package access, private*[m
 [m
[31m-    [m

[33mcommit ba49a23c598aeb80eeb28a90d8450f2a2f58b3d7[m
Author: chnnn <chnnn.git@gmail.com>
Date:   Tue Mar 17 22:47:20 2020 +0900

    VarArgs

[1mdiff --git a/algorithm_visualisation_Java/misc/Cp5_ArrayLoop.java b/algorithm_visualisation_Java/misc/Cp5_ArrayLoop.java[m
[1mnew file mode 100644[m
[1mindex 0000000..546b94f[m
[1m--- /dev/null[m
[1m+++ b/algorithm_visualisation_Java/misc/Cp5_ArrayLoop.java[m
[36m@@ -0,0 +1,13 @@[m
[32m+[m[32mpublic class Cp5_ArrayLoop{[m
[32m+[m[32m    public static void main (String[] args){[m
[32m+[m	[32mOther.main(new String[] {"ah", "ha", "ha" });[m
[32m+[m[32m    }[m
[32m+[m[32m}[m
[32m+[m[32mclass Other{[m
[32m+[m[32m    public static void main (String[] args){[m
[32m+[m	[32mSystem.out.println(args);[m
[32m+[m	[32mfor(String x : args)[m
[32m+[m	[32m    System.out.print(x + "");[m
[32m+[m[32m    }[m
[32m+[m[32m}[m
[32m+[m
[1mdiff --git a/algorithm_visualisation_Java/misc/Cp5_VarArgs.java b/algorithm_visualisation_Java/misc/Cp5_VarArgs.java[m
[1mnew file mode 100644[m
[1mindex 0000000..e1a17ef[m
[1m--- /dev/null[m
[1m+++ b/algorithm_visualisation_Java/misc/Cp5_VarArgs.java[m
[36m@@ -0,0 +1,20 @@[m
[32m+[m[32mpublic class Cp5_VarArgs{[m
[32m+[m[32m    //A Static Method[m
[32m+[m[32m    static Object obj = new Integer(1);[m
[32m+[m[32m    static Object i = new Integer(1);[m
[32m+[m
[32m+[m[32m    static void printArray(Object[] args){[m
[32m+[m	[32mfor(Object obj : args)[m
[32m+[m	[32m    System.out.print(" " + obj);[m
[32m+[m	[32mSystem.out.println();[m
[32m+[m[32m    }[m
[32m+[m[32m    public static void main (String[] args){[m
[32m+[m	[32mint i = 1;[m
[32m+[m	[32mObject c = (Object) i;[m
[32m+[m	[32mSystem.out.printlnc.getClass());[m
[32m+[m
[32m+[m	[32mprintArray(new Object[]{[m
[32m+[m		[32mnew Integer(47), new Float(3.141)[m
[32m+[m	[32m    });[m
[32m+[m[32m    }[m
[32m+[m[32m}[m
[1mdiff --git a/algorithm_visualisation_Java/misc/Cp5_VarArgs2.java b/algorithm_visualisation_Java/misc/Cp5_VarArgs2.java[m
[1mnew file mode 100644[m
[1mindex 0000000..a33ea12[m
[1m--- /dev/null[m
[1m+++ b/algorithm_visualisation_Java/misc/Cp5_VarArgs2.java[m
[36m@@ -0,0 +1,21 @@[m
[32m+[m[32mpublic class Cp5_VarArgs2{[m
[32m+[m[32m    //A Static Method[m
[32m+[m[41m    [m
[32m+[m[32m    static void f(Object[] args, String... someStrs){[m
[32m+[m	[32mfor(Object obj : args)[m
[32m+[m	[32m    System.out.print(" " + obj);[m
[32m+[m	[32mSystem.out.println("next, trailers.");[m
[32m+[m	[32mfor(String s : someStrs)[m
[32m+[m	[32m    System.out.print(" " + s);[m
[32m+[m	[32mSystem.out.println();[m
[32m+[m[32m    }[m
[32m+[m[32m    public static void main (String[] args){[m
[32m+[m	[32mint i = 1;[m
[32m+[m	[32mObject c = (Object) i;[m
[32m+[m	[32mSystem.out.println(c.getClass());[m
[32m+[m	[32mf(new Object[]{[m
[32m+[m		[32mnew Integer(47), new Float(3.141)[m
[32m+[m	[32m    });[m
[32m+[m	[32mf(new Object[]{new Integer(47), new Float(3.141)}, new String("firstString"), "secondString");[m
[32m+[m[32m    }[m
[32m+[m[32m}[m
[1mdiff --git a/algorithm_visualisation_Java/misc/Cp5_VarArgsOverloading.java b/algorithm_visualisation_Java/misc/Cp5_VarArgsOverloading.java[m
[1mnew file mode 100644[m
[1mindex 0000000..685d64d[m
[1m--- /dev/null[m
[1m+++ b/algorithm_visualisation_Java/misc/Cp5_VarArgsOverloading.java[m
[36m@@ -0,0 +1,19 @@[m
[32m+[m[32mpublic class Cp5_VarArgsOverloading{[m
[32m+[m[32m    //A Static Method[m
[32m+[m[32m    static void overloadingFunction(int argsss){ //argsss is joking[m
[32m+[m	[32mSystem.out.printf("Method1%n" + argsss + "%n");[m
[32m+[m[32m    }[m
[32m+[m[32m    static void overloadingFunction(Object[] args, String... someStrs){[m
[32m+[m	[32mfor(Object obj : args)[m
[32m+[m	[32m    System.out.print(" " + obj);[m
[32m+[m	[32mSystem.out.println("next, trailers.");[m
[32m+[m	[32mfor(String s : someStrs)[m
[32m+[m	[32m    System.out.print(" " + s);[m
[32m+[m	[32mSystem.out.println();[m
[32m+[m[32m    }[m
[32m+[m[32m    public static void main (String[] args){[m
[32m+[m	[32moverloadingFunction(99);[m
[32m+[m	[32moverloadingFunction(new Object[]{new Integer (1)});[m
[32m+[m	[32moverloadingFunction(new Object[]{new Integer(47), new Float(3.141)}, new String("firstString"), "secondString");[m
[32m+[m[32m    }[m
[32m+[m[32m}[m
[1mdiff --git a/algorithm_visualisation_Java/misc/README b/algorithm_visualisation_Java/misc/README[m
[1mindex 27ae7b1..e134f6a 100644[m
[1m--- a/algorithm_visualisation_Java/misc/README[m
[1m+++ b/algorithm_visualisation_Java/misc/README[m
[36m@@ -352,5 +352,29 @@[m [mTo manipulate objects, C/C++ use &* pointers, which is treated as special object[m
    [m
    when size unknown, use the *new* keyword:[m
    int[] a;[m
[31m-   a = new int[the_Length][m
[32m+[m[32m   a = new int[the_Length];[m
[32m+[m[32m   //or[m
[32m+[m[32m   int[] a = new int[the_Length];[m
[32m+[m[32m`[m
[32m+[m[32m//Mar 15, ~p137[m
[32m+[m[32m*** Array grammar meaning[m[41m  [m
[32m+[m[32m    | int[] a1              | allocate enough memory for the *pointer*, to a primitive array       |[m
[32m+[m[32m    | int[] ai = new ...    | primitive array, value initialized to default values. i.e. 0         |[m
[32m+[m[32m    | //                    |                                                                      |[m
[32m+[m[32m    | Integer[] a = new ... | non-primitive array, create a *list of pointers* with no real values |[m
[32m+[m[32m    [[./Cp5_ArrayLoop.java][Cp5_ArrayLoop.java]][m
[32m+[m[32m//Mar 16.[m
[32m+[m[32m//Mar 17, ~p[m
[32m+[m[32m*** Variable argument lists, multiple args processing[m
[32m+[m[32m    [[./Cp5_VarArgs.java][Cp5_VarArgs.java]][m
[32m+[m[32m    //0 or more parameters, "..."[m
[32m+[m[32m    //[[https://docs.oracle.com/javase/tutorial/java/javaOO/arguments.html#varargs][docs.oracle.com: Arbitrary Numbers of Arguments]][m
[32m+[m[32m    [[./Cp5_VarArgs2.java][Cp5_VarArgs2.java]][m
[32m+[m[32m    //Better to use only 1 Varargs List when overloading.[m
[32m+[m[32m    [[./Cp5_VarArgsOverloading.java][Cp5_VarArgsOverloading.java]][m
[32m+[m[32m    and when an constructor is used, the default constructor is nullified. So be aware of the f() situation[m
[32m+[m[32m//Mar 17, ~p140[m
[32m+[m[32m** Enumerated types[m
 [m
[41m+[m
[41m+    [m

[33mcommit f868a90005ce05675cd5fddb42925918afe8fefa[m
Author: chnnn <chnnn.git@gmail.com>
Date:   Fri Mar 13 14:32:10 2020 +0900

    misc

[1mdiff --git a/emacslisp_practice.el b/emacsLisp.el[m
[1msimilarity index 100%[m
[1mrename from emacslisp_practice.el[m
[1mrename to emacsLisp.el[m
[1mdiff --git a/readme.md b/readme.md[m
[1mindex 142ed0a..89f60e1 100644[m
[1m--- a/readme.md[m
[1m+++ b/readme.md[m
[36m@@ -3,6 +3,6 @@[m
  (1分ほどの紹介ビデオ)：[m
 https://youtu.be/JPrq5dETKUQ[m
 [m
[31m-3. Algorithm_Visualisation_JAVA is in process. Estimate to complete at the end of the March, 2020.[m
[32m+[m[32m3. Algorithm_Visualisation_JAVA is in process.[m[41m [m
   Aims at a thorough JAVA study, as well as all basic algorithms.[m
 [m

[33mcommit 98c19803a202fa37eb09a91a3946897ffaff8681[m
Author: chnnn <chnnn.git@gmail.com>
Date:   Fri Mar 13 14:27:03 2020 +0900

    re-uploading the code

[1mdiff --git a/algorithm_visualisation_Java/SampleCodes/DrawRect.java b/algorithm_visualisation_Java/SampleCodes/DrawRect.java[m
[1mnew file mode 100644[m
[1mindex 0000000..82643b5[m
[1m--- /dev/null[m
[1m+++ b/algorithm_visualisation_Java/SampleCodes/DrawRect.java[m
[36m@@ -0,0 +1,44 @@[m
[32m+[m[32m//source: https://stackoverflow.com/questions/21964768/simple-java-2d-graphics-draw-a-rectangle[m
[32m+[m[32mimport java.awt.Dimension;[m
[32m+[m[32mimport java.awt.Graphics;[m
[32m+[m[32mimport javax.swing.*;[m
[32m+[m
[32m+[m[32mpublic class DrawRect extends JPanel {[m
[32m+[m[32m   private static final int RECT_X = 20;[m
[32m+[m[32m   private static final int RECT_Y = RECT_X;[m
[32m+[m[32m   private static final int RECT_WIDTH = 100;[m
[32m+[m[32m   private static final int RECT_HEIGHT = RECT_WIDTH;[m
[32m+[m
[32m+[m[32m   @Override[m
[32m+[m[32m   protected void paintComponent(Graphics g) {[m
[32m+[m[32m      super.paintComponent(g);[m
[32m+[m[32m      // draw the rectangle here[m
[32m+[m[32m      g.drawRect(RECT_X, RECT_Y, RECT_WIDTH, RECT_HEIGHT);[m
[32m+[m[32m   }[m
[32m+[m
[32m+[m[32m   @Override[m
[32m+[m[32m   public Dimension getPreferredSize() {[m
[32m+[m[32m      // so that our GUI is big enough[m
[32m+[m[32m      return new Dimension(RECT_WIDTH + 2 * RECT_X, RECT_HEIGHT + 2 * RECT_Y);[m
[32m+[m[32m   }[m
[32m+[m
[32m+[m[32m   // create the GUI explicitly on the Swing event thread[m
[32m+[m[32m   private static void createAndShowGui() {[m
[32m+[m[32m      DrawRect mainPanel = new DrawRect();[m
[32m+[m
[32m+[m[32m      JFrame frame = new JFrame("DrawRect");[m
[32m+[m[32m      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);[m
[32m+[m[32m      frame.getContentPane().add(mainPanel);[m
[32m+[m[32m      frame.pack();[m
[32m+[m[32m      frame.setLocationByPlatform(true);[m
[32m+[m[32m      frame.setVisible(true);[m
[32m+[m[32m   }[m
[32m+[m
[32m+[m[32m   public static void main(String[] args) {[m
[32m+[m[32m      SwingUtilities.invokeLater(new Runnable() {[m
[32m+[m[32m         public void run() {[m
[32m+[m[32m            createAndShowGui();[m
[32m+[m[32m         }[m
[32m+[m[32m      });[m
[32m+[m[32m   }[m
[32m+[m[32m}[m
[1mdiff --git a/algorithm_visualisation_Java/SampleCodes/Interface.java b/algorithm_visualisation_Java/SampleCodes/Interface.java[m
[1mnew file mode 100644[m
[1mindex 0000000..9fe1863[m
[1m--- /dev/null[m
[1m+++ b/algorithm_visualisation_Java/SampleCodes/Interface.java[m
[36m@@ -0,0 +1,12 @@[m
[32m+[m[32mimport javax.swing.*;[m
[32m+[m[32mpublic class Interface{[m[41m  [m
[32m+[m[32m    public static void main(String[] args) {[m[41m  [m
[32m+[m	[32mJFrame f=new JFrame();//creating instance of JFrame[m[41m  [m
[32m+[m	[32mJButton b=new JButton("click");//creating instance of JButton[m[41m  [m
[32m+[m	[32mb.setBounds(130,100,100, 40);//x axis, y axis, width, height[m[41m  [m
[32m+[m	[32mf.add(b);//adding button in JFrame[m[41m  [m
[32m+[m	[32mf.setSize(400,500);//400 width and 500 height[m[41m  [m
[32m+[m	[32mf.setLayout(null);//using no layout managers[m[41m  [m
[32m+[m	[32mf.setVisible(true);//making the frame visible[m[41m  [m
[32m+[m[32m    }[m[41m  [m
[32m+[m[32m}[m
[1mdiff --git a/algorithm_visualisation_Java/SampleCodes/Interface2.java b/algorithm_visualisation_Java/SampleCodes/Interface2.java[m
[1mnew file mode 100644[m
[1mindex 0000000..8278901[m
[1m--- /dev/null[m
[1m+++ b/algorithm_visualisation_Java/SampleCodes/Interface2.java[m
[36m@@ -0,0 +1,12 @@[m
[32m+[m[32mimport javax.swing.*;[m
[32m+[m[32mpublic class Interface2{[m[41m  [m
[32m+[m[32m    public static void main(String[] args) {[m[41m  [m
[32m+[m	[32mString fn = JOptionPane.showInputDialog("text");[m
[32m+[m
[32m+[m	[32mint num1 = Integer.parseInt(fn);[m
[32m+[m
[32m+[m	[32mint sum = num1 * 2;[m
[32m+[m
[32m+[m	[32mJOptionPane.showMessageDialog(null, "The sum is " + sum, "the title", JOptionPane.PLAIN_MESSAE);[m
[32m+[m[32m    }[m[41m  [m
[32m+[m[32m}[m
[1mdiff --git a/algorithm_visualisation_Java/misc/Cp2_Downcasting.java b/algorithm_visualisation_Java/misc/Cp2_Downcasting.java[m
[1mnew file mode 100644[m
[1mindex 0000000..f89368c[m
[1m--- /dev/null[m
[1m+++ b/algorithm_visualisation_Java/misc/Cp2_Downcasting.java[m
[36m@@ -0,0 +1,9 @@[m
[32m+[m[32mif (anim instanceof Cat) {[m
[32m+[m[32m    Cat cat = (Cat) anim;[m
[32m+[m[32m    cat.meow();[m
[32m+[m[32m} else if (anim instanceof Dog) {[m
[32m+[m[32m    Dog dog = (Dog) anim;[m
[32m+[m[32m    dog.bark();[m
[32m+[m[32m}[m
[32m+[m
[32m+[m[32mArrayList<Shape> shapes = new ArrayList<Shape>();[m
[1mdiff --git a/algorithm_visualisation_Java/misc/Cp2_NamingSpace.java b/algorithm_visualisation_Java/misc/Cp2_NamingSpace.java[m
[1mnew file mode 100644[m
[1mindex 0000000..6da8565[m
[1m--- /dev/null[m
[1m+++ b/algorithm_visualisation_Java/misc/Cp2_NamingSpace.java[m
[36m@@ -0,0 +1,13 @@[m
[32m+[m[32mpublic class Cp2_NamingSpace {[m
[32m+[m[32m    int a = 1;[m
[32m+[m[32m    private static boolean fun(){[m
[32m+[m	[32mSystem.out.println("abc");[m
[32m+[m	[32mreturn false;[m
[32m+[m[32m    }[m
[32m+[m[32m    public static void main(String[] args){[m
[32m+[m	[32mfun();[m
[32m+[m[32m    }[m
[32m+[m[41m	 [m
[32m+[m[32m}[m
[32m+[m[32m//System.out.println("efg", a);[m
[32m+[m
[1mdiff --git a/algorithm_visualisation_Java/misc/Cp2_UserInput.java b/algorithm_visualisation_Java/misc/Cp2_UserInput.java[m
[1mnew file mode 100644[m
[1mindex 0000000..492f1bb[m
[1m--- /dev/null[m
[1m+++ b/algorithm_visualisation_Java/misc/Cp2_UserInput.java[m
[36m@@ -0,0 +1,13 @@[m
[32m+[m[32mimport java.util.Scanner;[m
[32m+[m[32mclass Cp2_UserInput{[m
[32m+[m[32m    public static void main(String args[]){[m
[32m+[m[32m        Scanner in = new Scanner(System.in);[m
[32m+[m[32m        String s = in.nextLine();[m
[32m+[m[32m        System.out.println("You entered string "+s);[m
[32m+[m[32m        int a = in.nextInt();[m
[32m+[m[32m        System.out.println("You entered integer "+a);[m
[32m+[m[32m        float b = in.nextFloat();[m
[32m+[m[32m        System.out.println("You entered float "+b);[m
[32m+[m[32m    }[m
[32m+[m[32m}[m
[32m+[m
[1mdiff --git a/algorithm_visualisation_Java/misc/Cp3_Class.java b/algorithm_visualisation_Java/misc/Cp3_Class.java[m
[1mnew file mode 100644[m
[1mindex 0000000..a5c93b0[m
[1m--- /dev/null[m
[1m+++ b/algorithm_visualisation_Java/misc/Cp3_Class.java[m
[36m@@ -0,0 +1,26 @@[m
[32m+[m[32mpublic class Cp3_Class{[m
[32m+[m[32m    static class DataOnly{[m
[32m+[m	[32m//[m[41m [m
[32m+[m	[32mint i;[m
[32m+[m	[32mString c;[m
[32m+[m	[32mboolean b;[m
[32m+[m[32m    }[m
[32m+[m[32m    static class StaticTest{[m
[32m+[m	[32mstatic int i = 1;[m
[32m+[m[32m    }[m
[32m+[m[32m    public static void staticTestMethod(){[m
[32m+[m	[32mStaticTest St1 = new StaticTest();[m
[32m+[m	[32mStaticTest St2 = new StaticTest();[m
[32m+[m	[32mSt1.i++;[m
[32m+[m	[32mSt2.i++;[m
[32m+[m	[32mSt2.i = St2.i * 2;[m
[32m+[m	[32mSystem.out.println("StaticTest_i= " + StaticTest.i);[m
[32m+[m[32m    }[m
[32m+[m[32m    public static void main (String[] args){[m
[32m+[m	[32mDataOnly datax = new DataOnly();[m
[32m+[m	[32mdatax.i = 1;[m
[32m+[m	[32mdatax.c = "str";[m
[32m+[m	[32mSystem.out.println("i "+datax.i + " c "+datax.c);[m
[32m+[m	[32mstaticTestMethod();[m
[32m+[m[32m    }[m
[32m+[m[32m}[m
[1mdiff --git a/algorithm_visualisation_Java/misc/Cp3_Javadoc.java b/algorithm_visualisation_Java/misc/Cp3_Javadoc.java[m
[1mnew file mode 100644[m
[1mindex 0000000..637e802[m
[1m--- /dev/null[m
[1m+++ b/algorithm_visualisation_Java/misc/Cp3_Javadoc.java[m
[36m@@ -0,0 +1,18 @@[m
[32m+[m[32m/**[m
[32m+[m[32m * Class documentation test[m
[32m+[m[32m * newline1 with asterisk[m
[32m+[m[32m * @author chnnn[m
[32m+[m[32m */[m
[32m+[m[32mpublic class Cp3_Javadoc{[m
[32m+[m[32m    //normal comments[m
[32m+[m[32m    /*[m
[32m+[m[32m      normal comments[m
[32m+[m[32m     */[m
[32m+[m[32m    /** The main method documentation test[m
[32m+[m	[32mnewline without asterisk[m[41m [m
[32m+[m	[32m@param args the default argument[m
[32m+[m[32m    */[m
[32m+[m[32m    public static void main (String[] args){[m
[32m+[m	[32mSystem.out.println("javadoctest");[m
[32m+[m[32m    }[m
[32m+[m[32m}[m
[1mdiff --git a/algorithm_visualisation_Java/misc/Cp3_Pointers.java b/algorithm_visualisation_Java/misc/Cp3_Pointers.java[m
[1mnew file mode 100644[m
[1mindex 0000000..34046d2[m
[1m--- /dev/null[m
[1m+++ b/algorithm_visualisation_Java/misc/Cp3_Pointers.java[m
[36m@@ -0,0 +1,51 @@[m
[32m+[m[32m//import java.lang.Object.*;[m
[32m+[m[32mimport java.util.Arrays;[m
[32m+[m[32mpublic class Cp3_Pointers {[m
[32m+[m[32m    private static boolean fun(){[m
[32m+[m	[32mString s = new String ("ab");[m
[32m+[m	[32m//String s;[m
[32m+[m	[32m//s = "ab";[m
[32m+[m	[32m//String s = "ab";[m
[32m+[m	[32m//Those should be illgal in C/C++. And are special cases in Java hence should be avoided.[m
[32m+[m	[32mSystem.out.println(s);[m
[32m+[m	[32mreturn false;[m
[32m+[m[32m    }[m
[32m+[m[32m    private static void fun2(){[m
[32m+[m	[32mchar c = 'x';[m
[32m+[m	[32mSystem.out.println(c);[m
[32m+[m	[32mCharacter d = c;[m
[32m+[m	[32mSystem.out.println(d);[m
[32m+[m	[32mchar e = d;[m
[32m+[m	[32mSystem.out.println(e);[m
[32m+[m	[32mfloat i = 3;[m
[32m+[m	[32mSystem.out.println("float i= " + i);[m
[32m+[m	[32mchar j = 33; //unicode 0021 is "!"[m
[32m+[m	[32mSystem.out.println("char j= " + j);[m
[32m+[m[32m    //check later[m
[32m+[m	[32m//String f = new BigInteger(String, 9);[m
[32m+[m	[32m//Systm.out.println(f);[m
[32m+[m
[32m+[m[32m    }[m
[32m+[m[32m    public static void fun3(){[m
[32m+[m	[32mint[] an_int_array = {1, 2, 3};[m
[32m+[m	[32mSystem.out.println(an_int_array);[m
[32m+[m	[32mClass c = an_int_array.getClass();[m
[32m+[m	[32mSystem.out.println("haha: "+ c.getName());[m
[32m+[m[32m        String e = Arrays.toString(an_int_array);[m
[32m+[m	[32mSystem.out.println("hahae: "+ e);[m
[32m+[m	[32mSystem.out.println("haha2: "+ Arrays.toString(an_int_array));[m
[32m+[m	[32m//null array pointer[m
[32m+[m	[32mint[] null_array;[m
[32m+[m	[32m//System.out.println("nullarray: " + Arrays.toString(null_array));[m
[32m+[m	[32m//Compile error: variable null_array might not have been initialized[m
[32m+[m[32m    }[m
[32m+[m[41m	   [m
[32m+[m[32m    public static void main(String[] args){[m
[32m+[m	[32mfun();[m
[32m+[m	[32mfun2();[m
[32m+[m	[32mfun3();[m
[32m+[m[32m    }[m
[32m+[m[41m	 [m
[32m+[m[32m}[m
[32m+[m[32m//System.out.println("efg", a);[m
[32m+[m
[1mdiff --git a/algorithm_visualisation_Java/misc/Cp4_Bitwise.java b/algorithm_visualisation_Java/misc/Cp4_Bitwise.java[m
[1mnew file mode 100644[m
[1mindex 0000000..a10b5c9[m
[1m--- /dev/null[m
[1m+++ b/algorithm_visualisation_Java/misc/Cp4_Bitwise.java[m
[36m@@ -0,0 +1,25 @@[m
[32m+[m[32mpublic class Cp4_Bitwise{[m
[32m+[m[32m    static byte i = (byte) 0b00010001;[m
[32m+[m[32m    static byte j = (byte) 0b00110010;[m
[32m+[m[32m    public static void main (String[] args){[m
[32m+[m	[32mbyte k = (byte) (i & j);[m
[32m+[m	[32mbyte l = (byte) (i | j);[m
[32m+[m	[32mSystem.out.println(k);[m
[32m+[m	[32m//System.out.println(((byte) i | (byte) j).getClass().getName());[m
[32m+[m	[32m//Class e = ((byte) i | (byte) j).getClass();[m
[32m+[m	[32mObject o = (byte) i | (byte) j;[m
[32m+[m	[32mObject m = ((byte) i )/ ((byte) j);[m
[32m+[m	[32mSystem.out.println(o.getClass());[m
[32m+[m	[32mSystem.out.println(m.getClass());[m
[32m+[m	[32mObject p = i;[m
[32m+[m	[32mSystem.out.println(p.getClass());[m
[32m+[m	[32mObject q = i-i;[m
[32m+[m	[32mSystem.out.println(q.getClass());[m
[32m+[m	[32m//try overflow[m
[32m+[m	[32mint r = 2147483647;[m
[32m+[m	[32mSystem.out.println(r << 1);[m
[32m+[m	[32mSystem.out.println(r >>> 1);[m
[32m+[m	[32mSystem.out.println(Integer.toBinaryString(-1));[m
[32m+[m[41m	[m
[32m+[m[32m    }[m
[32m+[m[32m}[m
[1mdiff --git a/algorithm_visualisation_Java/misc/Cp4_Casting.java b/algorithm_visualisation_Java/misc/Cp4_Casting.java[m
[1mnew file mode 100644[m
[1mindex 0000000..f83a6cf[m
[1m--- /dev/null[m
[1m+++ b/algorithm_visualisation_Java/misc/Cp4_Casting.java[m
[36m@@ -0,0 +1,15 @@[m
[32m+[m[32mpublic class Cp4_Casting{[m
[32m+[m[32m    public static void main (String[] args){[m
[32m+[m	[32mint i = 100;[m
[32m+[m	[32mlong ii = i; //Auto Widening[m
[32m+[m	[32mint j = (int) ii; //Narrawing, cast required.[m
[32m+[m	[32mSystem.out.println("" + i + ii + j);[m
[32m+[m	[32mboolean x = false;[m
[32m+[m	[32mboolean y = true;[m
[32m+[m	[32mSystem.out.println(x | y);[m
[32m+[m
[32m+[m	[32mint k = 2147483647;[m
[32m+[m	[32mfloat l = (float) k;[m
[32m+[m	[32mSystem.out.println(l); //IEEE 754[m
[32m+[m[32m    }[m
[32m+[m[32m}[m
[1mdiff --git a/algorithm_visualisation_Java/misc/Cp4_InnerClass.java b/algorithm_visualisation_Java/misc/Cp4_InnerClass.java[m
[1mnew file mode 100644[m
[1mindex 0000000..5014373[m
[1m--- /dev/null[m
[1m+++ b/algorithm_visualisation_Java/misc/Cp4_InnerClass.java[m
[36m@@ -0,0 +1,15 @@[m
[32m+[m[32mpublic class Cp4_InnerClass {[m
[32m+[m[32m    String outerStr = "outerStr";[m[41m [m
[32m+[m[32m    private class Inner_Demo {[m
[32m+[m	[32mpublic void print() {[m
[32m+[m	[32m    System.out.println("InnerDemoPrinting");[m
[32m+[m	[32m}[m
[32m+[m[32m    }[m
[32m+[m[32m    void display_Inner() {[m
[32m+[m	[32mInner_Demo x = new Inner_Demo();[m
[32m+[m[32m        x.print();[m
[32m+[m[32m    }[m
[32m+[m[32m    public static void main (String[] args){[m
[32m+[m	[32m//Non-static variable cannot be referenced from a static context[m
[32m+[m[32m    }[m
[32m+[m[32m}[m
[1mdiff --git a/algorithm_visualisation_Java/misc/Cp4_Literals.java b/algorithm_visualisation_Java/misc/Cp4_Literals.java[m
[1mnew file mode 100644[m
[1mindex 0000000..fb797bb[m
[1m--- /dev/null[m
[1m+++ b/algorithm_visualisation_Java/misc/Cp4_Literals.java[m
[36m@@ -0,0 +1,42 @@[m
[32m+[m[32mpublic class Cp4_Literals{[m
[32m+[m[32m    static int i1 = 0x2f;[m
[32m+[m[32m    static int i2 = 0x2F;[m
[32m+[m[32m    static char c = 0xffff;[m
[32m+[m[32m    public static void main (String[] args){[m
[32m+[m	[32mSystem.out.println(i1);[m
[32m+[m	[32mSystem.out.println(i2);[m
[32m+[m	[32mSystem.out.println(c);[m
[32m+[m	[32mSystem.out.println(Integer.toBinaryString(c));[m
[32m+[m	[32m//[m
[32m+[m	[32mint i3 = (byte)0b1111;[m
[32m+[m	[32mint i3_2 = 0b1111;[m
[32m+[m[41m	[m
[32m+[m	[32mbyte aByte = (byte)0b00010001;[m
[32m+[m	[32mshort aShort = (short)0b1111000011110000;[m
[32m+[m	[32mlong l1 = 200L;[m
[32m+[m	[32mfloat f2 = 0.1f;[m
[32m+[m	[32mdouble d2 = 1D;[m
[32m+[m	[32mSystem.out.println(i3);[m
[32m+[m	[32mSystem.out.println(l1);[m
[32m+[m	[32mSystem.out.println(f2);[m
[32m+[m	[32mSystem.out.println(d2);[m
[32m+[m
[32m+[m	[32m//Octal[m
[32m+[m	[32mint anOctal = 010;[m
[32m+[m	[32mSystem.out.println(anOctal);[m
[32m+[m
[32m+[m	[32m//Exponents[m
[32m+[m	[32mfloat expFloat = 1.39e-43f;[m
[32m+[m	[32mfloat expFloat2 = 1.39e-44f;[m
[32m+[m	[32mSystem.out.println(expFloat);[m
[32m+[m	[32mSystem.out.println(expFloat/expFloat2);[m
[32m+[m	[32mdouble d5 = 1.39e-43d;[m
[32m+[m	[32mdouble d6 = 1.39e-44d;[m
[32m+[m	[32mSystem.out.println(d5);[m
[32m+[m	[32mSystem.out.println(d5/d6);[m
[32m+[m	[32mdouble d7 = 1e-1d;[m
[32m+[m	[32mdouble d8 = 1e1d;[m
[32m+[m	[32mSystem.out.println(d7);[m
[32m+[m	[32mSystem.out.println(d8);[m
[32m+[m[32m    }[m
[32m+[m[32m}[m
[1mdiff --git a/algorithm_visualisation_Java/misc/Cp4_Operators.java b/algorithm_visualisation_Java/misc/Cp4_Operators.java[m
[1mnew file mode 100644[m
[1mindex 0000000..7043467[m
[1m--- /dev/null[m
[1m+++ b/algorithm_visualisation_Java/misc/Cp4_Operators.java[m
[36m@@ -0,0 +1,20 @@[m
[32m+[m[32mimport static java.lang.Math.PI;[m
[32m+[m[32mimport static java.lang.Math.pow;[m
[32m+[m[32mimport static java.lang.System.out;[m
[32m+[m[32mpublic class Cp4_Operators {[m
[32m+[m[32m    public static void main (String[] args){[m
[32m+[m	[32mSystem.out.print("import static test1\n");[m
[32m+[m	[32mout.println("import static test1");[m
[32m+[m	[32mint x = 1, y = 2, z = 3;[m
[32m+[m	[32mint a = x + y - 2/2 + z;[m
[32m+[m	[32mint b = x + (y - 2)/(2 + z);[m
[32m+[m	[32mout.println("a = " + a + "b = " + b);[m
[32m+[m	[32mTestClass anValue = new TestClass();[m
[32m+[m	[32mout.println(anValue.i);[m
[32m+[m	[32manValue.i = 1;[m
[32m+[m	[32mout.println(anValue.i);[m
[32m+[m[32m    }[m
[32m+[m[32m}[m
[32m+[m[32mclass TestClass {[m
[32m+[m[32m    int i;[m
[32m+[m[32m}[m
[1mdiff --git a/algorithm_visualisation_Java/misc/Cp4_Scope.java b/algorithm_visualisation_Java/misc/Cp4_Scope.java[m
[1mnew file mode 100644[m
[1mindex 0000000..1237fa8[m
[1m--- /dev/null[m
[1m+++ b/algorithm_visualisation_Java/misc/Cp4_Scope.java[m
[36m@@ -0,0 +1,35 @@[m
[32m+[m[32m/* //The private is illegal (outside a public class)[m
[32m+[m[32mprivate class Data01{[m
[32m+[m[32m    static int constI = 1;[m
[32m+[m[32m}[m
[32m+[m[32m*/[m
[32m+[m[32m//import static must follows a static method[m
[32m+[m
[32m+[m[32m//The code might be confusing, more explaination in the note.[m
[32m+[m[32mimport static java.util.Arrays.asList;[m
[32m+[m[32mimport java.util.Random;[m
[32m+[m[32m//import java.util.*;[m
[32m+[m[32mpublic class Cp4_Scope{[m
[32m+[m[32m    private static class Data01{[m
[32m+[m	[32mstatic int constI = 1;[m
[32m+[m[32m    }[m
[32m+[m[32m    private class Data02{[m
[32m+[m	[32mstatic final int constI = 1;[m
[32m+[m[32m    }[m
[32m+[m[32m    private class Random04{[m
[32m+[m[32m        Random rand04 = new Random();[m
[32m+[m[32m    }[m
[32m+[m[32m    public static void main (String[] args){[m
[32m+[m	[32m//Data01 D = Data01();i[m
[32m+[m	[32mSystem.out.println(Data01.constI);[m
[32m+[m	[32mSystem.out.println(Data02.constI);[m
[32m+[m	[32mData01.constI++;[m
[32m+[m	[32m//Data02.constI++; illegal since final[m
[32m+[m	[32mSystem.out.println(Data01.constI);[m
[32m+[m	[32mSystem.out.println(Data02.constI);[m
[32m+[m	[32m////////////////////[m
[32m+[m[32m        Random rand03 = new Random();[m
[32m+[m[32m        int rand03_int1 = rand03.nextInt();[m[41m [m
[32m+[m	[32m//int i = rand04.nextInt();[m
[32m+[m[32m    }[m
[32m+[m[32m}[m
[1mdiff --git a/algorithm_visualisation_Java/misc/Cp5_Array.java b/algorithm_visualisation_Java/misc/Cp5_Array.java[m
[1mnew file mode 100644[m
[1mindex 0000000..4b19e75[m
[1m--- /dev/null[m
[1m+++ b/algorithm_visualisation_Java/misc/Cp5_Array.java[m
[36m@@ -0,0 +1,23 @@[m
[32m+[m[32mimport java.lang.reflect.Array;[m
[32m+[m[32mimport java.util.Arrays;[m
[32m+[m[32mpublic class Cp5_Array{[m
[32m+[m[32m    public static void main (String[] args){[m
[32m+[m	[32mint[] a1 = {1, 2, 3, 4, 5};[m
[32m+[m	[32mint[] a2;[m
[32m+[m	[32ma2 = a1; //Only changes the pointer.[m[41m [m
[32m+[m	[32mfor (int i = 0; i < Array.getLength(a2); i++)[m
[32m+[m	[32m    a2[i] += 1;[m
[32m+[m	[32mSystem.out.println(Arrays.toString(a1));[m
[32m+[m	[32m//int?[m
[32m+[m	[32mint j1 = 1;[m
[32m+[m	[32mint j2;[m
[32m+[m	[32mj2 = j1;[m
[32m+[m	[32mj2 += 1;[m
[32m+[m	[32mSystem.out.println(j1);[m
[32m+[m	[32m//or when length unknown, call a *new*[m
[32m+[m	[32mint[] a;[m
[32m+[m	[32mint the_Length = 9; //can be any random number unknowned till runtime.[m
[32m+[m	[32ma = new int[the_Length]; //can be any value or function output within [][m
[32m+[m	[32mSystem.out.println(Arrays.toString(a));[m
[32m+[m[32m    }[m
[32m+[m[32m}[m
[1mdiff --git a/algorithm_visualisation_Java/misc/Cp5_ControlFlow.java b/algorithm_visualisation_Java/misc/Cp5_ControlFlow.java[m
[1mnew file mode 100644[m
[1mindex 0000000..2f8eeba[m
[1m--- /dev/null[m
[1m+++ b/algorithm_visualisation_Java/misc/Cp5_ControlFlow.java[m
[36m@@ -0,0 +1,28 @@[m
[32m+[m[32mimport java.util.*;[m
[32m+[m[32mpublic class Cp5_ControlFlow{[m
[32m+[m[32m    public static void main (String[] args){[m
[32m+[m	[32mchar i = 123;[m
[32m+[m	[32mint k = i++;[m
[32m+[m	[32mObject o = i++;[m
[32m+[m	[32mint j = i++;[m
[32m+[m	[32mi += 1 ;[m
[32m+[m	[32mSystem.out.println((int)i);[m
[32m+[m	[32mSystem.out.println(o.getClass());[m
[32m+[m	[32mSystem.out.println((int)j);[m
[32m+[m	[32mSystem.out.println((int)k);[m
[32m+[m	[32mfor(char c = 0; c<100; c++)[m
[32m+[m	[32m    if(Character.isLowerCase(c))[m
[32m+[m		[32mSystem.out.println((int)c+ "character" +c);[m
[32m+[m	[32m//[m
[32m+[m	[32mRandom rand = new Random(47);[m
[32m+[m	[32mfloat f[] = new float[10];[m
[32m+[m	[32mfor(int ii = 0; ii<10; ii++)[m
[32m+[m	[32m    f[ii] = rand.nextFloat();[m
[32m+[m	[32mfor(float x : f)[m
[32m+[m	[32m    System.out.println(x);[m
[32m+[m	[32mfor (char c : "Hello".toCharArray())[m
[32m+[m	[32m    System.out.print(c + " ");[m
[32m+[m	[32mList<Integer> range = java.util.stream.IntStream.rangeClosed(1, 10).boxed().collect(java.util.stream.Collectors.toList());[m
[32m+[m	[32mSystem.out.printlna(range);[m
[32m+[m[32m    }[m
[32m+[m[32m}[m
[1mdiff --git a/algorithm_visualisation_Java/misc/Cp5_Initialize.java b/algorithm_visualisation_Java/misc/Cp5_Initialize.java[m
[1mnew file mode 100644[m
[1mindex 0000000..4f49c31[m
[1m--- /dev/null[m
[1m+++ b/algorithm_visualisation_Java/misc/Cp5_Initialize.java[m
[36m@@ -0,0 +1,15 @@[m
[32m+[m[32mpublic class Cp5_Initialize{[m
[32m+[m[32m    int i;[m
[32m+[m[32m    static int j;[m
[32m+[m[32m    public static void main (String[] args){[m
[32m+[m	[32mCp5_Initialize a = new Cp5_Initialize();[m
[32m+[m	[32ma.i = 1;[m
[32m+[m	[32ma.j = 1;[m
[32m+[m	[32mSystem.out.println("" + a.i + a.j);[m
[32m+[m	[32mSystem.out.println(a.i + a.j + "k"); //different[m
[32m+[m	[32mCp5_Initialize b = new Cp5_Initialize();[m
[32m+[m	[32mb.i = 2;[m
[32m+[m	[32mb.j = 2;[m
[32m+[m	[32mSystem.out.println("" + a.i + a.j); //static is not default.[m
[32m+[m[32m    }[m
[32m+[m[32m}[m
[1mdiff --git a/algorithm_visualisation_Java/misc/Cp5_Overloading.java b/algorithm_visualisation_Java/misc/Cp5_Overloading.java[m
[1mnew file mode 100644[m
[1mindex 0000000..c67cc53[m
[1m--- /dev/null[m
[1m+++ b/algorithm_visualisation_Java/misc/Cp5_Overloading.java[m
[36m@@ -0,0 +1,27 @@[m
[32m+[m[32mclass ClassTest{[m
[32m+[m[32m    int i = 0;[m
[32m+[m[32m    ClassTest(){ //constructor[m
[32m+[m	[32mi = 1;[m
[32m+[m[32m    }[m
[32m+[m[32m    ClassTest(int j){ //overload constructor[m
[32m+[m	[32mi = j;[m
[32m+[m[32m    }[m
[32m+[m[32m    public void method(){ //method[m
[32m+[m	[32mdouble k = i + i;[m
[32m+[m	[32mSystem.out.println("i + i = " + k);[m
[32m+[m[32m    }[m
[32m+[m[32m    public void method(String str2){ //method1 overload[m
[32m+[m	[32mdouble k = i * i;[m
[32m+[m	[32mSystem.out.println("i * i = " + k);[m
[32m+[m[32m    }[m
[32m+[m[32m}[m
[32m+[m[32mpublic class Cp5_Overloading{[m
[32m+[m[32m    public static void main (String[] args){[m
[32m+[m	[32mClassTest a = new ClassTest();[m
[32m+[m	[32ma.method();[m
[32m+[m	[32ma.method("rock");[m
[32m+[m	[32mClassTest b = new ClassTest(12);[m
[32m+[m	[32mb.method();[m
[32m+[m	[32mb.method("rock");[m
[32m+[m[32m    }[m
[32m+[m[32m}[m
[1mdiff --git a/algorithm_visualisation_Java/misc/Cp5_This.java b/algorithm_visualisation_Java/misc/Cp5_This.java[m
[1mnew file mode 100644[m
[1mindex 0000000..6ddf0d7[m
[1m--- /dev/null[m
[1m+++ b/algorithm_visualisation_Java/misc/Cp5_This.java[m
[36m@@ -0,0 +1,17 @@[m
[32m+[m[32mclass C{[m
[32m+[m[32m    private int i = 0;[m
[32m+[m[32m    C increment (){[m
[32m+[m	[32mi++;[m
[32m+[m[32m    return this;[m
[32m+[m[32m    }[m
[32m+[m[32m    int getter(){[m
[32m+[m	[32mreturn i;[m
[32m+[m[32m    }[m
[32m+[m[32m}[m
[32m+[m[32mpublic class Cp5_This{[m
[32m+[m[32m    public static void main(String[] args){[m
[32m+[m	[32mC x = new C();[m[41m [m
[32m+[m	[32mint j = x.increment().increment().increment().getter();[m
[32m+[m	[32mSystem.out.println(j);[m
[32m+[m[32m    }[m
[32m+[m[32m}[m
[1mdiff --git a/algorithm_visualisation_Java/misc/HelloWorld.java b/algorithm_visualisation_Java/misc/HelloWorld.java[m
[1mnew file mode 100644[m
[1mindex 0000000..b85e4c6[m
[1m--- /dev/null[m
[1m+++ b/algorithm_visualisation_Java/misc/HelloWorld.java[m
[36m@@ -0,0 +1,7 @@[m
[32m+[m[32mpublic class HelloWorld {[m
[32m+[m[32m    public static void main(String[] args) {[m
[32m+[m[32m        // Prints "Hello, World" to the terminal window.[m
[32m+[m[32m        System.out.println("Hello, World");[m
[32m+[m[32m    }[m
[32m+[m
[32m+[m[32m}[m
[1mdiff --git a/algorithm_visualisation_Java/misc/JavaReference.txt b/algorithm_visualisation_Java/misc/JavaReference.txt[m
[1mnew file mode 100644[m
[1mindex 0000000..74773df[m
[1m--- /dev/null[m
[1m+++ b/algorithm_visualisation_Java/misc/JavaReference.txt[m
[36m@@ -0,0 +1,28 @@[m
[32m+[m[32m## JAVA & SpringMVC & SQL & html & JavaScript & JSP[m[41m[m
[32m+[m[41m[m
[32m+[m[32mThinking in Java (4th ed) by Bruce Eckel[m[41m[m
[32m+[m[41m[m
[32m+[m[32m### [JAVA 基本](https://github.com/DuGuQiuBai/Java.git)[m[41m[m
[32m+[m[41m[m
[32m+[m[32m> https://github.com/DuGuQiuBai/Java.git[m[41m[m
[32m+[m[41m[m
[32m+[m[32m### [SpringMVC + MyBatis](https://github.com/lenve/JavaEETest)[m[41m[m
[32m+[m[41m[m
[32m+[m[32m> https://github.com/lenve/JavaEETest[m[41m[m
[32m+[m[41m[m
[32m+[m[32m### [SQL](https://www.runoob.com/sql/sql-tutorial.html)[m[41m[m
[32m+[m[41m[m
[32m+[m[32m> https://www.runoob.com/sql/sql-tutorial.html[m[41m[m
[32m+[m[41m[m
[32m+[m[32m### [HTML](https://www.runoob.com/html/html-tutorial.html)[m[41m[m
[32m+[m[41m[m
[32m+[m[32m> https://www.runoob.com/html/html-tutorial.html[m[41m[m
[32m+[m[41m[m
[32m+[m[32m### [JavaScript](https://www.runoob.com/js/js-tutorial.html)[m[41m[m
[32m+[m[41m[m
[32m+[m[32m> https://www.runoob.com/js/js-tutorial.html[m[41m[m
[32m+[m[41m[m
[32m+[m[32m### [JSP](https://www.runoob.com/jsp/jsp-tutorial.html)[m[41m[m
[32m+[m[41m[m
[32m+[m[32m> https://www.runoob.com/jsp/jsp-tutorial.html[m[41m  [m
[32m+[m[32m> https://github.com/mariuszs/spring-boot-web-jsp-example.git[m[41m[m
[1mdiff --git a/algorithm_visualisation_Java/misc/NewTemplate.java b/algorithm_visualisation_Java/misc/NewTemplate.java[m
[1mnew file mode 100644[m
[1mindex 0000000..7f9117e[m
[1m--- /dev/null[m
[1m+++ b/algorithm_visualisation_Java/misc/NewTemplate.java[m
[36m@@ -0,0 +1,5 @@[m
[32m+[m[32mpublic class ClassName {[m
[32m+[m[32m    public static void main (String[] args){[m
[32m+[m	[32mSystem.out.println();[m
[32m+[m[32m    }[m
[32m+[m[32m}[m
[1mdiff --git a/algorithm_visualisation_Java/misc/README b/algorithm_visualisation_Java/misc/README[m
[1mnew file mode 100644[m
[1mindex 0000000..27ae7b1[m
[1m--- /dev/null[m
[1m+++ b/algorithm_visualisation_Java/misc/README[m
[36m@@ -0,0 +1,356 @@[m
[32m+[m[32m//Thinking in Java, by Bruce Eckel, 1033 pages[m
[32m+[m
[32m+[m[32m//Mar 3, p0 ~ p33[m
[32m+[m[32m* Chapter 2. Introduction to Objects.[m
[32m+[m[32mJava 1. > C++ when objects are more "dynamic". e.g. handling data that with an always changing size. Reasons: variables declaration conventions (effect how to compile). (cpp automatic/scoped variables or static in size) vs (Java's convention, the dynamic approach, e.g. the heap).[m
[32m+[m[32m  However the dynamic method requires more headers, hence slower.[m
[32m+[m[32m  Cpp can use heap too. However needs manual order, to destory. While Java uses the GBC.[m
[32m+[m
[32m+[m[32m2. Exception cannot be ignored. Thus more robust in general[m
[32m+[m
[32m+[m[32m3. When dealing with concurrency, Language level, enables it to cross-platforming(or not because it's JVM lol) i.e. multi-threading.[m[41m [m
[32m+[m[32m  Shared resources access: Lock->use->Released loop. SE5~ with lib support. (diff. with Golong)[m
[32m+[m
[32m+[m[32m//Mar 4th, ~p44[m
[32m+[m[32m4. In Web senario. middleware a. processes client data, b. increases respond speed, c. more maintainable than changing client.[m
[32m+[m[32m  To further reduce latency, use client-side programming. i.e. Common Gateway Interface (CGI)[m
[32m+[m
[32m+[m[32m  4.1 Most of the simple client-side programming could be implemented using plug-ins & scripting language. (e.g. js) However complex scripts might be messy since it is hard to catch error or debug.[m
[32m+[m[32m  4.2 For more complicate usage (e.g. concurrency, database access, network programming, distributed computing), Java/.Net steps in via *applet* & *Java Web Start* :[m
[32m+[m[32m    The applet might be considered as a specified tiny program(e.g. capture mouse click), which is pushed from server to client when necessary. However, since it depends on JRE(+-10MB), which needs to be manually downloaded, and was not included by default in the IE(MS counter part shall be .Net/C#). The usage was limited in Internet.[m
[32m+[m[32m    In enterprise however, since client machine are configurable by system manager, the applet&JavaWebStart might be more cost-efficient, since it eliminate the needs to manually update client softwares(each push of the applet is the newest).[m
[32m+[m[32m    In cross-platform cases, Java applet/JWS > .Net, for obvious reason. Though in enterprise all-clients-Windows case exists.[m
[32m+[m[32m    In real world, cases depends on the Legacy code, and the cost of each solution.[m
[32m+[m[32m    Server-side-programming, including text processing & database r/w, are traditionally implemented using Perl, Python, C++ ,.etc to create CGI programs. For complicated usage(supposely dynamic large data?), servlets/JSPs kicks in. In this scenario, Java wins by cross-platforming. (there're more)[m
[32m+[m
[32m+[m[32m* Chapter 3. Everything is an Object[m
[32m+[m[32mTo manipulate objects, C/C++ use &* pointers, which is treated as special objects that each refer to a position in the memory. As for Java, the process is automated, and Class.Obj refers to the object in the memory.[m
[32m+[m[32m  String s;    create the pointer.[m
[32m+[m[32m  new ...;  create a new object.[m
[32m+[m[32m  //Hence, String s = "ab"; is the illegal cases in C/C++[m
[32m+[m[32m  String s = new String("asdf"); create a new obj -> link it to a pointer.[m
[32m+[m
[32m+[m[32m** Storage Lives in:[m
[32m+[m[32m  a. The registers.[m
[32m+[m[32m  b. The stack.[m
[32m+[m[32m    In RAM, but directly supported by the processor, via its stack pointer. The stack pointer moves down for new memory, moves up to release the memory. 2nd fastest(supposely because of the fixed pointer)[m
[32m+[m[32m    Objs in the stack must be specified explicitly on its exact lifetime(and size?) when compiling, thus reduce its flexibility.[m
[32m+[m[32m    Java can also create new obj in the stack, i.e. *Primitive Types*:[m
[32m+[m[32m      Heap is inefficient for small variables.[m
[32m+[m[32m      generate new variables and store it directly in the stack.[m
[32m+[m[32m      *keywords: boolean, char(16 bits), byte(8bits), short(16bits), int(32bits), long(64bits), float(32bits), double(64bits), void*[m
[32m+[m[32m      *wrappers: Boolean, Characer, Byte, Short, Integer, Long, Float, Double, Void*[m
[32m+[m[32m      Autoboxing, Wrapper and Primitive Types:[m
[32m+[m[32m        char c = 'x';    //Primitive Types c in stack[m
[32m+[m[32m        Character ch = c;[m
[32m+[m[32m        char d = ch;[m
[32m+[m[32m  c. The heap.[m
[32m+[m[32m    In RAM. Most Java objs lives in the heap. Does not require to specify the lifetime on compilation. Calling the "new" function on runtime allocates new heap for the new obj. And needs cleanup (GBC), hence slower.[m
[32m+[m[32m  d. Constant storage.[m
[32m+[m[32m    Constant values are hard coded since it never changes. Somecases in Read-Only-Memory(ROM). e.g. string pool.[m
[32m+[m[32m  e. Non-RAM storage.[m[41m [m
[32m+[m[32m    Data lives outside a program. e.g. Streamed objects & Persistent objects. (e.g. used in JDBC/Hibernation)[m
[32m+[m
[32m+[m[32m** Other datatypes:[m[41m [m
[32m+[m[32m  High-precision numbers(Check later).[m
[32m+[m[32m    BigInterger[m
[32m+[m[32m    BigDecimal[m
[32m+[m[32m  Arrays.[m
[32m+[m[32m    > C++ in the sense that, 1. a Java array is guaranteed to be initilaized; 2. Java array has memory overhead & verify index on runtime, thus eliminated the risk of illegal r/w on memory outside of the array range.[m[41m [m
[32m+[m
[32m+[m[32m//Mar 5th, ~p51[m[41m [m
[32m+[m[32m** Null pointer:[m
[32m+[m[32m  //int[] anArray = {1, 2,..., 5};[m
[32m+[m[32m  int[] nullArray;[m
[32m+[m[32m  When pointer is declared without a referencing object, JAVA auto refer it to keyward *null*. When *null* is called, compilier throws an error.[m
[32m+[m
[32m+[m[32m** Obj lifespawn & GBC:[m
[32m+[m[32m  *scope*[m
[32m+[m[32m    {...{...}...}[m
[32m+[m[32m    {int x=12;[m
[32m+[m[32m      {int x=13; //Illegal in JAVA, though legal in C/C++[m
[32m+[m[32m       String s = new String("13");[m
[32m+[m[32m      }[m
[32m+[m[32m    }[m[41m [m
[32m+[m[32m   Java's *GBC* (on runtime) search in all obj created by *new*. Auto destory when out of the scope (cannot be referenced anymore).[m[41m  [m
[32m+[m[32m   While C++ GBC is hard coded.[m
[32m+[m[41m [m
[32m+[m[32m** /Naming Conventions/[m
[32m+[m[32m  https://en.wikipedia.org/wiki/Naming_convention_%28programming%29#Java[m
[32m+[m[32m  | Class     | *UpperCamelCase*      |                                                                                                                              |[m
[32m+[m[32m  | Methods   | *lowerCamelCase*      |                                                                                                                              |[m
[32m+[m[32m  | Variables | *lowerCamelCase*      | should not start with '_' or '$'(instance variables). For temporary varialbes, (i j k) for integers, (c d e) for characters. |[m
[32m+[m[32m  | Constants | *UPPERCASECHARACTERS* | should not start with digit                                                                                                  |[m
[32m+[m
[32m+[m[32m** class:[m
[32m+[m[32m*** Default initial values for primitive types, *as members of a class*.[m
[32m+[m[32m    | boolean | false    |                       |[m
[32m+[m[32m    | char    | 'u\0000' | 16 bits = 2^16 = 16^4 |[m
[32m+[m[32m    | byte    | (byte)0  | 8 bits = 1 byte       |[m
[32m+[m[32m    | short   | (short)0 | 16 bits               |[m
[32m+[m[32m    | int     | 0        | 32 bits               |[m
[32m+[m[32m    | long    | 0L       | 64 bits               |[m
[32m+[m[32m    | float   | 0.0f     | 32 bits               |[m
[32m+[m[32m    | double  | 0.0d     | 64 bits               |[m
[32m+[m
[32m+[m[32m***  *importing packages/classes*[m
[32m+[m[32m     import java.util.ArrayList; //java.util is a package[m
[32m+[m[32m     import java.util.*;[m[41m [m
[32m+[m[41m  [m
[32m+[m[32m***  *static*[m
[32m+[m[32m      1. for CONSTANTs, that one single instance used universally.[m
[32m+[m[32m      2. for methods which are independent, to any other object instances of that class.[m
[32m+[m[32m //Mar 6th, ~p55[m[41m [m
[32m+[m[32m*** *static* method create a fix entry point. Can be called withouout creating an object.[m[41m [m
[32m+[m[32m    [[file:Cp3_Class.java::17][Cp3ClassStaticTest]][m
[32m+[m[32m    And for this reason (fixed entry point), the main{} has to be static.[m
[32m+[m
[32m+[m[32m//Mar 7th, ~p62[m[41m [m
[32m+[m[32m** Javadoc (in case need more styles, use "doclets")[m
[32m+[m[32m   *{>javadoc -d ./destination file}*[m
[32m+[m[32m   [[./Cp3_Javadoc.java::3][Cp3_Javadoc]][m
[32m+[m[32m   1. Before the class/method[m
[32m+[m[32m   2. more about @tags in *annotation*.[m
[32m+[m[32m   3. some tags: @author, @version, @param, @return, @throws(check later), @deprecated[m[41m  [m
[32m+[m[41m      [m
[32m+[m[41m      [m
[32m+[m[32m//Mar 8th, ~p68[m[41m [m
[32m+[m[32m* Chapter 4. Operators[m[41m  [m
[32m+[m[32m** *import static*[m
[32m+[m[32m   [[file:Cp4_Operators.java][Cp4_Operators_import_statiic]][m
[32m+[m[41m   [m
[32m+[m[32m** Something more about the *private, public, static* scopes.[m
[32m+[m[32m   1. The meaning of private / public field shall be clear.[m[41m [m
[32m+[m[32m    public class Person {[m
[32m+[m[32m      public String name;[m
[32m+[m[32m      private String count;[m
[32m+[m[32m      modifier returnType nameOfMethod (Param List){[m
[32m+[m[32m      //method body (could be used to modify the private variables)[m
[32m+[m[32m      }[m
[32m+[m[32m    }[m
[32m+[m[32m   //in this case, use Person.method to interact with tthe private String.[m
[32m+[m[32m   2. *static final* as const[m
[32m+[m
[32m+[m[32m//Mar 9, ~p79[m
[32m+[m[32m** The *private class* / *inner class*[m
[32m+[m[32m   Non-static variable cannot be referenced from a static context[m
[32m+[m[32m   For detail see:[m
[32m+[m[32m   [[https://docs.oracle.com/javase/tutorial/java/javaOO/innerclasses.html][docs.oracle.come/innerclasses]][m[41m [m
[32m+[m[32m   Private inner class -> referenced as *new* instance in a *public method* of the class-> main{call class constructor -> call the method};[m
[32m+[m[41m   [m
[32m+[m[32m** comparison[m
[32m+[m[32m   *equals()* (class java.lang.Object)[m[41m [m
[32m+[m[32m   *x.equals(y)* returns true if and noly if x & y points to the same object.[m
[32m+[m[32m   while as in String class, there's another equals() that compares string content if match.[m
[32m+[m
[32m+[m[32m** && || ![m
[32m+[m
[32m+[m[32m** Literals[m
[32m+[m[32m   [[./Cp4_Literals.java][Cp4_Literals.java]][m
[32m+[m[32m   (byte) (short) / L / D / f[m
[32m+[m[32m   0b / number / 0x / 0[m[41m [m
[32m+[m[32m   Expoents: 1e-2d == 0.01; 1e1d == 10;[m[41m [m
[32m+[m
[32m+[m[32m** Bitwise Operators[m
[32m+[m[32m   | AND | &           |[m
[32m+[m[32m   | OR  | verticalBar |[m
[32m+[m[32m   | XOR | ^           |[m
[32m+[m[32m   | NOT | ~           |[m
[32m+[m[32m   &=, |=, ^= are legitimate.[m
[32m+[m[32m   Bitwise-NOT is illegit on *booleans*[m
[32m+[m[41m   [m
[32m+[m[32m** How to print the type of an primitive[m
[32m+[m[32m   *Use autoboxing*[m
[32m+[m[32m   Object o = x + c;[m
[32m+[m[32m   System.out.println(o.getClass());[m
[32m+[m[32m*** Note that (byte +,-,*,/,&,| byte) -> int[m
[32m+[m[32m    [[./Cp4_Bitwise.java::10][Cp4_Bitwise]][m
[32m+[m[32m    To prevent register leak/overflow, and presumably increase effiency.[m
[32m+[m[32m    Due to the definition of the operator, which for C# is defined in (ECMA-334).[m[41m [m
[32m+[m[41m    [m
[32m+[m[32m** Shift operators[m
[32m+[m[32m   | signed extension   | >>, << |[m
[32m+[m[32m   | Unsigned extension | >>>    |[m
[32m+[m[32m   Note that since << cause overflow directly, <<< does not exist.[m
[32m+[m[32m   char, byte, short auto promote to int. (to prevent "bits leak" in the x64 register)[m
[32m+[m[32m   [[./Cp4_Bitwise.java::19][Cp4_Bitwise]][m[41m [m
[32m+[m[41m  [m
[32m+[m[32m** Print Binary Strings[m
[32m+[m[32m   Integer.toBinaryString();[m
[32m+[m[32m   Long.toBinaryString();[m
[32m+[m[41m   [m
[32m+[m[32m//Mar 10, ~p100[m
[32m+[m[32m** Ternary if-else operator[m
[32m+[m[32m   boolean-exp ? ifTrueEvalFunction0 : ifFalseEvalFunction1;[m[41m [m
[32m+[m[32m   static int ternary (int i){[m
[32m+[m[32m     return i < 10 ? i * 100 : i * 10;[m
[32m+[m[32m   }[m
[32m+[m[32m** Casting operator[m
[32m+[m[32m   [[./Cp4_Casting.java][Cp4_Casting.java]][m
[32m+[m[32m   double j = 1;[m
[32m+[m[32m   int i = (int) j;[m
[32m+[m[32m   (float format? IEEE 754, check later)[m
[32m+[m[32m   Noted that the casting is not the same in C++;[m
[32m+[m
[32m+[m[32m** round() and int()[m
[32m+[m[32m   java.lang.Math.round()[m
[32m+[m
[32m+[m[32m** no *sizeof()*[m
[32m+[m[32m   size is hard coded into the compiler.[m
[32m+[m[41m   [m
[32m+[m[32m** *no warning on overflow*.[m
[32m+[m[32m   int k = 2147483647;[m
[32m+[m[32m   k * 4 == -4;[m
[32m+[m
[32m+[m[32m* Chapter 5, Controlling Execution[m
[32m+[m[32m** if(boolean-statement)[m
[32m+[m[32m     else if()[m
[32m+[m[32m     else[m
[32m+[m
[32m+[m[32m** while(boolean-expression)[m
[32m+[m[32m     statement[m
[32m+[m
[32m+[m[32m** do-while[m
[32m+[m[32m   do[m
[32m+[m[32m   while(boolean-expression);[m
[32m+[m
[32m+[m[32m** for(initialization; boolean-expression; step)[m
[32m+[m[32m   | for (char i=0; i<10; i++) |[m
[32m+[m[32m   | for (char c : Iterable)   |[m
[32m+[m[32m   [[./Cp5_ControlFlow.java][Cp5_ControlFlow.java]][m
[32m+[m[32m** while(true) equals to for(;;) or for(;true;)[m[41m [m
[32m+[m[32m** generate a list, (1, 10): //Java 8[m[41m   [m
[32m+[m[32m   [[./Cp5_ControlFlow.java::25][Cp5_ControlFlow.java]][m
[32m+[m[32m   import static java.util.stream.*;[m
[32m+[m[32m   List<Integer> range = IntStream.rangeClosed(start, end)[m
[32m+[m[32m    .boxed().collect(Collectors.toList());[m
[32m+[m[32m     System.out.print(c + "");[m
[32m+[m[32m   //In this case java seems quite tedious handling math.[m
[32m+[m[41m   [m
[32m+[m[32m** unconditional branching. return, break, continue[m
[32m+[m[32m   *return*[m
[32m+[m[32m   quit the current method.[m
[32m+[m[32m   *break*[m
[32m+[m[32m   break the for/while loop[m
[32m+[m[32m   *continue*[m
[32m+[m[32m   next loop[m
[32m+[m[41m   [m
[32m+[m[32m//Mar 11, ~p117[m
[32m+[m[32m** "goto" - "label"[m
[32m+[m[32m   the label better to be exactly before a control flow.[m[41m [m
[32m+[m[32m   label1:[m
[32m+[m[32m   outer-iter{[m
[32m+[m[32m     lol:[m
[32m+[m[32m     inner-iter{[m
[32m+[m[32m       continue lol;[m
[32m+[m[32m       continue label1;[m
[32m+[m[32m       //...[m
[32m+[m[32m       break label1;[m
[32m+[m[32m     }[m
[32m+[m[32m   }[m
[32m+[m[41m   [m
[32m+[m[32m** switch[m
[32m+[m[32m   switch(integral-selector){[m
[32m+[m[32m     case int-value1 :[m[41m [m
[32m+[m[32m     case int-value2 : statement; //case 1 and 2 share an output.[m
[32m+[m[32m                       break;[m
[32m+[m[32m     case int-value3 : statement;[m[41m [m
[32m+[m[32m                       break;[m
[32m+[m[32m     //...[m
[32m+[m[32m     default: statement; //execute default if no match.[m
[32m+[m[32m   }[m
[32m+[m[41m     [m
[32m+[m[32m* Chapter 6, Initialization & Cleanup[m
[32m+[m[32m** Constructor[m[41m [m
[32m+[m[32m   Same name as the class[m
[32m+[m[32m** Method overloading[m
[32m+[m[32m   [[./Cp5_Overloading.java][Cp5_Overloading.java]][m
[32m+[m
[32m+[m[32m** this[m
[32m+[m[32m   this refers back to object.[m
[32m+[m[32m   [[./Cp5_This.java::3][Cp5_This.java]][m[41m [m
[32m+[m[32m   *used often in a returns clause.*[m[41m [m
[32m+[m[32m   *to pass objects around(separate implementation with object, i.e. to call methods in other classes)*[m
[32m+[m[32m   C increment(){ //C is the class. since "return this" returns an obj.[m
[32m+[m[32m     i++; return this;[m
[32m+[m[32m   }[m
[32m+[m[41m   [m
[32m+[m[32m//Mar 12th, ~p135[m
[32m+[m[32m   Also can call constructors from constructors. Once. Or use this.s = value; to modify class variable.[m
[32m+[m
[32m+[m[32m** Cannot call non-static methods from inside static methods.[m[41m [m
[32m+[m
[32m+[m[32m** Garbage Collection & Finalization[m[41m [m
[32m+[m[32m   finalize(); //is just a mark, mark object for next garbage collection. Different with the /Distructor/ from C++[m
[32m+[m[32m   Need to free() if used malloc() native function.[m
[32m+[m[32m   Not reliable.[m
[32m+[m[41m   [m
[32m+[m[32m  *Avoid Finalizers* check out <Effective Java> later.[m
[32m+[m[32m  try{//methods}[m
[32m+[m[32m  finally{super.finalize()}[m
[32m+[m[41m  [m
[32m+[m[32m  *used to catch error e.g. obj not complete processed be thrown to gbc*[m
[32m+[m[32m  protected void finalize(){[m
[32m+[m[32m    if(flag)[m
[32m+[m[32m      System.out.println("error msg.");[m
[32m+[m[32m    super.finalize() //Call the base class finalizer[m
[32m+[m[32m  }[m
[32m+[m[32m*** GBC implementation[m
[32m+[m[32m    1. reference-counting (simple, slow, inefficient)(when reference count==0 or null(out of scope), GBC. In circularly referencing cases, trash can have count greater than 0)[m
[32m+[m[32m    2. Trace from static objects on the stack / in the static storage.[m[41m [m
[32m+[m[32m       a. Hence, GBC might /stop-and-copy/, cp all live objects and pack them to new heap, thus free the desolated ones.[m
[32m+[m[32m          it also create a map of new pointers and the old. correct when during the walk.[m
[32m+[m[32m       b. when progn becomes stable, GBC uses /mark-and-sweep/, (slow but efficient in little to no garbage scenario. Prevent moving memory around.[m
[32m+[m[32m    3. for big trunks / small temporary objects, use the *reference-counting* (generation-count), as well as *stop-and-copy*.[m[41m [m
[32m+[m[32m       if all objects become long-lived, GBC proceed to *mark-and-sweep*.[m
[32m+[m[32m       if fragments becomes an issue, GBC proceed to *stop-and-copy* again.[m
[32m+[m[41m       [m
[32m+[m[32m** the JIT implementation[m
[32m+[m[32m    a JIT compiler partially or fully interpreted a code to native machine code so what does not rely on JVM interpretation.[m
[32m+[m[32m    However, take compile time, and memory for the extra machine code, which decrease speed if cause paging.[m
[32m+[m[32m    Or alternativly, /lazy evaluation/, JIT compile only when necessary.[m
[32m+[m
[32m+[m[32m** Member Initialization[m
[32m+[m[32m   [[./Cp5_Initialize.java][Cp5_Initialize.java]][m
[32m+[m[32m   Every primitive field in a *Class* is automatically initiated.[m[41m [m
[32m+[m[41m   [m
[32m+[m[32m   Ways to specify initialize value, include the followings, Different from C++[m
[32m+[m[32m   *specify when initialize*[m
[32m+[m[32m   public class C{[m
[32m+[m[32m     int i = 10;[m
[32m+[m[32m     char c = 'c';[m
[32m+[m[32m   }[m
[32m+[m[32m   //Trivia in forward referencing[m
[32m+[m[32m   public class MethodInit2[m
[32m+[m[32m     //! int j = g(i); //illegal[m
[32m+[m[32m     int i = f(); //legal[m
[32m+[m[32m     int f() {return 10;}[m
[32m+[m[32m     int g(int n) {return n;}[m
[32m+[m[32m   }[m
[32m+[m[41m   [m
[32m+[m[32m   *objects within a class might get initialized multiple times, to guarantee proper initialization*[m
[32m+[m[32m   e.g. If, in an overload method, an object is not initialized.[m
[32m+[m[41m   [m
[32m+[m[32m   *static* cannot be used on local variables, only applies to fields.[m
[32m+[m[32m   The static object is initialized only once, when the obj is first called.[m
[32m+[m[32m   public class C{[m
[32m+[m[32m     static int i;[m
[32m+[m[32m     static {[m
[32m+[m[32m       i = 47;[m
[32m+[m[32m     }[m
[32m+[m[32m   }[m
[32m+[m
[32m+[m[32m** Array initialization[m[41m   [m
[32m+[m[32m   indexing operator [];[m
[32m+[m[32m   int[] a1;[m
[32m+[m[32m   int a1[]; //C++ style[m
[32m+[m[32m   int[] a1 = {1, 2, 3, 4, 5};[m
[32m+[m[32m   int[] a2;[m
[32m+[m[32m   a2 = a1; //Only changes the pointer.[m[41m [m
[32m+[m[32m   //So a2 change affects a1...[m
[32m+[m[32m   [[./Cp5_Array.java][Cp5_Array.java]][m
[32m+[m[41m   [m
[32m+[m[32m   when size unknown, use the *new* keyword:[m
[32m+[m[32m   int[] a;[m
[32m+[m[32m   a = new int[the_Length][m
[32m+[m
[1mdiff --git a/algorithm_visualisation_Java/readme b/algorithm_visualisation_Java/readme[m
[1mnew file mode 100644[m
[1mindex 0000000..49dcb2e[m
[1m--- /dev/null[m
[1m+++ b/algorithm_visualisation_Java/readme[m
[36m@@ -0,0 +1,10 @@[m
[32m+[m[32m//Visualisation of basic algorithm, Java project. 3 parts included.[m
[32m+[m[32m//Sorting[m
[32m+[m[32m//Data Structure & Searching: LinkLists, Stacks & Queues, HashTables, Trees, Heaps, Graphs[m
[32m+[m[32m//Path finding: Djkstra, A*, etc.[m[41m [m
[32m+[m[32m------------------------------------[m
[32m+[m[32mI realize that maybe Java is not that great in stand-alone visulisation.[m[41m [m
[32m+[m[32mMajority of that part could be handled with js. .etc.[m
[32m+[m
[32m+[m[32mD3.js[m
[32m+[m[32mHighcharts[m[41m [m
[1mdiff --git a/emacslisp_practice.el b/emacslisp_practice.el[m
[1mnew file mode 100644[m
[1mindex 0000000..6088964[m
[1m--- /dev/null[m
[1m+++ b/emacslisp_practice.el[m
[36m@@ -0,0 +1,202 @@[m
[32m+[m[32mc-x C-f: Opens a file, ask for the file name. Create the file if not exist.[m
[32m+[m[32mC-x C-s: Saves the file without a prompt[m
[32m+[m[32mC-x s: Saves the all files with a prompt[m
[32m+[m[32mC-s C-w: Saves the file with a different name. Asks for the name.[m
[32m+[m[32mEverytime a file is saved, Emacs creates a file~, which is the previous version of the file.[m
[32m+[m[32mAlso, Emacs auto-saves everhthing you type to a file named "#filename#".[m
[32m+[m[32mC-x C-c: to Quits[m
[32m+[m[32mC-g Always quits the command.[m
[32m+[m
[32m+[m[32m;;;;;;;;;Majorly Overrided;;;;;;;;;;;[m
[32m+[m[32m;"#Copy&Paste" Overrided by evil-mode.[m
[32m+[m[32m----------[m
[32m+[m[32mC-x h: Select the whole buffer[m
[32m+[m[32mC-k : Vim dd[m
[32m+[m[32mC-y : Vim p[m
[32m+[m[32mC-Space: Vim Visual mode?[m
[32m+[m[32mM-w : Copies the selection into the clipboard[m
[32m+[m[32mC-w : Cut the selection into the clipboard[m
[32m+[m[32mIn evil-mode the first buffer always goes to the clipboard now. Nice.[m
[32m+[m[32m----------[m
[32m+[m[32m;"#Cursor Commands", Partially overrided by evil-mode[m
[32m+[m[32m----------[m
[32m+[m[32mC-a / C-e : Beginning/End of a line.[m
[32m+[m[32mM-> : End of buffer[m
[32m+[m[32mM-< : Beginning of buffer[m
[32m+[m
[32m+[m[32m;Undo/Redo, Overrided by evil-mode[m
[32m+[m[32m----------[m
[32m+[m[32mC-/ : Undo[m
[32m+[m[32mC-g C-/ : Redo[m
[32m+[m[32m;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;[m
[32m+[m[32m;Vim Commands[m
[32m+[m[32mma/mA(remove previous a mark) set mark a[m
[32m+[m[32m'a/`a               back to first of line / exactly mark a[m
[32m+[m[32m]`/[`               jump list navigation[m
[32m+[m
[32m+[m[32m;Window Commands[m
[32m+[m[32m----------[m
[32m+[m[32mC-x 0 : Single Window view.[m
[32m+[m
[32m+[m[32m;Buffer Commands[m
[32m+[m[32m----------[m
[32m+[m[32mC-x b : Switches buffers (same as bxut in case evil-mode :b or ls does not work, e.g. in help document)[m
[32m+[m[32mC-w s : Split the current window vertically. (Vim command)[m
[32m+[m[32mC-w v : Split the current window horizontally. (Vim command)[m
[32m+[m
[32m+[m[32mC-x o : Switch between windows[m
[32m+[m[32mC-w h/j/k/l : Switch between windows in a direction. (Vim command)[m
[32m+[m[32mC-w >/</+/-: Adjust windows width/height[m
[32m+[m[32mC-w _/=: Adjust windows height[m
[32m+[m
[32m+[m[32m;Help Commands[m
[32m+[m[32m-------------[m
[32m+[m[32mC-h[m[41m [m
[32m+[m[32mC-h c : <describe key-combination briefly>[m
[32m+[m[32mC-h k : <describe key> same as F1-k[m
[32m+[m[32mC-h m : <describe mode>[m
[32m+[m[32mC-h f : <describe funtion>[m
[32m+[m[32mC-h a : apropos-command, fuzzy search for the command[m
[32m+[m[32minfo[m
[32m+[m[32mC-h v : <describe-variable>[m
[32m+[m[32mM-x customize-group[m
[32m+[m
[32m+[m[32m;Run Emacs Daemon[m
[32m+[m[32m-------------[m
[32m+[m[32memacs --daemon[m
[32m+[m[32memacs --fg-daemon : run in foreground[m
[32m+[m[32memacsclient --eval "(kill-emacs)" : in bash to kill the daemon or eval(a-x)  kill-emacs[m
[32m+[m[32memacsclient <file> : to access[m
[32m+[m
[32m+[m[32m;Tabs[m
[32m+[m[32m------------[m
[32m+[m[32mC-x h then M-x untabify/tabify[m
[32m+[m[32mhttps://www.emacswiki.org/emacs/IndentationBasics[m
[32m+[m
[32m+[m[32m;Elisp / REPO(Re-Eval-Print-Loop)[m[41m [m
[32m+[m[32m-----------[m
[32m+[m[32mC-x C-e : eval-last sexp[m
[32m+[m[32mM-x byte-compile-file[m
[32m+[m[32mC-M-i auto-completion[m
[32m+[m[32m(- 2 5)[m
[32m+[m[32m'foo!'[m
[32m+[m[32m(message "abc") : send the message to the mini-buffer[m
[32m+[m[32m(insert " ;inserted text") : insert text at the cursor location[m
[32m+[m[32m(quote(1 2 3)) : the list (1,2,3)[m
[32m+[m[32m'(1 2 3)[m
[32m+[m[32m(car '(1 2 3)) : the content of the address register[m
[32m+[m[32m(cdr '(1 2 3)) : the content of the decrement register[m
[32m+[m[32m'() : () : nil : all the same and falsy[m[41m [m
[32m+[m[32m(null '()) : check if null[m
[32m+[m[32m(cons '(1 2) (cons '(3 4) '()))[m
[32m+[m[32m(cons '(1 2) (cons '(3 4) nil))[m
[32m+[m[32m(set 'some-list '(1 2 3)) : set and setq(set quote) and global[m
[32m+[m[32msome-list[m[41m [m
[32m+[m[32m(let ((a 1)[m
[32m+[m[32m      (b 5))[m
[32m+[m[32m  (format "a is %d and b is %d" a b))[m
[32m+[m[32m(let* ((a 1)[m
[32m+[m[32m      (b (+ a 5)))[m
[32m+[m[32m  (format "a is %d and b is %d" a b)) ;: let* is sequential[m
[32m+[m[32m(defun square (x)[m
[32m+[m[32m  (* x x))[m
[32m+[m[32m(square 2)[m
[32m+[m[32m(defun distance (x1 y1 x2 y2)[m
[32m+[m[32m  (sqrt (+ (square (- x1 x2)) (square (- y1 y2))))[m
[32m+[m[32m  )[m
[32m+[m[32m(distance 1 2 3 4)[m
[32m+[m
[32m+[m[32m;;Conditions[m
[32m+[m[32m(when (= 1))[m
[32m+[m[32m(defun evens-or-odds (n)[m
[32m+[m[32m  (if (= 0 (% n 2))[m
[32m+[m[32m      "even"[m
[32m+[m[32m    "odd"))[m
[32m+[m[32m(evens-or-odds 4)[m
[32m+[m[32m(defun conditions (n)[m
[32m+[m[32m  (cond[m
[32m+[m[32m   ((= n 1) "bulbous")[m
[32m+[m[32m   ((= n 2) "bouffant")[m
[32m+[m[32m   (t "gazebo")[m
[32m+[m[32m   )[m
[32m+[m[32m  )[m
[32m+[m[32m(conditions '(33)) : fail because the function '= need a number as input[m
[32m+[m[32m(conditions 4)[m
[32m+[m
[32m+[m[32m;;Anoymous functions. lambda is executable. note the parentheses[m
[32m+[m[32m(lambda (x) (* x x x))[m
[32m+[m[32m( (lambda (x) (* x x x)) 5)[m
[32m+[m[32m( (lambda () (setq a 2)) )[m
[32m+[m[32m(setq a 1)[m
[32m+[m[32ma[m
[32m+[m[32m(fset 'cubic (lambda(x) (* x x x))) : fset set 'cubic to the function space[m
[32m+[m[32m(set 'cubic 1)[m
[32m+[m[32mcubic : eval to 1[m
[32m+[m[32m(cubic 4) : eval to 64[m
[32m+[m
[32m+[m[32m(global-set-key (kbd "M-#") 'sort-lines) ;; global applies to major-mode[m
[32m+[m[32m(add-hook 'c-mode-common-hook[m
[32m+[m	[32m  (lambda()[m
[32m+[m	[32m    (local-set-key (kud "<f5>") 'recompile)))[m
[32m+[m[32m;;Java settings[m
[32m+[m[32m(add-hook 'java-mode-hook[m
[32m+[m[32m    (lambda ()[m
[32m+[m	[32m(set (make-local-variable 'compile-command)[m
[32m+[m	[32m    (concat "javac "[m
[32m+[m		[32m    (if buffer-file-name[m
[32m+[m			[32mbuffer-file-name)))))[m
[32m+[m[32m;(file-name-sans-extension (buffer-file-name))[m
[32m+[m[32m(add-hook 'java-mode-hook[m
[32m+[m[32m      (lambda()[m
[32m+[m[32m        (local-set-key (kbd "<f5>") (lambda()[m
[32m+[m[32m                                      (interactive)[m
[32m+[m[32m                                      (if (get-buffer '"*compilation*")[m
[32m+[m[32m                                        (progn[m
[32m+[m[32m                                          (kill-buffer '"*compilation*")[m
[32m+[m[32m                                            (compile compile-command))[m
[32m+[m[32m                                        (compile compile-command))))))[m
[32m+[m[32m;;f6 run(or test later?)[m[41m    [m
[32m+[m[32m(add-hook 'java-mode-hook[m
[32m+[m	[32m  (lambda()[m
[32m+[m	[32m    (local-set-key (kbd "<f6>") (lambda() (interactive) (shell-command (concat "java "[m
[32m+[m										[32m       (if buffer-file-name[m
[32m+[m											[32m   (shell-quote-argument[m
[32m+[m											[32m    (file-name-nondirectory (file-name-sans-extension buffer-file-name))))"&")[m
[32m+[m									[32m       (get-buffer-create '"*compilation*"))))))[m
[32m+[m[32m(load-file user-init-file) ;;reload init file[m
[32m+[m[32m;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;[m
[32m+[m[32mBlock execution -> org mode[m[41m [m
[32m+[m
[32m+[m
[32m+[m[32m;;lsp-mode[m
[32m+[m[32m;;c/cpp company auto-complete[m
[32m+[m[32m(use-package company[m
[32m+[m	[32m     :ensure t[m
[32m+[m	[32m     :config[m
[32m+[m	[32m     (setq company-idle-delay 0)[m
[32m+[m	[32m     (setq company-minimum-prefix-length 3))[m
[32m+[m[32m(with-eval-after-load 'company[m
[32m+[m[32m  (define-key company-active-map (kbd "M-n") nil)[m
[32m+[m[32m  (define-key company-active-map (kbd "M-p") nil)[m
[32m+[m[32m  (define-key company-active-map (kbd "C-n") #'company-select-next)[m
[32m+[m[32m  (define-key company-active-map (kbd "C-p") #'company-select-previous))[m
[32m+[m[32m(use-package company-irony[m
[32m+[m	[32m     :ensure t[m
[32m+[m	[32m     :config[m
[32m+[m	[32m     (require`company)[m
[32m+[m	[32m     (add-to-list `company-backends `company-irony))[m
[32m+[m[32m(use-package irony[m
[32m+[m	[32m     :ensure t[m
[32m+[m	[32m     :config[m
[32m+[m	[32m     (add-hook 'c++-mode-hook 'irony-mode)[m
[32m+[m	[32m     (add-hook 'c-mode-hook 'irony-mode)[m
[32m+[m	[32m     (add-hook 'irony-mode-hook 'irony-cdb-autosetup-compile-options))[m
[32m+[m[32m(with-eval-after-load 'company[m
[32m+[m	[32m     (add-hook 'c++-mode-hook 'company-mode)[m
[32m+[m	[32m     (add-hook 'c-mode-hook 'company-mode))[m
[32m+[m
[32m+[m[32m;;lsp-java[m
[32m+[m
[32m+[m
[32m+[m
[32m+[m
[1mdiff --git a/morse_code/IMC_data.txt b/morse_code/IMC_data.txt[m
[1mnew file mode 100644[m
[1mindex 0000000..28bde83[m
[1m--- /dev/null[m
[1m+++ b/morse_code/IMC_data.txt[m
[36m@@ -0,0 +1,36 @@[m
[32m+[m[32ma .-[m
[32m+[m[32mb -...[m
[32m+[m[32mc -.-.[m
[32m+[m[32md -..[m
[32m+[m[32me .[m
[32m+[m[32mf ..-.[m
[32m+[m[32mg --.[m
[32m+[m[32mh ....[m
[32m+[m[32mi ..[m
[32m+[m[32mj .---[m
[32m+[m[32mk -.-[m
[32m+[m[32ml .-..[m
[32m+[m[32mm --[m
[32m+[m[32mn -.[m
[32m+[m[32mo ---[m
[32m+[m[32mp .--.[m
[32m+[m[32mq --.-[m
[32m+[m[32mr .-.[m
[32m+[m[32ms ...[m
[32m+[m[32mt -[m
[32m+[m[32mu ..-[m
[32m+[m[32mv ...-[m
[32m+[m[32mw .--[m
[32m+[m[32mx -..-[m
[32m+[m[32my -.--[m
[32m+[m[32mz --..[m
[32m+[m[32m0 -----[m
[32m+[m[32m1 .----[m
[32m+[m[32m2 ..---[m
[32m+[m[32m3 ...--[m
[32m+[m[32m4 ....-[m
[32m+[m[32m5 .....[m
[32m+[m[32m6 -....[m
[32m+[m[32m7 --...[m
[32m+[m[32m8 ---..[m
[32m+[m[32m9 ----.[m
[1mdiff --git a/morse_code/MorseEmitter.py b/morse_code/MorseEmitter.py[m
[1mnew file mode 100644[m
[1mindex 0000000..13255e8[m
[1m--- /dev/null[m
[1m+++ b/morse_code/MorseEmitter.py[m
[36m@@ -0,0 +1,11 @@[m
[32m+[m[32mimport ledhandler[m
[32m+[m
[32m+[m[32mStringtobeConvert = raw_input("Input a string to send as morse code")[m
[32m+[m[32m#The input string shall range from[a-z][0-9][m
[32m+[m[32mStringtobeConvert = str(StringtobeConvert)[m
[32m+[m[32mStringtobeConvert = StringtobeConvert.lower()[m
[32m+[m
[32m+[m[32m#def charactertobesent_array_creation(original_string):[m
[32m+[m[32mfor characters in StringtobeConvert:[m
[32m+[m[32m    #print characters;[m
[32m+[m[32m    ledhandler.LED_IMC_MORSE_BLINK(characters, 0.4)[m
[1mdiff --git a/morse_code/Pipfile b/morse_code/Pipfile[m
[1mnew file mode 100644[m
[1mindex 0000000..f522099[m
[1m--- /dev/null[m
[1m+++ b/morse_code/Pipfile[m
[36m@@ -0,0 +1,13 @@[m
[32m+[m[32m[[source]][m
[32m+[m[32mname = "pypi"[m
[32m+[m[32murl = "https://pypi.org/simple"[m
[32m+[m[32mverify_ssl = true[m
[32m+[m
[32m+[m[32m[dev-packages][m
[32m+[m
[32m+[m[32m[packages][m
[32m+[m[32mgpiozero = "*"[m
[32m+[m[32mtime = "*"[m
[32m+[m
[32m+[m[32m[requires][m
[32m+[m[32mpython_version = "2.7"[m
[1mdiff --git a/morse_code/Pipfile.lock b/morse_code/Pipfile.lock[m
[1mnew file mode 100644[m
[1mindex 0000000..9ca6f18[m
[1m--- /dev/null[m
[1m+++ b/morse_code/Pipfile.lock[m
[36m@@ -0,0 +1,36 @@[m
[32m+[m[32m{[m
[32m+[m[32m    "_meta": {[m
[32m+[m[32m        "hash": {[m
[32m+[m[32m            "sha256": "ff69acc272256fcd8640d5335186eb30e69ff1d261484e2a2a65ad7abea14ea4"[m
[32m+[m[32m        },[m
[32m+[m[32m        "pipfile-spec": 6,[m
[32m+[m[32m        "requires": {[m
[32m+[m[32m            "python_version": "2.7"[m
[32m+[m[32m        },[m
[32m+[m[32m        "sources": [[m
[32m+[m[32m            {[m
[32m+[m[32m                "name": "pypi",[m
[32m+[m[32m                "url": "https://pypi.org/simple",[m
[32m+[m[32m                "verify_ssl": true[m
[32m+[m[32m            }[m
[32m+[m[32m        ][m
[32m+[m[32m    },[m
[32m+[m[32m    "default": {[m
[32m+[m[32m        "colorzero": {[m
[32m+[m[32m            "hashes": [[m
[32m+[m[32m                "sha256:acba47119b5d8555680d3cda9afe6ccc5481385ccc3c00084dd973f7aa184599",[m
[32m+[m[32m                "sha256:e3c36d15b293de2b2f77ff54a5bd243fffac941ed0a5332d0697a6612a26a0a3"[m
[32m+[m[32m            ],[m
[32m+[m[32m            "version": "==1.1"[m
[32m+[m[32m        },[m
[32m+[m[32m        "gpiozero": {[m
[32m+[m[32m            "hashes": [[m
[32m+[m[32m                "sha256:101044038e71cec8be2fa841d4cea9e50e7962e9fb0287f465298b59e3f06594",[m
[32m+[m[32m                "sha256:ae1a8dc4e6e793ffd8f900968f3290d218052c46347fa0c0503c65fabe422e4d"[m
[32m+[m[32m            ],[m
[32m+[m[32m            "index": "pypi",[m
[32m+[m[32m            "version": "==1.5.1"[m
[32m+[m[32m        }[m
[32m+[m[32m    },[m
[32m+[m[32m    "develop": {}[m
[32m+[m[32m}[m
[1mdiff --git a/morse_code/ledhandler.py b/morse_code/ledhandler.py[m
[1mnew file mode 100644[m
[1mindex 0000000..2b8f2f9[m
[1m--- /dev/null[m
[1m+++ b/morse_code/ledhandler.py[m
[36m@@ -0,0 +1,68 @@[m
[32m+[m[32mfrom gpiozero import LED[m
[32m+[m[32mfrom time import sleep[m
[32m+[m[32mimport string[m
[32m+[m
[32m+[m[32m#------datasheet.readline.handler-----#[m
[32m+[m[32mdatafile = open("./IMC_data.txt", "r")[m
[32m+[m[32mmorse_chart_matrix = [][m
[32m+[m[32mmorse_chart_matrix = [line.split() for line in datafile][m
[32m+[m[32m#print morse_chart_matrix[m
[32m+[m[32m#print morse_chart_matrix[3][m
[32m+[m[32m#print morse_chart_matrix[3][0][m
[32m+[m[32m#print morse_chart_matrix[3][1][m
[32m+[m[32m#[3]is d, the example output is -..[m
[32m+[m[32m#------datasheet.readline.handler-----#[m
[32m+[m
[32m+[m[32m#1. The length of a dot is one unit.[m
[32m+[m[32m#2. A dash is three units.[m
[32m+[m[32m#3. The space between parts of the same letter is one unit.[m
[32m+[m[32m#4. The space between letters is three units.[m
[32m+[m[32m#5. The space between words is seven units.[m
[32m+[m
[32m+[m[32m#the character input shall be lowercase & space[m
[32m+[m[32m#the IMC_data.txt does not include space[m
[32m+[m[32mdef LED_IMC_MORSE_BLINK(character, unit_time = 0.4):[m
[32m+[m[32m    if character.isalpha():[m
[32m+[m[32m        character_index = string.lowercase.index(character)[m
[32m+[m[32m        morse_code_to_send = morse_chart_matrix[character_index][1][m
[32m+[m[32m    elif character.isdigit():[m
[32m+[m[32m        the_last_alphabet_index_in_data = 25[m
[32m+[m[32m        character_index = the_last_alphabet_index_in_data + 1 + int(character)[m
[32m+[m[32m        morse_code_to_send = morse_chart_matrix[character_index][1][m
[32m+[m[32m    elif character.isspace():[m
[32m+[m[32m        morse_code_to_send = "seven_units_hold"[m[41m [m
[32m+[m[32m    LED_CONTROL(morse_code_to_send, unit_time)[m
[32m+[m
[32m+[m[32m#example input is ("--.", 0.4)[m
[32m+[m[32mdef LED_CONTROL(morse_code_to_send, unit_time):[m
[32m+[m[32m    led = LED(17)[m
[32m+[m[32m    if morse_code_to_send == "seven_units_hold":[m
[32m+[m[32m        led.off()[m
[32m+[m[32m        #between words, sleep seven units.[m
[32m+[m[32m        sleep(unit_time * (7-3))[m
[32m+[m[32m        return()[m
[32m+[m[32m    else:[m
[32m+[m[32m        for i in morse_code_to_send:[m
[32m+[m[32m            if i == ".":[m
[32m+[m[32m                led.on()[m
[32m+[m[32m                sleep(unit_time * 1)[m
[32m+[m[32m                led.off()[m
[32m+[m[32m                sleep(unit_time * 1)[m
[32m+[m[32m            elif i == "-":[m
[32m+[m[32m                led.on()[m
[32m+[m[32m                sleep(unit_time * 3)[m
[32m+[m[32m                led.off()[m
[32m+[m[32m                sleep(unit_time * 1)[m
[32m+[m[32m    led.off()[m
[32m+[m[32m    #sleep three units after sending every letter[m
[32m+[m[32m    sleep(unit_time * (3-1))[m
[32m+[m[32m    return()[m
[32m+[m[41m    [m
[32m+[m
[32m+[m[32m#function LED_IMC_MORSE_BLINK(b, 0.4);[m[41m [m
[32m+[m
[32m+[m[32m#while True:[m
[32m+[m[32m#    led.on()[m
[32m+[m[32m#    sleep(1)[m
[32m+[m[32m#    led.off()[m
[32m+[m[32m#    sleep(1)[m
[1mdiff --git a/morse_code/ledhandler_test.py b/morse_code/ledhandler_test.py[m
[1mnew file mode 100644[m
[1mindex 0000000..897ddff[m
[1m--- /dev/null[m
[1m+++ b/morse_code/ledhandler_test.py[m
[36m@@ -0,0 +1,6 @@[m
[32m+[m[32mimport ledhandler[m
[32m+[m
[32m+[m[32mledhandler.LED_IMC_MORSE_BLINK("a")[m
[32m+[m[32mledhandler.LED_IMC_MORSE_BLINK("b", 0.4)[m
[32m+[m[32mledhandler.LED_IMC_MORSE_BLINK("9", 0.3)[m
[32m+[m
[1mdiff --git a/morse_code/readme b/morse_code/readme[m
[1mnew file mode 100644[m
[1mindex 0000000..cdf87b1[m
[1m--- /dev/null[m
[1m+++ b/morse_code/readme[m
[36m@@ -0,0 +1,16 @@[m
[32m+[m[32m#This is aereadmefile for the Morse_code_emitter programme[m
[32m+[m[32m#The programme accept input and output LED blinks through Raspberry Pi 4's GPIO pin 17. The LED blinks are correspond to Morse code.[m
[32m+[m[32m#Video: https://youtu.be/tKNwtsOHZy4[m
[32m+[m
[32m+[m[32m#Dependencies:[m
[32m+[m[32m    #python2.7[m
[32m+[m[32m    #gpiozero   (standard python library for pi4 gpio controlling)[m[41m [m
[32m+[m[32m    #string[m
[32m+[m[32m    #time[m
[32m+[m
[32m+[m[32m    #the programme is ran through a pipenv that contains the gpiozero package.[m
[32m+[m
[32m+[m[32m#Run:[m
[32m+[m[32m    #Run the main MorseEmitter.py[m
[32m+[m[32m    #Input a string[m
[32m+[m[32m    #the pi will output the correspondent signal through GPIO pin 17[m
[1mdiff --git a/morse_code/tempfiles/nonestopblink.py b/morse_code/tempfiles/nonestopblink.py[m
[1mnew file mode 100644[m
[1mindex 0000000..6f57c25[m
[1m--- /dev/null[m
[1m+++ b/morse_code/tempfiles/nonestopblink.py[m
[36m@@ -0,0 +1,17 @@[m
[32m+[m[32m#None stop high frequency blinking test[m
[32m+[m[32mfrom gpiozero import LED[m
[32m+[m[32m#from gpiozero import PWMLED[m[41m [m
[32m+[m[32mfrom time import sleep[m
[32m+[m[32mfrom signal import pause[m
[32m+[m
[32m+[m[32m#led = PWMLED(17)[m
[32m+[m[32mled = LED(17)[m
[32m+[m
[32m+[m[32m#for i in range(100):[m
[32m+[m[32m#    led.on()[m
[32m+[m[32m#    sleep(0.05)[m
[32m+[m[32m#    led.off()[m
[32m+[m[32m#    sleep(0.05)[m
[32m+[m
[32m+[m[32mled.pulse()[m
[32m+[m[32mpause()[m
[1mdiff --git a/morse_code/tempfiles/simpleblink.py b/morse_code/tempfiles/simpleblink.py[m
[1mnew file mode 100644[m
[1mindex 0000000..56f419e[m
[1m--- /dev/null[m
[1m+++ b/morse_code/tempfiles/simpleblink.py[m
[36m@@ -0,0 +1,12 @@[m
[32m+[m[32m#The first programme from gpio manual[m
[32m+[m
[32m+[m[32mfrom gpiozero import LED[m
[32m+[m[32mfrom time import sleep[m
[32m+[m
[32m+[m[32mled = LED(17)[m
[32m+[m
[32m+[m[32mwhile True:[m
[32m+[m[32m    led.on()[m
[32m+[m[32m    sleep(1)[m
[32m+[m[32m    led.off()[m
[32m+[m[32m    sleep(1)[m
[1mdiff --git a/morse_code/tempfiles/test2.py b/morse_code/tempfiles/test2.py[m
[1mnew file mode 100644[m
[1mindex 0000000..2a675d7[m
[1m--- /dev/null[m
[1m+++ b/morse_code/tempfiles/test2.py[m
[36m@@ -0,0 +1,6 @@[m
[32m+[m[32mimport string[m
[32m+[m[32moutputa = string.lowercase.index("z")[m
[32m+[m[32mprint(outputa)[m
[32m+[m
[32m+[m[32mteststring = "abcdefg"[m
[32m+[m[32mprint("a".isalpha())[m
[1mdiff --git a/readme.md b/readme.md[m
[1mnew file mode 100644[m
[1mindex 0000000..142ed0a[m
[1m--- /dev/null[m
[1m+++ b/readme.md[m
[36m@@ -0,0 +1,8 @@[m
[32m+[m[32m1. Each folder contains a project[m
[32m+[m[32m2. One minute introduction video on the Rubik's cube Project.[m
[32m+[m[32m (1分ほどの紹介ビデオ)：[m
[32m+[m[32mhttps://youtu.be/JPrq5dETKUQ[m
[32m+[m
[32m+[m[32m3. Algorithm_Visualisation_JAVA is in process. Estimate to complete at the end of the March, 2020.[m
[32m+[m[32m  Aims at a thorough JAVA study, as well as all basic algorithms.[m
[32m+[m
[1mdiff --git a/rubiks_cube_simulator/README.md b/rubiks_cube_simulator/README.md[m
[1mnew file mode 100644[m
[1mindex 0000000..c63ce57[m
[1m--- /dev/null[m
[1m+++ b/rubiks_cube_simulator/README.md[m
[36m@@ -0,0 +1,52 @@[m
[32m+[m[32m#A python rubik's cube simulator.[m
[32m+[m
[32m+[m[32m#Video in 1 min:[m
[32m+[m[32mhttps://youtu.be/JPrq5dETKUQ[m
[32m+[m
[32m+[m[32m#-----------miscs----------[m
[32m+[m[32mThis programme will be temporarily marked as finished. I will add no more further functionality to it, due to the clumsy nature of its huge dependies (hard to package).[m
[32m+[m[32mAny further implementation will be done somedays in the future when I rewrite this in JS.[m[41m [m
[32m+[m
[32m+[m[32m#-------------Usage------------------[m
[32m+[m
[32m+[m[32mRun the script "main.py".[m
[32m+[m
[32m+[m[32mPress key l, r, u, d, f, b to rotate 90 degree clockwise,[m[41m [m
[32m+[m[32mor L R U D F B to rotate counter-clockwise.[m
[32m+[m[32mPress 0 to switch between window and fullscreen.[m
[32m+[m[32mMouse Click and drag to adjust the viewing angle.[m
[32m+[m
[32m+[m[32m#----------Dependencies---------------[m
[32m+[m
[32m+[m[32mThe source code depends on:[m
[32m+[m[32m1. python 3.8.1[m
[32m+[m[32m2. Standard 64 bits OpenGL library.[m
[32m+[m[32m3. pygame 1.9.6[m
[32m+[m[32mOr follow the pygame&OpenGL setup instructions.[m
[32m+[m
[32m+[m[32m##==================Dev_History===========================[m
[32m+[m
[32m+[m[32mFeb 19th[m
[32m+[m[32mmain program complete.[m[41m [m
[32m+[m
[32m+[m[32m#Feb 18th[m
[32m+[m[32mPress r to rotate the R 90 degree. with animation.[m
[32m+[m[32m(basic strucure is 80% complete)[m
[32m+[m
[32m+[m[32m#Feb 17th[m
[32m+[m[32ma basic half rotation without animation[m
[32m+[m
[32m+[m[32m#Feb 16th[m
[32m+[m[32mthe whole structure of the cube is complete.[m[41m [m
[32m+[m[32mconsist of 26 individual cubies.[m
[32m+[m
[32m+[m[32m#Feb 9th[m
[32m+[m[32mcompleted the GLcubies.py, which output a colored rotating 3D cubie using OpenGL and Pygame library.[m
[32m+[m
[32m+[m[32m#Feb 2nd[m
[32m+[m[32mjust completed the quaternion.py. It's tested and shall be fine.[m
[32m+[m[32mmove on to the cubie part.[m
[32m+[m
[32m+[m
[32m+[m
[32m+[m
[1mdiff --git a/rubiks_cube_simulator/cubies.py b/rubiks_cube_simulator/cubies.py[m
[1mnew file mode 100644[m
[1mindex 0000000..2bb0c53[m
[1m--- /dev/null[m
[1m+++ b/rubiks_cube_simulator/cubies.py[m
[36m@@ -0,0 +1,106 @@[m
[32m+[m[32m#--------------------[m
[32m+[m[32m#The cubie class. Generate (26) cubie objects for 3D Graphical rendering[m
[32m+[m[32m#--------------------[m
[32m+[m[32mimport pygame[m
[32m+[m[32mimport math[m
[32m+[m[32mfrom pygame.locals import *[m
[32m+[m[32mfrom OpenGL.GL import *[m
[32m+[m[32mfrom OpenGL.GLU import *[m
[32m+[m
[32m+[m[32mEdgeLength_of_the_cubie=0.5[m
[32m+[m[32ml=EdgeLength_of_the_cubie/2[m
[32m+[m[32m#define vertices from D to U, F to B, L to R[m
[32m+[m[32mverticies_default=([m
[32m+[m[32m        (-l,-l,-l), (l,-l,-l),[m
[32m+[m[32m        (l,l,-l), (-l,l,-l),[m
[32m+[m[32m        (-l,-l,l), (l,-l,l),[m
[32m+[m[32m        (l,l,l), (-l,l,l),[m
[32m+[m[32m    )[m
[32m+[m[32mfaces_default_dict={[m
[32m+[m[32m        'D':(0,1,2,3), 'U':(4,5,6,7),[m
[32m+[m[32m        'F':(0,1,5,4), 'B':(3,2,6,7),[m
[32m+[m[32m        'L':(0,3,7,4), 'R':(1,2,6,5)[m
[32m+[m[32m    }[m
[32m+[m[32mcolors_dict={[m
[32m+[m[32m        'D':(1, 1, 0.8), 'U':(0.7, 1, 0.2),[m
[32m+[m[32m        'F':(0.2, 0.7, 0.2), 'B':(0.1, 0.3, 1),[m
[32m+[m[32m        'L':(0.7, 0.1, 0), 'R':(0.9, 0.5, 0)[m
[32m+[m[32m    }[m
[32m+[m[32medges_default=([m
[32m+[m[32m        (0,1), (0,3),[m
[32m+[m[32m        (0,4), (2,1),[m
[32m+[m[32m        (2,3), (2,6),[m
[32m+[m[32m        (5,1), (5,4),[m
[32m+[m[32m        (5,6), (7,3),[m
[32m+[m[32m        (7,4), (7,6)[m
[32m+[m[32m    )[m
[32m+[m[32m#---------------------[m
[32m+[m[32m#a=cubie("UFR") -> the UFR cubie object[m
[32m+[m[32m#-----------------------[m
[32m+[m[32mclass cubie:[m
[32m+[m[32m    def __init__(self,pos): #pos=a string, "UFR" or "F" or "DB" .etc, see wiki notation.[m
[32m+[m[32m        pos=str(pos)[m
[32m+[m[32m        color_of_the_faces_dict={}[m
[32m+[m[32m        defaultColor=(0.5,0.5,0.5)   #GL RGB gray[m
[32m+[m[32m        for face in faces_default_dict:[m[41m [m
[32m+[m[32m            #all faces default gray[m
[32m+[m[32m            color_of_the_faces_dict.update({face:defaultColor})[m
[32m+[m[32m        for outsideface in pos:[m
[32m+[m[32m            #paint cubies outside face[m
[32m+[m[32m            color_of_the_faces_dict.update({outsideface:colors_dict[outsideface]})[m
[32m+[m
[32m+[m[32m        #calculate one dimentional drift of, e.g. "U" "F" "R", then sum up[m
[32m+[m[32m        drift_cases={[m
[32m+[m[32m                'D':(0,0,-2*l), 'U':(0,0,2*l),[m
[32m+[m[32m                'F':(0,-2*l,0), 'B':(0,2*l,0),[m
[32m+[m[32m                'L':(-2*l,0,0), 'R':(2*l,0,0)[m
[32m+[m[32m                }[m
[32m+[m[32m        coordinates_drift=(0,0,0)   #initialize[m
[32m+[m[32m        for key in pos:[m
[32m+[m[32m            one_dimensional_drift=drift_cases.get(key)[m
[32m+[m[32m            coordinates_drift=list(map(sum,zip(coordinates_drift, one_dimensional_drift)))[m
[32m+[m[32m        verticies_cubie=list(verticies_default)[m
[32m+[m[32m        for i in range(len(verticies_cubie)):[m
[32m+[m[32m            verticies_cubie[i]=list(map(sum,zip(verticies_cubie[i],coordinates_drift)))[m
[32m+[m
[32m+[m[32m        self.faces_dict=faces_default_dict[m
[32m+[m[32m        self.faces_color_dict=color_of_the_faces_dict[m
[32m+[m[32m        self.center_coordinates_list=coordinates_drift[m
[32m+[m[32m        self.verticies_coordinateslist_list=list(verticies_cubie)[m
[32m+[m[32m        self.edges_tuple=edges_default[m
[32m+[m[32m#------------------------[m
[32m+[m[32m#generate the cubies (now in main.py)[m
[32m+[m[32m#------------------------[m
[32m+[m[32m#def cubies_generate():[m
[32m+[m[32m#    l=([m
[32m+[m[32m#        "DFL", "DF", "DFR",[m
[32m+[m[32m#        "FL", "F", "FR",[m
[32m+[m[32m#        "UFL", "UF", "UFR",[m
[32m+[m[32m#        "DR", "R", "UR",[m
[32m+[m[32m#        "DRB", "RB", "URB",[m
[32m+[m[32m#        "DL", "L", "UL",[m
[32m+[m[32m#        "DLB", "LB", "ULB",[m
[32m+[m[32m#        "DB", "B", "UB",[m
[32m+[m[32m#        "D", "U"[m
[32m+[m[32m#        )[m
[32m+[m[32m#    cubies26_dict={}[m
[32m+[m[32m#    for i in range(len(l)):[m
[32m+[m[32m#        cubie_key=str(l[i])[m
[32m+[m[32m#        cubie_attr_value=cubie(cubie_key) #an obj in the cubie class[m
[32m+[m[32m#        cubies26_dict.update({cubie_key:cubie_attr_value})[m
[32m+[m[32m#    return cubies26_dict[m
[32m+[m[32m#[m
[32m+[m[32m#cubies26_dict=cubies_generate()[m
[32m+[m[32m#[m
[32m+[m[32m#Sample Output:[m
[32m+[m[32m#t=cubies26_dict[m
[32m+[m[32m#>>> t['DFL'].verticies_coordinateslist_tuple[m
[32m+[m[32m#([-1.5, -1.5, -1.5], [-0.5, -1.5, -1.5], [-0.5, -0.5, -1.5], [-1.5, -0.5, -1.5], [-1.5, -1.5, -0.5], [-0.5, -1.5, -0.5], [-0.5, -0.5, -0.5], [-1.5, -0.5, -0.5])[m
[32m+[m[32m#>>> t['DFL'].edges_tuple[m
[32m+[m[32m#((0, 1), (0, 3), (0, 4), (2, 1), (2, 3), (2, 6), (5, 1), (5, 4), (5, 6), (7, 3), (7, 4), (7, 6))[m
[32m+[m[32m#>>> t['DFL'].faces_dict[m
[32m+[m[32m#{'D': (0, 1, 2, 3), 'U': (4, 5, 6, 7), 'F': (0, 1, 5, 4), 'B': (3, 2, 6, 7), 'L': (0, 3, 7, 4), 'R': (1, 2, 6, 5)}[m
[32m+[m[32m#>>> t['DFL'].faces_color_dict[m
[32m+[m[32m#{'D': (1, 0, 0), 'U': (0.5, 0.5, 0.5), 'F': (0, 0, 1), 'B': (0.5, 0.5, 0.5), 'L': (1, 0, 1), 'R': (0.5, 0.5, 0.5)}[m
[32m+[m[32m#>>> t['DFL'].center_coordinates_list[m
[32m+[m[32m#[-1.0, -1.0, -1.0][m
[1mdiff --git a/rubiks_cube_simulator/devnote.txt b/rubiks_cube_simulator/devnote.txt[m
[1mnew file mode 100644[m
[1mindex 0000000..5dd7a33[m
[1m--- /dev/null[m
[1m+++ b/rubiks_cube_simulator/devnote.txt[m
[36m@@ -0,0 +1,131 @@[m
[32m+[m[32mObject: a rubik cube simulator & solver.[m
[32m+[m[32m    Sub-Obj01: simulater itself.[m
[32m+[m
[32m+[m[32mSub-Project: 3D rotation simulator:{[m
[32m+[m[32m    To represent the Rotation of a cubie:{[m
[32m+[m[32m        1.Rotation Matrix[m[41m [m
[32m+[m[32m            problem: Gimbal lock[m
[32m+[m[32m        2.Euler Rotation theorem -> Quaternion -> Hamilton product[m
[32m+[m[32m    Hence use the Quaternion.[m
[32m+[m[32m    }[m
[32m+[m[32m    Quaternion 2D case:{[m
[32m+[m[32m        Vector 4+2i rotate counterclockwise 90 degree gives Vector (4+2i)*i = -2+4i[m
[32m+[m[32m    }[m
[32m+[m[32m    3D case:{[m
[32m+[m[32m        cubie UFR, R 90 degree clockwise[m
[32m+[m[41m        [m
[32m+[m[32m        1. Assign the central point of each cubie a  (ai, bj, ck) coordinate "p" relative to the center of the Rubik's cube.[m
[32m+[m[32m        2. the result, f(ai,bj,ck), can be calculated. using f(p)=qpq^-1, where q=cos(RotationAngleCounterclockwise/2)+sin(RotationAngleCounterclockwise/2)*(axis's unit quaternion)[m
[32m+[m[32m        where the axis's unit quaternion= axis's (aai,abj,ack) coordinate/sqrt(aa^2+ab^2+ac^2)[m[41m  [m
[32m+[m[32m    }[m
[32m+[m[32m}[m
[32m+[m
[32m+[m[32mQuaternion, Rotation Calculator:{[m
[32m+[m[32m    Set Coordinate Origin, the center piece. Set Axis x i(Center to Right) , y j(Center to Back), z k(Center to Up)[m
[32m+[m[32m    Let the Edge Length of each cubie be 1. -> the whole cube is 3x3x3[m[41m [m
[32m+[m[32m    Center (0,0,0)[m[41m [m
[32m+[m[32m    Center of the cubie UFR (1, -1, 1)[m
[32m+[m[32m    Center of the UBR (1, 1, 1)[m
[32m+[m[41m    [m
[32m+[m[32m    Use R to rotate UFR to UBR.[m
[32m+[m[32m    Let f(p)=qpq^-1, Hence Let F_R=q, where theta=45 degree, which is pi/4 since the python&c calculation use radians[m
[32m+[m[32m    pi=math.pi[m
[32m+[m[32m    cos=math.cos()[m
[32m+[m[32m    sin=math.sin()[m
[32m+[m[41m    [m
[32m+[m[32m    The Rotation function f(degree_of_rotation_in_radians, ){[m
[32m+[m[32m    #Clockwise is Negative[m
[32m+[m[32m    theta=degree_of_rotation_in_radians/2[m
[32m+[m
[32m+[m[32m    #Working on Rotation Matrix[m
[32m+[m[32m    #the Matrix{[m
[32m+[m[32m    #    2D: (x, yi) rotate t degree to -> (X, Yi)[m
[32m+[m[32m    #        let v = [x][m
[32m+[m[32m    #                [y][m
[32m+[m[32m    #        Matrix M x v = [X][m
[32m+[m[32m    #                       [Y][m
[32m+[m[32m    #    3D: p_new= M x p_old[m[41m [m
[32m+[m[32m    #}[m
[32m+[m[41m    [m
[32m+[m[32m    #p_new=q*p_old*q^-1 where q= q_r + q_i i + q_j j + q_k k and q_r = cos(theta),[m[41m [m
[32m+[m[32m    #q_i, q_j, q_k[m[41m [m
[32m+[m[32m    given an rotation axis vector RA(ra_i, ra_j, ra_k)[m
[32m+[m[32m    #As the (ra_i, ra_j, ra_k) represent a normalized rotation axis with a length of 1 (on a sphere), hence sum(ra_(i,j,k) ^2) = 1[m[41m [m
[32m+[m[32m    q_r=cos(theta)[m
[32m+[m[32m    q_i=sin(theta)*ra_i[m
[32m+[m[32m    q_j=sin(theta)*ra_j[m
[32m+[m[32m    q_k=sin(theta)*ra_k[m
[32m+[m
[32m+[m[32m    Then define a "complex.__multiply__" method. which process q1 x q2, return a 4 dimentional vector, following rule that i^2=j^2=k^2=ijk=-1, where ijk is non-commuting, which means to process (ij)k=k*k=-1, ij=k, jk=i, ki=j. Where i x j means rotate j by i. Hence a point (0, 1, 0) after rotate 90 degree around axis i, ends up at (0, 0, 1), in the case of a 4D hypersphere. Hence j x i is rotate i by j. where in the 4D case, i ended up at -k. Hence ji=-k. Same as kj=-i, ik=-j. As long as the sign is normalized. And what i^2=-1 means the projection of the "1" point from the 4D space to our 3D axis, is always our (0,0,0) point (Consider the 2D circle going through (1,0) (0,i) (-1,0) (0,-i) project to a 1D line, i^2=-1 defines a counterclockwise movement in 2D, or a group in 1D [1(the 0),i,infinity,-i][m[41m [m
[32m+[m
[32m+[m[32m}[m
[32m+[m
[32m+[m
[32m+[m
[32m+[m
[32m+[m
[32m+[m[32m#the cubies[m
[32m+[m[32m    cubies could be constructed using corner pieces. UFR has 7 and UF has 6, while the middle cubie in the F has 4 and center has 0.[m
[32m+[m[32m    or could be constructed giving it's center coordinate. then constructed using 6 faces around it. U D F B R L.[m
[32m+[m
[32m+[m[32m    Anyway cubies will be in 1 class.[m
[32m+[m
[32m+[m[32m    A 3x3 cube has 7 corner cubies, 12 edge cubies, and 6 center cubies. and 1 hidden middle core.[m[41m [m
[32m+[m[32m    these are cube's concern.[m
[32m+[m
[32m+[m[32m    the none hexahedron cube shall be out of our concern here.[m
[32m+[m[32m    now I just want to expend this simulator to any hexahedron ones. i.e., 3x3x4, 3x3x6, 6x6x6 .etc, but each face shall be a square![m
[32m+[m
[32m+[m[32m    in order to render the cubies, an API or lib would be handy or write on our own is also an option.[m
[32m+[m[32m    bpy in blender.[m[41m [m
[32m+[m[32m    or OpenGL?![m
[32m+[m[32m        pygame[m
[32m+[m[32m        OpenGL.GL[m
[32m+[m
[32m+[m[32m    cubies shall have attributes as follows:[m
[32m+[m[32m        1. cubies.center    center coordinate relative to the very center of the cube 0,0,0.[m
[32m+[m[32m        2. cubies.{U,D,F,B,L,R}[m[41m        [m
[32m+[m	[32m3. 8 vertices[m
[32m+[m	[32m4. 12 edges & 6 faces defined using vertices[m
[32m+[m
[32m+[m[32m--------------------[m
[32m+[m[32m    Other options:[m
[32m+[m[32m    GNUplot[m
[32m+[m[32m    VPython[m
[32m+[m
[32m+[m[32m    Tkinter[m
[32m+[m
[32m+[m[32m    But maybe just OpenGL.[m[41m [m
[32m+[m
[32m+[m[32m    GLUT[m
[32m+[m
[32m+[m[32m    1. Read the article[m
[32m+[m[32m    2. Use the function to define the center coordination.[m[41m [m
[32m+[m[32m        glTranslated (the center coordinate) -> cuber location[m[41m [m
[32m+[m[32m        glRotate -> rotate once -> save the result for next rotate (check implementation)[m
[32m+[m[32m        #calculate the (curve) of A Rotate. computer the  curve in case "frenquent update"[m
[32m+[m
[32m+[m[32m--------------------[m
[32m+[m[32m    Feb 9th, how to order/render the multiple cubies efficiently.[m
[32m+[m[32m    List the attributes of the cubies:[m
[32m+[m[32m        1. vertices absolute coordinates are shifted by a integer value.[m
[32m+[m[32m        2. surface color are fixed.[m[41m [m
[32m+[m[32m        3. the most simple way shall be making a class of cubies.[m
[32m+[m[32m            so that each face in each cubies may have an UDFBLRI(inside) attribute that can later be used to mark the color.[m
[32m+[m[32m                1. use python to generate the dataset, corespond to the nxn rubik's cube.[m[41m [m
[32m+[m[32m                2. cube data include the verticies, edge and faces, where edge data is the same.[m
[32m+[m[32m                3. initial verticies = original matrix plus or minus a constant.[m
[32m+[m[32m                4. note that qt and OpenGL cooridnate axises are different. OpenGL z points towards the camera.or in other words, the qt's ijk axis rotate cc 90 around the i axis.[m
[32m+[m[41m    [m
[32m+[m[32m-----------------------[m
[32m+[m[32m    Feb 16th. cubie frame is complete.[m
[32m+[m[32m    How to implement the Rotation in OpenGL[m
[32m+[m[32m        1. a simple way is to update the cubies26_dict.[m[41m [m
[32m+[m[32m            e.g. for rotation 'R', Select from cubies26_dict where key include R, apply transform on its verticies_coordinateslist_tuple, then render again[m
[32m+[m[32m        2. a more smoother way is to (use a qt transform matrix?), degree from 1 to 90. plot 90 times.?[m
[32m+[m[41m         [m
[32m+[m
[32m+[m[32m-------------------------[m
[32m+[m[32mFeb 18th night[m
[32m+[m[32mAll problem has been sort out.[m
[32m+[m[32mShall see the project complete tomorrow.[m
[1mdiff --git a/rubiks_cube_simulator/global_variables.py b/rubiks_cube_simulator/global_variables.py[m
[1mnew file mode 100644[m
[1mindex 0000000..8546f34[m
[1m--- /dev/null[m
[1m+++ b/rubiks_cube_simulator/global_variables.py[m
[36m@@ -0,0 +1,107 @@[m
[32m+[m[32mfrom cubies import *[m
[32m+[m[32mimport math[m
[32m+[m[32m#----plus or minus----[m
[32m+[m[32msign = lambda x: math.copysign(1, x)[m
[32m+[m[32m#----it will be used in permutation, so the order matters----[m
[32m+[m[32mall_cubies=([m
[32m+[m[32m    "FLU", "FU", "FUR",[m
[32m+[m[32m    "FL", "F", "FR",[m
[32m+[m[32m    "FLD", "FD", "FRD",[m
[32m+[m[32m    "RU", "RUB", "R",[m
[32m+[m[32m    "RB", "RD", "RBD",[m
[32m+[m[32m    "UB", "UBL", "B",[m
[32m+[m[32m    "BL", "BD", "BLD",[m
[32m+[m[32m    "LU", "L", "LD",[m
[32m+[m[32m    "U", "D"[m
[32m+[m[32m    )[m
[32m+[m[32m#-------------------------[m
[32m+[m[32m##generate_cubies(to draw)_dict[m
[32m+[m[32mdef cubies_dict_generate(cubies=all_cubies):[m
[32m+[m[32m    l=cubies[m
[32m+[m[32m    if len(cubies)==0:[m
[32m+[m[32m        cubies_dict={}[m
[32m+[m[32m        return cubies_dict[m
[32m+[m[32m    cubies_dict={}[m
[32m+[m[32m    for i in range(len(l)):[m
[32m+[m[32m        cubie_key=str(l[i])[m
[32m+[m[32m        cubie_attr_value=cubie(cubie_key) #an obj in the cubie class[m
[32m+[m[32m        cubies_dict.update({cubie_key:cubie_attr_value})[m
[32m+[m[32m    return cubies_dict[m
[32m+[m[32mcubies_currentstate_dict=cubies_dict_generate(all_cubies)[m
[32m+[m[32mstate_dict_stack=[][m
[32m+[m[32mtotal_transition_steps=int(0)[m
[32m+[m
[32m+[m[32m#--------the original mapping--------[m
[32m+[m[32m#(F)ront_face:[m[41m   [m
[32m+[m[32m#    [0:FLU, 1:FU, 2:FUR][m
[32m+[m[32m#    [3:FL, 4:F, 5:FR][m
[32m+[m[32m#    [6:FLD, 7:FD, 8:FRD][m
[32m+[m[32m#(R)ight_face:[m
[32m+[m[32m#    [2, 9:RU, 10:RUB][m
[32m+[m[32m#    [5, 11:R, 12:RB][m
[32m+[m[32m#    [8, 13:RD, 14:RBD][m
[32m+[m[32m#(B)ack_face:[m
[32m+[m[32m#    [10, 15:UB, 16:UBL][m
[32m+[m[32m#    [12, 17:B, 18:BL][m
[32m+[m[32m#    [14, 19:BD, 20:BLD][m
[32m+[m[32m#(L)eft_face:[m
[32m+[m[32m#    [16, 21:LU, 0][m
[32m+[m[32m#    [18, 22:L, 3][m
[32m+[m[32m#    [20, 23:LD, 6][m
[32m+[m[32m#(U)pper_face:[m
[32m+[m[32m#    [16, 15, 10][m
[32m+[m[32m#    [21, 24:U, 9][m
[32m+[m[32m#    [0, 1, 2][m
[32m+[m[32m#(D)own_face:[m
[32m+[m[32m#    [6, 7, 8][m
[32m+[m[32m#    [23, 25:D, 13][m
[32m+[m[32m#    [20, 19, 14][m
[32m+[m[32m#--------------------------------[m
[32m+[m[32m#the initial mapping_dict={0:FUL, 1:FU, 2:FUR, 3:..., 25:D}, where {position_ID:cubie_ID}[m
[32m+[m[32mcurrent_location_permutation_mapping_dict=dict(zip(list(range(26)),all_cubies))[m
[32m+[m
[32m+[m[32m##generate the new partial dict for updating[m
[32m+[m[32m##the result shall be part of the permutation_mapping_dict. {position_ID:cubie_ID,...}, e.g. {0:"UFR"}[m
[32m+[m[32mdef generate_new_cyclic_permutation_mapping_dict_partial(rotation_face, clockwise_rotation_degree, mapping_dict):[m
[32m+[m[32m    #----6x2 permutation tuple dict----[m
[32m+[m[32m    permutation_dict={[m
[32m+[m[32m        'F':((0, 2, 8, 6), (1, 5, 7, 3)),[m
[32m+[m[32m        'R':((2, 10, 14, 8), (9, 12, 13, 5)),[m
[32m+[m[32m        'B':((10, 16, 20, 14), (15, 18, 19, 12)),[m
[32m+[m[32m        'L':((16, 0, 6, 20), (21, 3, 23, 18)),[m
[32m+[m[32m        'U':((16, 10, 2, 0), (15, 9, 1, 21)),[m
[32m+[m[32m        'D':((6, 8, 14, 20), (7, 13, 19, 23))[m
[32m+[m[32m    }[m
[32m+[m[32m    #-----------------------------[m
[32m+[m[32m    total_permutation_needed=int(round(clockwise_rotation_degree/90))[m
[32m+[m[32m    new_dict_partial={}[m
[32m+[m[32m    t=permutation_dict[rotation_face][m
[32m+[m[32m    for l in t: #e.g. l=(0, 2, 8, 6) then (1, 5, 7, 3)[m[41m [m
[32m+[m[32m        for i in range(len(l)):[m
[32m+[m[32m            #----j is the range(3) in l----[m
[32m+[m[32m            j=i-total_permutation_needed[m
[32m+[m[32m            while j > 3:[m
[32m+[m[32m                j=j-4[m
[32m+[m[32m            while j < 0:[m
[32m+[m[32m                j=j+4[m
[32m+[m[32m            #-----------------------------[m
[32m+[m[32m            the_slot=l[i][m
[32m+[m[32m            new_cubiesID_in_the_slot_key=l[j][m
[32m+[m[32m            new_dict_partial.update({the_slot:mapping_dict[new_cubiesID_in_the_slot_key]})[m
[32m+[m[32m#    global current_location_permutation_mapping_dict[m
[32m+[m[32m#    print("parts before rotation:", current_location_permutation_mapping_dict.items(), "\n parts to be updated:", new_dict_partial.items())[m
[32m+[m[32m    return new_dict_partial[m
[32m+[m
[32m+[m
[32m+[m
[32m+[m
[32m+[m
[32m+[m
[32m+[m
[32m+[m
[32m+[m
[32m+[m
[32m+[m
[32m+[m
[32m+[m
[32m+[m
[1mdiff --git a/rubiks_cube_simulator/main.py b/rubiks_cube_simulator/main.py[m
[1mnew file mode 100644[m
[1mindex 0000000..f94d612[m
[1m--- /dev/null[m
[1m+++ b/rubiks_cube_simulator/main.py[m
[36m@@ -0,0 +1,204 @@[m
[32m+[m[32mimport math[m
[32m+[m[32mimport pygame[m
[32m+[m[32mfrom pygame.locals import *[m
[32m+[m[32mfrom OpenGL.GL import *[m
[32m+[m[32mfrom OpenGL.GLU import *[m
[32m+[m
[32m+[m[32mfrom cubies import *[m
[32m+[m[32mimport quarternion[m
[32m+[m[32mimport global_variables as g[m
[32m+[m
[32m+[m[32m#----draw_cubies----[m
[32m+[m[32m#e.g. draw_cubie('DFL'), it process the cubies26_dict to OpenGL parameters[m[41m [m
[32m+[m[32mdef draw_cubies(cubies_dict):[m
[32m+[m[32m    for key in cubies_dict:[m
[32m+[m[32m        cubie_obj=cubies_dict[key][m
[32m+[m[32m        glBegin(GL_QUADS)[m
[32m+[m[32m        for face_key in cubie_obj.faces_dict:[m
[32m+[m[32m            face=cubie_obj.faces_dict[face_key] #e.g. (0,1,2,3)[m
[32m+[m[32m            color=cubie_obj.faces_color_dict[face_key] #e.g. (1,0,0)[m
[32m+[m[32m            glColor3fv(color)[m
[32m+[m[32m            for vertex_index in face:[m
[32m+[m[32m                glVertex3fv(cubie_obj.verticies_coordinateslist_list[vertex_index])[m
[32m+[m[32m        glEnd()[m
[32m+[m[32m        glBegin(GL_LINES)[m
[32m+[m[32m        for edge in cubie_obj.edges_tuple:[m
[32m+[m[32m            for vertex_index in edge:[m
[32m+[m[32m                glColor3f(0,0,0) #black[m
[32m+[m[32m                glVertex3fv(cubie_obj.verticies_coordinateslist_list[vertex_index])[m
[32m+[m[32m        glEnd()[m
[32m+[m[32m    return[m
[32m+[m[32m#----select_cubies(the 9 cubies to rotate, from the total 26 cubies)----[m
[32m+[m[32m#----use the mapping_dict {1:'UFR', 2:... 25:'D'} to perform the select----------[m
[32m+[m[32m#----return 9 cubie_IDs ['UFR', 'R', ...]----[m
[32m+[m[32mdef select_cubies([m
[32m+[m[32m        key, mapping_dict = g.current_location_permutation_mapping_dict[m
[32m+[m[32m        ):[m
[32m+[m[32m    key = str(key) #e.g. 'U'[m
[32m+[m[32m    cubies_selected = [][m
[32m+[m[32m    cubies_leftovered = [][m
[32m+[m[32m    ##---loop 26 times, the index represents 26 possible positions on the cube---[m
[32m+[m[32m    for position_index in mapping_dict:[m[41m [m
[32m+[m[32m        cubie_ID=mapping_dict[position_index][m
[32m+[m[32m        ##---use g.all_cubies[position_index] to find which "position_indexes" belong to which "face"---[m
[32m+[m[32m        if key in g.all_cubies[position_index]:[m[41m [m
[32m+[m[32m            cubies_selected.append(cubie_ID)[m
[32m+[m[32m        else:[m
[32m+[m[32m            cubies_leftovered.append(cubie_ID)[m
[32m+[m[32m    return cubies_selected, cubies_leftovered[m
[32m+[m
[32m+[m[32m#----rotate: animation&coordinate_calculation----[m
[32m+[m[32mdef rotate(rotation_face, clockwise_rotation_degree, total_transition_steps):[m
[32m+[m[32m    #push status to stack. size depends on the step, should be optimized----[m
[32m+[m[32m    g.state_dict_stack.append(g.cubies_currentstate_dict)[m
[32m+[m[32m    #---------------------------------------------[m
[32m+[m[32m    rotation_face = str(rotation_face)[m
[32m+[m[32m    cubies_selected, cubies_leftovered = select_cubies(rotation_face)[m
[32m+[m[32m    total_transition_steps = float(total_transition_steps)[m
[32m+[m[32m    cc_rotation_degree = -float(clockwise_rotation_degree)/total_transition_steps[m
[32m+[m[32m    #----rotation_axis_ijk follows math's convention instead of OpenGL's. k axis points upwards----[m
[32m+[m[32m    if rotation_face == "R":[m
[32m+[m[32m        rotation_axis_ijk = (1, 0, 0)[m
[32m+[m[32m    elif rotation_face == "L":[m
[32m+[m[32m        rotation_axis_ijk = (-1, 0, 0)[m
[32m+[m[32m    elif rotation_face == "U":[m
[32m+[m[32m        rotation_axis_ijk = (0, 0, 1)[m
[32m+[m[32m    elif rotation_face == "D":[m
[32m+[m[32m        rotation_axis_ijk = (0, 0, -1)[m
[32m+[m[32m    elif rotation_face == "F":[m
[32m+[m[32m        rotation_axis_ijk = (0, -1, 0)[m
[32m+[m[32m    elif rotation_face == "B":[m
[32m+[m[32m        rotation_axis_ijk = (0, 1, 0)[m
[32m+[m[32m    ##----calculate next coordinates using quarternion----[m
[32m+[m[32m    ##----Can be Optimized using a middle point and 8 calculations----[m
[32m+[m[32m    for cubie in cubies_selected:[m
[32m+[m[32m        t = g.cubies_currentstate_dict[cubie].verticies_coordinateslist_list[m
[32m+[m[32m        for i in range(len(t)): #e.g. [-1.5, -1.5, -1.5]=t[i][m
[32m+[m[32m            p_new = quarternion.qtcal(cc_rotation_degree, rotation_axis_ijk[0], rotation_axis_ijk[1], rotation_axis_ijk[2], t[i][0], t[i][1], t[i][2]) #e.g. p_new=[1,0,1][m
[32m+[m[32m            g.cubies_currentstate_dict[cubie].verticies_coordinateslist_list[i]=p_new[m
[32m+[m[32m    return[m
[32m+[m[32m#----py_game&OpenGL_init----[m
[32m+[m[32mdef init_gl_stuff(display):[m
[32m+[m[32m    glEnable(GL_DEPTH_TEST)        #use pygame zbuffer[m
[32m+[m
[32m+[m[32m    aspect_ratio=display[0]/display[1][m
[32m+[m[32m    field_of_view_Angle=60[m
[32m+[m[32m    zNear=0.1[m
[32m+[m[32m    zFar=100[m
[32m+[m[32m    glMatrixMode(GL_PROJECTION)[m
[32m+[m[32m    glLoadIdentity()[m
[32m+[m[32m    gluPerspective(field_of_view_Angle, aspect_ratio,zNear,zFar)[m
[32m+[m
[32m+[m[32m#----main----[m
[32m+[m[32mdef main():[m
[32m+[m[32m    transitioning = False[m
[32m+[m[32m    total_transition_steps = 4[m[41m [m
[32m+[m[32m    #--------------------------[m
[32m+[m[32m    pygame.init()[m
[32m+[m[32m    display = (1080,720)[m
[32m+[m[32m    displayCenter = [display[0]/2, display[1]/2][m
[32m+[m[32m    isfullscreen = False[m
[32m+[m[32m    pygame.display.set_mode(display, DOUBLEBUF|OPENGL)[m
[32m+[m[32m    init_gl_stuff(display)[m
[32m+[m[32m    #------init&configure camera, tweak the camera location using mouse later.----[m[41m [m
[32m+[m[32m    #------Use the OpenGL xyz axises here.----------------------[m
[32m+[m[32m    #------Wanted to use gluLookAt to implement 3rd person perspective but it seems buggy, i.e. idk how to adjust the camera inside the while loop down below. But it is more of a library thing, so I decided to use glRotatef for now(in the mouse section).[m
[32m+[m[32m    camera_x, camera_y, camera_z = 0, -4, 2[m
[32m+[m[32m    gluLookAt(camera_x, camera_y, camera_z, 0,0,0, 0,0,1)[m
[32m+[m[32m    glRotatef(-15, 0, 0, 1)[m
[32m+[m[32m    while True:[m
[32m+[m[32m        if transitioning:[m
[32m+[m[32m            if rotation_remain > 0:[m
[32m+[m[32m                rotate(rotation_face, clockwise_rotation_degree, total_transition_steps)[m
[32m+[m[32m                rotation_remain -= 1[m
[32m+[m[32m            else:[m
[32m+[m[32m                print("Rotated ", rotation_face, clockwise_rotation_degree, "degree clockwise." )[m
[32m+[m[32m                new_dict_partial = g.generate_new_cyclic_permutation_mapping_dict_partial(rotation_face, clockwise_rotation_degree, g.current_location_permutation_mapping_dict)[m
[32m+[m[32m                transitioning = False[m
[32m+[m[32m                g.current_location_permutation_mapping_dict.update(new_dict_partial)[m
[32m+[m
[32m+[m[32m        #clear screen and move camera[m
[32m+[m[32m        glClear(GL_COLOR_BUFFER_BIT|GL_DEPTH_BUFFER_BIT)[m
[32m+[m[32m        draw_cubies(g.cubies_currentstate_dict)[m
[32m+[m[32m        mouseMove = pygame.mouse.get_rel()[m
[32m+[m
[32m+[m[32m        if not transitioning:[m
[32m+[m[32m            rotation_remain = total_transition_steps[m
[32m+[m[32m            for event in pygame.event.get():[m
[32m+[m[32m                if event.type == pygame.QUIT:[m
[32m+[m[32m                    pygame.quit()[m
[32m+[m[32m                    quit()[m
[32m+[m[32m                ##----mouse_click->view adjustion----[m
[32m+[m[32m                elif pygame.mouse.get_pressed()[0]:[m
[32m+[m[32m                    #mousePos = pygame.mouse.get_pos()[m
[32m+[m[32m                    #delta = [mousePos[0]-displayCenter[0], mousePos[1]-displayCenter[1]][m
[32m+[m[32m                    mouseMove = pygame.mouse.get_rel()[m
[32m+[m[32m                    glRotatef(mouseMove[0]*0.1, 0,0,1)[m
[32m+[m[32m                    glRotatef(mouseMove[1]*0.1, 1,0,0)[m
[32m+[m[32m                ##-----------------------------------[m[41m    [m
[32m+[m[32m                elif event.type == KEYDOWN:[m
[32m+[m[32m                    if event.key == pygame.K_0:[m
[32m+[m[32m                        if isfullscreen == False:[m
[32m+[m[32m                            print("Changing to FULLSCREEN")[m
[32m+[m[32m                            pygame.display.set_mode(display, OPENGL | DOUBLEBUF | FULLSCREEN)[m
[32m+[m[32m                            displayCenter = [display[0]/2, display[1]/2][m
[32m+[m[32m                            isfullscreen = True[m
[32m+[m[32m                        else:[m
[32m+[m[32m                            print("Changing to windowed mode")[m
[32m+[m[32m                            pygame.display.set_mode(display, OPENGL | DOUBLEBUF)[m
[32m+[m[32m                            displayCenter = [display[0]/2, display[1]/2][m
[32m+[m[32m                            isfullscreen = False[m
[32m+[m[32m                        init_gl_stuff(display)[m
[32m+[m[32m                    ##----press shift+r for R', r for R----[m
[32m+[m[32m                    if event.key == pygame.K_r:[m
[32m+[m[32m                        rotation_face = "R"[m
[32m+[m[32m                        if event.mod & pygame.KMOD_SHIFT:[m
[32m+[m[32m                            clockwise_rotation_degree = -90[m
[32m+[m[32m                            transitioning = True[m
[32m+[m[32m                        else:[m
[32m+[m[32m                            clockwise_rotation_degree = 90[m
[32m+[m[32m                            transitioning = True[m
[32m+[m[32m                    elif event.key == pygame.K_l:[m
[32m+[m[32m                        rotation_face = "L"[m
[32m+[m[32m                        if event.mod & pygame.KMOD_SHIFT:[m
[32m+[m[32m                            clockwise_rotation_degree = -90[m
[32m+[m[32m                            transitioning = True[m
[32m+[m[32m                        else:[m
[32m+[m[32m                            clockwise_rotation_degree = 90[m
[32m+[m[32m                            transitioning = True[m
[32m+[m[32m                    elif event.key == pygame.K_u:[m
[32m+[m[32m                        rotation_face = "U"[m
[32m+[m[32m                        if event.mod & pygame.KMOD_SHIFT:[m
[32m+[m[32m                            clockwise_rotation_degree = -90[m
[32m+[m[32m                            transitioning = True[m
[32m+[m[32m                        else:[m
[32m+[m[32m                            clockwise_rotation_degree = 90[m
[32m+[m[32m                            transitioning = True[m
[32m+[m[32m                    elif event.key == pygame.K_d:[m
[32m+[m[32m                        rotation_face = "D"[m
[32m+[m[32m                        if event.mod & pygame.KMOD_SHIFT:[m
[32m+[m[32m                            clockwise_rotation_degree = -90[m
[32m+[m[32m                            transitioning = True[m
[32m+[m[32m                        else:[m
[32m+[m[32m                            clockwise_rotation_degree = 90[m
[32m+[m[32m                            transitioning = True[m
[32m+[m[32m                    elif event.key == pygame.K_f:[m
[32m+[m[32m                        rotation_face = "F"[m
[32m+[m[32m                        if event.mod & pygame.KMOD_SHIFT:[m
[32m+[m[32m                            clockwise_rotation_degree = -90[m
[32m+[m[32m                            transitioning = True[m
[32m+[m[32m                        else:[m
[32m+[m[32m                            clockwise_rotation_degree = 90[m
[32m+[m[32m                            transitioning = True[m
[32m+[m[32m                    elif event.key == pygame.K_b:[m
[32m+[m[32m                        rotation_face = "B"[m
[32m+[m[32m                        if event.mod & pygame.KMOD_SHIFT:[m
[32m+[m[32m                            clockwise_rotation_degree = -90[m
[32m+[m[32m                            transitioning = True[m
[32m+[m[32m                        else:[m
[32m+[m[32m                            clockwise_rotation_degree = 90[m
[32m+[m[32m                            transitioning = True[m
[32m+[m[32m        #------[m
[32m+[m[32m        pygame.display.flip()[m
[32m+[m[32m        pygame.time.wait(10)[m
[32m+[m[32mmain()[m
[1mdiff --git a/rubiks_cube_simulator/misc/GLcubies.py b/rubiks_cube_simulator/misc/GLcubies.py[m
[1mnew file mode 100644[m
[1mindex 0000000..f7d7825[m
[1m--- /dev/null[m
[1m+++ b/rubiks_cube_simulator/misc/GLcubies.py[m
[36m@@ -0,0 +1,100 @@[m
[32m+[m[32m#Partially referended/modiedfied from the pygames's example code and OpenGL example code.[m[41m [m
[32m+[m[32mimport pygame[m
[32m+[m[32mimport math[m
[32m+[m[32mfrom pygame.locals import *[m
[32m+[m[32mfrom OpenGL.GL import *[m
[32m+[m[32mfrom OpenGL.GLU import *[m
[32m+[m
[32m+[m[32mEdgeLength_of_the_Regular_Hexahedron=1[m[41m [m
[32m+[m[32ml=EdgeLength_of_the_Regular_Hexahedron/2[m
[32m+[m[32m#define vertices from D to U, F to B, L to R[m
[32m+[m[32mverticies=([m
[32m+[m[32m        (-l,-l,-l), (l,-l,-l),[m
[32m+[m[32m        (l,l,-l), (-l,l,-l),[m
[32m+[m[32m        (-l,-l,l), (l,-l,l),[m
[32m+[m[32m        (l,l,l), (-l,l,l),[m
[32m+[m[32m    )[m
[32m+[m[32medges=([m
[32m+[m[32m        (0,1), (0,3),[m
[32m+[m[32m        (0,4), (2,1),[m
[32m+[m[32m        (2,3), (2,6),[m
[32m+[m[32m        (5,1), (5,4),[m
[32m+[m[32m        (5,6), (7,3),[m
[32m+[m[32m        (7,4), (7,6)[m
[32m+[m[32m    )[m
[32m+[m[32m##D U F B L R[m
[32m+[m[32mfaces=([m
[32m+[m[32m        (0,1,2,3), (4,5,6,7),[m
[32m+[m[32m        (0,1,5,4), (3,2,6,7),[m
[32m+[m[32m        (0,3,7,4), (1,2,6,5)[m
[32m+[m[32m    )[m
[32m+[m[32mcolors=([m
[32m+[m[32m        (1,0,0), (0,1,0),[m
[32m+[m[32m        (0,0,1), (1,1,0),[m
[32m+[m[32m        (1,0,1), (0,1,1)[m
[32m+[m[32m    )[m
[32m+[m
[32m+[m[32mdef cubies():[m
[32m+[m[32m    glBegin(GL_QUADS)[m
[32m+[m[32m    faces_and_colors=list(zip(faces, colors))[m
[32m+[m[32m    for face_and_color in faces_and_colors:[m
[32m+[m[32m        color=face_and_color[1][m
[32m+[m[32m        face=face_and_color[0][m
[32m+[m[32m        glColor3fv(color)[m
[32m+[m[32m        for vertex_index in face:[m
[32m+[m[32m            glVertex3fv(verticies[vertex_index])[m
[32m+[m[32m    glEnd()[m
[32m+[m[32m    glBegin(GL_LINES)[m
[32m+[m[32m    for edge in edges:[m
[32m+[m[32m        for vertex_index in edge:[m
[32m+[m[32m            glColor3f(0,0,0)[m
[32m+[m[32m            glVertex3fv(verticies[vertex_index])[m
[32m+[m[32m    glEnd()[m
[32m+[m
[32m+[m[32mdef init_gl_stuff(display):[m
[32m+[m[32m    glEnable(GL_DEPTH_TEST)        #use pygame zbuffer[m
[32m+[m
[32m+[m[32m    aspect_ratio=display[0]/display[1][m
[32m+[m[32m    field_of_view_Angle=60[m
[32m+[m[32m    zNear=0.1[m
[32m+[m[32m    zFar=100[m
[32m+[m[32m    glMatrixMode(GL_PROJECTION)[m
[32m+[m[32m    glLoadIdentity()[m
[32m+[m[32m    gluPerspective(field_of_view_Angle, aspect_ratio,zNear,zFar)[m
[32m+[m[32m    glTranslatef(0.0, 0.0, -3.0)                 #object move away from the screen[m
[32m+[m[32m    glRotatef(25, 1, 1, 0)                       #object rotate cc 25 deg around (1,1,0)[m
[32m+[m[32m    gluLookAt(-1,0.1,0, 0,0,-3, 0,1,0)           #cameramove left[m
[32m+[m
[32m+[m[32mdef main():[m
[32m+[m[32m    pygame.init()[m
[32m+[m[32m    display=(800,600)[m
[32m+[m[32m    isfullscreen=False[m
[32m+[m[32m    pygame.display.set_mode(display, DOUBLEBUF|OPENGL)[m
[32m+[m[32m    init_gl_stuff(display)[m
[32m+[m[32m    while True:[m
[32m+[m[32m        for event in pygame.event.get():[m
[32m+[m[32m            if event.type == pygame.QUIT:[m
[32m+[m[32m                pygame.quit()[m
[32m+[m[32m                quit()[m
[32m+[m[32m            elif event.type == KEYDOWN:[m
[32m+[m[32m                if event.key == pygame.K_f:[m
[32m+[m[32m                    if isfullscreen==False:[m
[32m+[m[32m                        print("Changing to FULLSCREEN")[m
[32m+[m[32m                        pygame.display.set_mode(display, OPENGL | DOUBLEBUF | FULLSCREEN)[m
[32m+[m[32m                        isfullscreen=True[m
[32m+[m[32m                    else:[m
[32m+[m[32m                        print("Changing to windowed mode")[m
[32m+[m[32m                        pygame.display.set_mode(display, OPENGL | DOUBLEBUF)[m
[32m+[m[32m                        isfullscreen=False[m
[32m+[m[32m                    init_gl_stuff(display)[m
[32m+[m
[32m+[m[32m        #clear screen and move camera[m
[32m+[m[32m        glClear(GL_COLOR_BUFFER_BIT|GL_DEPTH_BUFFER_BIT)[m
[32m+[m
[32m+[m[32m        #orbit camera around by 1 degree[m
[32m+[m[32m        glRotatef(1, 1, 1, 1)[m
[32m+[m[32m        cubies()[m
[32m+[m[32m        pygame.display.flip()[m
[32m+[m[32m        pygame.time.wait(10)[m
[32m+[m[41m       [m
[32m+[m[32mmain()[m
[1mdiff --git a/rubiks_cube_simulator/misc/gltest_sample.py b/rubiks_cube_simulator/misc/gltest_sample.py[m
[1mnew file mode 100644[m
[1mindex 0000000..7843ecc[m
[1m--- /dev/null[m
[1m+++ b/rubiks_cube_simulator/misc/gltest_sample.py[m
[36m@@ -0,0 +1,16 @@[m
[32m+[m[32mimport OpenGL[m
[32m+[m[32mimport OpenGL.GL[m
[32m+[m[32mimport OpenGL.GLUT[m
[32m+[m[32mimport OpenGL.GLU[m
[32m+[m
[32m+[m[32mdef showScreen():[m
[32m+[m[32m    glClear(GL_COLOR_BUFFER_BIT | GL_DEPTH_BUFFER_BIT) # Remove everything from screen (i.e. displays all white)[m
[32m+[m
[32m+[m[32mglutInit() # Initialize a glut instance which will allow us to customize our window[m
[32m+[m[32mglutInitDisplayMode(GLUT_RGBA) # Set the display mode to be colored[m
[32m+[m[32mglutInitWindowSize(500, 500)   # Set the width and height of your window[m
[32m+[m[32mglutInitWindowPosition(0, 0)   # Set the position at which this windows should appear[m
[32m+[m[32mwind = glutCreateWindow("OpenGL Coding Practice") # Give your window a title[m
[32m+[m[32mglutDisplayFunc(showScreen)  # Tell OpenGL to call the showScreen method continuously[m
[32m+[m[32mglutIdleFunc(showScreen)     # Draw any graphics or shapes in the showScreen function at all times[m
[32m+[m[32mglutMainLoop()  # Keeps the window created above displaying/running in a loop[m
[1mdiff --git a/rubiks_cube_simulator/misc/notations.txt b/rubiks_cube_simulator/misc/notations.txt[m
[1mnew file mode 100644[m
[1mindex 0000000..6857852[m
[1m--- /dev/null[m
[1m+++ b/rubiks_cube_simulator/misc/notations.txt[m
[36m@@ -0,0 +1,30 @@[m
[32m+[m[32m9 movement, if no middle then 6.[m
[32m+[m[32m    Each rotation changes the position[m
[32m+[m[32m    *use wiki page notation[m
[32m+[m[32m    Front Back Up Down Left Right, default clockwise, ' counter-clockwise, _2 180 degree.[m
[32m+[m[32m    F B U D L R[m
[32m+[m
[32m+[m[32m-------------------------[m
[32m+[m[32mPosition is necessary to determine if a layer is changed.[m
[32m+[m[32m    Each block have a 3d xyz coordinate[m
[32m+[m[32m    Each block have a position(direction) attribute. Corner have 3, edge have 2, middle block have 1(different if cube have direction instead of color)[m
[32m+[m[32m    But blocks are connected, so there are few less positions than 3*2 * 8 * 2*2 * 12 * 6 = 13824 possibilities.[m
[32m+[m[32m    How to represent the relationships?[m
[32m+[m[32m    If use the 20 depth inference, 3 moves(clock counterclock 180)*9 action-> 3^9=19683 possibility. means any problem could be solved within 19683 moves. though low efficiency.[m
[32m+[m
[32m+[m[32mHow to find solution?[m
[32m+[m[32m    1.knows that the corner block is adjustable without effecting the edge block.[m
[32m+[m[32m    2.infer that the rule holds for upper layers.[m
[32m+[m
[32m+[m[32mSo in our case, we can generate (3*6)*(3*6-1)^(n-1) moves, then check if bottom is the same.<F11>[m
[32m+[m[32m---------------------------------[m
[32m+[m[32mJan 12: add Group Theory permutation denotations.[m
[32m+[m[32m    From Left to Right, (1,2,4)(3)(5)*(3,1)(4,2)=(1,4,3)(2)(5)[m
[32m+[m
[32m+[m[32m    Theorem: The Cube always has even parity.[m[41m [m
[32m+[m[32m    It says that it means that hence there's no move that will exchange a single pair of cubies.[m[41m [m
[32m+[m[41m    [m
[32m+[m[32m    Thinks:[m[41m [m
[32m+[m[32m        to simplify, consider 2x2. a movement[m[41m [m
[32m+[m[32m        F(2x2) = (FLU, FRU, FRD, FLD)=(FLU, FRU)(FLU, FRD)(FLU, FLD)[m
[32m+[m[32m        so in 2x2 each movement is odd.[m
[1mdiff --git a/rubiks_cube_simulator/misc/pygameGL_samplecode.py b/rubiks_cube_simulator/misc/pygameGL_samplecode.py[m
[1mnew file mode 100644[m
[1mindex 0000000..be2d7f9[m
[1m--- /dev/null[m
[1m+++ b/rubiks_cube_simulator/misc/pygameGL_samplecode.py[m
[36m@@ -0,0 +1,129 @@[m
[32m+[m[32m#!/usr/bin/env python[m
[32m+[m
[32m+[m[32m"""Draw a cube on the screen. every frame we orbit[m
[32m+[m[32mthe camera around by a small amount and it appears[m
[32m+[m[32mthe object is spinning. note i've setup some simple[m
[32m+[m[32mdata structures here to represent a multicolored cube,[m
[32m+[m[32mwe then go through a semi-unoptimized loop to draw[m
[32m+[m[32mthe cube points onto the screen. opengl does all the[m
[32m+[m[32mhard work for us. :][m
[32m+[m[32m"""[m
[32m+[m
[32m+[m[32mimport pygame[m
[32m+[m[32mfrom pygame.locals import *[m
[32m+[m
[32m+[m[32mtry:[m
[32m+[m[32m    from OpenGL.GL import *[m
[32m+[m[32m    from OpenGL.GLU import *[m
[32m+[m[32mexcept ImportError:[m
[32m+[m[32m    print ('The GLCUBE example requires PyOpenGL')[m
[32m+[m[32m    raise SystemExit[m
[32m+[m
[32m+[m
[32m+[m
[32m+[m[32m#some simple data for a colored cube[m
[32m+[m[32m#here we have the 3D point position and color[m
[32m+[m[32m#for each corner. then we have a list of indices[m
[32m+[m[32m#that describe each face, and a list of indieces[m
[32m+[m[32m#that describes each edge[m
[32m+[m
[32m+[m
[32m+[m[32mCUBE_POINTS = ([m
[32m+[m[32m    (0.5, -0.5, -0.5),  (0.5, 0.5, -0.5),[m
[32m+[m[32m    (-0.5, 0.5, -0.5),  (-0.5, -0.5, -0.5),[m
[32m+[m[32m    (0.5, -0.5, 0.5),   (0.5, 0.5, 0.5),[m
[32m+[m[32m    (-0.5, -0.5, 0.5),  (-0.5, 0.5, 0.5)[m
[32m+[m[32m)[m
[32m+[m
[32m+[m[32m#colors are 0-1 floating values[m
[32m+[m[32mCUBE_COLORS = ([m
[32m+[m[32m    (1, 0, 0), (1, 1, 0), (0, 1, 0), (0, 0, 0),[m
[32m+[m[32m    (1, 0, 1), (1, 1, 1), (0, 0, 1), (0, 1, 1)[m
[32m+[m[32m)[m
[32m+[m
[32m+[m[32mCUBE_QUAD_VERTS = ([m
[32m+[m[32m    (0, 1, 2, 3), (3, 2, 7, 6), (6, 7, 5, 4),[m
[32m+[m[32m    (4, 5, 1, 0), (1, 5, 7, 2), (4, 0, 3, 6)[m
[32m+[m[32m)[m
[32m+[m
[32m+[m[32mCUBE_EDGES = ([m
[32m+[m[32m    (0,1), (0,3), (0,4), (2,1), (2,3), (2,7),[m
[32m+[m[32m    (6,3), (6,4), (6,7), (5,1), (5,4), (5,7),[m
[32m+[m[32m)[m
[32m+[m
[32m+[m
[32m+[m
[32m+[m[32mdef drawcube():[m
[32m+[m[32m    "draw the cube"[m
[32m+[m[32m    allpoints = list(zip(CUBE_POINTS, CUBE_COLORS))[m
[32m+[m
[32m+[m[32m    glBegin(GL_QUADS)[m
[32m+[m[32m    for face in CUBE_QUAD_VERTS:[m
[32m+[m[32m        for vert in face:[m
[32m+[m[32m            pos, color = allpoints[vert][m
[32m+[m[32m            glColor3fv(color)[m
[32m+[m[32m            glVertex3fv(pos)[m
[32m+[m[32m    glEnd()[m
[32m+[m
[32m+[m[32m    glColor3f(1.0, 1.0, 1.0)[m
[32m+[m[32m    glBegin(GL_LINES)[m
[32m+[m[32m    for line in CUBE_EDGES:[m
[32m+[m[32m        for vert in line:[m
[32m+[m[32m            pos, color = allpoints[vert][m
[32m+[m[32m            glVertex3fv(pos)[m
[32m+[m
[32m+[m[32m    glEnd()[m
[32m+[m
[32m+[m[32mdef init_gl_stuff():[m
[32m+[m
[32m+[m[32m    glEnable(GL_DEPTH_TEST)        #use our zbuffer[m
[32m+[m
[32m+[m[32m    #setup the camera[m
[32m+[m[32m    glMatrixMode(GL_PROJECTION)[m
[32m+[m[32m    glLoadIdentity()[m
[32m+[m[32m    gluPerspective(45.0,640/480.0,0.1,100.0)    #setup lens[m
[32m+[m[32m    glTranslatef(0.0, 0.0, -3.0)                #move back[m
[32m+[m[32m    glRotatef(25, 1, 0, 0)                       #orbit higher[m
[32m+[m
[32m+[m[32mdef main():[m
[32m+[m[32m    "run the demo"[m
[32m+[m[32m    #initialize pygame and setup an opengl display[m
[32m+[m[32m    pygame.init()[m
[32m+[m
[32m+[m[32m    fullscreen = True[m
[32m+[m[32m    pygame.display.set_mode((640,480), OPENGL|DOUBLEBUF|FULLSCREEN)[m
[32m+[m
[32m+[m[32m    init_gl_stuff()[m
[32m+[m
[32m+[m[32m    going = True[m
[32m+[m[32m    while going:[m
[32m+[m[32m        #check for quit'n events[m
[32m+[m[32m        events = pygame.event.get()[m
[32m+[m[32m        for event in events:[m
[32m+[m[32m            if event.type == QUIT or (event.type == KEYDOWN and event.key == K_ESCAPE):[m
[32m+[m[32m                going = False[m
[32m+[m
[32m+[m[32m            elif event.type == KEYDOWN:[m
[32m+[m[32m                if event.key == pygame.K_f:[m
[32m+[m[32m                    if not fullscreen:[m
[32m+[m[32m                        print("Changing to FULLSCREEN")[m
[32m+[m[32m                        pygame.display.set_mode((640, 480), OPENGL | DOUBLEBUF | FULLSCREEN)[m
[32m+[m[32m                    else:[m
[32m+[m[32m                        print("Changing to windowed mode")[m
[32m+[m[32m                        pygame.display.set_mode((640, 480), OPENGL | DOUBLEBUF)[m
[32m+[m[32m                    fullscreen = not fullscreen[m
[32m+[m[32m                    init_gl_stuff()[m
[32m+[m
[32m+[m
[32m+[m[32m        #clear screen and move camera[m
[32m+[m[32m        glClear(GL_COLOR_BUFFER_BIT|GL_DEPTH_BUFFER_BIT)[m
[32m+[m
[32m+[m[32m        #orbit camera around by 1 degree[m
[32m+[m[32m        glRotatef(1, 0, 1, 0)[m
[32m+[m
[32m+[m[32m        drawcube()[m
[32m+[m[32m        pygame.display.flip()[m
[32m+[m[32m        pygame.time.wait(10)[m
[32m+[m
[32m+[m
[32m+[m[32mif __name__ == '__main__': main()[m
[1mdiff --git a/rubiks_cube_simulator/misc/q_test1.py b/rubiks_cube_simulator/misc/q_test1.py[m
[1mnew file mode 100644[m
[1mindex 0000000..b133f41[m
[1m--- /dev/null[m
[1m+++ b/rubiks_cube_simulator/misc/q_test1.py[m
[36m@@ -0,0 +1,14 @@[m
[32m+[m[32mfrom quaternion import quaternion[m
[32m+[m[32mimport array[m
[32m+[m[32mdef rotate(px,py,pz,ccAngleinDegree,axis_i,axis_j,axis_k):[m
[32m+[m[32m    q=quaternion(ccAngleinDegree,axis_i,axis_j,axis_k)[m
[32m+[m[32m    q.lsq()[m
[32m+[m[32m    q_revert=quaternion(-ccAngleinDegree,axis_i,axis_j,axis_k)[m
[32m+[m[32m    p=array.array('d',[px,py,pz])[m
[32m+[m[32m    print("p=",p)[m
[32m+[m[32m    pq=q*p[m
[32m+[m[32m    print("pxq= ", pq)[m
[32m+[m[32m    q_revert.lsq()[m
[32m+[m[32m    p_new=pq*q_revert[m
[32m+[m[32m    print("p_new=: ", p_new)[m
[32m+[m[32m    return p_new[m
[1mdiff --git a/rubiks_cube_simulator/misc/q_test2.py b/rubiks_cube_simulator/misc/q_test2.py[m
[1mnew file mode 100644[m
[1mindex 0000000..15542cc[m
[1m--- /dev/null[m
[1m+++ b/rubiks_cube_simulator/misc/q_test2.py[m
[36m@@ -0,0 +1,13 @@[m
[32m+[m[32m#-------passed----------[m
[32m+[m[32mprint ("test1.rotate(0,0,1,-90,1,0,0)", test1.rotate(0,0,1,-90,1,0,0))[m
[32m+[m[32mprint ("test1.rotate(0,1,0,-90,1,0,0)", test1.rotate(0,1,0,-90,1,0,0))[m
[32m+[m[32mprint ("test1.rotate(1,0,0,-90,1,0,0)", test1.rotate(1,0,0,-90,1,0,0))[m
[32m+[m[32mprint ("test1.rotate(1,1,1,-90,1,0,0)", test1.rotate(1,1,1,-90,1,0,0))[m
[32m+[m[32mprint ("test1.rotate(1,1,-1,-90,1,0,0)", test1.rotate(1,1,-1,-90,1,0,0))[m
[32m+[m[32mtest1.rotate(1,1,-1,-90,3,0,0)[m
[32m+[m[32mtest1.rotate(0,0,1,-90,0.59,0.6,0.53)[m
[32m+[m[32mtest1.rotate(1,1,1,-90,1,1,1)[m
[32m+[m
[32m+[m[32mtest1.rotate(1,0,0,-120,1,1,1)[m
[32m+[m[32mtest1.rotate(1,-1,1,-120,1,1,1)[m
[32m+[m[32m#---------------[m
[1mdiff --git a/rubiks_cube_simulator/quarternion.py b/rubiks_cube_simulator/quarternion.py[m
[1mnew file mode 100644[m
[1mindex 0000000..a224387[m
[1m--- /dev/null[m
[1m+++ b/rubiks_cube_simulator/quarternion.py[m
[36m@@ -0,0 +1,99 @@[m
[32m+[m[32m#----------------[m
[32m+[m[32m#The quaternion calculator.[m[41m [m
[32m+[m[32m#Used in generating custom 3D animation.[m
[32m+[m[32m#Input a 3D starting point, as well as rotation axises and rotation degree.[m
[32m+[m[32m#Output the point's rotation result.[m
[32m+[m[32m#The calculation follows this logic: p_new=qxpxq_revert. where q is the "rotation" represented in quaternion, and p is the point to rotate. p shall be an 1x3 array, p=array.array('d',[i,j,k])[m
[32m+[m[32m#----------------[m
[32m+[m[32mimport math[m
[32m+[m[32mimport array[m
[32m+[m[32mclass quaternion:[m
[32m+[m[32m    def __init__(self,CounterclockRotationAngleinDegree,axis_i,axis_j,axis_k):[m
[32m+[m[32m        self.theta=math.radians(CounterclockRotationAngleinDegree/2)[m
[32m+[m[32m        normalization_constant=math.sqrt(axis_i**2+axis_j**2+axis_k**2)[m
[32m+[m[32m        self.a=float(math.cos(self.theta))[m
[32m+[m[32m        self.b=float(math.sin(self.theta)*axis_i/normalization_constant)[m
[32m+[m[32m        self.c=float(math.sin(self.theta)*axis_j/normalization_constant)[m
[32m+[m[32m        self.d=float(math.sin(self.theta)*axis_k/normalization_constant)[m
[32m+[m[32m    def lsq(self):[m
[32m+[m[32m        print("q.{a-d}", self.a,self.b,self.c,self.d)[m
[32m+[m[32m    def __mul__(self,other):[m[41m [m
[32m+[m[32m        if hasattr(other, "__len__"):[m
[32m+[m[32m            if 3==len(other):[m
[32m+[m[32m                a1=self.a[m
[32m+[m[32m                b1=self.b[m
[32m+[m[32m                c1=self.c[m
[32m+[m[32m                d1=self.d[m
[32m+[m[32m                a2=0[m
[32m+[m[32m                b2=other[0][m
[32m+[m[32m                c2=other[1][m
[32m+[m[32m                d2=other[2][m
[32m+[m[32m                H=HamiltonProduct(a1,b1,c1,d1,a2,b2,c2,d2)[m
[32m+[m[32m                return H[m
[32m+[m[32m            if 4==len(other):[m
[32m+[m[32m                a1=self.a[m
[32m+[m[32m                b1=self.b[m
[32m+[m[32m                c1=self.c[m
[32m+[m[32m                d1=self.d[m
[32m+[m[32m                a2=other[0][m
[32m+[m[32m                b2=other[1][m
[32m+[m[32m                c2=other[2][m
[32m+[m[32m                d2=other[3][m
[32m+[m[32m                H=HamiltonProduct(a1,b1,c1,d1,a2,b2,c2,d2)[m
[32m+[m[32m                return H[m
[32m+[m[32m    def __rmul__(self,other):[m
[32m+[m[32m        if hasattr(other, "__len__"):[m
[32m+[m[32m            if 3==len(other):[m
[32m+[m[32m                a2=self.a[m
[32m+[m[32m                b2=self.b[m
[32m+[m[32m                c2=self.c[m
[32m+[m[32m                d2=self.d[m
[32m+[m[32m                a1=0[m
[32m+[m[32m                b1=other[0][m
[32m+[m[32m                c1=other[1][m
[32m+[m[32m                d1=other[2][m
[32m+[m[32m                H=HamiltonProduct(a1,b1,c1,d1,a2,b2,c2,d2)[m
[32m+[m[32m                return H[m
[32m+[m[32m            if 4==len(other):[m
[32m+[m[32m                a2=self.a[m
[32m+[m[32m                b2=self.b[m
[32m+[m[32m                c2=self.c[m
[32m+[m[32m                d2=self.d[m
[32m+[m[32m                a1=other[0][m
[32m+[m[32m                b1=other[1][m
[32m+[m[32m                c1=other[2][m
[32m+[m[32m                d1=other[3][m
[32m+[m[32m                H=HamiltonProduct(a1,b1,c1,d1,a2,b2,c2,d2)[m
[32m+[m[32m                return H[m
[32m+[m
[32m+[m[32mdef HamiltonProduct(a1,b1,c1,d1,a2,b2,c2,d2):[m
[32m+[m[32m    H=array.array('d', [a1*a2-b1*b2-c1*c2-d1*d2, a1*b2+b1*a2+c1*d2-d1*c2, a1*c2-b1*d2+c1*a2+d1*b2, a1*d2+b1*c2-c1*b2+d1*a2])[m
[32m+[m[32m    return H[m
[32m+[m[32mdef qtcal(ccRotationinDegree, axis_i, axis_j, axis_k, p_i, p_j, p_k):[m
[32m+[m[32m    q=quaternion(ccRotationinDegree,axis_i,axis_j,axis_k)[m
[32m+[m[32m    q_revert=quaternion(-ccRotationinDegree,axis_i,axis_j,axis_k)[m
[32m+[m[32m    p=array.array('d',[p_i,p_j,p_k])[m
[32m+[m[32m    p_new=q*p*q_revert[m
[32m+[m[32m    p_new=list(p_new)[m
[32m+[m[32m    p_new.pop(0)[m
[32m+[m[32m    return p_new[m
[32m+[m[41m    [m
[32m+[m[32mdef getInputs():[m
[32m+[m[32m    degree=float(input("Counter-Clockwise-Rotation-Angle in degree: "))[m
[32m+[m[32m    axis_i=float(input("Rotation axis i value: "))[m
[32m+[m[32m    axis_j=float(input("Rotation axis j value: "))[m
[32m+[m[32m    axis_k=float(input("Rotation axis k value: "))[m
[32m+[m[32m    p_i=float(input("Point to Rotate i value: "))[m
[32m+[m[32m    p_j=float(input("Point to Rotate j value: "))[m
[32m+[m[32m    p_k=float(input("Point to Rotate k value: "))[m
[32m+[m[32m    return degree, axis_i, axis_j, axis_k, p_i, p_j, p_k[m
[32m+[m[32mdef main():[m
[32m+[m[32m    ccRotationinDegree, axis_i, axis_j, axis_k, p_i, p_j, p_k = getInputs()[m
[32m+[m[32m    q=quaternion(ccRotationinDegree,axis_i,axis_j,axis_k)[m
[32m+[m[32m    q_revert=quaternion(-ccRotationinDegree,axis_i,axis_j,axis_k)[m
[32m+[m[32m    p=array.array('d',[p_i,p_j,p_k])[m
[32m+[m[32m    p_new=q*p*q_revert[m
[32m+[m[32m    #print("p_new=: ", p_new[1],"i, ",p_new[2],"j, ",p_new[3],"k")[m
[32m+[m[32m    print("p_new=: ", "{0:.2f}".format(p_new[1]), "i, ", "{0:.2f}".format(p_new[2]), "j, ", "{0:.2f}".format(p_new[2]), "k")[m
[32m+[m[32m    return[m
[32m+[m[32m#main()[m
