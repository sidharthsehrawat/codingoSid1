package revision.trees;

import java.util.Stack;

public class MirrorImage {
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
        display(root); // 4 2 5 1 6 3 7
        mirrorImage(root);
        System.out.println("\n");
        display(root); // 5 3 4 1 7 2 6
    }

    private static void display(TreeNode root) {
        if(root == null) return;
        display(root.left);
        System.out.print(" " + root.data);
        display(root.right);
    }

    private static void mirrorImage(TreeNode root) {
        if(root != null) {
            mirrorImage(root.left);
            mirrorImage(root.right);
            swap(root);
        }
    }

    private static void swap(TreeNode root) {
        TreeNode temp = root.left;
        root.left = root.right;
        root.right =  temp;
    }
}
