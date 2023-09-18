package folder.streams;

import java.util.stream.Collectors;
import java.util.stream.Stream;

public class SortAString {
    public static void main(String[] args) {
        String str = "CADB";
        str = Stream.of(str.split(""))
                .sorted()
                .collect(Collectors.joining());
        System.out.println(str);
    }
}
