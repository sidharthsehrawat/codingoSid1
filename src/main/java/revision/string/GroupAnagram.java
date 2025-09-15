package revision.string;

import java.util.*;

public class GroupAnagram {
    public static void main(String[] args) {
        Map<Set<Character>, List<String>> map  = new HashMap<>();
        List<String> list = Arrays.asList("cat", "dog", "god");
        List<List<String>> res = groupAnagram(list);
        System.out.println(res);
    }

    private static List<List<String>> groupAnagram(List<String> list) {
        Map<Set<Character>, List<String>> map  = new HashMap<>();
        for (String s : list){
            Set<Character> set = new HashSet<>();
            char[] ch = s.toCharArray();
            for (char c : ch){
                set.add(c);
            }
            if(!map.containsKey(set)){
                List<String > l = new ArrayList<>();
                l.add(s);
                map.put(set,  l);
            }else {
               List<String> li =  map.get(set);
               li.add(s);
               map.put(set, li);
            }
        }
        List<List<String>> finalList = new ArrayList<>();
        for(Map.Entry<Set<Character>, List<String>> entry : map.entrySet()){
            finalList.add(entry.getValue());
        }
        return finalList;
    }
}
