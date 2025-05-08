package revision.array;

public class DuplicateUsingXor {
    public static void main(String[] args) {
        int[] arr = {1, 3, 4, 2, 3}; // 3 is duplicated
        int n = arr.length - 1;
        int xor = 0;

        // XOR all elements in the array
        for (int x : arr) {
            xor ^= x;
        }

        // XOR all numbers from 1 to n
        for (int i = 1; i <= n; i++) {
            xor ^= i;
        }

        System.out.println("Duplicate is: " + xor);
    }
}
