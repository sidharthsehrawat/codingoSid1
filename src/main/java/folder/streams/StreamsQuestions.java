package folder.streams;

import java.util.*;
import java.util.stream.Collectors;

public class StreamsQuestions {
    public static void main(String[] args) {
        // 77. Remove duplicates case-insensitively from a list:
        List<String> input = Arrays.asList("Java", "JAVA", "JaVa", "Kotlin");
        input.stream().collect(Collectors.collectingAndThen(Collectors.toMap(
                        s -> s.toUpperCase(),
                        s -> s,
                        (a, b) -> a,
                        LinkedHashMap::new
                ),
                m -> new ArrayList<>(m.values())
        ));
        // 2nd approach
        List<String> ans = input.stream().map(s -> s.toLowerCase()).distinct().collect(Collectors.toList());
        System.out.println(" ans " + ans);


        // Group strings by their first letter:
        List<String> input1 = Arrays.asList("dog", "deer", "cat", "cow");
        Map<Character, List<String>> res = input1.stream().collect(Collectors.groupingBy(s -> s.charAt(0)));
        System.out.println("res" + res);

        // Convert a list of objects into a map:
        List<String> input2 = Arrays.asList("dog", "deer", "cat", "cow");


        // Find duplicate elements in a list:
        List<String> input3 = Arrays.asList("A", "A", "B", "C");
        Set<String> set = new HashSet<>();
        Set<String> res1 = input3.stream().filter(s -> !set.add(s)).collect(Collectors.toSet());
        System.out.println(res1);


        // PArtition into even and odd..
        List<Integer> nums = Arrays.asList(1, 2, 3, 4, 5);
        Map<Boolean, List<Integer>> ans3 = nums.stream().collect(Collectors.partitioningBy(num -> num % 2 == 0));
        System.out.println("res" + ans3);


        List<List<String>> nested = Arrays.asList(
                Arrays.asList("A", "B"),
                Arrays.asList("C", "D")
        );

        List<String> ans4 = nested.stream().flatMap(List::stream).collect(Collectors.toList());
        System.out.println(ans4);

        // find the longest string
        List<String> list = Arrays.asList("dog", "elephant", "cat");
        String ans5 = list.stream().reduce((a, b) -> (a.length() > b.length()) ? a : b).get();
        System.out.println("max len " + ans5 );

        //Get distinct sorted characters from a list of words:
        List<String> input4 = Arrays.asList("dog", "cat");
        input4.stream().flatMapToInt(String::chars)
                .mapToObj(c-> (char)c).distinct().sorted();
    }
}