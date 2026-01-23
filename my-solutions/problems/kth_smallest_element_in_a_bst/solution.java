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
    private int ans = -1;
    private int k ;
    public int kthSmallest(TreeNode root, int k) {
        this.k = k;
        helper(root);
        return ans;

    }
    public void helper(TreeNode node ){
        if(node == null || k==0){
            return;
        }
        helper(node.left);
        
        if(--k == 0){
            ans = node.val;
            return;
        }
        helper(node.right);
    }
}