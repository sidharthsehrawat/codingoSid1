package revision.recursion;

import java.util.ArrayList;
import java.util.List;

public class Subsets {
    public static void main(String[] args) {
        int[] num = {1,2,3};

        List<List<Integer>> ans = subsets(num);
        System.out.println("ans : " + ans);
    }

    private static List<List<Integer>> subsets(int[] num) {
        int index = 0;
        List<Integer> list = new ArrayList<>();
        List<List<Integer>> finalAns = new ArrayList<>();
        helperFunc(num , index, list, finalAns);
        return finalAns;
    }

    private static void helperFunc(int[] num, int index, List<Integer> list, List<List<Integer>> finalAns) {
        if(index >num.length){
            return;
        }

        if(index == num.length){
            finalAns.add(new ArrayList<>(list));
            return;
        }

        list.add(num[index]);
        helperFunc(num, index+1, list, finalAns);
        list.remove(list.size()-1);
        helperFunc(num, index+1, list,finalAns);
    }
}
