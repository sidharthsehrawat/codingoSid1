package folder.Recursion;

import java.util.HashSet;
import java.util.Set;

public class WordBreak {
    public static void main(String[] args) {
        String str = "hissisSid";
        Set<String> set = new HashSet<>();
        set.add("his");
        set.add("sis");
        set.add("Sid");
        set.add("t");

        boolean res = checkWordBreak(str, set, "");
        System.out.println(res);

    }

    private static boolean checkWordBreak(String str, Set<String> set, String ans) {

        if (str.length() == 0) {
            System.out.println(ans);
            return true;
        }

        for (int i = 0; i < str.length(); i++) {
            String left = str.substring(0, i+1 );
            String right = str.substring(i + 1);
            if (set.contains(left)) {
               return checkWordBreak(right, set, ans + left + " ");
            }

        }

        return false;
    }
}
