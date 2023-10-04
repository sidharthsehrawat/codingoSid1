package folder.array;

public class Kadane {
    public static void main(String[] args) {
        int arr[] = {-2, 1, 3, -5, 2, 5, -1};
        int max_so_far = -100;
        int current_max = 0;
        int start = 0;
        int end = 0;
        int x = 0;
        for (int i = 0; i < arr.length; i++) {
            current_max = current_max + arr[i];
            if (current_max > max_so_far) {
                max_so_far = current_max;
                start = x;
                end = i;
            }
            if (current_max < 0) {
                current_max = 0;
                x = i + 1;
            }
        }
        System.out.println("max : " + max_so_far + "   ( start = " + start + ", end = " + end + ")");
    }
}
