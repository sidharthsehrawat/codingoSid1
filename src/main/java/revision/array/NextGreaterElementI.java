package revision.array;

import java.util.*;

public class NextGreaterElementI {
    public static void main(String[] args) {
        int[] num1 = {4,1,2};
        int[] num2 = {1,3,4,2};
        int[] res = nextGreaterElement(num1, num2);
        System.out.println(res);


    }

    public static int[] nextGreaterElement(int[] nums1, int[] nums2) {
        //nums2 = [1, 4, 3, 5, 2]
        //        [4, 5, 5,-1,-1]
        int last = nums2.length;
        Map<Integer, Integer> map = new HashMap<>();
        Stack<Integer> stack = new Stack<>();

        for (int i = last-1 ; i >= 0; i--) {
            while (!stack.isEmpty() && stack.peek() < nums2[i]) {
                stack.pop();
            }
            if(stack.isEmpty()) {
                map.put(nums2[i] , -1);
            }else{
                map.put(nums2[i], stack.peek());
            }

            stack.push(nums2[i]);
        }

        int[] result = new int[nums1.length];
        for (int j = 0; j < nums1.length; j++) {
            result[j] = map.get(nums1[j]);
        }
        return result;
    }
}
