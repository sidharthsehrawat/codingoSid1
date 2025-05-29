package revision.array;

import java.util.Stack;

public class NextGreaterElementII {
    public static void main(String[] args) {
        int[] nums = {2,1,3};
        int[] res = nextGreaterElements(nums);
        System.out.println("res " + res);
    }

    public static int[] nextGreaterElements(int[] nums) {
        int n = nums.length;
        int[] aux = new int[nums.length];
        Stack<Integer> stack = new Stack<>();
        int last = nums.length;
        for(int i = 2*last-1; i>= 0; i--) {
            int number = nums[i%n];
            while(!stack.isEmpty() && stack.peek() <= number){
                stack.pop();
            }
            if(stack.isEmpty()){
                aux[i%n] = -1;
            }else{
                aux[i%n] = stack.peek();
            }
            stack.push(number);
        }
        return aux;
    }
}

// approach using double the array
/**
 int n = nums.length;
 int[] num = new int[2 * n];
 for (int i = 0; i < n; i++) {
 num[i] = nums[i];
 num[i + n] = nums[i];
 }

 int[] aux = new int[num.length];
 Stack<Integer> stack = new Stack<>();

 int last = num.length-1;
 aux[last] = -1;
 stack.push(num[last]);

 for(int i = last-1; i>= 0; i--) {
 while(!stack.isEmpty() && stack.peek() <= num[i]){
 stack.pop();
 }
 if(stack.isEmpty()){
 aux[i] = -1;
 }else{
 aux[i] = stack.peek();
 }
 stack.push(num[i]);
 }

 int[] res = new int[nums.length];
 return Arrays.copyOfRange(aux, 0, nums.length);

 */
