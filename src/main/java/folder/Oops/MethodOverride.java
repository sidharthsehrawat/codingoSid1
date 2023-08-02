package folder.Oops;

public class MethodOverride {
    public static void main(String[] args) {
        // static no override
        //  Parent parent = new Child();
        // parent.method(1);
        C c = new C();
        c.method2();

    }
}

class Parent {
    public void method(int a) {
        System.out.println("In parent.." + a);
    }
}

class Child extends Parent {
    public void method(int b) {
        System.out.println("In child.." + b);
    }
}

interface A {
    public void method2();

   /* default void method() {
        System.out.println("In Interface A method");
    }*/
}

interface AB {
    public void method2();

   /* default void method() {
        System.out.println("In Interface B method");
    }*/
}

class C implements AB {

    @Override
    public void method2() {

    }
}



