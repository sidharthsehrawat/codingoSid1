package revision.trees;

public class KthSmallest {
    static class TreeNode {
        TreeNode left;
        TreeNode right;
        int data;

        public TreeNode(int data) {
            this.data = data;
        }
    }
    static class CountWrapper {
        int count = 0;
        int node;
    }


    public static void main(String[] args) {
        /*
                     8
                 5       9
              3    6        10
       */

        TreeNode root = new TreeNode(8);
        root.left = new TreeNode(5);
        root.left.left = new TreeNode(3);
        root.right = new TreeNode(9);
        root.right.right = new TreeNode(10);
        root.left.right = new TreeNode(6);
        int ans = kthSmallest(root, 2);
        System.out.println("ans " + ans);
    }

    private static int kthSmallest(TreeNode root, int k) {

        CountWrapper countWrapper = new CountWrapper();
        helperfunc(root,k,countWrapper);
        return countWrapper.count;
    }

    private static void helperfunc(TreeNode root, int k, CountWrapper countWrapper) {
        if( root == null) return ;
        helperfunc(root.left,k,countWrapper);
        countWrapper.count++;
        if(countWrapper.count == k){
            countWrapper.node  = root.data;
        }
        helperfunc(root.right,k,countWrapper);

    }


}

