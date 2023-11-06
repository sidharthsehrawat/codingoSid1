package folder.data_structure_impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class QueueUsingOneStack {
    private static Stack<Integer> stack = new Stack<>();
    private static List<Integer> list = new ArrayList<>();

    private static void enque(int data) {
        stack.push(data);
        //list.add(data);
    }


    private static void deque() {
        int top = 0;
            if (stack.size() == 1) {
                System.out.println(" " + stack.pop());
                return;
            }
            top = stack.peek();
            stack.pop();
            // recursive call..
         deque();

        stack.push(top);
    }


    public static void main(String[] args) {

        enque(1);
        enque(2);
        enque(3);
        deque();
        enque(4);
        deque();
        deque();
        deque();
    }


}
