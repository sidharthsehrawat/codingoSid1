package folder.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PascalTriangle {
    public static void main(String[] args) {
        int n = 5;
        List<List<Integer>> res =  PascalFun(n);
        for(List<Integer> l : res){
            System.out.print(" " + l);
        }
        System.out.println();
    }
    // 1
    // 1 1
    // 1 2 1
    // 1 3 3 1
    // 1 4 6 4 1

    private static List<List<Integer>> PascalFun(int n) {
        List<List<Integer>> finalList = new ArrayList<>();
        if(n >=1){
            finalList.add(Arrays.asList(1));
        }
        if(n >=2){
            finalList.add(Arrays.asList(1,1));
        }else return finalList;

        for (int i = 3 ; i<=n; i++){
            List<Integer> list = new ArrayList<>(3);
                list.add(finalList.get(i-2).get(i-2) + finalList.get(i-2).get(i-1));
                list.add(finalList.get(i-2).get(i-2) + finalList.get(i-2).get(i-1));
        }
        return finalList;
    }
}
