package folder.strings;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LongestRepeatingCharacterReplacement {
    public static void main(String[] args) {
        String str = "AABABBA";
        str = str + 'a';

        int k = 1;
        if(Character.isAlphabetic('1')){
            System.out.println();
        } if(Character.isAlphabetic('A')){
            System.out.println();
        } if(Character.isAlphabetic('a')){
            System.out.println();
        } if(Character.isAlphabetic('%')){
            System.out.println();
        } if(Character.isLetter('`')){
            System.out.println();
        }if(Character.isLetter('1')){
            System.out.println();
        }if(Character.isLetter('a')){
            System.out.println();
        }if(Character.isLetter('A')){
            System.out.println();
        }if(Character.isLetter('@')){
            System.out.println();
        }
        Map<String, List<String>> map = new HashMap<>();
        List<String> list = new ArrayList<>();
        list.add("Sid");
        list.add("Sid2");
        map.put("Sid" ,list);

        List<String> list1 = new ArrayList<>();
        list1.add("Kid");
        list1.add("Kid1");
        map.put("Kid" ,list1);

        List<List<String>> fin = new ArrayList<>(map.values());
        System.out.println(fin);

    }
}
