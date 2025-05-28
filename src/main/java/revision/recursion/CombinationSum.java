package revision.recursion;

import java.util.ArrayList;
import java.util.List;

public class CombinationSum {
    public static void main(String[] args) {
        int[] num = {2,3,4} ;
        int target = 7;

        List<List<Integer>> res= combination(num, target);
        System.out.println("res " + res);
    }

    private static List<List<Integer>> combination(int[] num, int target) {
        int index = 0;
        List<List<Integer>> finalList = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        helper(num,index,target,list,finalList);
        return finalList;
    }

    private static void helper(int[] num, int index, int target, List<Integer> list, List<List<Integer>> finalList) {
        if(index>=num.length || target<0){
            return;
        }
        if(target == 0){
            finalList.add(new ArrayList<>(list));
            return;
        }
        list.add(num[index]);
        helper(num,index,target-num[index], list,finalList);
        list.remove(list.size()-1);
        helper(num, index+1, target, list, finalList);
    }
}
