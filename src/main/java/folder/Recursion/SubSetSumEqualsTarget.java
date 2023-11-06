package folder.Recursion;

import java.util.ArrayList;
import java.util.List;

public class SubSetSumEqualsTarget {
    public static void main(String[] args) {
        int [] arr = {3,1,1,7,6,3,5,4};
        int target = 9;
        int len = arr.length-1;
        int res = subarraySum(arr,target,0);
        System.out.println("count : " + res);
    }
    private static int ans =0;
    public static int subarraySum(int[] nums, int target, int index) {
        List<Integer> list = new ArrayList<>();
         helper(nums,target,index,list);
        return ans;
    }
    public static boolean helper(int [] nums,int target, int index,List<Integer> list){
        if(target == 0){
            ans++;
            System.out.println(list);
            return true;
        }
        if(  index >=nums.length){
            return false;
        }

        list.add(nums[index]);
        boolean include = helper(nums,target-nums[index], index+1,list);
        list.remove(list.size()-1);
        boolean exclude = helper(nums,target, index+1,list);
        return include || exclude;
    }
}
