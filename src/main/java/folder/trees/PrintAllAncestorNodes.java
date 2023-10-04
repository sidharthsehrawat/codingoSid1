package folder.trees;

public class PrintAllAncestorNodes {
    static class TreeNode {
        TreeNode left;
        TreeNode right;
        int val;

        public TreeNode(int val) {
            this.val = val;
        }

        public static void main(String[] args) {
            TreeNode root = new TreeNode(1);
            root.left = new TreeNode(2);
            root.left.left = new TreeNode(4);
            root.left.right = new TreeNode(5);
          //  root.left.right.right = new TreeNode(8);
            root.right = new TreeNode(3);
            root.right.left = new TreeNode(6);
            root.right.right = new TreeNode(7);

           // printAllAncestor(root, root.left.right.right);

            printKthNodes(root, 1);
        }
        private static void printKthNodes(TreeNode root, int k) {
            if(root ==null){
                return;
            }
            if(k==0){
                System.out.println(root.val + " ");
            }
                printKthNodes(root.left , k-1);
                printKthNodes(root.right,k-1);
        }

        private static TreeNode printAllAncestor(TreeNode root, TreeNode node) {
            if (root == null) {
                return null;
            }
            if (root == node) {
                return root;
            }

            TreeNode left = printAllAncestor(root.left, node);
            TreeNode right = printAllAncestor(root.right, node);

            if (left != null || right != null) {
                    System.out.print(" " + root.val);
                }
                return left != null ? left : right;
            }

        }
    }
