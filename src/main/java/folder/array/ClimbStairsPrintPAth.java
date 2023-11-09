package folder.array;

public class ClimbStairsPrintPAth {
    static class Value {
        int v;
    }

    static int count = 0;

    public static void main(String[] args) {
        int n = 3;
        Value ob = new Value();
        ob.v =0;
        int res = climbStairs(n,ob);
        System.out.println(res);
    }

    public static int climbStairs(int n, Value ob) {
        helper(n, "",  ob);
        return ob.v;
    }


    public static void helper(int num, String psf, Value ob ) {
        if (num < 0) {
            return;
        }
        if (num == 0) {
            System.out.println(psf);
            count++;
            ob.v = Math.max(count, ob.v);
        }
        helper(num - 1, psf + 1 , ob);
        helper(num - 2, psf + 2, ob);
    }
}
