package folder.Oops;

public interface IA {
    public void m1();

    default void  m2(int a) {
        System.out.println(a + "interface IA");
    }
}

 class Test {
    public static void main(String[] args) {
        AA a = new AA();
        a.m2(1);
    }
}

class AA implements IA {


    @Override
    public void m1() {

    }


}
