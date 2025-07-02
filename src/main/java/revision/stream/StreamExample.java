package revision.stream;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class StreamExample {
    public static void main(String[] args) {
        List<String> listString= Arrays.asList("Apple","Banana","Orange","Papaya");
        Map<String, Integer> ans = listString.stream().collect(Collectors.toMap(
                str -> str,
                str -> (int) str.toLowerCase().chars().distinct().count()
        ));
        System.out.println(" ans " + ans);
    }
}
