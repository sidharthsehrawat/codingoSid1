package folder.streams;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class FreqOFCharWithMostValue {
    public static void main(String[] args) {
        int[] arr = {2,1,3,4,5,2,3,2};
        Map.Entry<Integer, Long> res = Arrays.stream(arr).boxed()
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting())).entrySet().stream().sorted(Map.Entry.comparingByValue(Comparator.reverseOrder())).findFirst().get();
        System.out.println(res.getKey() + " = " + res.getValue());
    }
}
