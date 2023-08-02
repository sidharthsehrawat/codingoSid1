package folder.trees;

public class ValidateBST {
    public static class TreeNode {
        TreeNode left;
        TreeNode right;
        int data;

        public TreeNode(int data) {
            this.data = data;
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(6);
        root.left = new TreeNode(4);
        root.right = new TreeNode(7);
        root.right.right = new TreeNode(8);
        root.left.left = new TreeNode(2);
        root.left.right = new TreeNode(5);
        root.left.left.left = new TreeNode(1);
        root.left.left.left.left = new TreeNode(0);

        int min = Integer.MIN_VALUE;
        int max = Integer.MAX_VALUE;
        boolean res = validateBST(root, min, max);
        System.out.println(res);
    }

    private static boolean validateBST(TreeNode root, int min, int max) {
        if (root == null) {
            return true;
        }
        if (root.data > min && root.data < max) {
            boolean left = validateBST(root.left, min, root.data);
            boolean right = validateBST(root.right, root.data, max);
            return left && right;
        }
        return false;
    }
}
