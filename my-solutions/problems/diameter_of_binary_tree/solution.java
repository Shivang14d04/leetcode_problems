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
    public int diameterOfBinaryTree(TreeNode root) {
        int [] d = new int[1];
        height(root,d);
        return d[0];
    }
    public int height(TreeNode node, int []d){
        if(node == null)return 0;
        int left =  height(node.left,d);
       int right  = height(node.right,d);
       d[0]  = Math.max(d[0],left+right);
       return 1+ Math.max(left,right);

    }
}