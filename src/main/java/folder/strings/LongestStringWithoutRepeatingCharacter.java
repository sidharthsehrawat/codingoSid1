package folder.strings;

import java.util.HashSet;
import java.util.Set;

public class LongestStringWithoutRepeatingCharacter {
    public static void main(String[] args) {
        String str = "ABCDEFGABEF";
        String str1 = "GEEKSFORGEEKS";

        // Pattern Sliding Window

        int res = function(str);
        System.out.println("maxSize : " + res);


    }

    public static int function(String str){
        Set<Character> set = new HashSet<>();
        //A B C D E F G  max = 7

        int i =0 ;
        int j=0;
        int maxSize =0;
        while (i<str.length()){
            if(!set.contains(str.charAt(i)) ){
                set.add(str.charAt(i));
                i++;
            }else {
                set.remove(str.charAt(j));
                j++;
            }
            maxSize = Math.max(maxSize,set.size());
        }

       return maxSize ;
    }

}
