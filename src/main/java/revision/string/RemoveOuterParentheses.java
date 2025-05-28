package revision.string;

public class RemoveOuterParentheses {
    public static void main(String[] args) {
        String s = "(()())(()(())";
        String res = removeOuterParentheses(s);
        System.out.println("ans - " + res);
    }

    private static String removeOuterParentheses(String s) {
        int balance = 0;
        StringBuilder sb = new StringBuilder();
        for (char c : s.toCharArray()) {
            if (c == '(') {
                if (balance > 0) {
                    sb.append("(");
                }
                balance++;
            } else {
                balance--;
                if (balance > 0) {
                    sb.append(")");
                }
            }
        }
        return String.valueOf(sb);
    }
}
