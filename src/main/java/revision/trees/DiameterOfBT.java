package revision.trees;

public class DiameterOfBT {
    static int max= -1;

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
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(4);
        root.right = new TreeNode(3);
        root.right.right = new TreeNode(7);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);

        diameter(root);
        System.out.println("diameter : " + max);


    }

    private static int diameter(TreeNode root) {
        if (root == null) return 0;

        int left = diameter(root.left);
        int right = diameter(root.right);
        max = Math.max(max, (left + right));
        return Math.max(left , right) + 1;
    }
}