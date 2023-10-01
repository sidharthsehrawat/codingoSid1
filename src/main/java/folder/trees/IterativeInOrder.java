package folder.trees;


import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class IterativeInOrder {
    static class TreeNode {
        TreeNode left;
        TreeNode right;
        int data;

        public TreeNode(int data) {
            this.data = data;
        }
    }


    public static void main(String[] args) {
/*
        Byte byt = (byte) 127;
        Byte byt1 = (byte) 130;
        Byte byt2 = (byte) -130;
        Byte byt3 = (byte) -127;
        Byte byt4 = (byte) 126;
*/


        TreeNode root = new TreeNode(9);
        root.left = new TreeNode(5);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(6);
        root.right = new TreeNode(14);
        root.right.left = new TreeNode(13);
        root.right.left.left = new TreeNode(11);
        root.right.left.left.right = new TreeNode(12);
        root.right.right = new TreeNode(15);

        // recursiveInOrder(root);
        //iterativeInOrder(root);
        //iterativePreOrder(root);
        // iterativePostOrderUsingTwoStack(root);
        iterativePostOrderUsingOneStack(root);
    }

    private static void iterativePostOrderUsingTwoStack(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        Stack<TreeNode> stack1 = new Stack<>();

        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode pop = stack.pop();
            stack1.push(pop);
            if (pop.left != null) {
                stack.push(pop.left);
            }
            if (pop.right != null) {
                stack.push(pop.right);
            }
        }
        List<Integer> list = new ArrayList<>();
        while (!stack1.isEmpty()) {
            list.add(stack1.pop().data);
        }
        System.out.println(list);
    }

    private static void iterativePostOrderUsingOneStack(TreeNode root) {
        if (root == null) {
            return;
        }
        Stack<TreeNode> stack = new Stack<>();
        TreeNode current = root;

        while (!stack.isEmpty() || current != null) {
            if (current != null) {
                stack.push(current);
                current = current.left;
            } else {
                TreeNode temp = stack.peek().right;
                if (temp == null) {
                    temp = stack.pop();
                    System.out.print(temp.data + " ");
                    while (!stack.isEmpty() && temp == stack.peek().right) {
                        temp = stack.pop();
                        System.out.print(temp.data + " " );
                    }
                } else {
                    current = temp;
                }
            }
        }
    }


    private static void iterativeInOrder(TreeNode root) {
        if (root == null) {
            return;
        }
        Stack<TreeNode> stack = new Stack<>();
        while (!stack.isEmpty() || root != null) {
            if (root != null) {
                stack.push(root);
                root = root.left;
            } else {
                root = stack.pop();
                System.out.println(root.data);
                root = root.right;
            }
        }
    }

    private static void iterativePreOrder(TreeNode root) {
        if (root == null) {
            return;
        }

        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);

        while (!stack.isEmpty()) {
            TreeNode pop = stack.pop();
            System.out.println(pop.data);

            if (pop.right != null) {
                stack.push(pop.right);
            }
            if (pop.left != null) {
                stack.push(pop.left);
            }

        }


    }

    private static void recursiveInOrder(TreeNode root) {

        if (root == null) {
            return;
        }
        recursiveInOrder(root.left);
        System.out.println(root.data);
        recursiveInOrder(root.right);
    }

}
