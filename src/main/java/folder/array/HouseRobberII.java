package folder.array;

public class HouseRobberII {
    public static void main(String[] args) {
        int[] arr = {1, 2, 1, 1}; // [200,200,340,340]
        int res = rob(arr);
        System.out.println(res);
        reverse(arr);
        int res1 = rob(arr);
        System.out.println(res1);

    }

    public static int rob(int[] nums) {
        if (nums[0] < nums[nums.length - 1]) {
            reverse(nums);
        }

        if (nums.length == 1) {
            return nums[0];
        } else if (nums.length == 2) {
            return Math.max(nums[0], nums[1]);
        } else if (nums.length == 3) {
            return Math.max(Math.max(nums[0], nums[2]), nums[1]);
        }

        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);
        dp[2] = Math.max(nums[0] + nums[2], nums[1]);
        for (int i = 3; i < nums.length; i++) {
            if (nums[i] + dp[i - 2] > dp[i - 1]) {
                dp[i] = nums[i] + dp[i - 2];
            } else {
                dp[i] = dp[i - 1];
            }
        }

        return dp[dp.length - 2];

    }

    public static void reverse(int[] nums) {
        int i = 0;
        int j = nums.length - 1;
        while (i < j) {
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
            i++;
            j--;
        }

    }
}

