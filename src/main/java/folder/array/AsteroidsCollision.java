package folder.array;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class AsteroidsCollision {
    public static void main(String[] args) {
        int arr[] = {5, 10 , -5};
        int[] res = asteroidCollision(arr);
        Arrays.stream(res).forEach(a -> System.out.println(":" + a));
    }

    public static int[] asteroidCollision(int[] arr) {
        Stack<Integer> stack = new Stack<>();  // 5 , 10
        for (int astroid : arr) {
            boolean flag = true;
            while (!stack.isEmpty() && astroid < 0 && stack.peek() > 0) {

                if (-astroid > stack.peek()) {
                    stack.pop();
                } else if (-astroid < stack.peek()) {
                    flag= false;
                    break;
                } else {
                    flag=false;
                    stack.pop();
                    break;
                }

            }

            if(flag== true){
                stack.push(astroid);
            }
        }

        int[] result = new int[stack.size()];
        int i = stack.size() - 1;
        while (!stack.isEmpty()) {
            result[i] = stack.pop();
            i--;
        }

        return result;
    }
}
