private class Closure implements Incrementable {
    public void increment() {
        Callee2.this.increment();
    }
}

Incrementable getCallbackReference() {
    return new Closure();
}

class Caller {
    //body...,
    //1.constructor with *Closure()* Object reference.
    //2.ref.increment() -> void go(){}
}
public class Cp11_Callback{
    public static void main(String[] args){
        Callee2 c2 = new Callee2();
        Caller caller = new Caller(c2.getCallbackReference());
        caller2.go();
    }
}