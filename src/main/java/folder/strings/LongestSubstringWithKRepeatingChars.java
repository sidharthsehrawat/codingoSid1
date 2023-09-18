package folder.strings;

import java.util.HashMap;
import java.util.Map;

public class LongestSubstringWithKRepeatingChars {
    public static void main(String[] args) {
       // String str = "aabbcc";
        String str = "aaabbcc";
        int k = 2;

        int res = helper(str, k);
        System.out.println(res);
    }

    private static int helper(String str, int k) {
        Map<Character, Integer> map = new HashMap<>();
        int j = 0;
        int maxSize = 0;
        int curr = 0;
        for (int i = 0; i < str.length(); i++) {
            if (!map.containsKey(str.charAt(i))) {
                map.put(str.charAt(i), 1);
            } else {
                map.put(str.charAt(i), map.get(str.charAt(i)) + 1);
            }

            if (map.size() > k) {
                j+=map.get(str.charAt(j));
                map.remove(str.charAt(j));
            } else {
                curr = i-j+1;
               maxSize = Math.max(maxSize,curr);
            }


        }
        return maxSize;
    }
}
