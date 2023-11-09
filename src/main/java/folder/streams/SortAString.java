package folder.streams;

import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class SortAString {
    public static void main(String[] args) {
        String str = "CADB";
        str = Arrays.stream(str.split("")).sorted().collect(Collectors.joining());
        System.out.println(str);
    }
}
