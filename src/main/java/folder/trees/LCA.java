package folder.trees;

public class LCA {
    static class TreeNode {
        TreeNode left;
        TreeNode right;
        int val;

        public TreeNode (int val){
            this.val = val;
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(9);
        root.left = new TreeNode(5);
        root.left.left=  new TreeNode(3);
        root.left.right = new TreeNode(6);
        root.right = new TreeNode(18);
        root.right.left = new TreeNode(10);
        root.right.right = new TreeNode(20);

        TreeNode ans = lcsFun(root,root.right.left,root.right.right );
        System.out.println("lcs = " + ans.val);

    }
    private static TreeNode lcsFun(TreeNode root, TreeNode node1, TreeNode node2) {
        if(root == null){
            return null;
        }

        if(root == node1 || root == node2 ){
            return root;
        }

        TreeNode left = lcsFun(root.left , node1,node2);
        TreeNode right = lcsFun(root.right , node1,node2);

        if(left !=null && right !=null){
            return root;
        }else {
            return (left!=null ? left: right);
        }

    }
}
