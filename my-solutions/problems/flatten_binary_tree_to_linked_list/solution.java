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
    public void flatten(TreeNode root) {
        TreeNode curr = root;
        while(curr!=null){
            if(curr.left != null){
                TreeNode temp2 = curr.left;
                while(temp2.right!=null){
                    temp2 = temp2.right;
                }
                temp2.right = curr.right;
                curr.right = curr.left;
                curr.left = null;

            }
            curr=curr.right;
        }
    }
}