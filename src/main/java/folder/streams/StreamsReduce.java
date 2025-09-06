package folder.streams;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class StreamsReduce {
    public static void main(String[] args) {

        List<String> list = Arrays.asList("Sid", "aidh", "Sidhassdsdsrt", "Sehrawat");
        Optional<String> ans = list.stream().reduce((w1, w2) -> (w1.length() > w2.length() )  ? w2 : w1);
        ans.ifPresent(System.out::println);


        // Given a collection of numbers, find average of squares which are greater than 10000.
        //Integer[] arr = {100,24,13,44,114,200,40,112};

        Integer[] arr = {100,24,13,44,1,200,40,2};
        double res = Arrays.stream(arr).map(m -> m*m).filter(n-> n>10000).mapToInt(s->s).average().getAsDouble();

        System.out.println(" result " + res);
    }
}
