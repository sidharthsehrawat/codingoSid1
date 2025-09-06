package your;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Test1 {
    public static void main(String[] args) {
        // 1st Question
       //  Find char with max count from String "AABCA", here output should be A
        String s = "BBBAAACCDDD";
        Map<String, Long> res = Arrays.stream(s.split("")).collect(Collectors.groupingBy(Function.identity(),  LinkedHashMap::new, Collectors.counting()));
        Optional<Map.Entry<String, Long>> res1 = res.entrySet().stream().findFirst();
        System.out.println("res " + res1.get());

//  ========================================================================================================
        // 2nd Question.
       //  Find the largest odd repetitions from below integer array.
       //  Input : arr = {1,1,1,2, 2,2, 3, 2, 3, 1, 3,4,4,4,4,4,5,5,5,5,5,5,5, 7, 7, 7}

        /// 1 = 4
        /// 2 = 4
        /// 3 = 3 odd
        /// 4 = 5 odd
        /// 5 = 7 odd
        /// 7 = 3

        int[] arr =  {1,1,1,2,2,2,3,2,3,1,3,4,4,4,4,4,5,5,5,5,5,5,5,7,7,7};

        int[] result = new int[100];

        // Count frequencies
        for(int i : arr){
            result[i]++;
        }

        int max = -1;
        int num = -1;

        for(int i = 0; i < result.length; i++){
            if(result[i] % 2 == 1) { // Only odd counts
                if(result[i] > max){
                    max = result[i];
                    num = i;
                }
            }
        }

        System.out.println("Number with largest odd count: " + max + ", count: " + num);

        //


        TreeSet<Object>  set = new TreeSet<>();
        set.add("One");
        set.add(1);

        System.out.println();
    }

}
