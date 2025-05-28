package z_epam;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Test {
    public static void main(String[] args) {
        String s = "abcabcbb";
        int res = lengthOfLongestSubstring(s);
        //System.out.println("result : " + res);

        String str ="abacbcedf";
        // a - 2
        // b - 2
        // c - 2
        // d -
        Map<String, Long> ans = Arrays.stream(str.split("")).collect(Collectors.groupingBy(Function.identity(), LinkedHashMap::new, Collectors.counting()));
        System.out.println("check " + ans);
        Map.Entry<String, Long> result = ans.entrySet().stream().filter(entry -> entry.getValue() == 1).findAny().get();
        System.out.println("result " + result.getKey());

       // System.out.println(ans);

    }

    public static int lengthOfLongestSubstring(String str) {
        int maxLength = 0;
        int start = 0;
        int i = 0;
        Set<Character> set = new HashSet<>();
        while (i<str.length()){
            if(!set.contains(str.charAt(i))){
                set.add(str.charAt(i));
                i++;
            }else{
                set.remove(str.charAt(start));
                start++;
            }

            maxLength = Math.max(i - start, maxLength);

        }

        return maxLength;
    }


}
