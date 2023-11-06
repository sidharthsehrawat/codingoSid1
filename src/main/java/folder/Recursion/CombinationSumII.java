package folder.Recursion;

import java.util.*;

public class CombinationSumII {
    public static void main(String[] args) {
        int[] arr = {10,1,2,7,6,1,5};
        int target = 8;
        int index = 0;
        Arrays.sort(arr);
        List<Integer> list = new ArrayList<>();
        fun(arr, index, list, target);
    }

    private static void fun(int[] arr, int index, List<Integer> list ,int target) {
            if (target==0) {
                System.out.println(list);
                return;
            }

        for(int i  = index ;i<arr.length ;i++){
            if(i>index && arr[i] == arr[i-1]) continue;
            if(arr[i]>target) break;

            list.add(arr[i]);
            fun(arr, index+1, list,  target-arr[i]);
            list.remove(list.size() - 1);
        }
    }
}
