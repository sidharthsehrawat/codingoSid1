
package Test;

import java.util.ArrayList;
import java.util.List;

public class PatternExped {
    public static void main(String[] args) {
        int k  = 7;
        generate(k);
    }

    private static void generate(int k) {
        List<Integer> list = new ArrayList<>();
        int count =0;
            for(int i =0;i<k;i++){
                if(count<2){
                    list.add(1);
                    count++;
                }else {
                    break;
                }
            }
            // [1 1]
        List<Integer> finalList = new ArrayList<>();
        System.out.println(list);
        if(k>2){
            for(int i =2;i<k;i++){
                finalList.add(1);
                for(int j =1 ;j<list.size();j++){
                    finalList.add(list.get(j)+list.get(j-1));
                }
                list.clear();
                finalList.add(1);
                list.addAll(finalList);
                System.out.println(finalList);
                finalList.clear();
            }
        }
    }
}


/*

Write a function which takes a value k and prints the numbers in the following pattern:

If K = 5

1
1 1
1 2 1
1 3 3 1
1 4 6 4 1


*/
