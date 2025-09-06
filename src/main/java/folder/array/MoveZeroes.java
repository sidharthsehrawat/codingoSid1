package folder.array;

public class MoveZeroes {
    public static void main(String[] args) {
        int[] arr = {0, 1, 0, 3, 12};
        movefun(arr);
        for (int n : arr) {
            System.out.print(n);
        }
    }

    private static void movefun(int[] nums) {
        int p1 = 0;
        int p2 = 1;
        if (nums.length > 1) {
            while (p1 < nums.length && p2 < nums.length) {
                if (nums[p1] == 0 && nums[p2] != 0) {
                    int temp = nums[p1];
                    nums[p1] = nums[p2];
                    nums[p2] = temp;
                    p1++;
                    p2++;
                } else {
                    if (nums[p1] == 0 && nums[p2] == 0) {
                        p2++;
                    }
                    if (nums[p1] != 0 && nums[p2] == 0) {
                        p1++;
                        p2++;
                    }
                }
            }
        }
    }
}
