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
    int count = 1;
    public int goodNodes(TreeNode root) {
        if(root == null) return 0;
       helper(root,root.left);
       helper(root, root.right);
       return count;
    }
    public void helper(TreeNode prev, TreeNode curr){
        if(curr == null)return;
        if(curr.val >= prev.val){count++;
        helper(curr,curr.left);
        helper(curr, curr.right);}
        else{
         helper(prev,curr.left);
        helper(prev, curr.right);   
        }
        

    }
}