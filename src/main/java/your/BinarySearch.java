package your;

public class BinarySearch {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};
        int target = 5;
        int index = binFun(arr, target);
        System.out.println("index is " + index);
        int index1 = binFunRecur(arr, target, 0, arr.length);
        System.out.println("index1 is " + index1);
    }

    private static int binFunRecur(int[] arr, int target, int start, int end) {
        if (start > end) {
            return -1;
        }
        int mid = (start + (end - start)) / 2;
        if (arr[mid] == target) {
            return mid;
        } else if (arr[mid] < target) {
            return binFunRecur(arr, target, mid + 1, end);
        } else if (arr[mid] > target) {
            return binFunRecur(arr, target, start, mid - 1);
        }
        return -1;
    }

    private static int binFun(int[] arr, int target) {
        int start = 0;
        int end = arr.length - 1;
        while (start <= end) {
            int mid = (start + end) / 2;
            if (arr[mid] == target) {
                return mid;
            } else if (arr[mid] > target) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return -1;
    }
}