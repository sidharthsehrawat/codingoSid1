package revision.recursion;

import java.util.Arrays;

public class Fibonacci {
    public static void main(String[] args) {
        int num = 7;
        //int ans = printFibo(num);
        //System.out.println("ans " + ans);
        int[] dp = new int[num];
        Arrays.fill(dp, -1);
        int ans = printFiboDP(num, dp);
        System.out.println("ans " + ans);
    }

    private static int printFiboDP(int num, int[] dp) {
        if (num <= 1) {
            dp[num] = num;
            return num;
        }
        if (dp[num] != -1) {
            return dp[num];
        }
        dp[num] = printFiboDP(num - 1, dp) + printFiboDP(num - 2, dp);
        return dp[num];
    }

    private static int printFibo(int num) {
        if (num <= 1) {
            return num;
        }
        int last = printFibo(num - 1);
        int slast = printFibo(num - 2);
        return last + slast;
    }
}
