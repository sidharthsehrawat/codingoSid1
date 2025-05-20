package revision.trees;

public class BSTIterator {
    static class TreeNode {
        TreeNode left;
        TreeNode right;
        int data;

        public TreeNode(int data) {
            this.data = data;
        }
    }

    public BSTIterator(){

    }

    public static void main(String[] args) {
        /*
                     1
                 2        3
              4    5    6   7
           9         8        
       */
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(4);
        root.left.left.left = new TreeNode(9);
        root.right = new TreeNode(3);
        root.right.right = new TreeNode(7);
        root.left.right = new TreeNode(5);
        root.left.right.right = new TreeNode(8);
        root.right.left = new TreeNode(6);
    }
}
