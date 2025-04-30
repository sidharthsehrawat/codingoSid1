package folder.trees;

import sun.reflect.generics.tree.Tree;

import java.util.ArrayList;
import java.util.List;

public class MaxPathSum {
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
                4
             1     2
          1    6 8   7
       3    2

        */

        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(1);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(6);
        root.left.left.left = new TreeNode(3);
        root.left.left.right = new TreeNode(2);
        root.right = new TreeNode(2);
        root.right.left = new TreeNode(8);
        root.right.right = new TreeNode(7);
        TreeNode node = root.right.left;
        int k =1;
        String path ="";
        int ans =-1;
        int kthancestor=  kthAncestor(root,k, path,node, ans);
        System.out.println("ans " + kthancestor);
        /*
        int maxPathSum = maxPathSum(root);
        //System.out.println( "maxPathSum : " + maxPathSum);
        boolean hasPathSum = hasPathSumFun(root, 8);
        // System.out.println("HasPathSum : " + hasPathSum);

         int sum =allPathSumInteger(root, 0);
         // 4111 + 4112 + 428 + 427
        System.out.println("sum is " + sum );
        System.out.println("List is :" + list);

*/

    }

    private static int kthAncestor(TreeNode root, int k,String path, TreeNode node, int ans) {
        if(root ==null){
            return -1;
        }

        if(root == node){
            if(path.length()<k){
                System.out.println("ancestor not exist");
                return -1;
            }else {
                ans  = Integer.parseInt(String.valueOf(path.charAt(path.length()-(k))));
                System.out.println("ans is " + Integer.parseInt(String.valueOf(path.charAt(path.length()-(k)))));
                return ans;
            }
        }

        kthAncestor(root.left, k, path+root.data,node, ans);
        kthAncestor(root.right, k, path+root.data, node, ans);

        return ans;
    }


    static List<String > list = new ArrayList<>();
    private static int allPathSumInteger(TreeNode root, int path) {
        if (root == null) {
            return 0 ;
        }
        if (root.left == null && root.right == null) {
            list.add(String.valueOf(path*10 + root.data));
           return path*10 + root.data;
        }
         int left  = allPathSumInteger(root.left, path * 10 + root.data);
         int right = allPathSumInteger(root.right, path * 10 + root.data);
         return left+ right;
    }

    private static boolean hasPathSumFun(TreeNode root, int targetSum) {
        if (root == null) {
            return false;
        }
        if (targetSum - root.data == 0 && root.left == null && root.right == null) {
            return true;
        }
        boolean left = hasPathSumFun(root.left, targetSum - root.data);
        boolean right = hasPathSumFun(root.right, targetSum - root.data);
        return left || right;
    }

    static class Res {
        public int val;
    }
    private static int maxPathSumUtil(TreeNode root, Res result) {
        if (root == null) {
            return 0;
        }
        int leftSum = maxPathSumUtil(root.left, result);
        int rightSum = maxPathSumUtil(root.right, result);

        int c12 = Math.max(Math.max(leftSum, rightSum) + root.data, root.data);
        int c21 = Math.max(c12, rightSum + leftSum + root.data);
        result.val = Math.max(result.val, c21);
        return c12;
    }

    private static int maxPathSum(TreeNode root) {
        Res res = new Res();
        res.val = -1;
        maxPathSumUtil(root, res);
        return res.val;
    }
}
