package Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

public class TestMobi {


    //  Q1.
    // Given an array nums, there is a sliding window of size k which is moving from the very left of the array to the very right.
    //  You can only see the k numbers in the window. Each time the sliding window moves right by one position, Print the max sliding window.

    // Input: vals = [1,3,-1,-3,5,3,6,7], and k = 3
    // Output -res =  [3 ,3, 5, 5, 6, 7]
    //  List<Integers>
    // space : max
    //DS : (k nums)

    //Soln -  Use 2 loops Brute force approach

    //TC - O(N2) : //
    //SC - O(N) :

    //TC - PQ (NlogK) re-shufling : + (logK)
    //SC - O(K)

    //     3
    //   1, 3,-3

    //Code - PQ max heap(k) //


    public static void main(String[] args) {

        int[] arr = {1, 3, -1, -3, 5, 3, 6, 7};
        int k = 3;

     // 1->3

        List<Integer> result = function(arr, k);
        System.out.println(" Result : " + result);
    }

    private static  List<Integer> function(int[] arr, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
          if(pq.size()<k){
              pq.add(arr[i]);
          }else{
              list.add(pq.peek());
              pq.remove(arr[i-k]);
              pq.add(arr[i]);
          }
        }
        list.add(pq.peek());
        return list;
    }
}
