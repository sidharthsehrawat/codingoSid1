package revision.array;

import java.util.*;

public class ThreeSum {
    public static void main(String[] args) {
        int[] arr = {-1, 0, 1, 2, -1, -4};
        List<List<Integer>> res = threeSum(arr);
        System.out.println(res);
    }

    public static List<List<Integer>> threeSum(int[] nums) {

        // [ -1, 0, 1, 2, -1, -4 ]
        // sort the array
        // [ -4, -1, -1, 0, 1, 2 ]
        //            i  j     k
        List<List<Integer>> ans = new ArrayList<>();

        Arrays.sort(nums);
        int i = 0;
        int j = i+1;
        int k = nums.length-1;

        while(j<=k){
            if(nums[i] + nums[j] + nums[k] == 0){
                List<Integer> res =  new ArrayList<>();
                res.add(nums[i]);
                res.add(nums[j]);
                res.add(nums[k]);
                ans.add(res);
                i++;
                j++;
                k--;

            }else if(nums[i] + nums[j] < nums[k]){
                i++; j++;
            }
            
        }

        return ans;
    }
}
