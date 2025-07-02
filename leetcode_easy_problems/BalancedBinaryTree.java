
public class BalancedBinaryTree {

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

    class Solution1 {

        public boolean isBalanced(TreeNode root) {
            if (root == null) {
                return true;
            }
            int leftHeight = getHeight(root.left);
            int rightHeight = getHeight(root.right);

            if (Math.abs(leftHeight - rightHeight) <= 1 && isBalanced(root.left) && isBalanced(root.right)) {
                return true;
            }
            return false;

        }

        public int getHeight(TreeNode node) {
            if (node == null) {
                return 0;
            }
            int leftHeight = getHeight(node.left);
            int rightHeight = getHeight(node.right);
            return Math.max(leftHeight, rightHeight) + 1;
        }
    }

    class Solution2 {

        public boolean isBalanced(TreeNode root) {
            if (root == null) {
                return true;
            }
            return checkHeight(root) != -1;
        }

        public int checkHeight(TreeNode node) {
            if (node == null) {
                return 0;
            }

            int left = checkHeight(node.left);
            if (left == -1) {
                return -1;
            }

            int right = checkHeight(node.right);
            if (right == -1) {
                return -1;
            }

            if (Math.abs(left - right) > 1) {
                return -1;
            }
            return Math.max(left, right) + 1;

        }
    }
}
