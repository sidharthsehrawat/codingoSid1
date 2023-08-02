package folder.array;

import java.util.*;
public class TrapRainWater {
    public static void main(String[] args) {

        List<Integer> input = Arrays.asList(0,1,0,2,1,0,1,3,2,1,2,1);
        int[] prevMax = new int[input.size()];
        int[] nextMax = new int[input.size()];
        // filling array values prevMax
        Stack<Integer> stack = new Stack();
        stack.push(input.get(0));
        for(int i=1;i<input.size();i++){
            if(input.get(i) > stack.peek().intValue()){
                stack.pop();
                stack.push(input.get(i));
                prevMax[i]= 0;
            }else{
                prevMax[i]=stack.peek();
            }
        }

        stack.clear();

       // Stack<Integer> stack = new Stack();
        int n = input.size();
        stack.push(input.get(n-1));

        for(int i=n-2;i>=0;i--){
            if(input.get(i) >= stack.peek()){
                stack.pop();
                stack.push(input.get(i));
                nextMax[i]= 0;
            }else{
                nextMax[i]=stack.peek();
            }
        }

        int ans =0;
        for(int i=0;i<input.size();i++){
            int height =  Math.min(prevMax[i] , nextMax[i]);
            if(height>= input.get(i)){
                ans += (height - input.get(i));
            }
        }

        System.out.println("Ans "  + ans);

    }

}
