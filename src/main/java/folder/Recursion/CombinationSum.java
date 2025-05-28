package folder.Recursion;

import java.util.ArrayList;
import java.util.List;

public class CombinationSum {
    public static void main(String[] args) {
        int[] arr = {2, 5, 3, 7};
        int target = 7;
        // [2,2,3] , [7]
        int index = 0;
        List<Integer> list = new ArrayList<>();
        int sum = 0;

        fun(arr, index, list, 0, target);
    }

    private static void fun(int[] arr, int index, List<Integer> list, int sum ,int target) {

        if (index >= arr.length || sum>target) {
            if ( sum == target) {
                System.out.println(list);
            }
        }

        list.add(arr[index]);
        fun(arr, index+1, list, sum+ arr[index], target);
        list.remove(list.size() - 1);
        fun(arr, index + 1, list,sum, target);
    }
}
