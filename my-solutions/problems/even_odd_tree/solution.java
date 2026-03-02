/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
public class Solution {
    public boolean isEvenOddTree(TreeNode root) {
        boolean even = true;
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);

        while (!q.isEmpty()) {
            int prev = even ? Integer.MIN_VALUE : Integer.MAX_VALUE;
            for (int i = q.size(); i > 0; i--) {
                TreeNode node = q.poll();

                if (even && (node.val % 2 == 0 || node.val <= prev)) return false;
                if (!even && (node.val % 2 == 1 || node.val >= prev)) return false;

                if (node.left != null) q.offer(node.left);
                if (node.right != null) q.offer(node.right);

                prev = node.val;
            }
            even = !even;
        }
        return true;
    }
}