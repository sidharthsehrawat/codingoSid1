package revision.trees;

import java.util.Stack;

public class IterativePostOrder {
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

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(4);
        root.right = new TreeNode(3);
        root.right.right = new TreeNode(7);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);

        iteratePostOrder(root); // 4 5 2 6 7 3 1
    }

    private static void iteratePostOrder(TreeNode root) {
        Stack<TreeNode> stack1 = new Stack<>();
        Stack<TreeNode> stack2 = new Stack<>();
        if(root == null){
             return;
        }

        stack1.push(root);
        while (!stack1.isEmpty()) {
            TreeNode pop = stack1.pop();
            stack2.push(pop);
            if(pop.left!=null){
                stack1.push(pop.left);
            }
            if(pop.right!=null){
                stack1.push(pop.right);
            }
        }
        while (!stack2.isEmpty()){
            TreeNode pop = stack2.pop();
            System.out.print(" " + pop.data);
        }
    }
}
