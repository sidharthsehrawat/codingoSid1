package folder.Oops.polymorphism;

class Base {
    public int bvar = 2;

    public void m(String a) {
        System.out.println(a);
    }

    public void m(Object a) {
        System.out.println(a);
    }
}

class SubBase extends Base {
    public int sbvar = 1;

    public void m(String a) {
        System.out.println(a);
    }

    public void m(Object a) {
        System.out.println(a);
    }
}

public class PolyMorphismNullMethodCall {
    public static void main(String[] args) {
        SubBase sb = new SubBase();
        sb.m(null);
        sb.m("1");
        int sbvar = sb.sbvar;
        System.out.println(sbvar);

        Base b = new Base();
        b.m("1");
        b.m(null);
        int bvar = b.bvar;
        System.out.println(bvar);

        Base bs = new SubBase();
        bs.m("1");
        bs.m(null);
        int bvar2 = bs.bvar;
        System.out.println(bvar2);
    }
}
