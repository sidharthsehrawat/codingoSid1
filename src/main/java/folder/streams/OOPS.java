package folder.streams;

public class OOPS {
    public static void main(String[] args) {
        Child child = new Child();
        System.out.println(child.a);
        child.m1();
        Parent parent = new Child();
        System.out.println(parent.a);
        parent.m1();

        Parent parent1 = new Parent();

        System.out.println(parent1.a);
        parent1.m1();
    }

}

class Parent {
    static int a=1;
    public static void m1(){
        System.out.println("in class Parent Method");
    }
}

class Child extends Parent {
    static int a=2;
    public static void m1(){
        System.out.println("In class Child Method");
    }
}


