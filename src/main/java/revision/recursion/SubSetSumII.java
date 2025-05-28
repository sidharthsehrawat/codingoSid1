package revision.recursion;

import java.util.ArrayList;
import java.util.List;

public class SubSetSumII {
    public static void main(String[] args) {
        int num[] = {1, 1, 2, 3, 3};
        List<List<Integer>> ans = subsetSum(num);
        System.out.println("ans " + ans);
    }

    private static List<List<Integer>> subsetSum(int[] num) {
        int index = 0;
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        helper(num, index, list, ans);
        return ans;
    }

    private static void helper(int[] num, int index, List<Integer> list, List<List<Integer>> ans) {
        ans.add(new ArrayList<>(list));

        for (int i = index; i < num.length; i++) {
            if (i != index && num[i] == num[i - 1]) {
                continue;
            }
            list.add(num[i]);
            helper(num, i + 1, list, ans);
            list.remove(list.size() - 1);
        }
    }
}
