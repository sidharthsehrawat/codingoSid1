package folder.array;

public class MaxProdSum {
    public static void main(String[] args) {
        int[] arr = {6, -3, -10, 0, 2};
        // pref and suff technique iternate from start and end ... when zero comes set pref =1 again ,
        int prod = 1;
        for (int i = 0; i < arr.length; i++) {
          prod = prod * arr[i];
        }
    }
}
