package revision.trees;


public class CountNodesCompleteBT {
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
                 2       3
              4    5   7
                           
       */
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(4);
        root.right = new TreeNode(3);
        root.right.left = new TreeNode(7);
        root.left.right = new TreeNode(5);
        int size = countNodes(root);
        System.out.println("size " + size);
    }

    private static int countNodes(TreeNode root) {
        if(root == null) return 0;

        int lh = getLeftHeight(root);
        int rh = getRightHeight(root);

        if(lh == rh){
            return (int) (Math.pow(2,lh)-1);
        }

        return countNodes(root.left) + countNodes(root.right) + 1;
    }

    private static int getLeftHeight(TreeNode root) {
        TreeNode temp = root;
        int size = 0;
        while (temp!=null){
            temp =  temp.left;
            size++;
        }
        return size;
    }

    private static int getRightHeight(TreeNode root) {
        TreeNode temp = root;
        int size = 0;
        while (temp!=null){
            temp =  temp.right;
            size++;
        }
        return size;
    }
}

