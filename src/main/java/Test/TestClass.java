package Test;

import java.util.HashSet;

public class TestClass {
    public static void main(String[] args) {
        String s = "abcdeaabdc";
        HashSet<Character> set = new HashSet();
        int i = 0;
        int j = 0;
        int max = 0;
        // i
        // 0 1 2 3 4 5 6 7 8 9         set :    e a
        // a b c d e a a b d c
        //             j
        while (j < s.length()) {
            if (!set.contains(s.charAt(j))) {
                set.add(s.charAt(j));
                max = Math.max(set.size(), max);
                j++;
            } else {
                set.remove(s.charAt(i));
                i++;
            }
        }
    }
}
