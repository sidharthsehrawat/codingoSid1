package folder.array;

public class BinarySearch {
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6,7,8};
        int target  = 2;
        int res=  getFun(arr,target,0,arr.length-1);
        System.out.println(res);
    }

    private static int getFun(int[] arr, int target, int start, int end) {

        if (start <= end) {
            int mid = (start + end) / 2;

            if (arr[mid] == target) {
                return mid;
            }
            if (arr[mid] > target) {
                return getFun(arr, target, start, mid - 1);
            }

            return getFun(arr, target, mid + 1, end);
        }
        return -1;
    }
}
