package Test;

import java.util.Arrays;

public class TestEY1 {
    public static void main(String[] args) {


                                   //          i    k
      int arr[]  ={4,7,15, 0, 0, 0}; // { 4 ,4,7, 9, 13, 15 }
                                  //           j
      int arr2[] ={2,9,13};          //  {2,9,13}

        //int i = 0;
        int end2 =arr2.length-1;
        int k = arr.length-1;
        int end = arr.length- arr2.length-1;
        while(end>=0 && end2>=0){
              if(arr[end] > arr2[end2]){
                   arr[k] = arr[end];
                   end--;
              }else{
                  arr[k] = arr[end2];
                  end2--;
              }
            k--;
        }

        while(end>=0){
            arr[k] = arr[end];
            k--;
            end--;
        }

        while(end2>=0){
            arr[k] = arr2[end2];
            k--;
            end2--;
        }

        String str = arr.toString();
        //System.out.println("ans = " + str);
        Arrays.stream(arr).forEach(System.out::print);

    }
}
