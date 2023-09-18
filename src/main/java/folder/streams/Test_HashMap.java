package folder.streams;

import javax.swing.text.html.parser.Entity;
import java.util.*;
import java.util.stream.Collectors;

public class Test_HashMap {
    public static void main(String[] args) {
        Map<Integer,Integer> map = new HashMap<>();
        map.put(1,2);
        map.put(3,1);
        map.put(2,4);
        map.put(4,3);
        String s = "a";
        String c = s+ "c";
        System.out.println(s);
        System.out.println(c);
        String s1 = new String("a");
        String s2 = new String(s1);
        System.out.println(s2);

       // s1="ab";
        System.out.println(s1);
      /*  LinkedHashMap<Integer, Integer> res = map.entrySet().stream().sorted(((o1, o2) -> {
            return o1.getValue().compareTo(o2.getValue());
        })).collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (o1, o2) -> o1, LinkedHashMap::new));*/

        LinkedHashMap<Integer, Integer> ma = map.entrySet().stream()
                .sorted(((o1, o2) -> {
                    return o1.getValue().compareTo(o2.getValue());
                }))
                .collect(Collectors
                        .toMap(Map.Entry::getKey, Map.Entry::getValue, (o1, o2) -> o1, LinkedHashMap::new));
        

        List<Map.Entry<Integer,Integer>> list = new LinkedList<>(map.entrySet());
        Collections.sort(list, new Comparator<Map.Entry<Integer, Integer>>() {
            @Override
            public int compare(Map.Entry<Integer, Integer> o1, Map.Entry<Integer, Integer> o2) {
                return o1.getValue().compareTo(o2.getValue());
            }
        });

        Map<Integer,Integer> linkedMap = new LinkedHashMap<>();
        for(Map.Entry<Integer,Integer> entry : list) {
            linkedMap.put(entry.getKey(),entry.getValue());
        }

        //  System.out.println(linkedMap);


}
}
