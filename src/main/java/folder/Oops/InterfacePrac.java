package folder.Oops;


public interface InterfacePrac  {
    void method(int a);
    int a = 0;
    default void method1() {
        System.out.println("default method. ");
    }
    static void method2() {
        System.out.println("static method in interface. ");
    }
}

 class Student implements InterfacePrac {
    int a=10;
    String name;

Student(){}
    Student(int a , String name){
        this.a = a;
        this.name = name;
    }

    @Override
    public void method(int a) {
        System.out.println("overiiden abstrct method : " + a);
    }

    public void method1() {
        InterfacePrac.super.method1();
        // System.out.println("Overide default method" );
    }

    public static void xyx() {
        System.out.println("non abstarct method.");
    }
}

class Teacher extends Student {
    Teacher(int a, String name) {
        super(a, name);
    }
}

class Main {
    public static void main(String[] args) {
        /// InterfacePrac.ABC obj =  new InterfacePrac.ABC();

           Student s = new Student();
        int a = s.a;
        System.out.println(a);
        //   s.method(1);
        //   s.method1();
        //   s.method2();
        Student.xyx();
        Teacher obj = new Teacher(101,"sid");
        obj.method(1);
    }
}
