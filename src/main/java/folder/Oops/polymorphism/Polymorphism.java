package folder.Oops.polymorphism;

class Parent {
    public Parent() {

        System.out.println("Parent Constructor");
    }

    int i = 1;
    static int j = 1;
    String str = "abc";

    public void method(int a) {
        System.out.println("parent: " + a);
    }

    public void getString() {
        System.out.println("Parent getString called " + str);
    }
}

class Child extends Parent {
    public Child() {
        System.out.println("Child Constructor");
    }
    int i = 2;
    static int j = 2;
    String str = "de";

    public void method(int b) {
        System.out.println("child: " + b);
    }
    public void getString() {
        this.i =  21;
        System.out.println("child val i : " + i);
        super.str = "abcChanged";
        int ivalue = super.i = 3;
        System.out.println( "parent value changed :" + ivalue);
        super.getString();
        System.out.println("Child getString called " + str + " i :" + i + " j: " + j);
    }
}

class Child1 extends Child {

    public Child1() {
        super();
        System.out.println("Child1 Constructor");
    }

    int i = 3;
    static int j = 3;
    String str = "xyz";

    public void method(int b) {
        System.out.println("child1: " + b);
    }

    public void getString() {
        super.str = "deChanged";
        super.i = 4;
        super.getString();
        System.out.println("Child1 getString called " + str + " i: " + i + " j: " + j);
    }
}


public class Polymorphism {
    public static void main(String[] args) {
        Child child = new Child();
        //   System.out.println(child.i); // 2
        //   System.out.println(Child.j);// 2
        //   System.out.println(child.str); // de
        //   child.method(2);
        child.getString(); //  2 de 2

        Parent parent = new Child();
        //   System.out.println(parent.i); // 1
        //   System.out.println(Parent.j);//1
        //   System.out.println(parent.str);// abc
        //   parent.method(1);
        parent.getString(); // 2 de 2

        Parent parentchild = new Parent();
        //    System.out.println(parentchild.i);//1
        //    System.out.println(parentchild.j);//1
        //    System.out.println(parentchild.str);// abc
        //   parentchild.method(1);
        parentchild.getString(); // 1 abc 1

        Parent parentchild1 = new Child1();

        //    System.out.println(parentchild1.i);//1
        //    System.out.println(parentchild1.j);//1
        //    System.out.println(parentchild1.str);// abc
        //  parentchild1.method(1);
        parentchild1.getString();  // 3 xyz 3

    }

}

/*

1. Parent -> Child -> child1
a) Parent parent = new Parent(); -> parent variables called , parent method will called.
b) Parent parentchild = new Child(); -> parent variables called , Child method will called.
c) Parent parentchild1 = new Child1() -> parent variables(i, static , str) called , Child1 method will called.
d) Child childchild1 = new Child1() -> child variables(i, static , str) called , Child1 method will called.

2) i and j static values can be overriden by super.method(), but original values cannot be changed.




*/
