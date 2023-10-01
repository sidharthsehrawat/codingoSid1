package folder.array;

public class QuickSort {

    public static void main(String[] args) {
        int[] arr = {4, 7, 2, 1, 3, 5};
        quicksort(arr, 0, arr.length - 1);
        System.out.println("sorted arr :");
        for (int n : arr) {
            System.out.print(n + " ");
        }
    }
    private static void quicksort(int[] arr, int l, int r) {
        if (l < r) {
            int index = partition(arr, l, r);
            quicksort(arr, l, index - 1);
            quicksort(arr, index + 1, r);
        }
    }
    private static int partition(int[] arr, int l, int r) {
        int pivot = l;
        while (l < r) {
            while (l < arr.length - 1 && arr[l] <= arr[pivot]) {
                l++;
            }
            while (arr[r] > arr[pivot]) {
                r--;
            }
            if (l < r) {
                swap(arr, l, r);
            }
        }
        swap(arr, r, pivot);
        return r;
    }

    private static void swap(int[] arr, int l, int r) {
        int temp = arr[l];
        arr[l] = arr[r];
        arr[r] = temp;
    }
}
