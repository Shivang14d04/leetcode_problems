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
    private int count =0;
    private int ans = -1;
    public int kthSmallest(TreeNode root, int k) {
        if(root==null)return -1;
          helper(root,k);
          return ans;
    }
    public void helper(TreeNode node,int k){
                if(node==null)return ;

        helper(node.left,k);
        count ++;
        if(count==k){
            ans = node.val;
            return;
        }
        helper(node.right,k);

    }
}