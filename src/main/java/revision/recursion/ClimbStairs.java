package revision.recursion;

import java.util.ArrayList;
import java.util.List;

public class ClimbStairs {
    public static void main(String[] args) {
        int num = 5;
        List<String> res = getStairs(num);
        System.out.println("res " + res );
    }

    private static List<String> getStairs(int num) {

        if (num < 0) {
            return new ArrayList<>();
        }

        if (num == 0) {
            List<String> str = new ArrayList<>();
            str.add("");
            return str;
        }

        List<String> l1 = getStairs(num -1);
        List<String> l2 = getStairs(num -2);
        List<String> l3 = getStairs(num -3);


        List<String> finalList = new ArrayList<>();
        for (String s1 : l1) {
            finalList.add(s1 + 1);
        }

        for (String s2 : l2) {
            finalList.add(s2 + 2);
        }

        for (String s3 : l3) {
            finalList.add(s3 + 3);
        }

        return finalList;


    }
}
