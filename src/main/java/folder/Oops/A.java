package folder.Oops;

 abstract  class Aa {


    int a;

    abstract int m(int a);

    //int () ;

    Aa(int a) {
        this.a = a;
    }

    //  A a = new A(10);
}


class B extends Aa {

    B(int a) {
        super(a);
    }

    public B() {
        super(10);

    }

    @Override
    int m(int a) {
        return 0;
    }

    B b = new B();
}