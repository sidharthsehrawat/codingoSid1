package revision.trees;

public class MaxPathSum {
    static class TreeNode {
        TreeNode left;
        TreeNode right;
        int data;

        public TreeNode(int data) {
            this.data = data;
        }
    }
    static int maxNum = -1;

    public static void main(String[] args) {
        /*
                     1
                 2        -3
              4    5    6   7

       */

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(4);
        root.right = new TreeNode(-3);
        root.right.right = new TreeNode(7);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);

        maxPath(root);
        System.out.println("max path : " + maxNum);
    }

    private static int maxPath(TreeNode root) {
        if (root == null) return 0;
        int left = maxPath(root.left);
        int right = maxPath(root.right);
        int c12 = Math.max(Math.max(left,right) + root.data, root.data);
        int c21 = Math.max(c12, left+right + root.data);
        maxNum = Math.max(maxNum,c21);
        return c12;
    }
}