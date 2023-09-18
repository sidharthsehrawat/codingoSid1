package folder.DP;

import java.util.HashSet;
import java.util.Set;

public class DiceTargetSum {

    public static void main(String[] args) {
        int d = 3;
        int face = 4;
        int target = 5;
        int res = getCombination(d, face, target);
        System.out.println("dice ans = " + (res));
    }
    private static int getCombination(int n, int k, int target) {
        Integer[][] mem = new Integer[n+1][target+1];
         int ans = helper(n ,k, target, mem);
            return ans;
        // 113 122 131  212 221 311
    }

    private static int helper(int d, int k, int target, Integer[][] mem) {

        if (d == 0 && target == 0) {
            return 1;
        }

        if (d < 0 || target < 0) {
            return 0;
        }

        if(mem[d][target]!=null ){
            return mem[d][target];
        }
        int count = 0;

        for (int x = 1; x <= k; x++) {
            int r = helper(d - 1, k, target - x, mem);
            count += r;
        }

        mem[d][target] = count;
        return count;
    }
}
