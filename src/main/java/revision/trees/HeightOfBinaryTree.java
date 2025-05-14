package revision.trees;

import java.util.Stack;

public class HeightOfBinaryTree {
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
                               8
       */

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(4);
        root.right = new TreeNode(3);
        root.right.right = new TreeNode(7);
        root.right.right.right = new TreeNode(8);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);

        int height = height(root);
        System.out.println("Height of tree " + height);

    }

    private static int height(TreeNode root) {
        if (root == null) return 0;

        int left = height(root.left);
        int right = height(root.right);
        int max = Math.max(left,right) + 1;
        return max;
    }

}
