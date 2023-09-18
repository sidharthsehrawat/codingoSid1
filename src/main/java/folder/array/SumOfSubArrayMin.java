package folder.array;

import java.util.PriorityQueue;
import java.util.Queue;

public class SumOfSubArrayMin {
    public static void main(String[] args) {

        char opr= '*';
        char o1 ='2';
        char o2= '3';
        int res11 = Integer.valueOf(String.valueOf(o1)) * Integer.valueOf(String.valueOf(o2));
         int n =1;
         char n1 =  (char) n;
        int arr[] = {3,1,2,4};
        int res = sumSubarrayMins(arr);
        System.out.println(res);
    }

    public static int sumSubarrayMins(int[] arr) {
        //use 2 loops for subarrays
        // use PQ and then add sum in var..
        Queue<Integer> pq= new PriorityQueue<>();
        int sum =0;

        for(int i=0;i<arr.length;i++){
            for(int j=i;j<arr.length;j++){
                pq.add(arr[j]);
                sum =sum+ pq.peek();
            }
            pq.clear();
        }

        return sum;
    }
}
