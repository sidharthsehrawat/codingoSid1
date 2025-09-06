package folder.array;

import java.util.*;

public class AsteroidsCollision {
    public static void main(String[] args) {
        int arr[] = {-2,1,1,-1};
       // int[] res = asteroidCollision(arr);
        int[] res1 = asteroidCollision1(arr);
        Arrays.stream(res1).forEach(a -> System.out.println(":" + a));
    }

    private static int[] asteroidCollision1(int[] arr) {
        Stack<Integer> stack = new Stack<>();

        for (int asteroid : arr) {
            boolean flag = true;
                while (!stack.isEmpty() && stack.peek() > 0 && asteroid < 0) {
                    if (stack.peek() > -asteroid) {
                        flag = false;
                        break;
                    } else if (stack.peek() < -asteroid) {
                        stack.pop();
                    } else {
                        stack.pop();
                        flag = false;
                        break;
                    }
                }
            if (flag) {
                stack.push(asteroid);
            }
        }
        int k = 0;
        int[] ans = new int[stack.size()];
        while (!stack.isEmpty()) {
            ans[k++] = stack.pop();
        }
        for (int i = 0; i < ans.length / 2; i++) {
            int temp = ans[i];
            ans[i] = ans[ans.length - 1 - i];
            ans[ans.length - 1 - i] = temp;
        }
        return ans;
    }


    public static int[] asteroidCollision(int[] arr) {
        Stack<Integer> stack = new Stack<>();  // 5 , 10
        for (int astroid : arr) {
            boolean flag = true;
            while (!stack.isEmpty() && astroid < 0 && stack.peek() > 0) {
                if (-astroid > stack.peek()) {
                    stack.pop();
                } else if (-astroid < stack.peek()) {
                    flag = false;
                    break;
                } else {
                    flag = false;
                    stack.pop();
                    break;
                }
            }
            if (flag == true) {
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
