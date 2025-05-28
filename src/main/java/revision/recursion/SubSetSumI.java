package revision.recursion;

import java.util.ArrayList;
import java.util.List;



public class SubSetSumI {
    public static void main(String[] args) {
        int[] arr = {1,2};
        List<Integer> res = subset(arr);
        System.out.println("ans " + res);

    }

    private static List<Integer> subset(int[] arr) {
        int index = 0;
        List<Integer> list = new ArrayList<>();
        int sum = 0;
        helperFunc(arr, sum, index, list);
        return list;
    }

    private static void helperFunc(int[] arr,int sum ,int index, List<Integer> list) {
        if(index>arr.length) return;

        if(index == arr.length){
            list.add(sum);
            return;
        }
        helperFunc(arr, sum + arr[index], index+1, list);
        helperFunc(arr, sum, index+1, list);
    }
}
