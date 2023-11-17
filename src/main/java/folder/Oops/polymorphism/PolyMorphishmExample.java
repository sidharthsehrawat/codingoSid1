package folder.Oops.polymorphism;

class C {
    protected int  a = 0;
    public void getA(){
        System.out.println("a from C" + a);
    }
    public void m1(){
        System.out.println("In C m1");
    }
}

class D extends C{
    protected   int a = 1 ;
    public void getA(){
        System.out.println("a from D" + a);
    }
    public void m1(){
        System.out.println("In D m1");
    }

    public void m2(){
        System.out.println("In D m2");
    }
}
public class PolyMorphishmExample {
    public static void main(String[] args) {
        C c = new C();
        C cd = new D();
        D d = new D();
        c.m1();
        c.getA();
        int ans = c.a;
        System.out.println(ans);
        cd.m1();
        cd.getA();
        int ans1  = cd.a;
        System.out.println(ans1);
        d.m2();
        d.getA();
        int ans2 = d.a;
        System.out.println(ans2);
    }
}
