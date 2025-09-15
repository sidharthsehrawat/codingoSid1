package revision.array;

public class CustomNextGreater {
    public static void main(String[] args) {
        int[] arr = {20, 10, 35, 10, 20, 40, 25};
        int[] result = new int[arr.length];

        // Loop over each element
        for (int i = 0; i < arr.length; i++) {
            result[i] = 0; // default to 0 if no greater is found
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] > arr[i]) {
                    result[i] = arr[j];
                    break; // we found the first greater element
                }
            }
        }

        // Print result
        for (int num : result) {
            System.out.print(num + " ");
        }
    }
}
