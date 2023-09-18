package folder.Oops;

public class A1 {
    void method(A1 a){
        System.out.println("A");
    }
}

class B1 extends A1{
    public void method(A1 a){
        System.out.println("B");
    }
}

class TestPoly{
    public static void main(String[] args) {
        A1 a = new A1();
        B1 b = new B1();
        b.method(null);
        //a = b;
        a.method(null);
        b.method(new A1());
    }
}
