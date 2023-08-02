package folder.array;

public class SemiSortedArrayPivotPoint {


    // Q. Find pivot index in a semi-sorted array. Example you have an array of unique elements 1,2,6,7,5,3 the pivot element is 7 (index 3),
    // since the array was in increasing order from 0 to 3 index and decreasing from 4 to n-1 index.
    //       Ex 1: 1,2,3,4,5,0,-1,-2
    //output: 4

    // Brute force...
    // semi sorted O(logn)...

    public static void main(String[] args) {
        //      s m e
        //int arr[] = {5,6,7,8,3,2};
        int arr[] ={3,2,1,4,5,6};
        //int arr[] = {5, 4, 0, 1, 2, 4};
        int res = getFuntion(arr, 0, arr.length - 1);
        System.out.println(res);
    }


    // Algo : start > mid < end  (start= mid , end = end )  ==
    // Algo : start > mid > end  (start= mid , end = end )
    // Algo : start < mid < end  (start= start , end = mid )  ==
    // Algo : start > mid < end  (start= mid , end = end )
    private static int getFuntion(int[] arr, int start, int end) {
        // base condition
        if (start <= end) {
            int mid = (start + end) / 2;

            if (mid == start) {
                return mid;
            }
            //
            if (arr[mid] > arr[start] && arr[mid] < arr[end]) {
                return getFuntion(arr, start, mid);
            }

            if (arr[mid] > arr[start] && arr[mid] > arr[end]) {
                return getFuntion(arr, mid, end);
            }

            if (arr[mid] < arr[start] && arr[mid] > arr[end]) {
                return getFuntion(arr, start, mid);
            }

            if (arr[mid] < arr[start] && arr[mid] < arr[end]) {
                return getFuntion(arr, mid, end);
            }
        }

        return -1;
    }


}
