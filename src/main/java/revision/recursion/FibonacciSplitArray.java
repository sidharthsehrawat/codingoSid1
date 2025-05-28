package revision.recursion;

import java.util.ArrayList;
import java.util.List;

public class FibonacciSplitArray {
    public static void main(String[] args) {
        String num = "123456579";
        List<Integer> res = splitIntoFibonacci(num);
        System.out.println("res : " + res);
    }

    public static List<Integer> splitIntoFibonacci(String num) {
        List<Integer> list = new ArrayList<>();
        int pos = 0;
        helper(num, list, pos);
        return list;
    }

    public static boolean helper(String s, List<Integer> list, int pos) {
        if (pos == s.length()) {
            return list.size() > 2;
        }

        long num = 0;
        for (int i = pos; i < s.length(); i++) {
            num = num * 10 + (s.charAt(i) - '0');
            if (i > pos && s.charAt(pos) == '0') return false;
            if (num < 0 || num > Integer.MAX_VALUE) return false;
            if (list.size() < 2 || (long) list.get(list.size() - 1) + list.get(list.size() - 2) == num) {
                list.add((int) num);
                if (helper(s, list, i + 1)) return true;
                list.remove(list.size() - 1);
            }
        }
        return false;
    }
}
