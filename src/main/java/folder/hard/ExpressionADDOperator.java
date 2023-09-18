package folder.hard;

import java.util.ArrayList;
import java.util.List;

public class ExpressionADDOperator {
    public static void main(String[] args) {
        String str = "123";
        int target = 6;
        List<String> result = getCountOperator(str, target);
        System.out.println(result);

    }

    private static List<String> getCountOperator(String num, int target) {
        List<String> finalist = new ArrayList<>();
        if (num.length() == 0 || target < 0) {
            return finalist;
        }
        helper(finalist, "", num, target, 0, 0, 0);
        return finalist;
    }

    private static void helper(List<String> finalist, String path, String num, int target, int pos, long eval, long mul) {
        if (pos == num.length()) {
            if (target == eval)
                finalist.add(path);
            return;
        }
        for (int i = pos; i < num.length(); i++) {
            if (i != pos && num.charAt(pos) == '0') break;
            long cur = Long.parseLong(num.substring(pos, i + 1));
            if (pos == 0) {
                helper(finalist, path + cur, num, target, i + 1, cur, cur);
            } else {
                helper(finalist, path + "+" + cur, num, target, i+1, eval + cur, mul);
                helper(finalist, path + "-" + cur, num, target, i+1, eval - cur, -mul);
                helper(finalist, path + "*" + cur, num, target, i+1, eval - mul + mul * cur, mul* cur);
            }
        }

    }
}
