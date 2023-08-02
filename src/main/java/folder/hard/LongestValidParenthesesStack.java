package folder.hard;

import java.util.Stack;

public class LongestValidParenthesesStack {

    public static void main(String[] args) {

        //   ["apple pen apple"] => ["apple", "pen", "apple"]
        //   [sand make model] => ["sand","mode"]

        String str1 = "{{{}}}{";
        String str2 = "{{}}{{{}";
        String str3 = "{{{}}{}}";
        String str4 = "{{{{}}{}}";
        int result = getValidParenthesesUsingStack(str1);
        System.out.println(result);

        //   max = i+1 - si = Math.max(2,4,6,2) = 0;

/*    (3-1) = 2  ||  (4-0) = 4 || (6-0) = 6 || (8-6) = 2

       7 }
       6 {
       5 }x
       4 }x
       3 }x
       2 {x
       1 {x
       0 {x
    // max (3-1=2 | 4-0 =4 | 5-(-1) =6)
       STACK   : -1 0 1 2
*/
    }

    private static int getValidParenthesesUsingStack(String str) {
        Stack<Integer> stack = new Stack<>();
        int max = 0;
        stack.push(-1);
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (ch == '{') {
                stack.push(i);
            } else {
                stack.pop();
                if (!stack.isEmpty()) {
                    max = Math.max(max, i - stack.peek());
                } else {
                    stack.push(i);
                }
            }
        }
        return max;
    }
}
