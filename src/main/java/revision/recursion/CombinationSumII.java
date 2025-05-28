package revision.recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSumII {
    public static void main(String[] args) {
        int[] num = {1, 1, 1, 2, 2, 3};
        int target = 7;

        List<List<Integer>> res = combination(num, target);
        System.out.println("res " + res);
    }

    private static List<List<Integer>> combination(int[] num, int target) {
        Arrays.sort(num);
        List<List<Integer>> finalList = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        int index = 0;
        helper(num, target, index, list, finalList);
        return finalList;
    }

    private static void helper(int[] num, int target, int index, List<Integer> list, List<List<Integer>> finalList) {
        if (target == 0) {
            finalList.add(new ArrayList<>(list));
            return;
        }
        for (int i = index; i < num.length; i++) {
            if(i>index && num[i]==num[i-1]){
                continue;
            }
            if(num[i] > target) break;

            list.add(num[i]);
            helper(num, target - num[i], i+1  ,list,finalList);
            list.remove(list.size()-1);
        }
    }
}