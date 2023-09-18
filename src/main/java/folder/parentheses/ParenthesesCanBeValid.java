package folder.parentheses;

import java.util.Stack;

public class ParenthesesCanBeValid {

    public static void main(String[] args) {
        String s = "((()(()()))()((()()))))()((()(()";
        String locked = "10111100100101001110100010001001";
        boolean res = canBeValid(s, locked);
        System.out.println(res);

    }

    public static boolean canBeValid(String s, String locked) {
        Stack<Character> stack = new Stack<>();
        // Edge cases
        if ((locked.charAt(0) == '1' && s.charAt(0) == ')') || (s.length() % 2 != 0)) {
            return false;
        } else {
            stack.push('(');
            for (int i = 1; i < s.length(); i++) {
                if (locked.charAt(i) == '0' && stack.isEmpty()) {
                    stack.push('(');
                } else if ((locked.charAt(i) == '0' && s.charAt(i) == ')') && stack.peek() == '(') {
                    stack.pop();
                } else if ((locked.charAt(i) == '0' && s.charAt(i) == '(') && !stack.isEmpty()) {
                    stack.push('(');
                } else if (locked.charAt(i) == '1' && s.charAt(i) == ')') {
                    if (!stack.isEmpty() && stack.peek() == '(') {
                        stack.pop();
                    } else {
                        return false;
                    }
                } else if (locked.charAt(i) == '1' && s.charAt(i) == '(' && !stack.isEmpty()) {
                    stack.push('(');
                }
            }
        }
        if (stack.isEmpty()) {
            return true;
        }
        return false;
    }
}
