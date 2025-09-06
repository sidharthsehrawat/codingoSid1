package folder.streams;

import java.util.*;
import java.util.stream.Collectors;

public class PrintSumOfAllNumbers {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1,2,3,4,5);
        // Sum of integers.
        Optional<Integer> sum = list.stream().reduce((a,b) -> a+b);
        int sum1 = list.stream().mapToInt(Integer::intValue).sum();
        System.out.println("sum is : " + sum.get());

        // Avg of integers.
        OptionalDouble avg = list.stream().mapToInt(e -> e).average();
        System.out.println("Avg is : " + avg.getAsDouble());

        // Sqrt of integers and filter greater than 10 and then find avg .
        OptionalDouble res = list.stream().map(a -> a*a).filter(a -> a > 5).mapToDouble(e -> e).average();
        System.out.println("List integers greater than 2 : " + res);

        //print odd and Even .
        List<Integer> even = list.stream().filter(a -> a % 2 == 0).collect(Collectors.toList());
        System.out.println("Even : " + even);

        //print numbers start with 2.
        List<Integer> ans = list.stream().map(String::valueOf)
                .filter(a -> a.startsWith("2"))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
        System.out.println("Integeres starts with 2 :"  + ans);

        //print duplicate numbers .
        List<Integer> list2 = Arrays.asList(1,2,2,3,4,4,5);
        Set<Integer> ans1 = list2.stream().filter(e-> Collections.frequency(list2, e)>1).collect(Collectors.toSet());
        System.out.println("Duplicate :" + ans1);

        Set<Integer> set = new HashSet<>();
        Set<Integer> ans3 = list2.stream().filter(e -> !set.add(e)).collect(Collectors.toSet());
        System.out.println("Duplicate by Set  : " + ans3);

        //Min and max using streams
        List<Integer> list3 = Arrays.asList(8,2,9,4,5);
        int max = list3.stream().max(Comparator.comparing(Integer::valueOf)).get();
        System.out.println("max no " + max);

        int max1 = list3.stream().reduce((a, b)-> (a>b) ? a: b).get();
        System.out.println("max by reduce : "+ max1);

        // Skip and reduce using streams.
        List<Integer> list4 = Arrays.asList(1,2,3,4,5,6);
        int sumlm = list4.stream().limit(2).reduce((a,b)-> a+b).get();
        System.out.println("Limit : " + sumlm);

        // 2nd highest .
        List<Integer> list5 = Arrays.asList(1,4,3,2,5); // 5 4 3 2 1
        int secHigh = list5.stream().sorted(Collections.reverseOrder()).skip(1).findFirst().get();
        int secLow = list5.stream().sorted().skip(1).findFirst().get();
        System.out.println("2nd Highest no  : " + secHigh);
        System.out.println("2nd Lowest  no  : " + secLow);

    }
}
