package folder.trees;

import java.util.ArrayList;
import java.util.List;

public class KthAncestor {
    static class TreeNode {
        TreeNode left;
        TreeNode right;
        int val;
        public TreeNode (int val){
            this.val = val;
        }
    }

    public static void main(String[] args) {
        /*
              7
           5     1
        3   4  9    2
                      8
        */
        TreeNode root = new TreeNode(7);
        root.left = new TreeNode(5);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(4);
        root.right = new TreeNode(1);
        root.right.left = new TreeNode(9);
        root.right.left.left = new TreeNode(11);
        root.right.right = new TreeNode(2);
        root.right.right.left = new TreeNode(10);
        root.right.right.right = new TreeNode(8);
       // allPathSumInteger(root, root.right.left.left);


    }



    static TreeNode temp = null;
    static int k =2;
    private static TreeNode allPathSumInteger(TreeNode root, TreeNode node) {
        if(root == null){
            return null;
        }
        if (root == node ||
                (temp = allPathSumInteger(root.left,node)) != null ||
                (temp = allPathSumInteger(root.right,node)) != null) {
           if(k>0){
               k--;
           } else if (k==0) {
               System.out.println("root : " + root.val);
               return null;
           }
           return root;
        }
        return null;
    }
}
