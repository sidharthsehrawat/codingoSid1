package folder;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TestPra {
    public static void main(String[] args) {
       // int arr[] = { 2,2,2,2};
        int arr[] = {1,0,-1,0,-2,2};

        Arrays.sort(arr);
        int target  = 0;
        int f1 = 0;
        int l1 = arr.length- 1;
        List<List<Integer>> finalList = new ArrayList<>();
        while (f1<l1){

            int f2 = f1+ 1;
            int l2 = l1 -1;
            while (f2<l2){
                if(arr[f1] + arr[l1] + arr[f2] + arr[l2] == target){
                     List<Integer> list = new ArrayList<>();
                     list.add(arr[f1]);list.add(arr[f2]);list.add(arr[l1]);list.add(arr[l2]);
                     finalList.add(list);
                     f2++;
                     l2--;
                }else if(arr[f1] + arr[l1] + arr[f2] + arr[l2] < target){
                    f2++;
                }else if(arr[f1] + arr[l1] + arr[f2] + arr[l2] > target){
                   l2--;
                }
            }
            f1++;
            l1--;
        }

        System.out.println("Output : " + finalList);
    }
}
