package folder.trees;

import java.util.List;
import java.util.Stack;

public class CountGoodNodes {

    public static class TreeNode {
        TreeNode left;
        TreeNode right;
        int val;

        public TreeNode(int data) {
            this.val = data;
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(1);
        root.right = new TreeNode(4);
        root.left.left = new TreeNode(3);
        root.right.left = new TreeNode(1);
        root.right.right = new TreeNode(5);
        int res = goodNodes(root);
        System.out.println("count of good nodes : " + res);
    }

    public static int goodNodes(TreeNode root) {

        helper(root,  root.val);
        return count+1;

    }
  private  static  int count =0;
    private static void helper(TreeNode root, int psf) {
        if(root == null){
            return;
        }
        if(root.left!=null && psf%10 <= root.left.val){
           psf = psf*10+root.left.val;
           count ++;
        }
        helper(root.left, psf);

        if(root.right!=null && psf%10 <= root.right.val){
            psf = psf*10+root.right.val;
            count ++;
        }
        helper(root.right, psf);
    }
}
