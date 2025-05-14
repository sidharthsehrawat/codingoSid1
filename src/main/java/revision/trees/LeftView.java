package revision.trees;

public class LeftView {
    static class TreeNode {
        TreeNode left;
        TreeNode right;
        int data;
        
        public TreeNode(int data){
            this.data = data;
        }
    }
    static int max = -1;
    public static void main(String[] args) {
        /*
                     1
                 2        3
              4    5    6   7
                      8
       */
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(4);
        root.right = new TreeNode(3);
        root.right.right = new TreeNode(7);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.left.left = new TreeNode(8);
        int hd = 0;

        leftView(root, hd);

    }

    private static void leftView(TreeNode root, int hd) {
        if (root == null) return;
        if(hd> max){
            System.out.print(" " + root.data);
            max= hd;
        }
        leftView(root.left, hd +1);
        leftView(root.right, hd+1);

    }
}
