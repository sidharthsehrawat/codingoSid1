 package folder.array;

public class SearchInsertPosition {
    public static void main(String[] args) {
        int nums[] = {1, 3, 5, 6};
        int target = 4;
        int res = searchInsert(nums, target);
        System.out.println("index : " + res);
    }



    public static int searchInsert(int[] nums, int target) {
        // binary search
        int start = 0;
        int end = nums.length;
        int mid = -1;
        while (start < end) {
            mid = (start + end) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (target > nums[mid]) {
                start = mid+1 ;
            } else if (target < nums[mid]) {
                end = mid -1;
            } else {
                if (mid == 0) {
                    return start + 1;
                } else if (mid == nums.length - 1) {
                    return end + 1;
                }
            }
        }
        return mid + 1;
    }
}
