package Test;

public class TestBitsDS {
    public static void main(String[] args) {
        int res = 0;
        int[] nums = {4, 1, 2, 1, 2};
        for (int num : nums) {
            res = res ^ num;
        }

        int n = 1001;
        int res1 = 0;
        while (n >0) {
            res1 += n % 2;
            n = n >> 1;
        }
        System.out.println("Count : " + res1);
    }
}
