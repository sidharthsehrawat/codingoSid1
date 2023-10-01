package folder.array;

import java.util.Stack;

public class BasicCalculator {
    public static void main(String[] args) {
        // String s = "3*2+2";
        String s = "23*2+1+3*2";
        //s = s.replaceAll(" ", "");
        int res = calculate(s);
        System.out.println(res);
    }

    public static int calculate(String s) {
        if (s.length() == 0) {
            return 0;
        }
        Stack<Integer> stack = new Stack<>();
        char opr = '+';

        char ch[] = s.toCharArray();
        int curr = 0;
// 23 2
        for (int i = 0; i < ch.length; i++) {
            if (Character.isDigit(ch[i])) {
                curr = curr * 10 + ch[i] - '0';
            }
            if (!Character.isDigit(ch[i]) || i ==s.length()-1) {
                if (opr == '*') {
                    stack.push(stack.pop() * curr);
                } else if (opr == '+') {
                    stack.push(curr);
                } else if (opr == '-') {
                    stack.push(-curr);
                } else if (opr == '/') {
                    stack.push(stack.pop() / curr);
                }
                curr = 0;
                opr = ch[i];
            }
        }
        int sum =0;
        while (!stack.isEmpty()){
            sum+=stack.pop();
        }
        return sum;
    }
}
