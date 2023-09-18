package Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class TestExam {
    public static void main(String[] args) {

      //  How to Find all Pairs in Array of Integers Whose sum is Equal to a Given Number ?

        int[] numbers = { 2, 4, 3, 5, 7, 8, 9, -2 ,-11};
         int target = 7;
        Map<Integer , Integer> map = new HashMap<>();
        // adding data to map.
        for(int i =0; i<numbers.length; i++){
            map.put(numbers[i], 1);
        }
        for(int i=0;i<numbers.length;i++){
            if(map.containsKey(target-numbers[i])){
                System.out.println("(" + numbers[i] + "," + (target-numbers[i]) + ")");
                 map.remove(numbers[i]);
            }
        }


    }
}
