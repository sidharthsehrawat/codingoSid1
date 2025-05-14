package revision.trees;

import sun.reflect.generics.tree.Tree;

import java.util.Stack;

public class SpiralTraversal {
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
                     1
                 2        3
              4    5    6   7

       */
        // 1 |  3 2 | 4 5 6 7
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(4);
        root.right = new TreeNode(3);
        root.right.right = new TreeNode(7);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        spiralTraversal(root);
    }


    private static void spiralTraversal(TreeNode root) {
        if (root == null) return;
        // using 2 stacks or 1 deque.
        Stack<TreeNode> stack1 = new Stack<>();
        Stack<TreeNode> stack2 = new Stack<>();
        stack1.push(root);
        while (!stack1.isEmpty() || !stack2.isEmpty()) {
            while (!stack1.isEmpty()) {
                TreeNode pop = stack1.pop();
                System.out.print(" " + pop.data);
                if (pop.left != null) {
                    stack2.push(pop.left);
                }
                if (pop.right != null) {
                    stack2.push(pop.right);
                }
            }

            while (!stack2.isEmpty()) {
                TreeNode pop = stack2.pop();
                System.out.print(" " + pop.data);
                if (pop.right != null) {
                    stack1.push(pop.right);
                }
                if (pop.left != null) {
                    stack1.push(pop.left);
                }
            }
        }
    }
}