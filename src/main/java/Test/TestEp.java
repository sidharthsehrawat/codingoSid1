package Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TestEp {
    public static void main(String[] args) {
        String num = "41716204";
        String search = "24610";
        Map<Character, List<Integer>> map = new HashMap<>();

        for(int i=0;i<num.length();i++){
            if(!map.containsKey(num.charAt(i))){
                List<Integer> list = new ArrayList<>();
                list.add(i);
                map.put(num.charAt(i), list);
            }else{
                List<Integer> lis = map.get(num.charAt(i));
                lis.add(i);
                map.put(num.charAt(i), lis);
            }
        }


        for(int i =0;i< search.length();i++){
            if(map.containsKey(search.charAt(i))){
                System.out.println(search.charAt(i) +" :" +  map.get(search.charAt(i)));
            }
    }

    }

}
