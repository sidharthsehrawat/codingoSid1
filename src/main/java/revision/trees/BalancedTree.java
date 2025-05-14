package revision.trees;

public class BalancedTree {
    static class TreeNode {
        TreeNode left;
        TreeNode right;
        int data;

        public TreeNode(int data) {
            this.data = data;
        }
    }

    static boolean flag = true;


    public static void main(String[] args) {
        /*
                     1
                 2        3
              4    5    6   7

       */

        TreeNode root = new TreeNode(1);
        //root.left = new TreeNode(2);
       // root.left.left = new TreeNode(4);
        root.right = new TreeNode(3);
        root.right.right = new TreeNode(7);
      //  root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);

         balance(root);
        System.out.println("is balanced " + flag);

    }

    private static int balance(TreeNode root) {
        if (root == null) return 0;

        int left = balance(root.left);
        int right = balance(root.right);
        int diff = Math.abs(left - right);
        if (diff > 1) flag = false;
        return Math.max(left , right) + 1;
    }
}