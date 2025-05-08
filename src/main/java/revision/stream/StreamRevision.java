package revision.stream;

import java.util.*;
import java.util.stream.Collectors;

public class StreamRevision {
    public static void main(String[] args) {
        Map<String, Integer> map = new HashMap<>();
        map.put("apple", 3);
        map.put("banana", 1);
        map.put("cherry", 2);

        LinkedHashMap<String, Integer> list = map.entrySet().stream().sorted(Map.Entry.comparingByValue())
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new));

        List<Map.Entry<String,Integer>> mapList = new ArrayList<>(map.entrySet());
        mapList.sort(Map.Entry.comparingByValue());
        Map<String,Integer> linkedHashMap  = new LinkedHashMap<>();
        for(Map.Entry<String,Integer> entry : mapList){
            linkedHashMap.put(entry.getKey(), entry.getValue());
        }

        System.out.println(linkedHashMap);

    }
}
