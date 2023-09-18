package folder.Oops;

public class Base {
    public Base(){
        System.out.println("base");
    }

    public Base (String name){
        System.out.println("Base" + name);
    }
}

class Derived extends Base {
   public Derived(String s){
       //super();
       super(s);
       System.out.println("Derived");
   }

}

class TestBase {
    public static void main(String[] args) {
        Base base = new Derived("sid");
    }
}
