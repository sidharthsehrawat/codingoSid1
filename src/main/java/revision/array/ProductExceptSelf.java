package revision.array;

public class ProductExceptSelf {
    public static void main(String[] args) {
        int[] arr = {1,3,4,6};
        int[] res = productExceptSelf(arr);
        System.out.println(res);
    }

    public static int[] productExceptSelf(int[] nums) {
        int[] result = new int[nums.length];
        result[0] = 1;
        int prod = 1;

        for(int i = 1; i<nums.length; i++){
            result[i] = result[i-1] * nums[i-1];
        }

        for(int j = nums.length-1 ; j>=0 ; j--) {
            result[j] = prod * result[j];
            prod = prod * nums[j];
        }
        return result;
    }
}

