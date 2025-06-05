package revision.recursion;

import java.util.ArrayList;
import java.util.List;

public class GetKeyPadCombination {

    static String[] keyboard = {"?", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tu", "vw", "xyz"};

    public static void main(String[] args) {
        String number = "789";
        List<String> ans = combination(number);
        System.out.println("ans " + ans);
    }

    private static List<String> combination(String number) {
        if (number.isEmpty()) {
            List<String> list = new ArrayList<>();
            list.add("");
            return list;
        }
        List<String> mres = new ArrayList<>();
        char ch = number.charAt(0);
        String ros = number.substring(1);
        List<String> res = combination(ros);
        String option = keyboard[ch - '0'];
        for (char c : option.toCharArray()) {
            for (String s : res) {
                mres.add(s + c);
            }
        }
        return mres;
    }
}
