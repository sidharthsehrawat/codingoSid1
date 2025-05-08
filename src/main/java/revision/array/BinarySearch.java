package revision.array;

public class BinarySearch {
    public static void main(String[] args) {
        int target = 5;
        int[] arr = {1,2,3,4,5,6,7,8};
        int res = getTargetUsingBinarySearchWithoutRecursion(arr, target);
        System.out.println(res);
    }

    private static int getTargetUsingBinarySearchWithoutRecursion(int[] arr, int target) {
        int start = 0;
        int end = arr.length;

        while (start <= end){

            int mid = (start+ end)/2;

            if(arr[mid] == target){
                return mid;
            }
            if(target < arr[mid]){
                end = mid-1;
            }
            if(target > arr[mid]){
               start = mid+1;
            }
        }
        return -1;
    }
}
