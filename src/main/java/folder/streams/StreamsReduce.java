package folder.streams;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class StreamsReduce {
    public static void main(String[] args) {

        List<String> list = Arrays.asList("Sid", "aidh", "Sidhassdsdsrt", "Sehrawat");
        Optional<String> ans = list.stream().reduce((w1, w2) -> (w1.length() > w2.length() )  ? w2 : w1);
        ans.ifPresent(System.out::println);
    }
}
