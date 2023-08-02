package folder.parentheses;

import java.util.Stack;

public class VaildateParentheses {
    public static void main(String[] args) {
      // {()()}[]  true
      // {()[[]}   false
      // [ {}{} [( [] )] ] true
        Stack<Character> stack = new Stack<>();
        char ch = stack.peek();

        String str1 = "{()()}[]";
        String str2 = "{()[[]}";
        String str3 = "[{}{}[([])]]";
        String str4 = "[[]][]";
        boolean res = validateParenthese("()");
        System.out.println(res);


    }

    private static boolean validateParenthese(String str) {
        Stack<Character> stack = new Stack<>();

        for(int i=0;i<str.length();i++){
            if(isOpeningBracket(str.charAt(i))){
                stack.push(str.charAt(i));
            }else{
                if(validateCheck(str.charAt(i),stack)){
                    stack.pop();
                }else {
                    return false;
                }

            }
        }

        return stack.empty();
    }

    private static boolean validateCheck(char ch, Stack<Character> stack ) {
        switch (ch){
            case ')' :
                if(stack.size()>0) return stack.peek() == '(';

            case '}' :
                if(stack.size()>0) return stack.peek() == '{';

            case ']' :
                if(stack.size()>0) return stack.peek() == '[';

            default:
                return false;
        }
    }

    private static boolean isOpeningBracket(char ch) {
        switch (ch){
            case '{':
                return true;
            case '(':
                return true;
            case '[':
                return true;
            case '}':
                return false;
            case ')':
                return false;
            case ']':
                return false;
            default:
                return false;
        }
    }

}
