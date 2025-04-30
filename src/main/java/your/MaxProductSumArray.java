package your;

public class MaxProductSumArray {
    public static void main(String[] args) {
        int[] arr = {-1, -3, -10, 0, 60};
        int prod = 1;
        int sum = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            if (prod < 0 && arr[i] < 0) {
                prod = prod * arr[i];
                sum = Math.max(sum, prod);
            } else {
                prod = prod * arr[i];
                sum = Math.max(sum, prod);
            }
        }
    }
}
