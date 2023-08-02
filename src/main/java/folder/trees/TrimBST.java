package folder.trees;

public class TrimBST {
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

        int low = 1;
        int high = 3;
        TreeNode result = trimBST(root, low, high);
        System.out.println(root);
        System.out.println(result);

    }

    private static TreeNode trimBST(TreeNode root, int low, int high) {
        if (root == null) {
            return null;
        }

        if (root.data > high) {
            return trimBST(root.left, low, high);
        }
        if (root.data < low) {
            return trimBST(root.right, low, high);

        }

        if (root.data >= low && root.data <= high) {
            root.left = trimBST(root.left, low, high);
            root.right = trimBST(root.right, low, high);
        }

        return root;
    }

}
