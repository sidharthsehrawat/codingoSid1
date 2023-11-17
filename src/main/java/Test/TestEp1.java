package Test;
public class TestEp1 {
    public static void main(String[] args) {
       // Input:
        // head = [1,2,3,4,5],
        // k = 2 int count  = 1;
        // Output: [4,5,1,2,3]
        int[] arr = {1,2,3,4,5}; // 4 5 1 2 3
        int k =2;
        int mid = arr.length -k;
        int start = 0;
        int end = arr.length-1;
        int right =mid-1;

        while (start <= right){
            int temp = arr[start];
            arr[start]= arr[right];
            arr[right] = temp;
            start++;
            right--;
        }

        while (mid <=end){
            int temp = arr[mid];
            arr[mid] = arr[end];
            arr[end] = temp;
            mid++;
            end--;
        }
        end = arr.length-1;
        start = 0;

        while (start <=end){
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
           start++;
           end--;
        }

        for(int i =0; i< arr.length ;i++){
            System.out.print( " " + arr[i]  );
        }
    }
}
