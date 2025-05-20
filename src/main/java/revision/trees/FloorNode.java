package revision.trees;

public class FloorNode {
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
                     6
                 5       9
              3    4   7
       */

        TreeNode root = new TreeNode(6);
        root.left = new TreeNode(5);
        root.left.left = new TreeNode(3);
        root.right = new TreeNode(9);
        root.right.right = new TreeNode(7);
        root.left.right = new TreeNode(4);
        int ceil = findFloor(root, 3);
        System.out.println("floor " + ceil);
    }

    private static int findFloor(TreeNode root, int key) {
        int floor = -1;

        while (root != null) {
            if(key==root.data){
                return root.data;
            }
            if(key > root.data){
                floor = root.data;
                root = root.right;
            }else {
                root = root.left;
            }
        }
        return floor;
    }
}
