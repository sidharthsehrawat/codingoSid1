package revision.array;

public class BinarySeachUsingRecur {
    public static void main(String[] args) {
        int target = 5;
        int[] arr = {1,2,3,4,6,7,8};
        int res = getTargetUsingBinarySearchWithoutRecursion(arr, target, 0, arr.length);
        System.out.println(res);
    }

    private static int getTargetUsingBinarySearchWithoutRecursion(int[] arr, int target, int start, int end) {
        if(start<end){
            int mid = (start+end)/2;
            if(arr[mid]==target){
                return mid;
            }
            if(arr[mid] < target){
              return getTargetUsingBinarySearchWithoutRecursion(arr,target,start,mid-1);
            }

            if(arr[mid] > target){
                return getTargetUsingBinarySearchWithoutRecursion(arr,target,mid+1,end);
            }
        }
        return -1;
    }
}
