package revision.trees;

import java.util.Stack;

public class IterativePreOrder {
    static class TreeNode {
        TreeNode left;
        TreeNode right;
        int data;

        public TreeNode(int data){
            this.data= data;
        }
    }


    public static void main(String[] args) {
        /*
                     1
                2         3
             4    5     6   7

       */

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(4);
        root.right = new TreeNode(3);
        root.right.right = new TreeNode(7);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);

        iterate(root);
    }

    private static void iterate(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        if(root==null){
            return;
        }

        stack.push(root);
        while (!stack.isEmpty()){
            TreeNode pop = stack.pop();
            System.out.println(pop.data);
            if(pop.right!=null){
                stack.push(pop.right);
            }
            if(pop.left!=null){
                stack.push(pop.left);
            }
        }
    }
}
