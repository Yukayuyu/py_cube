package testTemp;
interface test1int{
    
}
class test1base implements test1int{
    test1base(){}
    test1base(int i ){
    }
}

class test1base2 extends test1base{
    test1base2(int i){
    }
}

public class test1 extends test1base2 implements test1int{
    test1(){
        super(1);
    }
    public static void main(String[] args) {
        System.out.println("hi");
    }

}
