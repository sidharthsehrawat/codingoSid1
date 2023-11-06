package Test;

public class TestFlipSubarray {
    public static void main(String[] args) {
        int arr[] = new int[]{ -2, 3, -1, -4, -2 }; //  -6
        int N = arr.length;

        System.out.println(maxSumFlip(arr, N));
    }

    static int maxSumFlip(int ar[], int n)
    {

        // Stores the total sum of array
        int total_sum = 0;
        for (int i = 0 ; i < n ; i++){
            total_sum += ar[i];
        }

        // Kadane's algorithm to find the minimum subarray sum
        int b = 0;
        int a = 2000000000;
        for (int i = 0 ; i < n ; i++)
        {
            b += ar[i];
            if(a > b){
                a = b;
            }
            if(b > 0){
                b = 0;
            }
        }

        // Return the max_sum
        return Math.max(total_sum, total_sum - 2*a); // -6 , -6 + 14

    }
}


