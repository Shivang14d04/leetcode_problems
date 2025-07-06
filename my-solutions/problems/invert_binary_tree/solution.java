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
class Solution {
    public TreeNode invertTree(TreeNode root) {
       if (root == null) return null;

    TreeNode left = invertTree(root.left);  // Go deep into left subtree
    TreeNode right = invertTree(root.right); // Then right subtree

    root.left = right;  // Swap them
    root.right = left;

    return root; 
    }
}