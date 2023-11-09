package folder.array;

import java.util.ArrayList;
import java.util.List;

public class ClimbStairsGetList {
    public static void main(String[] args) {
        int n = 3;
        int res = climbStairs(n);
        System.out.println("Output : " + res);
    }

    public static int climbStairs(int n) {
       List<String> res = helper(n);
        System.out.println(res);
        return res.size();
    }


    public static List<String> helper(int num ) {
        if (num < 0) {
            return new ArrayList<>();
        }
        if (num == 0) {
            List<String> list1 = new ArrayList<>();
            list1.add("");
            return list1;
        }

      List<String> l1 =  helper(num - 1 );
      List<String> l2 =  helper(num - 2 );
      List<String> finalList = new ArrayList<>();
      for(String n1 : l1){
          finalList.add(n1+1);
      }
        for(String n2 : l2){
            finalList.add(n2+2);
        }
        return finalList;
    }
}
