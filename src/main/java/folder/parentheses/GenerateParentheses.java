package folder.parentheses;

import java.util.ArrayList;
import java.util.List;

public class GenerateParentheses {
    public static void main(String[] args) {
        int n = 3;
        GenerateParentheses generateParentheses = new GenerateParentheses();
        List<String> stringList = generateParentheses.generateValidParentheses(n, "(", 1, 0);
        System.out.println(stringList);
        //n =3 (((
        //                        (
        //                     /      \
        //                    ((        (()
        //                    /          \
        //                   (((         ((())
    }

    List<String> finalList = new ArrayList<>();

    private List<String> generateValidParentheses(int n, String str, int open, int closed) {
        if (str.length() == 2 * n) {
            System.out.println(str);
            finalList.add(str);
        }


        if (open < n) {
            generateValidParentheses(n, str + "(", open + 1, closed);
        }

        if (closed < open) {
            generateValidParentheses(n, str + ")", open, closed + 1);
        }

        return finalList;

    }


}
