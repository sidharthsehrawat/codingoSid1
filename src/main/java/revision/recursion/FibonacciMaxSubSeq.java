package revision.recursion;

import java.util.HashMap;
import java.util.Map;

public class FibonacciMaxSubSeq {
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6,7,8};
        int result = lenLongestFibSubseq(arr);
        System.out.println(result);
    }

    public static int lenLongestFibSubseq(int[] arr) {
        int maxLength = 0;
        Map<Integer, Integer> map = new HashMap<>();
        int index = 0;
        for (int num : arr) {
            map.put(num, index++);
        }
        for (int j = 1; j < arr.length; j++) {
            for (int k = j + 1; k < arr.length; k++) {
                int result = fibo(arr, j, k, map);
                if (result >= 3) {
                    maxLength = Math.max(maxLength, result);
                }
            }
        }
        return maxLength;
    }

    public static int fibo(int[] arr , int j, int k, Map<Integer,Integer> map) {
        int target =  arr[k] - arr[j];
        if(map.containsKey(target) && map.get(target)< j){
            int index = map.get(target);
            return fibo(arr, index, j, map) + 1;
        }
        return 2;
    }
}
