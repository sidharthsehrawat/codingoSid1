package Test;

import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;

public class TestCof {
    public static void main(String[] args) {
       // int[] arr = {5, 1, 3, 5, 2, 3, 4, 1};
        String arr = "51352341";
        //int[] arr = { 1, 2, 4, 4, 5, 6, 7, 8, 3, 4, 5, 3, 3, 4, 5, 6, 7, 8, 1, 2, 3, 4};

        // max length ; 5, 2, 3, 4, 1  ans  = 5 ;  O(n2)..
       // max  = 4
       //start = 1
      /*
       map

       1,1
       5,3
       2,4
       3,5
       4,6
       */

      /*  String s = "51352341";
        HashSet<Character> set = new HashSet();
        int i =0;
        int j=0;
        int max=0;
        while (j<s.length()){
            if(!set.contains(s.charAt(j))){
                set.add(s.charAt(j));
                max = Math.max(set.size(),max);
                j++;
            }else{
                set.remove(s.charAt(i));
                i++;
            }
        }*/
     LinkedHashMap<Integer, Integer> map = new LinkedHashMap<>();
        int start = 0;
        int max = 0;  // 1 2 3 4 5
        for (int i = 0; i < arr.length(); i++) {
            for(Map.Entry<Integer,Integer>  entry : map.entrySet()){
                int count=0;
                if(entry.getValue()>start){
                    count++;
                }
                max = Math.max(max,count);
            }
           // max = map.size();
            int num = arr.charAt(i);
            if(!map.containsKey(num)){
                map.put(num,i);
                max++;
            }else{
                if(map.get(num) > start){
                    start =map.get(num)+1;
                    map.put(num,i);
                }else {
                    map.put(num,i);
                }
            }
           // max = Math.max(max, map.size());
        }
        System.out.println("Max " + max);
    }
}
