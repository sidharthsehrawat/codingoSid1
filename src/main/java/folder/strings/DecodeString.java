package folder.strings;

import java.util.Stack;

public class DecodeString {
    public static void main(String[] args) {
        String str = "3[a]2[cd]";
        String str1 = "3[a2[c]]";

        String res = function(str);
        System.out.println(res);
    }

    // 3a
    private static String function(String str) {
        StringBuilder string = new StringBuilder();
        String num = "";
        Stack<StringBuilder> stack = new Stack<>();

        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (Character.isDigit(ch)) {
                num = num + ch;
            } else if (Character.isLetter(ch)) {
                string.append(ch);
            } else if (ch == '[') {
                stack.push(string);

            } else if (ch == ']') {

            }

        }

        return "";
    }
}
