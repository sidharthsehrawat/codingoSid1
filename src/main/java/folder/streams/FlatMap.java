package folder.streams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FlatMap {
    public static void main(String[] args) {
        List<String> list = Arrays.asList("Apple","Cards");
        List<Character> listchar =  list.stream().flatMap(word-> word.chars().mapToObj(ch->(char)ch)).collect(Collectors.toList());
        System.out.println(listchar);

        Predicate<Integer> predicate = e -> e%3==0;
        boolean res = Stream.iterate(0, n -> n + 2).limit(10).allMatch(predicate);
        System.out.println(res);

        List<List<String>> newlist = new ArrayList<>();
        List<String> l1 = new ArrayList<>();
        l1.add("ab");

        List<String> l2 = new ArrayList<>();
        l2.add("cd");
        l2.add("ef");

        newlist.add(l1);
        newlist.add(l2);

       List<String> ans =  newlist.stream().flatMap(words -> words.stream()).collect(Collectors.toList());
        System.out.println(ans);



    }
}
