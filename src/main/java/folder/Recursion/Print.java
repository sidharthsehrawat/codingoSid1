package folder.Recursion;

import java.util.Arrays;

public class Print {
    public static void main(String[] args) {
       // printNto1(5);

       // int res = sumOfNnumber(6);
       // System.out.println("sum" + res);

      //  int arr [] = {1,2,3,4,5};
      //  reverseArray(arr,0, arr.length-1);
      //  Arrays.stream(arr).forEach(System.out::print);
      //  String str= "ava";
      //  boolean res = stringPalindrome(str, 0, str.length() - 1);
      //  System.out.println(res);

    }



    private static boolean stringPalindrome(String str, int start, int end) {

        if(start>end){
            return true;
        }

        if(str.charAt(start)!=str.charAt(end)){
            return false;
        }
      return stringPalindrome(str, start+1,end-1);
    }


    private static void reverseArray(int[] arr, int start, int end) {
        if(start > end){
            return;
        }
        int temp  = arr[start];
        arr[start] = arr[end];
        arr[end] = temp;

        reverseArray(arr,start+1,end-1);

    }

    private static int sumOfNnumber(int num) {
        if(num==1){
            return 1;
        }
        return num+sumOfNnumber(num-1);

    }

    private static void printNto1(int num) {
        if(num==0){
            return;
        }

        printNto1(num-1);
        System.out.println(num);
    }
}
