
public class PathSum {

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

        public boolean hasPathSum(TreeNode root, int targetSum) {
            if (root == null) {
                return false;
            }

            return solution(root, targetSum);

        }

        public boolean solution(TreeNode node, int targetSum) {

            if (node.left == null && node.right == null) {
                return targetSum == node.val;
            }
            boolean left = false;
            boolean right = false;

            if (node.left != null) {
                left = solution(node.left, targetSum - node.val);
            }
            if (node.right != null) {
                right = solution(node.right, targetSum - node.val);
            }
            return left || right;

        }
    }
}
