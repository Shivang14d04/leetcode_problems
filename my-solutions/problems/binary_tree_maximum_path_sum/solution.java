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
    private int sum = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
      helper(root);  
      return sum;
    }
    public int helper(TreeNode node){
        if(node==null)return 0;
        int left = Math.max(0, helper(node.left));
        int right = Math.max(0,helper(node.right));
        sum = Math.max(sum,left+right+node.val);
        return node.val + Math.max(left,right);


    }
}