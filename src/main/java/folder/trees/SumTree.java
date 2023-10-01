package folder.trees;

public class SumTree {
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
              9
            5   14
          3    6   20

         37
        */


        TreeNode root = new TreeNode(9);
        root.left = new TreeNode(10);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(6);
        root.right = new TreeNode(14);

        int treeSum = treeSum(root);
        System.out.println("treesum : " + treeSum);

        int max = treeMax(root);
        System.out.println("max ele : " + max);

        int height = treeHeight(root);
        System.out.println("Height : " + height);

        int value = 6;
        //int value =10;
        boolean exist = existInTree(root, value);
        System.out.println("exist In tree : " + exist);

        //  System.out.println("Before reverse ");
        //recursiveInOrder(root);
        // System.out.println();
        // mirrorTree(root);
        //  System.out.println("After reverse ");
        // recursiveInOrder(root);

        boolean bst = checkBst(root);
        System.out.println("BST : " + bst);


    }

    // By Inorder Traverasal , all values should be sorted
    // use min max approach . INTEGER.MAX = INTEGER.MIN
    private static boolean checkBst(TreeNode root) {
        boolean ans = helper(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
        return ans;
    }

    private static boolean helper(TreeNode root, int minValue, int maxValue) {
        if (root == null) {
            return true;
        }

        if (root.data <= minValue || root.data >= maxValue) {
            return false;
        }


        boolean left = helper(root.left, minValue, root.data);
        boolean right = helper(root.right, root.data, maxValue);

        return left && right;
    }

    private static void recursiveInOrder(TreeNode root) {
        if (root == null) {
            return;
        }
        recursiveInOrder(root.left);
        System.out.print(root.data + " ");
        recursiveInOrder(root.right);
    }

    private static void mirrorTree(TreeNode root) {
        if (root == null) {
            return;
        }
        mirrorTree(root.left);
        mirrorTree(root.right);
        swap(root);
    }

    private static void swap(TreeNode root) {
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
    }

    private static boolean existInTree(TreeNode root, int value) {
        if (root == null) {
            return false;
        }

        if (root.data == value) {
            return true;
        }

        boolean left = existInTree(root.left, value);
        boolean right = existInTree(root.right, value);

        boolean result = left || right;
        return result;

    }

    private static int treeHeight(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int leftHeight = treeHeight(root.left);
        int rightHeight = treeHeight(root.right);

        int height = Math.max(leftHeight, rightHeight) + 1;
        return height;

    }

    private static int treeMax(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int leftMax = treeSum(root.left);
        int rightMax = treeSum(root.right);
        int max = Math.max(leftMax, Math.max(rightMax, root.data));
        return max;

    }

    private static int treeSum(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int leftsum = treeSum(root.left);
        int rightsum = treeSum(root.right);
        int sum = leftsum + rightsum + root.data;
        return sum;
    }
}
