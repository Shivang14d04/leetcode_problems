
public class DiameterOfBinaryTree {

    public class TreeNode {

        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;

        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;

            this.left = left;
            this.right = right;
        }
    }

    class Solution {

        int diameter = 0;

        public int diameterOfBinaryTree(TreeNode root) {
            Height(root);
            return diameter;

        }

        public int Height(TreeNode node) {
            if (node == null) {
                return 0;
            }

            int leftHeight = Height(node.left);
            int rightHeight = Height(node.right);

            diameter = Math.max(diameter, leftHeight + rightHeight);

            return 1 + Math.max(leftHeight, rightHeight);
        }
    }
}
