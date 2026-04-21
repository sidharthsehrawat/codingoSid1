package your;

import java.util.Arrays;
import java.util.Stack;

public class AsteroidCollision {
    public static void main(String[] args) {
        int[] arr = {-2,1,1,-1};
       int[] res =  asteroidCollision(arr);
       Arrays.stream(res).forEach(System.out::print);
    }

    private static int[] asteroidCollision(int[] arr) {
        Stack<Integer> stack = new Stack<>();
        boolean asteroidAdded = true;
        for(int asteroid : arr){
            while (!stack.isEmpty() && stack.peek() > 0 && asteroid < 0){
                if(stack.peek() > Math.abs(asteroid)){
                    asteroidAdded = false;
                    break;
                }else if(stack.peek() < asteroid) {
                    stack.pop();
                }else {
                    stack.pop();
                    asteroidAdded = false;
                    break;
                }

            }
            if(asteroidAdded){
                stack.push(asteroid);
            }
        }
        int k = 0;
        int[] ans = new int[stack.size()];
        while (!stack.isEmpty()) {
            ans[k++] = stack.pop();
        }
        return ans;
    }
}
