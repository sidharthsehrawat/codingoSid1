package folder.general;

public class General {
    public static void main(String[] args) {


        m(null);
        m(1);
        m("a");

        String a = "java";
        String b = a;
        a= "python";
        System.out.println(a);
        System.out.println(b);

        char[] ch = {'a', 'b'};
        String s = new String(ch);
        if(args.length>0){
            System.out.println(args.length);
        }
    }

    public static void m(String s){
        System.out.println(s);
    }

    public static void m(Object s){
        System.out.println(s);
    }
}
