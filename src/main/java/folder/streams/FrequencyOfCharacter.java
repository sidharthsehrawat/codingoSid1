package folder.streams;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FrequencyOfCharacter {

    public static void main(String[] args) {

        String str = "abcad";
        Map<String, Long> res= Arrays.stream(str.split("")).collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        System.out.println(res);

        List<String> list = Arrays.asList("Sid","Sid" ,"ash", "ok");
        List<String> ans = list.stream().sorted().collect(Collectors.toList());
    }
}
