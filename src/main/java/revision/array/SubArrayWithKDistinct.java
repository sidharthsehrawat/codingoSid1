package revision.array;

import java.util.HashSet;
import java.util.Set;

public class SubArrayWithKDistinct {
    public static void main(String[] args) {
        int[] nums = {2,1,2,1,2};
        int k = 2;
        int res = subarraysWithKDistinct(nums, k);
        System.out.println("res " + res);
    }
    public static int subarraysWithKDistinct(int[] nums, int k) {
        // [1,2] [1,2,1] [1,2,1,2] [2,1] [2,1,2] [1,2] [2,3].
        // use 2 loops and find all possible subarrays with count k.
        Set<Integer> set = new HashSet<>();
        int count = 0;
        for (int i = 0; i < nums.length-k+1; i++) {
            for (int j = i; j < nums.length; j++) {
                if (!set.contains(nums[j])) {
                    set.add(nums[j]);
                }
                if (set.size() == k) {
                    count++;
                } else if (set.size() > k) {
                    set.clear();
                    break;
                }
            }
        }
        return count;
    }
}
